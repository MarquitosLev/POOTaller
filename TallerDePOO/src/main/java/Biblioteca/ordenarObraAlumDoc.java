package Biblioteca;

import java.util.Comparator;

/**
 * Clase que ordena las obras segun la cantidad de veces pedidas por alumnos y
 * docentes.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */
class ordenarObraAlumDoc implements Comparator<Obra> {

	/**
	 * Metodo que compara dos obras y, segun la cantidad de veces pedida por los
	 * alumnos y docentes, devuelve un -1, 0 o 1.
	 * 
	 * @return Retorna un valor entero que puede ser -1 (que o1 se pidio menos veces
	 *         que o2), 0 (que ambas obras se pidieron igual cantidad de veces) o 1
	 *         (que o1 se pidio mas veces que o2).
	 */
	public int compare(Obra o1, Obra o2) {
		return o2.getPedidaPorAlumDoc() - o1.getPedidaPorAlumDoc();
	}
}
