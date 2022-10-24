package Biblioteca;

import java.util.ArrayList;

/**
 * Clase que representa la multa que se le coloca a un lector por infringir con
 * los tiempos de devolucion de un ejemplar.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Multa implements guardado{
	private int diasMulta;
	private Prestamo prestamo; // Asociacion Multa y Prestamo

	/**
	 * Constructor parametrizado de la clase.
	 * 
	 * @param diasMulta 
	 * @param prestamo
	 */
	public Multa(int diasMulta, Prestamo prestamo) {
		super();
		this.diasMulta = diasMulta;
		this.prestamo = prestamo;
	}

	public Multa(int diasMulta) {
		this.diasMulta = diasMulta;
	}

	public int getDiasMulta() {
		return diasMulta;
	}

	public void setDiasMulta(int diasMulta) {
		this.diasMulta = diasMulta;
	}
	
	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getDiasMulta());
		lista.add(getPrestamo().getEjemplar());
		return lista;
	}
}
