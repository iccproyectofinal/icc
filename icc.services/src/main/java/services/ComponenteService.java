/**
 * 
 */
package services;

import java.util.ArrayList;
import java.util.List;

import domain.Componente;
import domain.Sistema;
import domain.TipoComponente;

/**
 * @author MCORREA
 *
 */
public class ComponenteService {
	private static List<Componente> componentes = new ArrayList<Componente>();
	
	public List<Componente> traerLista(Componente c) {
		c.traerLista(componentes);
		return componentes;
	}
	
	public Componente traerPorId(int id, List<Componente> lista) {
		for(Componente i : lista) {
			if(i.getTipoComponente().getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public Componente traerComponenteRaiz(List<Componente> lista) {
		for(Componente i : lista) {
			TipoComponente t = i.getTipoComponente();
			if(t instanceof Sistema) {
				if(i.getPadre() == null) {
					return i;
				}
			}
		}
		return null;
	}

}
