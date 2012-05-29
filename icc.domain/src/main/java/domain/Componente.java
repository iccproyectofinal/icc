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
	public Componente(TipoComponente tipoComponente) {
		super();
		//this.padre=null;
		this.tipoComponente = tipoComponente;
	}
	
	private List<Componente> hijos = new ArrayList<Componente>();
	private TipoComponente tipoComponente;
	private Componente padre;
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
	/**
	 * @return the tipoComponente
	 */
	public TipoComponente getTipoComponente() {
		return tipoComponente;
	}
	/**
	 * @param tipoComponente the tipoComponente to set
	 */
	public void setTipoComponente(TipoComponente tipoComponente) {
		this.tipoComponente = tipoComponente;
	}
	
	public Componente cargarHijo(Componente componente) {
		componente.setPadre(this);
		hijos.add(componente);
		return this;
	}
	
	public Componente mostrarArbol() {
		
		System.out.println(this + " padre: " + padre);
		System.out.println(this + " tipo: " + this.getTipoComponente().getClass());
		System.out.println(this + " impedancia: " + this.getTipoComponente().getImpedancia());
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
		
		return String.valueOf(tipoComponente.getId());
	}
}
