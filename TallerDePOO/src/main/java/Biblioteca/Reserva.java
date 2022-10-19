package Biblioteca;
import java.time.LocalDate;

/**
 * Clase que representa el proceso de reserva de una obra. 
 * 
 * @author Leandro Gonzalez Fister
 *
 */

public class Reserva {
	private Lector lectorReserva;
	private Ejemplar ejemplarReservado;
	private LocalDate fechaReserva;
	private Funcionario funcionario;
	private Obra obra;
	
	/**
	 * Constructor de la clase 'Reserva'
	 * 
	 * @param lectorReserva
	 * @param ejemplarReservado
	 * @param fechaReserva
	 * @param funcionario
	 * @param obra
	 */
	
	public Reserva(Lector lectorReserva, Ejemplar ejemplarReservado, LocalDate fechaReserva, Funcionario funcionario,
			Obra obra) {
		super();
		this.lectorReserva = lectorReserva;
		this.ejemplarReservado = ejemplarReservado;
		this.fechaReserva = fechaReserva;
		this.funcionario = funcionario;
		this.obra = obra;
	}
	public Lector getLectorReserva() {
		return lectorReserva;
	}
	public Ejemplar getEjemplarReservado() {
		return ejemplarReservado;
	}
	public LocalDate getFechaReserva() {
		return fechaReserva;
	} 
	
}
