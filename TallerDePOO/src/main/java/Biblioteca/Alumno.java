package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa al tipo de lector "Alumno".
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Alumno extends Lector {
	private Funcionario funcionario; // Creación de la asociación entre el funcionario y el alumno.

	/**
	 * Constructor usado para crear al alumno.
	 * 
	 * @param nom       Se pasa un texto que contiene el/los nombre/s del alumno
	 * @param apellido  Se pasa un texto con el/los apellido/s del alumno.
	 * @param tipDoc    Se pasa un texto con el tipo de documento a colocar.
	 * @param numDoc    Se pasa un entero con el numero de documento a colocar.
	 * @param correo    Se pasa un texto con el correo perteneciente al alumno.
	 * @param numCel    Se pasa un entero con el numero de celular del alumno.
	 * @param fecNac    Se pasa la fecha de nacimiento que se quiere agregar, que es
	 *                  de tipo "LocalDate".
	 * @param sex       Se pasa un texto que contiene el sexo con el que se siente
	 *                  identificado el alumno.
	 * @param nac       Se pasa un texto con el lugar donde nacio el alumno.
	 * @param domi      Se pasa un texto con el domicilio donde reside el alumno.
	 * @param codPos    Aqui se encuentra el codigo postal, que es un entero.
	 * @param dep       Se pasa un texto con el departamento donde se encuentra
	 *                  ubicado el alumno.
	 * @param localidad Se pasa un texto en el que esta la localidad donde vive
	 *                  actualmente el alumno.
	 * @param clase     Se pasa un texto con el tipo de lector (en este caso, va a
	 *                  pasar que es Alumno).
	 */
	public Alumno(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad, String clase) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad, clase);
	}

	/**
	 * Metodo que devuelve un objeto de tipo "Funcionario" con los atributos de su
	 * clase.
	 * 
	 * @return Retorna el objeto almacenado de tipo "Funcionario".
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Metodo que settea el atributo "funcionario" de la clase.
	 * 
	 * @param funcionario Se pasa un objeto de tipo "Funcionario" con sus atributos,
	 *                    y se lo agrega al atributo de la clase Alumno.
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		lista.add("");
		return lista;
	}
}
