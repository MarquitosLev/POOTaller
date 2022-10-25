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

	public Ejemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	/**
	 * Constructor usado para la devolucion de un ejemplar.
	 * 
	 * @param idEjemplar
	 * @param observaciones
	 * @param disponible
	 * @param formaAdquirida
	 * @param fechaAdquisicion
	 * @param codUbicacion
	 * @param obra
	 * @param cantPedidas
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
	 * 
	 * 
	 * @param idEjemplar
	 * @param observaciones
	 * @param disponible
	 * @param cantPedidas
	 * @param fechaAdquisicion
	 * @param formaAdquirida
	 * @param fechaDeBaja
	 * @param motivoDeBaja
	 * @param codUbicacion
	 * @param obra
	 * @param lector
	 * @throws BarcodeException
	 * @throws OutputException
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

	public Ejemplar() {
		this.idEjemplar = 0;
		this.observaciones = "";
		this.disponible = true;
		this.cantPedidas = 0;
		this.fechaAdquisicion = LocalDateTime.of(1900, 1, 1, 1, 1);
		// this.formaAdquirida = formaAdquirida.Otro; A esta todavía no la se hacer xd.
		// Creo que hay que modificar algo en la enum.
		this.fechaDeBaja = LocalDateTime.of(1900, 1, 1, 1, 1);
		this.motivoDeBaja = " ";
		this.codUbicacion = " ";
		this.obra = new Obra();
	}

	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	/*
	 * CODIGO DE BARRA
	 */
	private void setCodBarr() throws BarcodeException, OutputException {
		Random r = new Random();
		int ran = r.nextInt(10000);
		String aux = this.codUbicacion + " " + String.valueOf(ran) + " " + String.valueOf(this.idEjemplar);
		Barcode CodBarr = BarcodeFactory.createCode128(aux);
		File file = new File("src/main/java/codigosBarra/" + aux + ".png");
		BarcodeImageHandler.savePNG(CodBarr, file);
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getCantPedidas() {
		return cantPedidas;
	}

	public void setCantPedidas(int cantPedidas) {
		this.cantPedidas = cantPedidas;
	}

	public LocalDateTime getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(LocalDateTime fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public FormaAdquirida getFormaAdquirida() {
		return formaAdquirida;
	}

	public void setFormaAdquirida(FormaAdquirida formaAdquirida) {
		this.formaAdquirida = formaAdquirida;
	}

	public LocalDateTime getFechaDeBaja() {
		return fechaDeBaja;
	}

	public void setFechaDeBaja(LocalDateTime fechaDeBaja) {
		this.fechaDeBaja = fechaDeBaja;
	}

	public String getMotivoDeBaja() {
		return motivoDeBaja;
	}

	public void setMotivoDeBaja(String motivoDeBaja) {
		this.motivoDeBaja = motivoDeBaja;
	}

	public String getCodUbicacion() {
		return codUbicacion;
	}

	public void setCodUbicacion(String codUbicacion) {
		this.codUbicacion = codUbicacion;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

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
