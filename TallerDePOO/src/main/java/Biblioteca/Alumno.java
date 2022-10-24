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
	private Funcionario funcionario; // Creación de la asociación entre el funcionario y el alumno. No se si se trata
										// de doble direccionalidad en este caso.

	public Alumno(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String nac, String domi, int codPos, String dep, String localidad) {
		super(nom, apellido, tipDoc, numDoc, correo, numCel, fecNac, sex, nac, domi, codPos, dep, localidad);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		lista.add(getDiasMultado());
		lista.add(this.getClass().getSimpleName());
		lista.add("");
		return lista;
	}
}
