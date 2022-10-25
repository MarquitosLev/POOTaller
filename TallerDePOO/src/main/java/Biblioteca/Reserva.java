package Biblioteca;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Clase que representa el proceso de reserva de una obra. 
 * 
 * @author Leandro Gonzalez Fister
 *
 */

public class Reserva implements guardado {
	private Lector lectorReserva;
	private Ejemplar ejemplarReservado;
	private LocalDateTime fechaReserva;
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
	
	public Reserva(Lector lectorReserva, Ejemplar ejemplarReservado, LocalDateTime fechaReserva, Funcionario funcionario,
			Obra obra) {
		super();
		this.lectorReserva = lectorReserva;
		this.ejemplarReservado = ejemplarReservado;
		this.fechaReserva = fechaReserva;
		this.funcionario = funcionario;
		this.obra = obra;
	}
	
	public Reserva(Lector lectorReserva, Ejemplar ejemplarReservado, LocalDateTime fechaReserva, Funcionario funcionario) {
		super();
		this.lectorReserva = lectorReserva;
		this.ejemplarReservado = ejemplarReservado;
		this.fechaReserva = fechaReserva;
		this.funcionario = funcionario;
	}
	
	public Lector getLectorReserva() {
		return lectorReserva;
	}
	public Ejemplar getEjemplarReservado() {
		return ejemplarReservado;
	}
	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	} 

	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getLectorReserva().getNumDoc());
		lista.add(getEjemplarReservado().getIdEjemplar());
		lista.add(getFechaReserva());
		lista.add(getFuncionario().getUsuario());
		return lista;
	}

	
	
}
