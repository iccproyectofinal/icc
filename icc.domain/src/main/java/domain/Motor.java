/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Motor implements TipoComponente {

	/**
	 * 
	 */

	private int id;
	private String nombre;
	private Double tensionNominal;
	private Double potenciaNominal;
	private Double cosenoFi;
	private Double impedancia;
	
	public Motor(int id, String nombre, double tensionNominal, double potenciaNominal, double cosenoFi, double impedancia) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.tensionNominal = tensionNominal;
		this.potenciaNominal = potenciaNominal;
		this.cosenoFi = cosenoFi;
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
		this.nombre= nombre;
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
		this.impedancia= impedancia;
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
	 * @param tensionNominal the tensionNominal to set
	 */
	public TipoComponente setTensionNominal(Double tensionNominal) {
		this.tensionNominal = tensionNominal;
		return this;
	}

	/**
	 * @return the tensionNominal
	 */
	public Double getTensionNominal() {
		return tensionNominal;
	}

	/**
	 * @param potenciaNominal the potenciaNominal to set
	 */
	public TipoComponente setPotenciaNominal(Double potenciaNominal) {
		this.potenciaNominal = potenciaNominal;
		return this;
	}

	/**
	 * @return the potenciaNominal
	 */
	public Double getPotenciaNominal() {
		return potenciaNominal;
	}

	/**
	 * @param cosenoFi the cosenoFi to set
	 */
	public TipoComponente setCosenoFi(Double cosenoFi) {
		this.cosenoFi = cosenoFi;
		return this;
	}

	/**
	 * @return the cosenoFi
	 */
	public Double getCosenoFi() {
		return cosenoFi;
	}

	public double getVoltajeReferencia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
