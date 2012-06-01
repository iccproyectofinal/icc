/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Motor extends Componente {

	/**
	 * 
	 */


	private Double tensionNominal;
	private Double potenciaNominal;
	private Double cosenoFi;

	
	public Motor(int id, String nombre, double tensionNominal, double potenciaNominal, double cosenoFi, double impedancia) {
		// TODO Auto-generated constructor stub
		super();
		this.setId(id);
		this.setNombre(nombre);		
		this.setImpedancia(impedancia);
		this.tensionNominal = tensionNominal;
		this.potenciaNominal = potenciaNominal;
		this.cosenoFi = cosenoFi;
	}
	/* (non-Javadoc)
	 * @see domain.TipoComponente#getImpedancia()
	 */
	public double getImpedancia() {
		// TODO Auto-generated method stub
		return super.getImpedancia();
	}
	public double getAdmitancia() {
		// TODO Auto-generated method stub
		return 1 / getImpedancia();
	}

	/**
	 * @return the tensionNominal
	 */
	public Double getTensionNominal() {
		return tensionNominal;
	}

		/**
	 * @return the potenciaNominal
	 */
	public Double getPotenciaNominal() {
		return potenciaNominal;
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
