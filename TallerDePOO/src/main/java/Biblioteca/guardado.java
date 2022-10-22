package Biblioteca;

import java.util.ArrayList;

/**
 * Interfaz que obliga a las clases que la implementan a especificar el metodo 'obtenerLista'
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */

public interface guardado {
	
	/**
	 * Declaracion de un metodo abstracto
	 * 
	 * @return dentro de la interfaz, no retorna nada, debe ser redefinido dentro de las clases que lo implementen.
	 * 
	 */
	public ArrayList<Object> obtenerLista();
	}