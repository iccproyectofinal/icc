package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */




/**
 * @author MCORREA
 *
 */
public class Barra extends Componente {

	/**
	 * 
	 */
	private double voltajeReferencia;
	
	public Barra(int id, String nombre, double voltajeRefencia, double impedancia) {
		// TODO Auto-generated constructor stub
		super();
		this.setId(id);
		this.setNombre(nombre);		
		this.setImpedancia((double) 0);
		this.voltajeReferencia=voltajeRefencia;
	}



	/* (non-Javadoc)
	 * @see domain.TipoComponente#getImpedancia()
	 */
	@Override
	
	public double getImpedancia() {
		// TODO Auto-generated method stub
		double sumaImpedancia=0 ;
		List<Componente> hijos = new ArrayList<Componente>();
		
		if (this.getPadre()!=null){
			sumaImpedancia = getPadre().getImpedancia();
		}
		hijos = this.getHijos();
		for (Componente miHijo : hijos) {			
			sumaImpedancia += miHijo.getImpedancia();
		}
		return sumaImpedancia;
	}


	/* (non-Javadoc)
	 * @see domain.TipoComponente#getAdmitancia()
	 */
	public double getAdmitancia() {
		// TODO Auto-generated method stub		
		return 0;
	}
	public void setVoltajeReferencia(double getVoltajeReferencia) {
		this.voltajeReferencia = getVoltajeReferencia;
	}
	public double getVoltajeReferencia() {
		return voltajeReferencia;
	}



}
