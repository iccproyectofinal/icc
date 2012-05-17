package services;

import domain.Componente;

/**
 * 
 */

/**
 * @author Eliseo
 *
 */
public interface Builder {
	/**
	 * @param id
	 * @param nombre
	 * @param potencia
	 * @param tension
	 * @param potenciaBase
	 * @param tensionBase
	 * @param impedancia
	 * @param padre
	 */
	void crearSistema(int id, String nombre, double potencia, double tension,
			double potenciaBase, double tensionBase, double impedancia, int padre);
	
	/**
	 * @param id
	 * @param nombre
	 * @param potencia
	 * @param tensionCC
	 * @param impedancia
	 * @param padre
	 */
	void crearTrafo(int id, String nombre, double potencia, double tensionCC,
			double impedancia, int padre);
	
	/**
	 * @param id
	 * @param nombre
	 * @param potencia
	 * @param seccion
	 * @param conductores
	 * @param longitud
	 * @param impedancia
	 * @param padre
	 */
	void crearLinea(int id, String nombre, double potencia, double seccion,
			int conductores, double longitud, double impedancia, int padre);
	
	/**
	 * @param id
	 * @param nombre
	 * @param voltajeReferencia
	 * @param padre
	 */
	void crearBarra(int id, String nombre, double voltajeReferencia, int padre);
	
	/**
	 * @param id
	 * @param nombre
	 * @param tensionNominal
	 * @param potenciaNominal
	 * @param cosenoFi
	 * @param impedancia
	 * @param padre
	 */
	void crearMotor(int id, String nombre, double tensionNominal,
			double potenciaNominal, double cosenoFi, double impedancia, int padre);
	
	/**
	 * @return
	 */
	Componente traerResultado();
}
