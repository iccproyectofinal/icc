/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Linea extends Componente {


	private Double potencia;
	private Double seccion;
	private int conductores;
	private Double longitud;
	
	
	public Linea(int id, String nombre, double potencia, double seccion, int conductores, double longitud, double impedancia) {
		// TODO Auto-generated constructor stub
		super();
		this.setId(id);
		this.setNombre(nombre);		
		this.setImpedancia(impedancia);
		
		this.potencia = potencia;
		this.seccion = seccion;
		this.conductores = conductores;
		this.longitud = longitud;		
	}


	/* (non-Javadoc)
	 * @see domain.TipoComponente#getAdmitancia()
	 */
	public double getAdmitancia() {
		// TODO Auto-generated method stub
		return 1 / getImpedancia();
	}


	/**
	 * @return the potencia
	 */
	public Double getPotencia() {
		return potencia;
	}

	/**
	 * @return the seccion
	 */
	public Double getSeccion() {
		return seccion;
	}


	/**
	 * @return the conductores
	 */
	public int getConductores() {
		return conductores;
	}

	/**
	 * @return the longitud
	 */
	public Double getLongitud() {
		return longitud;
	}

	public double getVoltajeReferencia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
