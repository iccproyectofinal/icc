/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MCORREA
 *
 */
public abstract class Componente {
	/**
	 * @param tipoComponente
	 */
	
	public Componente() {
		// TODO Auto-generated constructor stub
	}

	private List<Componente> hijos = new ArrayList<Componente>();	
	private Componente padre;
	private int id;	
	private String nombre;
	private double impedancia;
	//private double admitancia;
	
	/**
	 * @return the padre
	 */
	public Componente getPadre() {
		return padre;
	}
	/**
	 * @param padre the padre to set
	 */
	public void setPadre(Componente padre) {
		this.padre = padre;
	}
	/**
	 * @return the hijos
	 */
	public List<Componente> getHijos() {
		return hijos;
	}
	/**
	 * @param hijos the hijos to set
	 */
	public void setHijos(List<Componente> hijos) {
		this.hijos = hijos;
	}


	
	public Componente cargarHijo(Componente componente) {
		componente.setPadre(this);
		hijos.add(componente);
		return this;
	}
	
	public Componente mostrarArbol() {
		
		System.out.println(this + " padre: " + padre);
		System.out.println(this + " tipo: " + this.getClass());
		System.out.println(this + " impedancia: " + getImpedancia());
		System.out.println("----");
		
		for (Componente i : hijos) {
			i.mostrarArbol();
		}
		
		return this;
	}

	public void traerLista(List<Componente> l) {
		l.add(this);
		
		for (Componente i : hijos) {
			i.traerLista(l);
		}
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return String.valueOf(this.getId());
	}
	public void setId(int getId) {
		this.id = getId;
	}
	public int getId() {
		return id;
	}
	public void setNombre(String getNombre) {
		this.nombre = getNombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setImpedancia(double getImpedancia) {
		this.impedancia = getImpedancia;
	}
	public double getImpedancia() {
		return impedancia;
	}

	public double getAdmitancia() {
		return 1 / impedancia;
	}

}
