package Biblioteca;
//import java.util.Date;

import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalDate;

/**
 * Clase que representa el proceso de prestamo y devolucion de un ejemplar en la
 * biblioteca.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 *
 */
public class Prestamo implements guardado {
	private LocalDate fechaHoraPrestada;
	private String funcionarioPrestador;
	private LocalDate fechaHoraADevolver;
	private LocalDate fechaDevuelta;
	private String funcionarioDevuelta;
	private Boolean aDomicilio;
	private Lector lector;
	// Asociacion Multa y Prestamo
	private ArrayList<Multa> multas;
	private Ejemplar ejemplar;

	/**
	 * Constructor de la clase Prestamo
	 * 
	 * @param fechaHoraPrestada
	 * @param funcionarioPrestador
	 * @param fechaHoraADevolver
	 * @param lector
	 * @param aDomicilio
	 * @param funcionarios
	 * @param ejemplar
	 */
	public Prestamo(String funcionarioPrestador, Lector lector, Boolean aDomicilio, Ejemplar ejemplar) {
		this.fechaHoraPrestada = LocalDate.now();
		this.funcionarioPrestador = funcionarioPrestador;
		this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
		this.lector = lector;
		this.aDomicilio = aDomicilio;
		this.ejemplar = ejemplar;
	}

	public Prestamo(LocalDate fechaHoraPrestada, String funcionarioPrestador, LocalDate fechaHoraADevolver,
			Boolean aDomicilio, Lector lector, Ejemplar ejemplar) {
		this.fechaHoraPrestada = fechaHoraPrestada;
		this.funcionarioPrestador = funcionarioPrestador;
		this.fechaHoraADevolver = fechaHoraADevolver;
		this.aDomicilio = aDomicilio;
		this.lector = lector;
		this.ejemplar = ejemplar;
	}

	/**
	 * Constructor de la clase Prestamo
	 * 
	 * @param funcionarioPrestador
	 * @param fechaHoraADevolver
	 * @param fechaDevuelta
	 * @param funcionarioDevuelta
	 * @param lector
	 * @param aDomicilio
	 * @param multas
	 * @param funcionarios
	 * @param ejemplar
	 */

	public Prestamo(String funcionarioPrestador, LocalDate fechaDevuelta, String funcionarioDevuelta, Lector lector,
			Boolean aDomicilio, Ejemplar ejemplar) {
		this.fechaHoraPrestada = LocalDate.now();
		this.funcionarioPrestador = funcionarioPrestador;
		this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
		this.fechaDevuelta = fechaDevuelta;
		this.funcionarioDevuelta = funcionarioDevuelta;
		this.lector = lector;
		this.aDomicilio = aDomicilio;
		this.ejemplar = ejemplar;
	}

	/**
	 * Constructor por defecto de la clase.
	 */

	public Prestamo() {
		this.fechaHoraPrestada = LocalDate.now();
		this.funcionarioPrestador = "";
		this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
		this.fechaDevuelta = LocalDate.of(2000, 1, 1);
		this.funcionarioDevuelta = "";
		this.multas = new ArrayList<Multa>();
		this.lector = new Lector();
		this.ejemplar = new Ejemplar();

	}

	public Prestamo(LocalDate fechaHoraPrestada, String funcionarioPrestador, LocalDate fechaHoraADevolver,
			LocalDate fechaDevuelta, String funcionarioDevuelta, Boolean aDomicilio, Lector lector, Ejemplar ejemplar) {
		this.fechaHoraPrestada = fechaHoraPrestada;
		this.funcionarioPrestador = funcionarioPrestador;
		this.fechaHoraADevolver = fechaHoraADevolver;
		this.fechaDevuelta = fechaDevuelta;
		this.funcionarioDevuelta = funcionarioDevuelta;
		this.lector = lector;
		this.aDomicilio = aDomicilio;
		this.ejemplar = ejemplar;
	}

	public ArrayList<Multa> getMultas() {
		return multas;
	}

	public void setMultas(ArrayList<Multa> multas) {
		this.multas = multas;
	}

	public LocalDate getFechaHoraPrestada() {
		return fechaHoraPrestada;
	}

	public String getFuncionarioPrestador() {
		return funcionarioPrestador;
	}

	public void setFuncionarioPrestador(String funcionarioPrestador) {
		this.funcionarioPrestador = funcionarioPrestador;
	}

	public LocalDate getFechaHoraADevolver() {
		return fechaHoraADevolver;
	}

	public void setFechaHoraADevolver() {
		this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
	}

	public LocalDate getFechaDevuelta() {
		return fechaDevuelta;
	}

	public void setFechaDevuelta(LocalDate fechaDevuelta) {
		this.fechaDevuelta = fechaDevuelta;
	}

	public String getFuncionarioDevuelta() {
		return funcionarioDevuelta;
	}

	public void setFuncionarioDevuelta(String funcionarioDevuelta) {
		this.funcionarioDevuelta = funcionarioDevuelta;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Boolean getaDomicilio() {
		return aDomicilio;
	}

	public void setaDomicilio(Boolean aDomicilio) {
		this.aDomicilio = aDomicilio;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public boolean compararFecha() {
		Long x = ChronoUnit.DAYS.between(getFechaHoraADevolver(), getFechaDevuelta());
		if (x >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que crea un ArrayList del tipo 'Object' y agrega los atributos de la
	 * clase dentro.
	 */

	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getFechaHoraPrestada());
		lista.add(getFuncionarioPrestador());
		lista.add(getFechaHoraADevolver());
		lista.add(getaDomicilio());
		lista.add(getLector().getNumDoc());
		lista.add(getEjemplar().getIdEjemplar());
		return lista;
	}
}
