package Biblioteca;

import java.util.ArrayList;

/**
 * Interfaz que obliga a las clases que la implementan a especificar el metodo 'ObtenerLista'
 * 
 * @author Sebastian Etchepare
 *
 */

public interface guardado {
	
	/**
	 * Declaracion de un metodo abstacto
	 * 
	 * @return dentro de la interfaz, no retorna nada, debe ser redefinido dentro de las clases que lo implementen.
	 */
	public ArrayList<Object> obtenerLista();
	}