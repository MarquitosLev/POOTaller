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
	 * Constructor parametrizado de la clase.
	 * 
	 * @param diasMulta 
	 * @param prestamo
	 */
	public Multa(Long diasMulta, Prestamo prestamo) {
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
		this.fechaHoraMultado = LocalDateTime.now();
	}
	
	public Multa(Long diasMulta, Prestamo prestamo, LocalDateTime fechaHoraMultado) {
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
		this.fechaHoraMultado = fechaHoraMultado;
	}

	public Long getDiasMulta() {
		return diasMulta;
	}

	public void setDiasMulta(Long diasMulta) {
		this.diasMulta = diasMulta;
	}
	
	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	public LocalDateTime getFechaHoraMultado() {
		return fechaHoraMultado;
	}

	public void setFechaHoraMultado(LocalDateTime fechaHoraMultado) {
		this.fechaHoraMultado = fechaHoraMultado;
	}

	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getDiasMulta());
		lista.add(getPrestamo().getLector());
		lista.add(getFechaHoraMultado());
		return lista;
	}
	
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
