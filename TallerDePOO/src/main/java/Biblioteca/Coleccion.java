package Biblioteca;

import java.util.ArrayList;
/**
 * Clase que representa las colecciones a las que puede pertenecer una obra.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Coleccion extends Obra {
	private String nomColeccion;
	private int isbnColeccion;
	private ArrayList<Obra> obras;

	/**
	 * Constructor de la clase. Se lo llama al constructor de la clase Obra, y
	 * ademas se le pasa tambien el nombre de la coleccion.
	 * 
	 * @param nomColeccion Se pasa un texto con el nombre de la coleccion que se
	 *                     quiere agregar.
	 */
	public Coleccion(String nomColeccion) {
		super();
		this.nomColeccion = nomColeccion;
	}

	/**
	 * Metodo que devuelve el o los nombres de las colecciones a las que puede pertenecer una obra.
	 * 
	 * @return Retorna un String con el o los nombres guardados.
	 */
	public String getNomColeccion() {
		return nomColeccion;
	}

	/**
	 * Metodo que settea el atributo "nomColeccion" de la clase.
	 * 
	 * @param nomColeccion Se le pasa el o los nombres de las colecciones a agregar.
	 */
	public void setNomColeccion(String nomColeccion) {
		this.nomColeccion = nomColeccion;
	}

	/**
	 * Metodo que devuelve el ISBN (Numero Internacional Normalizado para Libros) de la coleccion.
	 * 
	 * @return Retorna un entero con el ISBN de la coleccion.
	 */
	public int getIsbnColeccion() {
		return isbnColeccion;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public ArrayList<Obra> getObras() {
		return obras;
	}

	/**
	 * 
	 * 
	 * @param obras
	 */
	public void setObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}

}
