package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que representa la multa que se le coloca a un lector por infringir con
 * los tiempos de devolucion de un ejemplar.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Multa implements guardado {
	private Long diasMulta;
	private Prestamo prestamo; // Asociacion Multa y Prestamo
	private LocalDateTime fechaHoraMultado;
	private Lector lector;

	/**
	 * Constructor que se usa para crear la multa nueva.
	 * 
	 * @param diasMulta Se pasa un Long con la cantidad de dias de multa que tiene
	 *                  el lector.
	 * @param prestamo  Se pasa un objeto de tipo "Prestamo" que contiene todos los
	 *                  atributos de la clase Prestamo.
	 */
	public Multa(Long diasMulta, Prestamo prestamo) {
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
		this.fechaHoraMultado = LocalDateTime.now();
	}

	/**
	 * Constructor que sirve para leer las multas del txt.
	 * 
	 * @param diasMulta        Se pasa un Long con los dias de multa que tiene el
	 *                         lector.
	 * @param prestamo         Se pasa un objeto de tipo "Prestamo" con todos los
	 *                         atributos de la clase Prestamo.
	 * @param fechaHoraMultado Se pasa la fecha y hora en la que el lector fue
	 *                         multado.
	 */
	public Multa(Long diasMulta, Prestamo prestamo, LocalDateTime fechaHoraMultado) {
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
		this.fechaHoraMultado = fechaHoraMultado;
	}

	/**
	 * Constructor usado para 
	 * 
	 * @param diasMulta        Se pasa un Long con los dias de multa que tiene el
	 *                         lector.
	 * @param lector           Se pasa el lector
	 * @param prestamo         Se pasa un objeto de tipo "Prestamo" con todos los
	 *                         atributos de la clase Prestamo.
	 * @param fechaHoraMultado Se pasa la fecha y hora en la que el lector fue
	 *                         multado.
	 */
	public Multa(Long diasMulta, Lector lector, Prestamo prestamo, LocalDateTime fechaHoraMultado) {
		this.diasMulta = diasMulta;
		this.lector = lector;
		this.prestamo = prestamo;
		this.fechaHoraMultado = LocalDateTime.now();
	}

	/**
	 * Metodo que devuelve la cantidad de dias de multa que tiene el lector.
	 * 
	 * @return Retorna un Long con los dias de multa almacenado.
	 */
	public Long getDiasMulta() {
		return diasMulta;
	}

	/**
	 * Metodo que settea el atributo "diasMulta" de la clase.
	 * 
	 * @param diasMulta Se pasa los dias de multa del lector, y se lo agrega al
	 *                  atributo.
	 */
	public void setDiasMulta(Long diasMulta) {
		this.diasMulta = diasMulta;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Lector getLector() {
		return lector;
	}

	/**
	 * 
	 * 
	 * @param lector
	 */
	public void setLector(Lector lector) {
		this.lector = lector;
	}

	/**
	 * Metodo que devuelve un objeto de tipo "Prestamo" con los atributos de su
	 * clase.
	 * 
	 * @return Retorna el objeto almacenado de tipo "Prestamo".
	 */
	public Prestamo getPrestamo() {
		return prestamo;
	}

	/**
	 * Metodo que settea el atributo "prestamo" de la clase.
	 * 
	 * @param prestamo Se pasa un objeto de tipo "Prestamo" con los datos de un
	 *                 prestamo, y se lo agrega al atributo.
	 */
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	/**
	 * Metodo que devuelve la fecha y hora en la que fue multado el lector.
	 * 
	 * @return Retorna la fecha y hora almacenada en el atributo.
	 */
	public LocalDateTime getFechaHoraMultado() {
		return fechaHoraMultado;
	}

	/**
	 * Metodo que settea el atributo "fechaHoraMultado" de la clase.
	 * 
	 * @param fechaHoraMultado Se pasa la fecha y hora en la que fue multado, y se
	 *                         la agrega al atributo.
	 */
	public void setFechaHoraMultado(LocalDateTime fechaHoraMultado) {
		this.fechaHoraMultado = fechaHoraMultado;
	}

	/**
	 * Metodo que se encarga de crear un ArrayList del tipo objeto e ir agregando
	 * los atributos de la clase dentro.
	 * 
	 * @return Retorna un ArrayList con todos los atributos de la clase.
	 */
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getDiasMulta());
		lista.add(getLector().getNumDoc());
		lista.add(getPrestamo().getEjemplar().getIdEjemplar());
		lista.add(getFechaHoraMultado());
		return lista;
	}

	/**
	 * Metodo que lee el archivo "Multas.txt" y retorna un ArrayList de todos los
	 * objetos que se encuentren ahi.
	 * 
	 * @return Retorna un ArrayList con todos los objetos existentes en el txt.
	 */
	public static ArrayList<Multa> leerTexto() {
		ArrayList<Multa> lista = new ArrayList<Multa>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Multas.txt"));
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");
				lista.add(new Multa(Long.parseLong(x.nextToken()), new Lector(Integer.parseInt(x.nextToken())),
						new Prestamo(Integer.parseInt(x.nextToken())), LocalDateTime.parse(x.nextToken())));
			}
		} catch (Exception e) {
		}
		return lista;
	}
}
