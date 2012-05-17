package domain;

public class Trafo implements TipoComponente {
	
	private int id;
	private String nombre;
	private double potencia;
	private double tensionCC;
	private double impedancia;

	
 	public Trafo(int id, String nombre, double potencia, double tensionCC, double impedancia) {
		this.id = id;
		this.nombre = nombre;
		this.potencia = potencia;
		this.tensionCC = tensionCC;
		this.impedancia = impedancia;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public TipoComponente setId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public TipoComponente setNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getImpedancia() {
		// TODO Auto-generated method stub
		return impedancia;
	}

	public TipoComponente setImpedancia(double impedancia) {
		// TODO Auto-generated method stub
		return null;
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
