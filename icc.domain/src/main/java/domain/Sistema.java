/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class Sistema extends Componente {
	
	
	private double potencia;
	private double tension;
	private double potenciaBase;
	private double tensionBase;
	
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
		this.setId(id);
		this.setNombre(nombre);		
		this.setImpedancia(impedancia);
		
		this.potencia = potencia;
		this.tension = tension;
		this.potenciaBase = potenciaBase;
		this.tensionBase = tensionBase;
		
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


	/* (non-Javadoc)
	 * @see domain.TipoComponente#getImpedancia()
	 */
	public double getImpedancia() {
		// TODO Auto-generated method stub
		return super.getImpedancia();
	}

	/* (non-Javadoc)
	 * @see domain.TipoComponente#getAdmitancia()
	 */
	public double getAdmitancia() {
		// TODO Auto-generated method stub
		return 1 / getImpedancia();
	}

}
