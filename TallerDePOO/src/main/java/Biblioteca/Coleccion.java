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
public class Coleccion extends Obra implements guardado {
	private String nomColeccion;
	private String isbnColeccion;
	private ArrayList<Obra> obras;

	/**
	 * Constructor de la clase. Se lo llama al constructor de la clase Obra, y
	 * ademas se le pasa tambien el nombre y el ISBN de la coleccion.
	 * 
	 * @param nomColeccion  Se pasa un texto con el nombre de la coleccion.
	 * @param isbnColeccion Se pasa un entero con el isbn de la coleccion.
	 */
	public Coleccion(String nomColeccion, String isbnColeccion) {
		super();
		this.nomColeccion = nomColeccion;
		this.isbnColeccion = isbnColeccion;
	}

	/**
	 * Metodo que devuelve el o los nombres de las colecciones a las que puede
	 * pertenecer una obra.
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
	 * Metodo que devuelve el ISBN (Numero Internacional Normalizado para Libros) de
	 * la coleccion.
	 * 
	 * @return Retorna un entero con el ISBN de la coleccion.
	 */
	public String getIsbnColeccion() {
		return isbnColeccion;
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
	 * @param obras Se pasa un ArrayList con las obras a agregar al atributo.
	 */
	public void setObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}

	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getNomColeccion());
		lista.add(getIsbnColeccion());
		return lista;
	}
}
