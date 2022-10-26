package Biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Random;
import net.sourceforge.barbecue.*;
import net.sourceforge.barbecue.output.OutputException;

public class Ejemplar implements guardado {
	private int idEjemplar;
	private String observaciones;
	private boolean disponible;
	private int cantPedidas;
	private LocalDateTime fechaAdquisicion;
	private FormaAdquirida formaAdquirida;
	private LocalDateTime fechaDeBaja;
	private String motivoDeBaja;
	private String codUbicacion;
	private Obra obra;
	private Lector lector;

	/**
	 * Constructor usado para registrar un nuevo ejemplar.
	 * 
	 * @param idEjemplar     Se pasa un entero con el id del ejemplar.
	 * @param observaciones  Se pasa un texto con las observaciones generales del
	 *                       ejemplar.
	 * @param disponible     Se pasa un valor booleano para ver si el ejemplar se
	 *                       encuentra o no disponible.
	 * @param formaAdquirida Se pasa la forma en la que se adquirio el ejemplar.
	 * @param codUbicacion   Se pasa un String con el codigo de ubicacion del
	 *                       ejemplar.
	 * @param obra           Se pasa un objeto de tipo "Obra" con todos los
	 *                       atributos de la clase Obra.
	 * @throws BarcodeException Se lanza porque sirve para que la libreria del Barcode pueda funcionar
	 * @throws OutputException Se lanza porque sirve para crear el png y poder mostrarlo.
	 */
	public Ejemplar(int idEjemplar, String observaciones, boolean disponible, FormaAdquirida formaAdquirida,
			String codUbicacion, Obra obra) throws BarcodeException, OutputException {

		// pasados por parametro
		this.idEjemplar = idEjemplar;
		this.observaciones = observaciones;
		this.disponible = disponible;
		this.formaAdquirida = formaAdquirida;
		this.codUbicacion = codUbicacion;
		this.obra = obra;
		this.fechaAdquisicion = LocalDateTime.now();
		this.cantPedidas = 0;

		// Codigo de barra
		this.setCodBarr();

	}

	/**
	 * Constructor de la clase Ejemplar (para obtener un ArrayList del tipo prestamo)
	 * 
	 * @param idEjemplar Se pasa por parametro el identificador unico del ejemplar.
	 */
	
	public Ejemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	/**
	 * Constructor usado para la devolucion de un ejemplar.
	 * 
	 * @param idEjemplar Se pasa un entero con el id del ejemplar.
	 * @param observaciones Se pasa un texto con las observaciones generales del ejemplar.
	 * @param disponible Se pasa un valor booleano para ver si el ejemplar se encuentra o no disponible.
	 * @param formaAdquirida Se pasa la forma en la que se adquirio el ejemplar.
	 * @param fechaAdquisicion Se pasa la fecha en la que se adquirio el ejemplar. 
	 * @param codUbicacion Se pasa un String con el codigo de ubicacion del ejemplar.
	 * @param obra Se pasa un objeto de tipo "Obra" con todos los atributos de la clase Obra.
	 * @param cantPedidas Se debe pasar un entero con la cantidad de veces que se ha pedido el ejemplar.
	 */
	public Ejemplar(int idEjemplar, String observaciones, boolean disponible, FormaAdquirida formaAdquirida,
			LocalDateTime fechaAdquisicion, String codUbicacion, Obra obra, int cantPedidas) {

		this.idEjemplar = idEjemplar;
		this.observaciones = observaciones;
		this.disponible = disponible;
		this.formaAdquirida = formaAdquirida;
		this.codUbicacion = codUbicacion;
		this.obra = obra;
		this.fechaAdquisicion = fechaAdquisicion;
		this.cantPedidas = cantPedidas;
	}

	/**
	 * Constructor default para la clase Ejemplares.
	 * 
	 * @param idEjemplar Se pasa por el parametro, el identificador unico del ejemplar.
	 * @param observaciones Se pasa un texto con las observaciones generales del ejemplar.
	 * @param disponible Se pasa un valor booleano para ver si el ejemplar se encuentra o no disponible.
	 * @param cantPedidas Se debe pasar un entero con la cantidad de veces que se ha pedido el ejemplar.
	 * @param fechaAdquisicion Se pasa la fecha en la que se adquirio el ejemplar. 
	 * @param formaAdquirida Se pasa la forma en la que se adquirio el ejemplar.
	 * @param fechaDeBaja Se pasa por el parametro la fecha enlaque se da de baja en ejemplar. 
	 * @param motivoDeBaja Se pasa por el parametro el motivo por el cual se dio de baja. 
	 * @param codUbicacion Se pasa un String con el codigo de ubicacion del ejemplar.
	 * @param obra Se pasa un objeto de tipo "Obra" con todos los atributos de la clase Obra.
	 * @param lector Se debe pasar como parametro un objeto del tipo Lector
	 * @throws BarcodeException Excepcion necesaria para la correcta generacion del codigo de barrras.
	 * @throws OutputException Excepcion necesaria para que pueda generarse el PNG y pueda mostrarse el codigo de barras.
	 */
	public Ejemplar(int idEjemplar, String observaciones, boolean disponible, int cantPedidas,
			LocalDateTime fechaAdquisicion, FormaAdquirida formaAdquirida, LocalDateTime fechaDeBaja,
			String motivoDeBaja, String codUbicacion, Obra obra, Lector lector)
			throws BarcodeException, OutputException {
		this.idEjemplar = idEjemplar;
		this.observaciones = observaciones;
		this.disponible = disponible;
		this.cantPedidas = cantPedidas;
		this.fechaAdquisicion = fechaAdquisicion;
		this.formaAdquirida = formaAdquirida;
		this.fechaDeBaja = LocalDateTime.now();
		this.motivoDeBaja = motivoDeBaja;
		this.codUbicacion = codUbicacion;
		this.obra = obra;
		this.lector = lector;

	}

	/**
	 * Getter que devuelve el valor de 'idEjemplar'
	 * 
	 * @return Retorna el identificador unico del ejemplar.
	 */
	
	public int getIdEjemplar() {
		return idEjemplar;
	}

	/**
	 * Setter que guarda un valor en el atributo 'idEjemplar'
	 * 
	 * @param idEjemplar Se pasa por el parametor, el identificador unico del ejemplar. 
	 */
	
	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	/**
	 * Metodo que se encarga de generar un codigo de barras en base al código de ubicacion de un ejemplar, 
	 * un numero aleatorio y su identificador unico.
	 * 
	 * @throws BarcodeException Excepcion requerida por parte del modulo Barcode para poder generar el codigo de barras.
	 * @throws OutputException Excepcion necesaria para poder generar el PNG del codigo de barras y mostrarlo.
	 */
	private void setCodBarr() throws BarcodeException, OutputException {
		Random r = new Random();
		int ran = r.nextInt(10000);
		String aux = this.codUbicacion + " " + String.valueOf(ran) + " " + String.valueOf(this.idEjemplar);
		Barcode CodBarr = BarcodeFactory.createCode128(aux);
		File file = new File("src/main/java/codigosBarra/" + aux + ".png");
		BarcodeImageHandler.savePNG(CodBarr, file);
	}

	/**
	 * Metodo que se encarga de mostrar las observaciones.
	 * 
	 * @return Retorna las observaciones que el funcionario haya ingresaso
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Metodo que sirve para setear el valor del atributo observaciones.
	 * 
	 * @param observaciones Las observaciones que el funcionario ingresa para ser guardadas.
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * Metodo que retorna la disponibilidad del ejemplar.
	 * 
	 * @return Retorna 'true' en el caso de que se encuentre diponible y 'false' en caso contrario
	 */
	public boolean getDisponible() {
		return disponible;
	}
	
	/**
	 * Metodo setter para guardar la disponibilidad.
	 * 
	 * @param disponible Parametro que sirve para asignarle la disponibilidad del ejemplar.
	 */

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Getter que retorna el atributo 'cantPedidas'
	 * 
	 * @return Retorna la cantidad de veces que se ha pedido el ejemplar.
	 */
	
	public int getCantPedidas() {
		return cantPedidas;
	}

	/**
	 * Setter que guarda un valor en el atributo 'canPedidas'
	 * 
	 * @param cantPedidas Se pasa por medio de este, la cantidad de veces que le ejemplar fue pedido.
	 */
	
	public void setCantPedidas(int cantPedidas) {
		this.cantPedidas = cantPedidas;
	}
	
	/**
	 * Getter que retorna el valor del atributo 'getFechaAdquisicion'
	 * 
	 * @return Retorna la fecha en la que se adquirio el ejemplar.
	 */

	public LocalDateTime getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	
	/**
	 * Setter que se encarga de guardar un valor en 'fechaAdquisición'
	 * 
	 * @param fechaAdquisicion se pasa por parámetro la fecha en la que se adquirio el ejemplar.
	 */

	public void setFechaAdquisicion(LocalDateTime fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	/**
	 * Getter que retorna el valor que tome la enumeracion 'formaAdquirida'
	 * 
	 * @return Retorna la forma en la que se adquirio el ejemplar.
	 */
	
	public FormaAdquirida getFormaAdquirida() {
		return formaAdquirida;
	}
	
	/**
	 * Setter que guardar el valor en el atributo 'formaAdquirida'
	 * 
	 * @param formaAdquirida Se pasa la por este parametro, la forma en la que se adquirio el ejemplar.
	 */

	public void setFormaAdquirida(FormaAdquirida formaAdquirida) {
		this.formaAdquirida = formaAdquirida;
	}
	
	/**
	 * Getter que retorna el valor de 'fechaDeBaja' 
	 * 
	 * @return Retorna la fecha en la que se dio de baja el ejemplar. 
	 */

	public LocalDateTime getFechaDeBaja() {
		return fechaDeBaja;
	}

	/**
	 * Setter que se encarga de guardar un valor en 'fechaDeBaja'
	 * 
	 * @param fechaDeBaja Parametro por el que se pasa la fecha de baja de un ejemplar.
	 */
	
	public void setFechaDeBaja(LocalDateTime fechaDeBaja) {
		this.fechaDeBaja = fechaDeBaja;
	}
	
	/**
	 * Getter que retorna el valor de 'motivoDeBaja'
	 * 
	 * @return Retorna el motivo por el cual el ejemplar se dio de baja.
	 */

	public String getMotivoDeBaja() {
		return motivoDeBaja;
	}

	/**
	 * Setter que guarda el valor en el atributo 'motivoDeBaja'
	 * 
	 * @param motivoDeBaja Se pasa un string en el que se establece el modtivo de la baja del ejemplar
	 */
	
	public void setMotivoDeBaja(String motivoDeBaja) {
		this.motivoDeBaja = motivoDeBaja;
	}
	
	/**
	 * Getter que devuelve el valor del atributo 'codUbicacion'
	 * 
	 * @return Retorna el codigo de ubicacion del ejemplar.
	 */

	public String getCodUbicacion() {
		return codUbicacion;
	}
	
	/**
	 * Setter que guarda un valor en 'codUbicacion'
	 * 
	 * @param codUbicacion A traves del parametro, se pasa el codigo de ubicacion para ser guardado en el atributo correspondiente.
	 */

	public void setCodUbicacion(String codUbicacion) {
		this.codUbicacion = codUbicacion;
	}
	
	/**
	 * Getter que retorna los datos de 'obra'
	 * 
	 * @return Retorna los datos de la obra a la que pertenece el ejemplar.
	 */

	public Obra getObra() {
		return this.obra;
	}

	/**
	 * Setter que guarda un valor dentro de 'obra'
	 *  
	 * @param obra Se pasa un objeto del tipo 'Obra' para ser guardado en el atributo 'obra'
	 */
	
	public void setObra(Obra obra) {
		this.obra = obra;
	}

	/**
	 * Getter que retorna el valor que se encuentra en el atribot 'lector'
	 * 
	 * @return Retorna todos los datos del objeto Lector que se encuentra en 'lector'
	 */
	
	public Lector getLector() {
		return lector;
	}
	
	/**
	 * Setter que guarda un valor en 'lector'
	 * 
	 * @param lector Se debe pasar un objeto del tipo Lector para que sea guardado en 'lector'
	 */
	
	public void setLector(Lector lector) {
		this.lector = lector;
	}

	/**
	 * Metodo que crea un ArrayList para almacenar los datos de la clase. 
	 * 
	 * @return Retorna un ArrayList con los datos del ejemplar. 
	 */
	
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getIdEjemplar());
		lista.add(getObservaciones());
		lista.add(getDisponible());
		lista.add(getFormaAdquirida());
		lista.add(getFechaAdquisicion());
		lista.add(getCodUbicacion());
		lista.add(getObra().getTitulo());
		lista.add(getCantPedidas());
		return lista;
	}

	/**
	 * Metodo que lee el archivo 'Ejemplares.txt' y agrega todos los datos del ejemplar a un ArrayList
	 * 
	 * @return Retorna la lista con los datos del Ejemplar, extraidos de 'Ejemplares.txt'
	 * @throws Es necesario el uso de "try - catch" para el funcionamiento del 'BufferedReader'
	 * 
	 */
	
	public static ArrayList<Ejemplar> leerTexto() {
		ArrayList<Ejemplar> lista = new ArrayList<Ejemplar>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Ejemplares.txt"));
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");
				lista.add(new Ejemplar(Integer.parseInt(x.nextToken()), x.nextToken(),
						Boolean.parseBoolean(x.nextToken()), FormaAdquirida.valueOf(x.nextToken()),
						LocalDateTime.parse(x.nextToken()), x.nextToken(), new Obra(x.nextToken()),
						Integer.parseInt(x.nextToken())));

			}
		} catch (Exception e) {
		}
		return lista;
	}

}
