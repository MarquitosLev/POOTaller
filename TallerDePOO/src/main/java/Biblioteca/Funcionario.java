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
 *
 */

public class Funcionario implements guardado{
	private String usuario;
	private String contrasenia;
	//Creacion de la asociacion entre el funcionario y la clase Ejemplar;
	private ArrayList<Ejemplar> ejemplares;
	//Creacion de la asociacion entre el funcionario y la clase Obra;
	private ArrayList<Reserva> obras;
	//Creacion de la asociacion entre el funcionario y la clase Prestamo;
	private ArrayList<Prestamo> prestamosFuncionario;
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param usuario Representa el nombre de usuario que el funcionario usa en el sistema
	 * @param contrasenia Representa la contraseña que el funcionario usara para acceder al sistema. 
	 */
	public Funcionario(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	public ArrayList<Ejemplar> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(ArrayList<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
	public ArrayList<Reserva> getObras() {
		return obras;
	}
	public void setObras(ArrayList<Reserva> obras) {
		this.obras = obras;
	}
	public ArrayList<Prestamo> getPrestamosFuncionario() {
		return prestamosFuncionario;
	}
	public void setPrestamosFuncionario(ArrayList<Prestamo> prestamosFuncionario) {
		this.prestamosFuncionario = prestamosFuncionario;
	}
	public ArrayList<Ejemplar> getRealizaObservacion() {
		return ejemplares;
	}
	public void setRealizaObservacion(ArrayList<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void registrarObservaciones() {
		//falta completar
	}
	
	public void realizarPrestamo() {
		//falta completar
	}
	
	/**
	 * Metodo que se encarga de crear un ArrayList del tipo 'Object' e ir agregando los atributos de la clase dentro. 
	 */
	
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object> ();
		lista.add(getUsuario());
		lista.add(getContrasenia());
		return lista;
	}
	
	public static ArrayList<Funcionario> leerTexto(){
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
