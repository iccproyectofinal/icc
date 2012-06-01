package domain;

public class Trafo extends Componente {
	
	
	private double potencia;
	private double tensionCC;

	
 	public Trafo(int id, String nombre, double potencia, double tensionCC, double impedancia) {
		super();
		this.setId(id);
		this.setNombre(nombre);		
		this.setImpedancia(impedancia);
		
 		this.potencia = potencia;
		this.tensionCC = tensionCC;
		
	}

	public double getImpedancia() {
		// TODO Auto-generated method stub
		return super.getImpedancia();
	}

	public double getAdmitancia() {
		// TODO Auto-generated method stub
		return 1 / getImpedancia();
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setTensionCC(double tensionCC) {
		this.tensionCC = tensionCC;
	}

	public double getTensionCC() {
		return tensionCC;
	}


}
