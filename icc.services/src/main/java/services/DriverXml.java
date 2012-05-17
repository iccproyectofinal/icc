package services;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import domain.Componente;

/**
 * 
 */

/**
 * @author Eliseo
 *
 */
public class DriverXml extends DefaultHandler {
	private String path;
	private String tempVal;
	
	private int id;
	private String nombre;
	private String tipoComponente;
	private double impedancia;
	private int padreId = 0;
	
	private double param1;
	private double param2;
	private double param3;
	private double param4;
	
	private Builder builder = new CircuitoBuilder();
	
	/**
	 * @param path
	 */
	public DriverXml(String path) {
		this.path = path;
		//builder.crearSistema(1, "aaa", 1, 1, 1, 1, 1, 1);
	}
	
	public void parse() {
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

		//get a new instance of parser
		SAXParser sp = spf.newSAXParser();

		//parse the file and also register this class for call backs
		sp.parse(path, this);

		} catch(SAXException se) {
			se.printStackTrace();
		} catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		
		if(qName.equalsIgnoreCase("componente")) {
			System.out.println("Comienza un nuevo componente");
			//componenteActual = new ComponenteCompuesto();
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("componente")) {
			System.out.println("Termina el componente");
			System.out.println("===================================================");
			
			if (tipoComponente.equals("sistema")) {
				builder.crearSistema(id, nombre, param1, param2, param3, param4, impedancia, padreId);
			}
			else if (tipoComponente.equals("trafo")) {
				builder.crearTrafo(id, nombre, param1, param2, param3, padreId);
			}
			else if (tipoComponente.equals("linea")) {
				builder.crearLinea(id, nombre, param1, param2, (int)param3, param4, impedancia, padreId);
			}
			else if (tipoComponente.equals("motor")) {
				builder.crearMotor(id, nombre, param1, param2, param3, impedancia, padreId);
			}
			else if (tipoComponente.equals("barra")) {
				builder.crearBarra(id, nombre, param1, padreId);
			}
		}
		
		else if(qName.equalsIgnoreCase("tipo")) {
			tipoComponente = tempVal.toLowerCase();
			System.out.println("El tipo de componente es: " + tipoComponente);
		}
		else if(qName.equalsIgnoreCase("id")) {
			id = Integer.parseInt(tempVal);
			System.out.println("Id: " + id);
		}
		else if(qName.equalsIgnoreCase("nombre")) {
			nombre = tempVal;
			System.out.println("Nombre: " + nombre);
		}
		else if(qName.equalsIgnoreCase("padre")) {
			padreId = Integer.parseInt(tempVal);
			System.out.println("Padre ID: " + padreId);
		}
		else if(qName.equalsIgnoreCase("impedancia")) {
			impedancia = Double.parseDouble(tempVal);
			System.out.println("Impedancia: " + impedancia);
		}
		
		//Parametros propios de los SISTEMAS
		else if(qName.equalsIgnoreCase("potencia")) {
			param1 = Double.parseDouble(tempVal);
			System.out.println("Potencia: " + param1);
		}
		else if(qName.equalsIgnoreCase("tension")) {
			param2 = Double.parseDouble(tempVal);
			System.out.println("Tensión: " + param2);
		}
		else if(qName.equalsIgnoreCase("potenciaBase")) {
			param3 = Double.parseDouble(tempVal);
			System.out.println("Potencia base: " + param3);
		}
		else if(qName.equalsIgnoreCase("tensionBase")) {
			param4 = Double.parseDouble(tempVal);
			System.out.println("Tensión base: " + param4);
		}
		
		//Parametros propios de las BARRAS
		else if(qName.equalsIgnoreCase("voltajeReferencia")) {
			param1 = Double.parseDouble(tempVal);
			System.out.println("Voltaje de referencia: " + param1);
		}
		
		//Parametros propios de las LINEAS
		else if(qName.equalsIgnoreCase("potencia")) {
			param1 = Double.parseDouble(tempVal);
			System.out.println("Potencia: " + param1);
		}
		else if(qName.equalsIgnoreCase("seccion")) {
			param2 = Double.parseDouble(tempVal);
			System.out.println("Sección: " + param2);
		}
		else if(qName.equalsIgnoreCase("conductores")) {
			param3 = Double.parseDouble(tempVal);
			System.out.println("Conductores por fase: " + param3);
		}
		else if(qName.equalsIgnoreCase("longitud")) {
			param4 = Double.parseDouble(tempVal);
			System.out.println("Longitud: " + param4);
		}
		
		//Parametros propios de los TRAFOS
		else if(qName.equalsIgnoreCase("potencia")) {
			param1 = Double.parseDouble(tempVal);
			System.out.println("Potencia: " + param1);
		}
		else if(qName.equalsIgnoreCase("tensionCC")) {
			param2 = Double.parseDouble(tempVal);
			System.out.println("Tensión de cortocircuito: " + param2);
		}
		
		//Parametros propios de los MOTORES
		else if(qName.equalsIgnoreCase("tensionNominal")) {
			param1 = Double.parseDouble(tempVal);
			System.out.println("Tensión nominal: " + param1);
		}
		else if(qName.equalsIgnoreCase("potenciaNominal")) {
			param2 = Double.parseDouble(tempVal);
			System.out.println("Potencia nominal: " + param2);
		}
		else if(qName.equalsIgnoreCase("cosenoFi")) {
			param3 = Double.parseDouble(tempVal);
			System.out.println("Coseno Fi: " + param3);
		}
	}
	
	public Componente traerResultado() {
		return builder.traerResultado();
	}

}
