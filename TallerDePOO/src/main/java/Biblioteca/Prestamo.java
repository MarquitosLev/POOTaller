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
 * @author Santiago Fernandez Gomez
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
	private Ejemplar ejemplar;

	/**
	 * Constructor de la clase Prestamo (principal)
	 * 
	 * @param funcionarioPrestador Parametro que establece el nombre del funcionario que realiza el prestamo
	 * @param lector Parametro del tipo Lector que contiene los datos de dicho objeto 
	 * @param aDomicilio Parametro booleano que permite saber si el prestamo es adomicilio (True) o en la biblioteca (False)
	 * @param ejemplar Parametro del tipo Ejemplar que contiene los datos de dicho objeto
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
	
	/**
	 * Constructor de la clase Prestamo (Usado para el metodo 'leerTexto')
	 * 
	 * @param fechaHoraPrestada Parametro por el cual se pasa la fecha y hora del prestamo.
	 * @param funcionarioPrestador Parametro por el que se pasa el nombre del funcionario que realiza el prestamo.
	 * @param fechaHoraADevolver Parametro por el cual se pasa la fecha y hora en la que deberia devolverse el ejemplar.
	 * @param aDomicilio Parametro por el que se pasa si el prestamo es a domicilio (True) o si no lo es (False)
	 * @param lector Parametro del tipo Lector que contiene los datos de dicho objeto.
	 * @param ejemplar Parametro del tipo Ejemplar que contiene los datos de dicho objeto. 
	 */

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
	 * Constructor de la clase prestamo.
	 * 
	 * @param id Se pasa un entero que representa el identificador unico del ejemplar.
	 */

	public Prestamo(int id) {
		this.ejemplar = new Ejemplar(id);
	}

	/**
	 * Constructor para la clase prestamo (prestamos terminados)
	 * 
	 * @param fechaHoraPrestada Parametro por el cual se pasa la fecha y hora del prestamo.
	 * @param funcionarioPrestador Parametro por el que se pasa el nombre del funcionario que realiza el prestamo.
	 * @param fechaHoraADevolver Parametro por el cual se pasa la fecha y hora en la que deberia devolverse el ejemplar.
	 * @param fechaDevuelta Parametro por el cual se pasa la fecha en la que se produce la devolucion del ejemplar
	 * @param funcionarioDevuelta Parametro por el que se pasa el nombre del funcionario que recibe la devolucion
	 * @param aDomicilio Parametro por el que se pasa si el prestamo es a domicilio (True) o si no lo es (False)
	 * @param lector Parametro del tipo Lector que contiene los datos de dicho objeto.
	 * @param ejemplar Parametro del tipo Ejemplar que contiene los datos de dicho objeto.
	 */
	
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

	/**
	 * Getter que retorna el valor del atributo 'fechHoraPrestada'
	 * 
	 * @return Retorna la fecha y hora en la que se realizo el prestamo del ejemplar.
	 */
	
	public LocalDateTime getFechaHoraPrestada() {
		return fechaHoraPrestada;
	}
	
	/**
	 * Getter que retorna el valor del atributo funcionarioPrestador.
	 * 
	 * @return Retorna el nombre del funcionario que realizo el prestamo.
	 */

	public String getFuncionarioPrestador() {
		return funcionarioPrestador;
	}
	
	/**
	 * Setter que guarda un valor en el atributo 'funcionarioPrestador'
	 * 
	 * @param funcionarioPrestador Por medio del parametro se pasa el nombre del funcionario que realiza el prestamo
	 */

	public void setFuncionarioPrestador(String funcionarioPrestador) {
		this.funcionarioPrestador = funcionarioPrestador;
	}

	/**
	 * Getter que retorna el valor del atributo 'fechaHoraADevolver'
	 * 
	 * @return Retorna la fecha y hora en la que deberia ser devuelto el ejemplar.
	 */
	
	public LocalDateTime getFechaHoraADevolver() {
		return fechaHoraADevolver;
	}
	
	/**
	 * Setter que guarda un valor en el atributo 'fechaHoraADevolver'
	 * 
	 * @param fechaHoraADevolver Se debe pasar la fecha y hora en la que se debe devolvolver el ejemplar
	 */

	public void setFechaHoraADevolver(LocalDateTime fechaHoraADevolver) {
		this.fechaHoraADevolver = fechaHoraADevolver;
	}
	
	/**
	 * Getter que retorna el valor del atributo 'fechaDevuelta'
	 * 
	 * @return Retorna la fecha en la que deberia ser devuelto el ejemplar
	 */

	public LocalDateTime getFechaDevuelta() {
		return fechaDevuelta;
	}

	/**
	 * Setter que guarda un valor en el atributo 'fechaDevuelta'
	 * 
	 * @param fechaDevuelta Se debe pasar la fecha en la que deberia devolverse el ejemplar
	 */
	
	public void setFechaDevuelta(LocalDateTime fechaDevuelta) {
		this.fechaDevuelta = fechaDevuelta;
	}

	/**
	 * Getter que retorna el valor del atributo 'funcionarioDevuelta'
	 * 
	 * @return Retorna el nombre del funcionario que recibe la devolucion. 
	 */
	
	public String getFuncionarioDevuelta() {
		return funcionarioDevuelta;
	}

	/**
	 * Setter que guarda un valor en el atributo 'funcionarioDevuelta'
	 * 
	 * @param funcionarioDevuelta Se pasa por parametro, un string con el nombre de funcionario que recibe la devolucion. 
	 */
	
	public void setFuncionarioDevuelta(String funcionarioDevuelta) {
		this.funcionarioDevuelta = funcionarioDevuelta;
	}

	/**
	 * Getter que retorna el valor del atributo 'lector'
	 * 
	 * @return Retorna los datos del lector que pide el prestamo. 
	 */
	
	public Lector getLector() {
		return lector;
	}
	
	/**
	 * Getter que retorna el valor del atributo 'lector'
	 * 
	 * @param lector Se pasa como parametro un objeto del tipo Lector
	 */

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	/**
	 * Getter que retorna el valor del atributo 'aDomicilio'
	 * 
	 * @return Retorna un booleano en 'True' si el ejemplar fue prestado a domicilio y 'False' si es prestado para lectura en la biblioteca
	 */
	
	public Boolean getaDomicilio() {
		return aDomicilio;
	}

	/**
	 * Setter que guarda un valor en el atributo 'aDomicilio'
	 * 
	 * @param aDomicilio Se le pasa un booleano en 'true' 
	 */
	
	public void setaDomicilio(Boolean aDomicilio) {
		this.aDomicilio = aDomicilio;
	}

	/**
	 * Getter que retorna el valor del atributo 'ejemplar'
	 * 
	 * @return Retorna los datos del ejemplar que se presto. 
	 */
	
	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	/**
	 * Setter que guarda un valor en el atributo 'ejemplar'
	 * 
	 * @param ejemplar Se ingresa un objeto del tipo Ejemplar para ser almacenado en el atributo 'ejemplar'
	 */
	
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	/**
	 * Metodo que crea un ArrayList del tipo 'Object' y agrega los atributos de la
	 * clase dentro.
	 * 
	 * @return Retorna una lista con con los datos de la clase. 
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
	
	/**
	 * Metodo que se encarga de leer el archivo 'Prestamos.txt', tomar sus elementos y guardarlos en un ArrayList
	 * 
	 * @param num Se debe pasar el entero '1' en caso de que se quiera leer y almacenar los datos del 'Prestamos.txt' o el entero '2' en el caso
	 * de que se quieran leer los datos del archivo 'PrestamosTerminados.txt'
	 * 
	 * @return Retorna un ArrayList con los datos que hayan sido solicitados por medio del parámetro. 
	 * 
	 * @throws Ambos try-catch se utilizan para que el 'BufferedReader' pueda funcionar. 
	 * 
	 */
	
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
