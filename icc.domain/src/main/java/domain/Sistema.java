/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Sistema implements TipoComponente {
	
	/**
	 * @param id
	 * @param nombre
	 * @param potencia
	 * @param tension
	 * @param potenciaBase
	 * @param tensionBase
	 * @param impedancia
	 */
	public Sistema(int id, String nombre, double potencia, double tension,
			double potenciaBase, double tensionBase, double impedancia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.potencia = potencia;
		this.tension = tension;
		this.potenciaBase = potenciaBase;
		this.tensionBase = tensionBase;
		this.impedancia = impedancia;
	}

	/**
	 * @return the potencia
	 */
	public double getPotencia() {
		return potencia;
	}

	/**
	 * @param potencia the potencia to set
	 */
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	/**
	 * @return the tension
	 */
	public double getTension() {
		return tension;
	}

	/**
	 * @param tension the tension to set
	 */
	public void setTension(double tension) {
		this.tension = tension;
	}

	/**
	 * @return the potenciaBase
	 */
	public double getPotenciaBase() {
		return potenciaBase;
	}

	/**
	 * @param potenciaBase the potenciaBase to set
	 */
	public void setPotenciaBase(double potenciaBase) {
		this.potenciaBase = potenciaBase;
	}

	/**
	 * @return the tensionBase
	 */
	public double getTensionBase() {
		return tensionBase;
	}

	/**
	 * @param tensionBase the tensionBase to set
	 */
	public void setTensionBase(double tensionBase) {
		this.tensionBase = tensionBase;
	}

	private int id;
	private String nombre;
	private double potencia;
	private double tension;
	private double potenciaBase;
	private double tensionBase;
	private double impedancia;

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

}
