package Biblioteca;

/**
 * Clase que representa la multa que se le coloca a un lector por inflingir con los tiempos de devolucion de un ejemplar.
 * 
 * @author Leandro Gonzalez Fister
 *
 */

public class Multa {
	private int diasMulta;
	//Asociacion Multa y Prestamo
	private Prestamo prestamo;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param diasMulta
	 * @param prestamo
	 */
	
	public Multa(int diasMulta, Prestamo prestamo) {
		super();
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public int getDiasMulta() {
		return diasMulta;
	}
	
	public void setDiasMulta(int diasMulta) {
		this.diasMulta = diasMulta;
	}
}
