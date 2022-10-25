package Biblioteca;
import java.util.ArrayList;
import java.util.StringTokenizer;



import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

/**
 * Clase que representa al lector.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */

public class Lector extends Persona implements guardado{
	private int canMulta;
	private Boolean estaMultado;
	private Long diasMultado;
	
	
	/**
	 * Constructor parametrizado de la clase.
	 * 
	 * @param nom
	 * @param apellido
	 * @param tipDoc
	 * @param numDoc
	 * @param correo
	 * @param numCel
	 * @param fecNac
	 * @param sex
	 * @param nac
	 * @param domi
	 * @param codPos
	 * @param dep
	 * @param localidad
	 * @param canMulta
	 * @param estaMultado
	 * @param ejemplares
	 */
	
	public Lector(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, int canMulta,
			Boolean estaMultado, Long diasMultado) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.canMulta = canMulta;
		this.estaMultado = estaMultado;
		this.diasMultado = diasMultado;
	}
	
	
	/**
	 * Constructor que agrega datos del Lector.
	 * 
	 * @param nom
	 * @param apellido
	 * @param tipDoc
	 * @param numDoc
	 * @param correo
	 * @param numCel
	 * @param fecNac
	 * @param sex
	 * @param nac
	 * @param domi
	 * @param codPos
	 * @param dep
	 * @param localidad
	 * 
	 */
	public Lector(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad) {
		
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.canMulta = 0;
		this.estaMultado = false;
		this.diasMultado = (long) 0;
	}
	
	/**
	 * Constructor del lector que asigna datos por defecto a los atributos relacionados a sus multas y los ejemplares que posee. 
	 */
	
	public Lector(int numDoc) {
		super(numDoc);
	}
	
	
	
	public Lector() {
		this.canMulta = 0;
		this.estaMultado = false;
	}

	public int getCanMulta() {
		return canMulta;
	}

	public void setCanMulta(int canMulta) {
		this.canMulta = canMulta;
	}

	public Boolean getEstaMultado() {
		return estaMultado;
	}

	public void setEstaMultado(Boolean estaMultado) {
		this.estaMultado = estaMultado;
	}

	public String toString() {
		return super.toString();
	}
	
	public Long getDiasMultado() {
		return diasMultado;
	}


	public void setDiasMultado(Long diasMultado) {
		this.diasMultado = diasMultado;
	}
	
	

	/**
	 * Metodo que se encarga de crear un ArrayList del tipo 'Object' y agrega a los atributos de la clase dentro.
	 */
	
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object>  lista = new ArrayList<Object> ();
		lista.add(getNom());
		lista.add(getApellido());
		lista.add(getTipDoc());
		lista.add(getNumDoc());
		lista.add(getCorreo());
		lista.add(getNumCel());
		lista.add(getFecNac());
		lista.add(getSex());
		lista.add(getLugarNac());
		lista.add(getDomi());
		lista.add(getCodPos());
		lista.add(getDep());
		lista.add(getLocalidad());
		lista.add(getCanMulta());
		lista.add(getEstaMultado());
		lista.add(getDiasMultado());
		lista.add(this.getClass().getSimpleName());
		lista.add("");
		return lista;
	}
	
	public static ArrayList<Lector> leerTexto(){
		ArrayList<Lector> lista = new ArrayList<Lector>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Lectores.txt"));
			String leer;
			while ((leer = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(leer, "/");
				lista.add(new Lector(x.nextToken(), x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()),
						x.nextToken(), Integer.parseInt(x.nextToken()), LocalDate.parse(x.nextToken()), x.nextToken(),
						x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()), x.nextToken(), x.nextToken(),
						Integer.parseInt(x.nextToken()), Boolean.parseBoolean(x.nextToken()), Long.parseLong(x.nextToken())));
			}
		} catch (Exception e) {
		}
		return lista;
	}
	
}