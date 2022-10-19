package Biblioteca;
import java.util.ArrayList;

public class Funcionario implements guardado{
	private String usuario;
	private String contrasenia;
	//Creacion de la asociacion entre el funcionario y la clase Ejemplar;
	private ArrayList<Ejemplar> ejemplares;
	//Creacion de la asociacion entre el funcionario y la clase Obra;
	private ArrayList<Reserva> obras;
	//Creacion de la asociacion entre el funcionario y la clase Prestamo;
	private ArrayList<Prestamo> prestamosFuncionario;
	
	
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
	
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object> ();
		lista.add(getUsuario());
		lista.add(getContrasenia());
		return lista;
	}
}
