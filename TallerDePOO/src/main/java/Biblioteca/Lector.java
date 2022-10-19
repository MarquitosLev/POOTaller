package Biblioteca;
import java.util.ArrayList;
import java.time.LocalDate;

public class Lector extends Persona implements guardado{
	private int canMulta;
	private Boolean estaMultado;
	private ArrayList<Ejemplar> ejemplares;
	
	public Lector(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, int canMulta,
			Boolean estaMultado, ArrayList<Ejemplar> ejemplares) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.canMulta = canMulta;
		this.estaMultado = estaMultado;
		this.ejemplares = ejemplares;
	}
	
	//Constructor para agregar datos del lector
	public Lector(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad) {
		
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.canMulta = 0;
		this.estaMultado = false;
	}
	
	public Lector() {
		this.canMulta = 0;
		this.estaMultado = false;
		this.ejemplares = new ArrayList<Ejemplar>();
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

	public ArrayList<Ejemplar> getEjemplar() {
		return ejemplares;
	}

	public void setEjemplar(ArrayList<Ejemplar> ejemplar) {
		this.ejemplares = ejemplar;
	}

	public String toString() {
		return super.toString();
	}
	
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
		return lista;
	}
	
	
	
	
}