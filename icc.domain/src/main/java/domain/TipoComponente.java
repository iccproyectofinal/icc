/**
 * 
 */
package domain;

/**
 * @author MCORREA
 *
 */
public interface TipoComponente {
	int getId();
	TipoComponente setId(int id);
	String getNombre();
	TipoComponente setNombre(String nombre);
	double getImpedancia();
	TipoComponente setImpedancia(double impedancia);
	double getAdmitancia();
	double getVoltajeReferencia();
}
