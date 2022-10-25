package Biblioteca;

import java.util.Comparator;

class OrdenarLectores implements Comparator<Lector> {
	 
    public int compare(Lector o1, Lector o2) {
        return o1.getCanMulta() - o2.getCanMulta();
    }
}
