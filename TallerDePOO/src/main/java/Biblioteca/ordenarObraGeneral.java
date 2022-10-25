package Biblioteca;

import java.util.Comparator;

class ordenarObraGeneral implements Comparator<Obra> {
	 
    public int compare(Obra o1, Obra o2) {
        return o1.getPedidaGeneral() - o2.getPedidaGeneral();
    }
}
