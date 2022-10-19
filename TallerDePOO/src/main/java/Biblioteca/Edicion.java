package Biblioteca;

/**
 * Clase que representa la edicion de cada obra.
 * 
 * @author Leandro Gonzalez Fister
 *
 */

public class Edicion {
	private String editorial;
	private String pais;
	private int num;
	private int anio;
	private int volumen;
	private int paginas;
	private String idioma;
	private formatoObra formato; //Falta Especificacion "Otro" en formato obra
	private Obra obra;
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param editorial
	 * @param pais
	 * @param num
	 * @param anio
	 * @param volumen
	 * @param paginas
	 * @param idioma
	 * @param obra
	 */
	
	public Edicion(String editorial, String pais, int num, int anio, int volumen, int paginas, String idioma, Obra obra) {
		super();
		this.editorial = editorial;
		this.pais = pais;
		this.num = num;
		this.anio = anio;
		this.volumen = volumen;
		this.paginas = paginas;
		this.idioma = idioma;
		this.obra = obra;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public formatoObra getFormato() {
		return formato;
	}
	public void setFormato(formatoObra formato) {
		this.formato = formato;
	}
	
	
}
