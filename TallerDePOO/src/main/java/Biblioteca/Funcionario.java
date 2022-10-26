package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que representa al funcionario de la biblioteca.
 * 
 * @author Leandro Gonzalez Fister
 * @author Sebastian Etchepare
 * @author Marcos Leiva
 * @author Santiago Fernandez Gomez
 *
 */

public class Funcionario implements guardado {
	private String usuario;
	private String contrasenia;
	private ArrayList<Ejemplar> ejemplares; // Asociacion entre el funcionario y la clase Ejemplar
	private ArrayList<Obra> obras; // Asociacion entre el funcionario y la clase Obra
	private ArrayList<Prestamo> prestamosFuncionario; // Asociacion entre el funcionario y la clase Prestamo

	/**
	 * Constructor para crear al funcionario.
	 * 
	 * @param usuario     Representa el nombre de usuario que el funcionario usa en
	 *                    el sistema
	 * @param contrasenia Representa la contraseña que el funcionario usara para
	 *                    acceder al sistema.
	 */
	public Funcionario(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	/**
	 * Constructor que se usa para mostrar quien es el funcionario que reserva el
	 * ejemplar.
	 * 
	 * @param usuario Se pasa el nombre de usuario que el funcionario usa en el
	 *                sistema.
	 */
	public Funcionario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que retorna ejemplares.
	 * 
	 * @return Retorna un ArrayList con los ejemplares almacenados.
	 */
	public ArrayList<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	/**
	 * Metodo que settea el atributo "ejemplares" de la clase.
	 * 
	 * @param ejemplares Se pasa un ArrayList con los ejemplares a agregar.
	 */
	public void setEjemplares(ArrayList<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	/**
	 * Metodo que devuelve obras.
	 * 
	 * @return Retorna un ArrayList con las obras almacenadas.
	 */
	public ArrayList<Obra> getObras() {
		return obras;
	}

	/**
	 * Metodo que settea el atributo "obras" de la clase.
	 * 
	 * @param obras Se pasa un ArrayList con las obras a guardar.
	 */
	public void setObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}

	/**
	 * Metodo que devuelve prestamos.
	 * 
	 * @return Retorna un ArrayList con los prestamos almacenados.
	 */
	public ArrayList<Prestamo> getPrestamosFuncionario() {
		return prestamosFuncionario;
	}

	/**
	 * Metodo que settea el atributo "prestamosFuncionario" de la clase.
	 * 
	 * @param prestamosFuncionario Se pasa un ArrayList con los prestamos a agregar al atributo.
	 */
	public void setPrestamosFuncionario(ArrayList<Prestamo> prestamosFuncionario) {
		this.prestamosFuncionario = prestamosFuncionario;
	}

	/**
	 * Metodo que devuelve el nombre de usuario del funcionario en el sistema.
	 * 
	 * @return Retorna un String con el nombre de usuario almacenado.
	 */
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * Metodo que settea el atributo "usuario" de la clase.
	 * 
	 * @param usuario Se pasa un texto con el nombre de usuario a agregar.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que devuelve la contraseña del funcionario en el sistema.
	 * 
	 * @return Retorna un String con la contraseña almacenada.
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Metodo que settea el atributo "contrasenia" de la clase.
	 * 
	 * @param contrasenia Se pasa un texto con la contraseña a guardar.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * Metodo que se encarga de crear un ArrayList del tipo 'Object' e ir agregando
	 * los atributos de la clase dentro.
	 * 
	 * @return Retorna un ArrayList con los atributos de la clase.
	 */
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getUsuario());
		lista.add(getContrasenia());
		return lista;
	}

	/**
	 * Metodo que lee el archivo "Funcionarios.txt" y retorna un ArrayList de todos
	 * los objetos.
	 * 
	 * @return Retorna un ArrayList con todos los objetos existentes en el txt.
	 * @throws Excepcion necesaria para el correcto funcionamiento del 'BufferedReader'
	 */
	public static ArrayList<Funcionario> leerTexto() {
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Funcionarios.txt"));
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");
				lista.add(new Funcionario(x.nextToken(), x.nextToken()));
			}
		} catch (Exception e) {
		}
		return lista;
	}
}
