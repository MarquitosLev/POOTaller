package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que representa la edicion de cada obra.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Edicion implements guardado {
	private String editorial;
	private String pais;
	private int num;
	private int anio;
	private int volumen;
	private int paginas;
	private String idioma;
	private formatoObra formato;
	private Obra obra;

	/**
	 * Constructor parametrizado de la clase.
	 * 
	 * @param editorial Se pasa un texto con la editorial de la obra.
	 * @param pais      Se pasa un String con el pais de edicion de la obra.
	 * @param num       Se pasa un valor entero con el numero de edicion de la obra.
	 * @param anio      Se pasa un entero con el año de creacion de la obra.
	 * @param volumen   Se pasa un entero con la cantidad de volumenes que tiene la
	 *                  obra.
	 * @param paginas   Se pasa un valor entero con la cantidad de paginas que tiene
	 *                  la obra.
	 * @param idioma    Se pasa un texto con el idioma en el que esta escrito la
	 *                  obra.
	 * @param obra
	 */

	public Edicion(String editorial, String pais, int num, int anio, int volumen, int paginas, String idioma,
			Obra obra) {
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

	/**
	 * Constructor por defecto de la clase.
	 */
	public Edicion() {
	}

	/**
	 * Metodo que devuelve un String con el nombre de la editorial de la obra.
	 * 
	 * @return Retorna un String con la editorial almacenada.
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo que settea el atributo "editorial" de la clase.
	 * 
	 * @param editorial Se pasa la editorial de la obra a agregar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo que devuelve un texto con el pais de edicion de la obra.
	 * 
	 * @return Retorna el pais de edicion de la obra guardado.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Metodo que settea el atributo "pais" de la clase.
	 * 
	 * @param pais Se pasa el pais de edicion a agregar.
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Metodo que se ocupa de retornar un entero con el numero de edicion de la
	 * obra.
	 * 
	 * @return Retorna el numero de edicion de la obra que esta almacenado.
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Metodo que settea el atributo "num" de la clase.
	 * 
	 * @param num Se pasa el numero de edicion que se desea agregar.
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * Metodo que devuelve un entero con el año en el que fue creada la obra.
	 * 
	 * @return Retorna el año que se encuentra almacenado.
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Metodo que settea el atributo "anio" de la clase.
	 * 
	 * @param anio Se pasa el año que se quiere agregar.
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Metodo que devuelve un entero con la cantidad de volumenes que tiene la obra.
	 * 
	 * @return Retorna la cantidad de volumenes guardado.
	 */
	public int getVolumen() {
		return volumen;
	}

	/**
	 * Metodo que settea el atributo "volumen" de la clase.
	 * 
	 * @param volumen Se pasa la cantidad de volumenes a agregar.
	 */
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	/**
	 * Metodo que devuelve un entero con el numero de paginas de la obra.
	 * 
	 * @return Retorna el numero de paginas almacenado.
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * Metodo que settea el atributo "paginas" de la clase.
	 * 
	 * @param paginas Se pasa el numero de paginas a agregar.
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/**
	 * Metodo que devuelve un texto con el idioma en el que esta escrito la obra.
	 * 
	 * @return Retorna el idioma guardado.
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Metodo que settea el atributo "idioma" de la clase.
	 * 
	 * @param idioma Se pasa el idioma que se desea agregar.
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * Metodo que devuelve el formato en el que se encuentra la obra.
	 * 
	 * @return Retorna el formato almacenado, que es de tipo "formatoObra" (una enumeracion).
	 */
	public formatoObra getFormato() {
		return formato;
	}

	/**
	 * Metodo que settea el atributo "formato" de la clase.
	 * 
	 * @param formato Se pasa el formato a agregar.
	 */
	public void setFormato(formatoObra formato) {
		this.formato = formato;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Obra getObra() {
		return obra;
	}

	/**
	 * 
	 * 
	 * @param obra
	 */
	public void setObra(Obra obra) {
		this.obra = obra;
	}

	/**
	 * Metodo que crea un ArrayList de tipo "Object" y va agregando los atributos de la clase adentro.
	 * 
	 * @return ArrayList con los atributos de la instancia creada.
	 */
	public ArrayList<Object> obtenerLista() {
		// new Edicion(editorial, pais, numero, anio, volumen, paginas, idioma, new
		// Obra(tituloObra))
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getEditorial());
		lista.add(getPais());
		lista.add(getNum());
		lista.add(getAnio());
		lista.add(getVolumen());
		lista.add(getPaginas());
		lista.add(getIdioma());
		lista.add(getObra().getTitulo());
		return lista;
	}

	/**
	 * Metodo que lee el archivo "Editoriales.txt" y retorna un ArrayList con todos los objetos guardados.
	 * 
	 * @return Devuelve un ArrayList con todos los objetos existentes en el archivo.
	 */
	public static ArrayList<Edicion> leerTexto(){
		ArrayList<Edicion> lista = new ArrayList<Edicion>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Editoriales.txt"));
			String ed;
			while ((ed = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(ed, "/");
				lista.add(new Edicion(x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()),
						Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()),
						x.nextToken(), new Obra(x.nextToken())));
			}
		} catch (Exception e) {
		}
		return lista;
	}
	
	@Override
	public String toString() {
		return "Edicion [editorial=" + editorial + ", pais=" + pais + ", num=" + num + ", anio=" + anio + ", volumen="
				+ volumen + ", paginas=" + paginas + ", idioma=" + idioma + ", obra=" + obra.getTitulo() + "]";
	}

}
