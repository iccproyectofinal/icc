/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Linea implements TipoComponente {

	/**
	 * 
	 */
	private int id;
	private String nombre;
	private Double potencia;
	private Double seccion;
	private int conductores;
	private Double longitud;
	private Double impedancia;
	
	
	public Linea(int id, String nombre, double potencia, double seccion, int conductores, double longitud, double impedancia) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.potencia = potencia;
		this.seccion = seccion;
		this.conductores = conductores;
		this.longitud = longitud;
		this.impedancia = impedancia;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#getId()
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#setId(int)
	 */
	public TipoComponente setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
		return this;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#getNombre()
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#setNombre(java.lang.String)
	 */
	public TipoComponente setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
		return this;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#getImpedancia()
	 */
	public double getImpedancia() {
		// TODO Auto-generated method stub
		return impedancia;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#setImpedancia(double)
	 */
	public TipoComponente setImpedancia(double impedancia) {
		// TODO Auto-generated method stub
		this.impedancia = impedancia;
		return this;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#getAdmitancia()
	 */
	public double getAdmitancia() {
		// TODO Auto-generated method stub
		return 1 / getImpedancia();
	}

	/**
	 * @param potencia the potencia to set
	 */
	public TipoComponente setPotencia(Double potencia) {
		this.potencia = potencia;
		return this;
	}

	/**
	 * @return the potencia
	 */
	public Double getPotencia() {
		return potencia;
	}

	/**
	 * @param seccion the seccion to set
	 */
	public TipoComponente setSeccion(Double seccion) {
		this.seccion = seccion;
		return this;
	}

	/**
	 * @return the seccion
	 */
	public Double getSeccion() {
		return seccion;
	}

	/**
	 * @param conductores the conductores to set
	 */
	public TipoComponente setConductores(int conductores) {
		this.conductores = conductores;
		return this;
	}

	/**
	 * @return the conductores
	 */
	public int getConductores() {
		return conductores;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public TipoComponente setLongitud(Double longitud) {
		this.longitud = longitud;
		return this;
	}

	/**
	 * @return the longitud
	 */
	public Double getLongitud() {
		return longitud;
	}

}
