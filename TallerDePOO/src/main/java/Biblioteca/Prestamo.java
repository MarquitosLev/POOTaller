package Biblioteca;
//import java.util.Date;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.time.temporal.ChronoUnit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

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
	private LocalDateTime fechaHoraPrestada;
	private String funcionarioPrestador;
	private LocalDateTime fechaHoraADevolver;
	private LocalDateTime fechaDevuelta;
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
		this.aDomicilio = aDomicilio;
		this.fechaHoraPrestada = LocalDateTime.now();
		this.funcionarioPrestador = funcionarioPrestador;
		if (this.aDomicilio) {
			this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
		} else {
			this.fechaHoraADevolver = this.fechaHoraPrestada.plusHours(3);
		}
		this.lector = lector;
		this.ejemplar = ejemplar;
		
		
	}

	public Prestamo(LocalDateTime fechaHoraPrestada, String funcionarioPrestador, LocalDateTime fechaHoraADevolver,
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

	public Prestamo(String funcionarioPrestador, LocalDateTime fechaDevuelta, String funcionarioDevuelta, Lector lector,
			Boolean aDomicilio, Ejemplar ejemplar) {
		this.fechaHoraPrestada = LocalDateTime.now();
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
	 * @param id 
	 */

	public Prestamo(int id) {
		this.ejemplar = new Ejemplar(id);

	}

	public Prestamo(LocalDateTime fechaHoraPrestada, String funcionarioPrestador, LocalDateTime fechaHoraADevolver,
			LocalDateTime fechaDevuelta, String funcionarioDevuelta, Boolean aDomicilio, Lector lector, Ejemplar ejemplar) {
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

	public LocalDateTime getFechaHoraPrestada() {
		return fechaHoraPrestada;
	}

	public String getFuncionarioPrestador() {
		return funcionarioPrestador;
	}

	public void setFuncionarioPrestador(String funcionarioPrestador) {
		this.funcionarioPrestador = funcionarioPrestador;
	}

	public LocalDateTime getFechaHoraADevolver() {
		return fechaHoraADevolver;
	}

	public void setFechaHoraADevolver(LocalDateTime fechaHoraADevolver) {
		this.fechaHoraADevolver = fechaHoraADevolver;
	}

	public LocalDateTime getFechaDevuelta() {
		return fechaDevuelta;
	}

	public void setFechaDevuelta(LocalDateTime fechaDevuelta) {
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
	//Se le pasa un 1 si se requiere un Array con los prestamos pendientes
	//Se le pasa un 2 si se requiere un Array con los prestamos ya terminados
	public static ArrayList<Prestamo> leerTexto(int num){
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		if (num == 1) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("Prestamos.txt"));
				String lector;
				while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
					StringTokenizer x = new StringTokenizer(lector, "/");
					lista.add(new Prestamo(LocalDateTime.parse(x.nextToken()), x.nextToken(), LocalDateTime.parse(x.nextToken()),
							Boolean.parseBoolean(x.nextToken()), new Lector(Integer.parseInt(x.nextToken())),
									new Ejemplar(Integer.parseInt(x.nextToken()) )));
	
				}
			} catch (Exception e) {
			}
			return lista;
		} else {
			try {
				BufferedReader br = new BufferedReader(new FileReader("PrestamosTerminados.txt"));
				String lector;
				while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
					StringTokenizer x = new StringTokenizer(lector, "/");
					lista.add(new Prestamo(LocalDateTime.parse(x.nextToken()), x.nextToken(), LocalDateTime.parse(x.nextToken()),
							LocalDateTime.parse(x.nextToken()), x.nextToken(),
							Boolean.parseBoolean(x.nextToken()), new Lector(Integer.parseInt(x.nextToken())),
									new Ejemplar(Integer.parseInt(x.nextToken()) )));
	
				}
			} catch (Exception e) {
			}
			return lista;
	}
}
}
