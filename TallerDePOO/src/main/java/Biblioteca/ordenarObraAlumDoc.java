package Biblioteca;

import java.util.Comparator;

class ordenarObraAlumDoc implements Comparator<Obra> {
	 
    public int compare(Obra o1, Obra o2) {
        return o1.getPedidaPorAlumDoc() - o2.getPedidaPorAlumDoc();
    }
}
