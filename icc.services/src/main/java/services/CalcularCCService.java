package services;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import domain.*;

public class CalcularCCService {

	/**
	 * @param args
	 */
	
	/*
	 * hcaer cosas
	 * */
	
	 
	private double matrizAdmitancia [][];
	private List<Componente> listComponentes = new ArrayList<Componente>();
	private List<Componente> barras = new ArrayList<Componente>();
	private Map<Componente , Integer> barraPos = new HashMap<Componente , Integer>();
	public CalcularCCService (Componente componente){
		ComponenteService componenteSrv = new ComponenteService();
		listComponentes = componenteSrv.traerLista(componente);
	}
	private void crearMatriz (int n){
	matrizAdmitancia = new double [n][n];		
	}

	private boolean llenarMatrizDiagonal(){
		/*recorre la lista de Barras, 
		 * por cada barra, suma los valores de A de cada componente conenctado a esa barra
		*/		
		List<Componente> hijos = new ArrayList <Componente>();		
		for (Componente miComponente : barras){
			double admitancia =0; 			
			//Object filO = barraPos.get(miComponente);
			//System.out.println("fila:"+filO);
			//int fil = Integer.parseInt(filO.toString());
			int fil = barraPos.get(miComponente);
			//toma los valores de admintancia del padre y de los hijos
			double sumaImpedancia=0;
			TipoComponente padreTipo = miComponente.getPadre().getTipoComponente();
			sumaImpedancia += padreTipo.getImpedancia();				
								
			hijos = miComponente.getHijos();
			for (Componente miHijo: hijos){
				TipoComponente hijoTipo = miHijo.getTipoComponente();
				sumaImpedancia += hijoTipo.getImpedancia();		
			}								
			System.out.println(fil+"impedan"+sumaImpedancia);
			admitancia = 1/sumaImpedancia;				
			matrizAdmitancia[fil][fil]=admitancia;					
		}
		return true;
	}
	
	
	private boolean llenarMatrizNoDiagonal(){
		/*recorre la lista, si no es barra carga el valor Admitancia (A)
		*/
		Iterator<Componente> componenteIt = listComponentes.iterator();
		List<Componente> hijos = new ArrayList <Componente>();
		List<Componente> conexionBarras = new ArrayList <Componente>();
		//Componente conexionBarraPadre=null;
		//int conexionBarraPadrePos;
		
		while(componenteIt.hasNext()){
			//componenteIt.next();
			Componente miComponente = componenteIt.next();			
				//busca conexiones de directa barra - linea - barra
				//es decir, si es linea busca padre barra, ó hijos barra
				if ("domain.Linea" == (miComponente.getTipoComponente().getClass().getName())){
					//padre es barra?
					if (miComponente.getPadre()!=null){					
						if ("domain.Barra" == (miComponente.getPadre().getTipoComponente().getClass().getName())){
							conexionBarras.add(miComponente.getPadre());																		
						}
					}
					//trae los hijos y filtra solo las barras
					hijos = miComponente.getHijos();
					if (hijos !=null){
						for (Componente miHijo: hijos){
							if ("domain.Barra" == (miHijo.getTipoComponente().getClass().getName())){
								conexionBarras.add(miHijo);
							}						
						}
					}
					
					//recorre la lista y dentro del bucle recorre de nuevo para las conexiones
					if (conexionBarras != null) {
						for (Componente conHijoPri : conexionBarras) {
							int barraPriPos = barraPos.get(conHijoPri);								
							for (Componente conHijoSec : conexionBarras) {
								if (!conHijoPri.equals(conHijoSec)){
								int barraSecPos = barraPos.get(conHijoSec);
								System.out.println("completa hijo: "+barraPriPos+"-"+barraSecPos);
								matrizAdmitancia[barraPriPos][barraSecPos] = matrizAdmitancia[barraPriPos][barraPriPos];								
								}
							}
						}
					}
				}				
		}
		return true;
	}
	
	public void llenarMatrizAdmitancia(){
		//traer lista en el constructor
		//crea un hashMap con solo las barras		
		int cont=-1;		
		for (Componente i : listComponentes){
			//si es barra lo agrega en lista barras			
			TipoComponente tipoC = i.getTipoComponente();
			Class clase = tipoC.getClass();			
			if ("domain.Barra" == clase.getName()){
				barras.add(i);
				//guarda las dupla "barra - posicion en arreglo" en un HashMap
				cont+=1;
				barraPos.put(i,cont);
			}						
		}		
		//define tamaño de matriz
		crearMatriz(barras.size());
		
		//llenar matriz diagonal principal
		llenarMatrizDiagonal();		

		//llenar matriz todo menos diagonal principal
		llenarMatrizNoDiagonal();
		
		//FALTA
		//Cargar matriz en JAMA
		
		//imprime matriz
		for (int filM=0; filM < matrizAdmitancia.length;filM++){
			for (int colM=0; colM < matrizAdmitancia.length;colM++){
				System.out.print("\t"+matrizAdmitancia[filM][colM]+"  ");
			}
			System.out.println();
		}
	}
}
