package services;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import Jama.Matrix;
import domain.*;

public class CalcularCCService {

	/**
	 * @param args
	 */
	
	 
	private double matrizAdmitancia [][];
	private List<Componente> listComponentes = new ArrayList<Componente>();
	
	/*N0TA barra-BarraPos: OJO barras y barraPos, deben estar sincronizados! 
	*la posicion 'pos' en barra debe coincidir con la clave en Hash barraPos	
	*esto se puede realizar, ya que no se prevee eliminar ni insertar elementos
	*en caso de requerir eliminar o insertar elementeos se debe corregir para poder 
	*implementando un solo MAP , con un LinkedHashMap<k, V>
	*/
	private List<Componente> barras = new ArrayList<Componente>();
	private Map<Componente , Integer> barraPos = new HashMap<Componente , Integer>();
	
	public CalcularCCService (Componente componente){
		ComponenteService componenteSrv = new ComponenteService();
		listComponentes = componenteSrv.traerLista(componente);
	}
	private void crearMatriz (int n){
	matrizAdmitancia = new double [n][n];		
	}

	private boolean llenarMatrizDiagonal() {
		/*
		 * recorre la lista de Barras, por cada barra, suma los valores de A de
		 * cada componente conenctado a esa barra
		 */
		List<Componente> hijos = new ArrayList<Componente>();
		for (Componente miComponente : barras) {
			double admitancia = 0;
			// Object filO = barraPos.get(miComponente);
			// System.out.println("fila:"+filO);
			// int fil = Integer.parseInt(filO.toString());
			int fil = barraPos.get(miComponente);
			// toma los valores de admintancia del padre y de los hijos
			double sumaImpedancia = 0;
			TipoComponente padreTipo = miComponente.getPadre()
					.getTipoComponente();
			sumaImpedancia += padreTipo.getImpedancia();

			hijos = miComponente.getHijos();
			for (Componente miHijo : hijos) {
				TipoComponente hijoTipo = miHijo.getTipoComponente();
				sumaImpedancia += hijoTipo.getImpedancia();
			}
			System.out.println(fil + "impedan" + sumaImpedancia);
			admitancia = 1 / sumaImpedancia;
			matrizAdmitancia[fil][fil] = admitancia;
		}
		return true;
	}
	
	
	private boolean llenarMatrizNoDiagonal(){
		/*recorre la lista, si no es barra, carga en un lista los componentes (padres ó hijos) que son barras
		 * es decir, las barras que estan relacionadas directo al componente actual
		 * luego toma la lista de barras y por cada barra busca las posiciones de las otras barras y agrega el valor
		 * en la matriz, por medio de un bucle dentro de otro bucle 
		*/
		Iterator<Componente> componenteIt = listComponentes.iterator();
		List<Componente> hijos = new ArrayList <Componente>();
		List<Componente> conexionBarras = new ArrayList <Componente>();
		double admitancia;
		
		while(componenteIt.hasNext()){
			conexionBarras.clear();
			Componente miComponente = componenteIt.next();
			// busca conexiones de directa barra - linea - barra
			// es decir, si es linea busca padre barra, ó hijos barra
			if ("domain.Barra" != (miComponente.getTipoComponente().getClass()
					.getName())) {
				admitancia = miComponente.getTipoComponente().getAdmitancia();
				// padre es barra?
				if (miComponente.getPadre() != null) {
					if ("domain.Barra" == (miComponente.getPadre()
							.getTipoComponente().getClass().getName())) {
						conexionBarras.add(miComponente.getPadre());
					}
				}
				// trae los hijos y filtra solo las barras
				hijos = miComponente.getHijos();
				if (hijos != null) {
					for (Componente miHijo : hijos) {
						if ("domain.Barra" == (miHijo.getTipoComponente()
								.getClass().getName())) {
							conexionBarras.add(miHijo);
						}
					}
				}
					
				// recorre la lista y dentro del bucle recorre de nuevo para las
				// conexiones
				if (conexionBarras != null) {
					for (Componente conHijoPri : conexionBarras) {
						int barraPriPos = barraPos.get(conHijoPri);
						for (Componente conHijoSec : conexionBarras) {
							if (!conHijoPri.equals(conHijoSec)) {
								int barraSecPos = barraPos.get(conHijoSec);
								System.out.println("completa hijo: "
										+ barraPriPos + "-" + barraSecPos);
								matrizAdmitancia[barraPriPos][barraSecPos] = admitancia;
							}
						}
					}
				}
			}
		}
		return true;
	}

	
	private void llenarMatrizAdmitancia() {
		// traer lista en el constructor
		// crea un hashMap con solo las barras
		int cont = -1;
		barras.clear();
		barraPos.clear();
		for (Componente i : listComponentes) {
			// si es barra lo agrega en lista barras
			TipoComponente tipoC = i.getTipoComponente();
			Class clase = tipoC.getClass();
			if ("domain.Barra" == clase.getName()) {				
				//OJO VER N0TA barra-BarraPos: 
				barras.add(i);
				// guarda las dupla "barra - posicion en arreglo" en un HashMap
				cont += 1;
				barraPos.put(i, cont);
			}
		}
		// define tamaño de matriz
		crearMatriz(barras.size());

		// llenar matriz diagonal principal
		llenarMatrizDiagonal();

		// llenar matriz todo menos diagonal principal
		llenarMatrizNoDiagonal();

		// FALTA
		// Cargar matriz en JAMA

		// imprime matriz
		for (int filM = 0; filM < matrizAdmitancia.length; filM++) {
			for (int colM = 0; colM < matrizAdmitancia.length; colM++) {
				System.out.print("\t" + matrizAdmitancia[filM][colM] + "  ");
			}
			System.out.println();
		}
	}
	
	public double calcularCC(Componente barra, HashMap<Componente, Double> barraTensionCC) {
		/*
		 * Busca el valor de cc de la barra seleccionda, y los voltaje de cada
		 * barra directamente relacionada a la barra seleccionda
		 */
		
		//calcular matrizAdmitancia
		llenarMatrizAdmitancia();
		
		double calculoCC = 0;
		// El sistema busca el valor de la barra seleccionada en la matriz
		// inversa.
		int posBarra = barraPos.get(barra);

		// carga matriz inversa con JAMA
		Matrix matrizCalculo = new Matrix(matrizAdmitancia);
		//double det = matrizCalculo.det();
		//System.out.println("DET: "+det);		
		
		Matrix matrizInv = matrizCalculo.inverse();
		System.out.println("inversa:");
		matrizInv.print(5, 3);
		
		double matrizInversa[][]= matrizInv.getArray();		
		
		/*
		 * El sistema aplica esta formula para conocer la corriente de
		 * cortocircuito en esa barra: If=Vref/Zkk, donde Vref es el voltaje de
		 * referencia de la barra seleccionada, y Zkk es el elemento de la
		 * matriz inversa que representa la barra.
		 */
		double vref = barra.getTipoComponente().getVoltajeReferencia();
		double zkk = matrizInversa[posBarra][posBarra];
		double valorIf = vref / zkk;
		calculoCC = valorIf;
		System.out.println("Calculo de CC en barra "+barra.getTipoComponente().getId()+":"+valorIf);

		/*
		 * Por cada barra que esta directamente conectada a la barra
		 * seleccionada,el sistema aplica esta formula para conocer el voltaje
		 * de la barra: Vj=Vref-Zjk*If,donde Vref es el voltaje de referencia de
		 * la barra seleccionada,Zjk es el elemento de la matriz inversa que
		 * representa la barra que esta conectada a la barraseleccionada, e If
		 * es la corriente de cortocircuito de la barra seleccionada (calculada
		 * en el paso anterior).
		 */		
		double vj=0;
		double zjk=0;		
		
		//recorre la matriz de admitancia en la columna de la barra seleccionada, 
		//en cada valor <>0 indica que hay una barra directamente conectada
		for (int cont=0; cont<matrizAdmitancia.length;cont++){
			if ((matrizAdmitancia[posBarra][cont]!=0) && (posBarra!=cont)){
				zjk = matrizInversa[posBarra][cont];
				Componente barraConectada = barras.get(cont);//ojo				
				vj=vref-(zjk*valorIf);
				barraTensionCC.put(barraConectada, vj);
			}
		}
		return calculoCC;
	}
}
