package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que representa el proceso de reserva de una obra.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */
public class Reserva implements guardado {
	private Lector lectorReserva;
	private Ejemplar ejemplarReservado;
	private LocalDateTime fechaReserva;
	private Funcionario funcionario;

	/**
	 * Constructor que crea la reserva.
	 * 
	 * @param lectorReserva     Se pasa un objeto de tipo "Lector" con los datos del
	 *                          lector que hizo la reserva del ejemplar.
	 * @param ejemplarReservado Se pasa un objeto de tipo "Ejemplar" con los datos
	 *                          del ejemplar reservado por el lector.
	 * @param fechaReserva      Se pasa la fecha y hora en la que se hizo la reserva
	 *                          del ejemplar.
	 * @param funcionario       Se pasa un objeto de tipo "Funcionario" con los
	 *                          datos del funcionario que se encargó de realizar la
	 *                          reserva.
	 */
	public Reserva(Lector lectorReserva, Ejemplar ejemplarReservado, LocalDateTime fechaReserva,
			Funcionario funcionario) {
		super();
		this.lectorReserva = lectorReserva;
		this.ejemplarReservado = ejemplarReservado;
		this.fechaReserva = fechaReserva;
		this.funcionario = funcionario;
	}

	/**
	 * Metodo que devuelve un objeto de tipo "Lector" con los atributos de su clase.
	 * 
	 * @return Retorna el objeto con los datos del lector almacenado en el atributo.
	 */
	public Lector getLectorReserva() {
		return lectorReserva;
	}

	/**
	 * Metodo que devuelve un objeto de tipo "Ejemplar" con los atributos de su
	 * clase.
	 * 
	 * @return Retorna el objeto con los datos del ejemplar almacenado en el
	 *         atributo.
	 */
	public Ejemplar getEjemplarReservado() {
		return ejemplarReservado;
	}

	/**
	 * Metodo que devuelve la fecha y hora en la que se hizo la reserva.
	 * 
	 * @return Retorna la fecha y hora almacenada en el atributo.
	 */
	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	/**
	 * Metodo que devuelve un objeto de tipo "Funcionario" con los atributos de su
	 * clase.
	 * 
	 * @return Retorna el objeto con los datos del funcionario almacenado en el
	 *         atributo.
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Metodo que crea un ArrayList de tipo "Object" y va agregando los atributos de
	 * la clase adentro.
	 * 
	 * @return Retorna un ArrayList con los atributos de la instancia creada.
	 */
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getLectorReserva().getNumDoc());
		lista.add(getEjemplarReservado().getIdEjemplar());
		lista.add(getFechaReserva());
		lista.add(getFuncionario().getUsuario());
		return lista;
	}

	/**
	 * Metodo que lee el archivo "Reservas.txt" y retorna un ArrayList con todos los
	 * objetos guardados.
	 * 
	 * @return Devuelve un ArrayList con todos los objetos existentes en el archivo.
	 */
	public static ArrayList<Reserva> leerTexto() {
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Reservas.txt"));
			String res;
			while ((res = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(res, "/");
				lista.add(new Reserva(new Lector(Integer.parseInt(x.nextToken())),
						new Ejemplar(Integer.parseInt(x.nextToken())), LocalDateTime.parse(x.nextToken()),
						new Funcionario(x.nextToken())));
			}
		} catch (Exception e) {
		}
		return lista;
	}

}
