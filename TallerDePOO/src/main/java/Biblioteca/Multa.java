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
public class Multa implements guardado{
	private Long diasMulta;
	private Prestamo prestamo; // Asociacion Multa y Prestamo
	private LocalDateTime fechaHoraMultado;
	/**
	 * Constructor que se usa para crear la multa nueva.
	 * 
	 * @param diasMulta Se pasa un Long con la cantidad de dias de multa que tiene el lector.
	 * @param prestamo 
	 */
	public Multa(Long diasMulta, Prestamo prestamo) {
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
		this.fechaHoraMultado = LocalDateTime.now(); //da la fecha y hora actual.
	}
	
	/**
	 * Constructor que sirve para leer las multas del txt.
	 * 
	 * @param diasMulta Se pasa un Long con los dias de multa que tiene el lector.
	 * @param prestamo 
	 * @param fechaHoraMultado Se pasa la fecha y hora en la que el lector fue multado.
	 */
	public Multa(Long diasMulta, Prestamo prestamo, LocalDateTime fechaHoraMultado) {
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
		this.fechaHoraMultado = fechaHoraMultado;
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
	 * @param diasMulta Se pasa los dias de multa del lector, y se lo agrega al atributo.
	 */
	public void setDiasMulta(Long diasMulta) {
		this.diasMulta = diasMulta;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public Prestamo getPrestamo() {
		return prestamo;
	}

	/**
	 * 
	 * 
	 * @param prestamo
	 */
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public LocalDateTime getFechaHoraMultado() {
		return fechaHoraMultado;
	}

	/**
	 * 
	 * 
	 * @param fechaHoraMultado
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
		lista.add(getPrestamo().getLector());
		lista.add(getFechaHoraMultado());
		return lista;
	}
	
	/**
	 * Metodo que lee el archivo "Multas.txt" y retorna un ArrayList de todos los
	 * objetos que se encuentren ahi.
	 * 
	 * @return Retorna un ArrayList con todos los objetos existentes en el txt.
	 */
	public static ArrayList<Multa> leerTexto(){
		ArrayList<Multa> lista = new ArrayList<Multa>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Multas.txt"));
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");
				lista.add(new Multa(Long.parseLong(x.nextToken()), new Prestamo(new Lector().getNumDoc()),
						LocalDateTime.parse(x.nextToken())));
			}
		} catch (Exception e) {
		}
		return lista;
	}
}
