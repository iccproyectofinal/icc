package services;

import java.util.ArrayList;
import java.util.List;

import domain.Barra;
import domain.Componente;
import domain.Linea;
import domain.Motor;
import domain.Sistema;
import domain.Trafo;

/**
 * @author Eliseo
 *
 */
public class CircuitoBuilder implements Builder {
	
	private List<Componente> componentes = new ArrayList<Componente>();
	private ComponenteService service = new ComponenteService();

	/* (non-Javadoc)
	 * @see Builder#crearSistema(int, java.lang.String, double, double, double, double, double, int)
	 */
	public void crearSistema(int id, String nombre, double potencia,
			double tension, double potenciaBase, double tensionBase,
			double impedancia, int padre) {
		System.out.println("Llamamos al m�todo crearSistema");
		Componente c = new Sistema(id, nombre, potencia, tension, potenciaBase, tensionBase, impedancia);		
		componentes.add(c);		
		unir(c, padre);
	}

	/* (non-Javadoc)
	 * @see Builder#crearTrafo(int, java.lang.String, double, double, double, int)
	 */
	public void crearTrafo(int id, String nombre, double potencia,
			double tensionCC, double impedancia, int padre) {
		System.out.println("Llamamos al m�todo crearTrafo");
		Componente c  = new Trafo(id, nombre, potencia, tensionCC, impedancia);		
		componentes.add(c);
		
		unir(c, padre);
	}

	/* (non-Javadoc)
	 * @see Builder#crearLinea(int, java.lang.String, double, double, int, double, double, int)
	 */
	public void crearLinea(int id, String nombre, double potencia,
			double seccion, int conductores, double longitud,
			double impedancia, int padre) {
		System.out.println("Llamamos al m�todo crearLinea");
		Componente c = new Linea(id, nombre, potencia, seccion, conductores, longitud, impedancia);		
		componentes.add(c);
		
		unir(c, padre);
	}

	/* (non-Javadoc)
	 * @see Builder#crearBarra(int, java.lang.String, double, int)
	 */
	public void crearBarra(int id, String nombre, double voltajeReferencia,
			int padre) {
		System.out.println("Llamamos al m�todo crearBarra");
		Componente c = new Barra(id, nombre, voltajeReferencia, 0);		
		componentes.add(c);
		
		unir(c, padre);
	}

	/* (non-Javadoc)
	 * @see Builder#crearMotor(int, java.lang.String, double, double, double, double, int)
	 */
	public void crearMotor(int id, String nombre, double tensionNominal,
			double potenciaNominal, double cosenoFi, double impedancia,
			int padre) {
		System.out.println("Llamamos al m�todo crearMotor");
		Componente c = new Motor(id, nombre, tensionNominal, potenciaNominal, cosenoFi, impedancia);		
		componentes.add(c);
		
		unir(c, padre);
	}

	/* (non-Javadoc)
	 * @see Builder#traerResultado()
	 */
	public Componente traerResultado() {
		return service.traerComponenteRaiz(componentes);
	}
	
	private void unir(Componente hijo, int padreId) {
		if(padreId != 0) {
			Componente componenteBuscado = service.traerPorId(padreId, this.componentes);
			if(componenteBuscado != null) {
				componenteBuscado.cargarHijo(hijo);
			}
		}
	}

}
