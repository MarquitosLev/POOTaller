package Biblioteca;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

/**
 * Clase que representa al lector.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */

public class Lector extends Persona implements guardado {
	private int canMulta;
	private Boolean estaMultado;
	private Long diasMultado;
	private String clase;

	/**
	 * Constructor que se usa para asignarle las multas a los lectores (incluidos
	 * alumnos y docentes).
	 * 
	 * @param nom         Se pasa un texto que contiene el/los nombre/s del lector.
	 * @param apellido    Se pasa un texto con el/los apellido/s del lector.
	 * @param tipDoc      Se pasa un texto con el tipo de documento del lector.
	 * @param numDoc      Se pasa un entero con el numero de documento del lector.
	 * @param correo      Se pasa un texto con el correo perteneciente al lector.
	 * @param numCel      Se pasa un entero con el numero de celular del lector.
	 * @param fecNac      Se pasa la fecha de nacimiento del lector, que es de tipo
	 *                    "LocalDate".
	 * @param sex         Se pasa un texto que contiene el sexo con el que se siente
	 *                    identificado el lector.
	 * @param nac         Se pasa un texto con el lugar donde nacio el lector.
	 * @param domi        Se pasa un texto con el domicilio donde reside el lector.
	 * @param codPos      Aqui se encuentra el codigo postal, que es un entero.
	 * @param dep         Se pasa un texto con el departamento donde se encuentra
	 *                    ubicado el lector.
	 * @param localidad   Se pasa un texto en el que esta la localidad donde vive
	 *                    actualmente el lector.
	 * @param canMulta    Se pasa un entero con la cantidad de multas que tiene el
	 *                    lector.
	 * @param estaMultado Se pasa un valor booleano en el que se indica si el lector
	 *                    esta multado o no.
	 * @param diasMultado Se pasa un Long con la cantidad de dias que esta multado
	 *                    el lector.
	 * @param clase       Se pasa un texto con el tipo de lector (Si es alumno,
	 *                    docente o publico en general).
	 */
	public Lector(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, int canMulta,
			Boolean estaMultado, Long diasMultado, String clase) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.canMulta = canMulta;
		this.estaMultado = estaMultado;
		this.diasMultado = diasMultado;
		this.clase = clase;
	}

	/**
	 * Constructor que se usa para registrar un nuevo lector.
	 * 
	 * @param nom       Se pasa un texto que contiene el/los nombre/s del lector.
	 * @param apellido  Se pasa un texto con el/los apellido/s del lector.
	 * @param tipDoc    Se pasa un texto con el tipo de documento del lector.
	 * @param numDoc    Se pasa un entero con el numero de documento del lector.
	 * @param correo    Se pasa un texto con el correo perteneciente al lector.
	 * @param numCel    Se pasa un entero con el numero de celular del lector.
	 * @param fecNac    Se pasa la fecha de nacimiento del lector, que es de tipo
	 *                  "LocalDate".
	 * @param sex       Se pasa un texto que contiene el sexo con el que se siente
	 *                  identificado el lector.
	 * @param nac       Se pasa un texto con el lugar donde nacio el lector.
	 * @param domi      Se pasa un texto con el domicilio donde reside el lector.
	 * @param codPos    Aqui se encuentra el codigo postal, que es un entero.
	 * @param dep       Se pasa un texto con el departamento donde se encuentra
	 *                  ubicado el lector.
	 * @param localidad Se pasa un texto en el que esta la localidad donde vive
	 *                  actualmente el lector.
	 * @param clase     Se pasa un texto con el tipo de lector (Si es alumno,
	 *                  docente o publico en general).
	 */
	public Lector(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, String clase) {

		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.canMulta = 0;
		this.estaMultado = false;
		this.diasMultado = (long) 0;
		this.clase = this.getClass().getSimpleName();
	}

	/**
	 * Constructor usado para asignarle a un prestamo el tipo de lector.
	 * 
	 * @param numDoc Se pasa un entero con el numero de documento del lector.
	 */
	public Lector(int numDoc) {
		super(numDoc);
	}

	/**
	 * Metodo que devuelve un entero con la cantidad de multas que tiene el lector.
	 * 
	 * @return Retorna la cantidad de multas almacenada en el atributo.
	 */
	public int getCanMulta() {
		return canMulta;
	}

	/**
	 * Metodo que settea el atributo "canMulta" de la clase.
	 * 
	 * @param canMulta Se pasa la cantidad de multas a agregar.
	 */
	public void setCanMulta(int canMulta) {
		this.canMulta = canMulta;
	}

	/**
	 * Metodo que devuelve un valor booleano que indica si el lector se encuentra
	 * multado o no.
	 * 
	 * @return Retorna "True" si esta multado, o "False" si no lo esta.
	 */
	public Boolean getEstaMultado() {
		return estaMultado;
	}

	/**
	 * Metodo que settea el atributo "estaMultado" de la clase.
	 * 
	 * @param estaMultado Se pasa el valor booleano que indica si esta o no multado,
	 *                    y se lo agrega al atributo.
	 */
	public void setEstaMultado(Boolean estaMultado) {
		this.estaMultado = estaMultado;
	}

	/**
	 * Metodo que llama al toString de la clase Persona, y retorna todos los
	 * atributos que hay en ella.
	 * 
	 * @return Retorna un String con todos los atributos de la clase Persona.
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * Metodo que devuelve un Long con la cantidad de dias de multa que tiene el
	 * lector.
	 * 
	 * @return Retorna la cantidad de dias de multa almacenada en el atributo.
	 */
	public Long getDiasMultado() {
		return diasMultado;
	}

	/**
	 * Metodo que settea el atributo "diasMultado" de la clase.
	 * 
	 * @param diasMultado Se pasa la cantidad de dias de multa del lector, y se lo
	 *                    agrega al atributo.
	 */
	public void setDiasMultado(Long diasMultado) {
		this.diasMultado = diasMultado;
	}

	/**
	 * Metodo que devuelve un String con el tipo de lector (que puede ser alumno,
	 * docente, o publico en general).
	 * 
	 * @return Retorna el tipo de lector almacenado en el atributo.
	 */
	public String getClase() {
		return clase;
	}

	/**
	 * Metodo que settea el atributo "clase".
	 * 
	 * @param clase Se pasa el tipo de lector, y se lo agrega al atributo.
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

	/**
	 * Metodo que se encarga de crear un ArrayList del tipo 'Object' y agrega a los
	 * atributos de la clase dentro.
	 * 
	 * @return Retorna un ArrayList con los atributos de la instancia creada.
	 */
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getNom());
		lista.add(getApellido());
		lista.add(getTipDoc());
		lista.add(getNumDoc());
		lista.add(getCorreo());
		lista.add(getNumCel());
		lista.add(getFecNac());
		lista.add(getSex());
		lista.add(getLugarNac());
		lista.add(getDomi());
		lista.add(getCodPos());
		lista.add(getDep());
		lista.add(getLocalidad());
		lista.add(getCanMulta());
		lista.add(getEstaMultado());
		lista.add(getDiasMultado());
		lista.add(this.getClass().getSimpleName());
		lista.add("");
		return lista;
	}

	/**
	 * Metodo que lee el archivo "Lectores.txt" y retorna un ArrayList con todos los
	 * objetos guardados.
	 * 
	 * @return Devuelve un ArrayList con todos los objetos existentes en el archivo.
	 */
	public static ArrayList<Lector> leerTexto() {
		ArrayList<Lector> lista = new ArrayList<Lector>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Lectores.txt"));
			String leer;
			while ((leer = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(leer, "/");
				lista.add(new Lector(x.nextToken(), x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()),
						x.nextToken(), Integer.parseInt(x.nextToken()), LocalDate.parse(x.nextToken()), x.nextToken(),
						x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()), x.nextToken(), x.nextToken(),
						Integer.parseInt(x.nextToken()), Boolean.parseBoolean(x.nextToken()),
						Long.parseLong(x.nextToken()), x.nextToken()));
			}
		} catch (Exception e) {
		}
		return lista;
	}

}