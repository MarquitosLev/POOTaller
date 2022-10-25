package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa al tipo de lector "Docente".
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Docente extends Lector {
	private String carrera;
	private Funcionario funcionario; // Asociación entre docente y funcionario.

	/**
	 * Constructor usado para crear al docente.
	 * 
	 * @param nom       Se pasa un texto que contiene el/los nombre/s del docente.
	 * @param apellido  Se pasa un texto con el/los apellido/s del docente.
	 * @param tipDoc    Se pasa un texto con el tipo de documento a colocar.
	 * @param numDoc    Se pasa un entero con el numero de documento a colocar.
	 * @param correo    Se pasa un texto con el correo perteneciente al docente.
	 * @param numCel    Se pasa un entero con el numero de celular del docente.
	 * @param fecNac    Se pasa la fecha de nacimiento que se quiere agregar, que es
	 *                  de tipo "LocalDate".
	 * @param sex       Se pasa un texto que contiene el sexo con el que se siente
	 *                  identificado el docente.
	 * @param nac       Se pasa un texto con el lugar donde nacio el docente.
	 * @param domi      Se pasa un texto con el domicilio donde reside el docente.
	 * @param codPos    Aqui se encuentra el codigo postal, que es un entero.
	 * @param dep       Se pasa un texto con el departamento donde se encuentra
	 *                  ubicado el docente.
	 * @param localidad Se pasa un texto en el que esta la localidad donde vive
	 *                  actualmente el docente.
	 * @param carrera   Se pasa un texto con la carrera a la cual esta relacionada
	 *                  el docente.
	 */
	public Docente(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, String clase, String carrera) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad, clase);
		this.carrera = carrera;
	}

	/**
	 * 
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
	 * @param diasMultado
	 * @param carrera
	 */
	public Docente(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, int canMulta,
			Boolean estaMultado, Long diasMultado, String clase, String carrera) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad, canMulta,
				estaMultado, diasMultado, clase);
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

	/**
	 * Metodo que se encarga de crear un ArrayList del tipo objeto e ir agregando
	 * los atributos de la clase dentro.
	 * 
	 * @return Retorna un ArrayList con todos los atributos de la clase.
	 */
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
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
		lista.add(getCarrera());
		return lista;
	}

}
