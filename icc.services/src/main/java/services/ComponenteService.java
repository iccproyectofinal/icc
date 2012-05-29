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
	
	
	public List<Componente> traerLista(Componente c) {
		List<Componente> componentes = new ArrayList<Componente>();
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
