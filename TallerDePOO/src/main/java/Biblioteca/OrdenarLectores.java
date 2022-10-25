package Biblioteca;

import java.util.Comparator;

/**
 * Clase que ordena a los lectores segun la cantidad de multas que tienen.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 *
 */
class OrdenarLectores implements Comparator<Lector> {
	/**
	 * Metodo que compara dos lectores y, segun la cantidad de multas que tienen,
	 * devuelve un -1, 0 o 1.
	 * 
	 * @return Retorna un valor entero que puede ser -1 (que o1 tiene menos multas
	 *         que o2), 0 (que ambos lectores tienen igual cantidad de multas) o 1
	 *         (que o1 tiene mas multas que o2).
	 */
	public int compare(Lector o1, Lector o2) {
		return o1.getCanMulta() - o2.getCanMulta();
	}
}
