package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa al tipo de lector 'Docente'
 * 
 * @author Leandro Gonzalez Fister
 *
 */

public class Docente extends Lector {
	private String carrera;
	//Creación de la asociación entre docente y funcionario. Aunque no se si se trata de doble direccionalidad en este caso. 
	private Funcionario funcionario;
	
	/**
	 * Constructor de la clase.
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
	 * @param carrera
	 * @param funcionario
	 */
	

	public Docente(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, String carrera) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
		this.carrera = carrera;
	}

	public Docente(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, int canMulta,
			Boolean estaMultado, String carrera) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad, canMulta,
				estaMultado);
		this.carrera = carrera;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public void Consultar() {
		
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
		lista.add(this.getClass().getSimpleName());
		lista.add(getCarrera());
		return lista;
	}
	
}
