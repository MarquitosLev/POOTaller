package Biblioteca;

import java.util.Comparator;
/**
 * Compara las veces pedidas por Tipo de Lector
 * 
 * @author Marcos Leiva
 *
 */
class ordenarObraAlumDoc implements Comparator<Obra> {
	 
    public int compare(Obra o1, Obra o2) {
        return o2.getPedidaPorAlumDoc() - o1.getPedidaPorAlumDoc();
    }
}
