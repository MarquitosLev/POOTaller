package Biblioteca;

import java.util.Comparator;

class ordenarObraGeneral implements Comparator<Obra> {
	 
    public int compare(Obra o1, Obra o2) {
        return o2.getPedidaGeneral() - o1.getPedidaGeneral();
    }
}
