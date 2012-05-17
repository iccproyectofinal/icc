/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Barra implements TipoComponente {

	/**
	 * 
	 */
	private int id;
	private String nombre;
	private Double voltajeReferencia;
	private Double impedancia;
	
	public Barra(int id, String nombre, double voltajeRefencia, double impedancia) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.voltajeReferencia = voltajeRefencia;
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
		return null;
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#getAdmitancia()
	 */
	public double getAdmitancia() {
		// TODO Auto-generated method stub
		//Sumar las admitancias de todos los componentes unidos directamente a la barra
		return 0;
	}

	/**
	 * @param voltajeReferencia the voltajeReferencia to set
	 */
	public TipoComponente setVoltajeReferencia(Double voltajeReferencia) {
		this.voltajeReferencia = voltajeReferencia;
		return this;
	}

	/**
	 * @return the voltajeReferencia
	 */
	public Double getVoltajeReferencia() {
		return voltajeReferencia;
	}

}
