/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public class ComponenteHoja extends Componente {

	/**
	 * @param tipoComponente
	 */
	public ComponenteHoja(TipoComponente tipoComponente) {
		super(tipoComponente);
	}
	
	@Override
	public Componente cargarHijo(Componente componente) {
		return this;
	}

}
