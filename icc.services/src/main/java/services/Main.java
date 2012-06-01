/**
 * 
 */
package services;
import java.util.List;
import java.util.HashMap;
import domain.Componente;


/**
 * @author MCORREA
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		Componente s1 = new Sistema(11, "s1", 1, 1, 1, 1, 1);		
		
		Componente b1 = new Barra(21, "b1", 2, 2);
		s1.cargarHijo(b1);
		
		Componente t1 = new Trafo(31, "t1", 1, 1, 1);
		b1.cargarHijo(t1);
		
		Componente b2 = new Barra(41, "b2", 2, 2);
		t1.cargarHijo(b2);
		
		Componente t41 = (new Trafo(51, "t41", 1, 1, 1));
		b2.cargarHijo(t41);
		
		Componente l41 =  (new Linea(52, "l41", 1, 1, 1,1,1));
		b2.cargarHijo(l41);
		
		Componente t42 =  (new Trafo(53, "t42", 1, 1, 1));
		b2.cargarHijo(t42);
		
		Componente bt411 = (new Barra (61, "bt411", 2, 2));
		t41.cargarHijo(bt411);
		
		Componente bl411 =(new Barra (62, "bl411", 2, 2));
		l41.cargarHijo(bl411);	
		
		Componente bt412 = (new Barra (63, "bt412", 2, 2));
		t42.cargarHijo(bt412);
		
		Componente m1 = (new Motor(71, "m1", 2,2,2,2));
		bl411.cargarHijo(m1);
		
		Componente m2 = (new Motor(72, "m2", 2,2,2,2));
		bl411.cargarHijo(m2);
				
		//s1.mostrarArbol();
	
		
		ComponenteService srv = new ComponenteService();
		List<Componente> lista = srv.traerLista(s1);
		
		//CalcularCCService ccc = new CalcularCCService(s1);
		HashMap<Componente, Double>barraTensionCC= new HashMap<Componente, Double>();
		
		
		Componente barraSel = srv.traerPorId(41, lista);
		System.out.println(barraSel);
		
		//ccc.calcularCC(barraSel, barraTensionCC);		
 		//System.out.println(barraTensionCC);
 		//System.out.println(b2);

		*/
		
		 // mc 2805
		
		//System.out.println("fin");
		DriverXml xml = new DriverXml("circuito.xml");
		xml.parse();
		Componente componenteRaiz = xml.traerResultado();
		componenteRaiz.mostrarArbol();
		
		ComponenteService srv = new ComponenteService();
		List<Componente> lista = srv.traerLista(componenteRaiz);
		Componente barraSel = srv.traerPorId(41, lista);
		System.out.println("barraSel:"+barraSel);
		//barraSel.mostrarArbol();
				
		HashMap<Componente, Double>barraTensionCC= new HashMap<Componente, Double>();			
		CalcularCCService ccc = new CalcularCCService(componenteRaiz);
		double valorCC = ccc.calcularCC(barraSel, barraTensionCC);		
 		System.out.println(barraTensionCC);
		
	}

}
