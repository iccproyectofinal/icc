package services;
import java.util.List;
import java.util.ArrayList;
import domain.*;


public class CalcularCCService {

	/**
	 * @param args
	 */
	private double matrizAdmitancia [][];
	private List<Componente> barras = new ArrayList<Componente>();
	
	private void crearMatriz (int n){
		matrizAdmitancia = new double [n][n];		
	}
	
	public List<Componente> buscarBarras (Componente componente){
		barras.add(componente);
		List<Componente> hijos = componente.getHijos();
		List<Componente>barrasTemp;
		for (Componente i : hijos) {
			barrasTemp = buscarBarras(i);	
			//carga las barras en el arreglo barras
			for (Componente barra : barrasTemp) {
				barras.add(barra);			
			}
		}

		return barras;
	}
}
