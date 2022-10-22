package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa al tipo de lector 'Docente'
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */
public class Docente extends Lector {
	private String carrera;
	private Funcionario funcionario; // Asociación entre docente y funcionario. Aunque no se si se trata de doble
										// direccionalidad en este caso.

	/**
	 * Constructor parametrizado de la clase Docente.
	 * 
	 * @param nom         Se pasa un String con el nombre o los nombres del docente.
	 * @param apellido    Se pasa un String con el apellido o los apellidos del
	 *                    docente.
	 * @param tipDoc      Se pasa un texto con el tipo de documento del docente.
	 * @param numDoc      Se pasa un valor entero con el numero de documento del
	 *                    docente.
	 * @param correo      Se pasa un texto con el correo perteneciente al docente.
	 * @param numCel      Se pasa un valor entero con el numero de celular
	 *                    correspondiente al docente.
	 * @param fecNac      Se pasa la fecha de nacimiento del docente, en forma de un
	 *                    "LocalDate".
	 * @param sex         Se pasa un String con el sexo al cual se identifica el
	 *                    docente.
	 * @param nac         Se pasa un String con el lugar de nacimiento del docente.
	 * @param domi        Se pasa un texto con el domicilio del docente.
	 * @param codPos      Se pasa un valor entero con el codigo postal del docente.
	 * @param dep         Se pasa un String con el departamento donde vive el
	 *                    docente.
	 * @param localidad   Se pasa un texto con la localidad donde reside el docente.
	 * @param canMulta
	 * @param estaMultado
	 * @param ejemplares
	 * @param carrera     Se pasa un String con la/s carrera/s relacionada/s al
	 *                    docente.
	 * @param funcionario
	 * 
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
		lista.add(this.getClass().getSimpleName());
		lista.add(getCarrera());
		return lista;
	}

}
