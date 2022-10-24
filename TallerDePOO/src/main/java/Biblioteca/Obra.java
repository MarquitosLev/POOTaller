package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que representa a las obras que se tienen registradas en la biblioteca
 * 
 * @author Leandro González Fister
 * @author Marcos Leiva
 * @author Sebastián Etchepare
 * @author Santiago Fernandez Gomez
 */
public class Obra implements guardado {

	private int cantEjem;
	private int cantEjemDisponible;
	private String titulo;
	private String subtitulo;
	private String autor1;
	private String autor2;
	private String autor3;
	private String genero;
	private int isbn;
	private int id;
	private Area area; // Enumeracion
	private tipoObra tipo; // Enumeracion
	private ArrayList<Coleccion> colecciones;
	// private Coleccion perteneceA; //Unidireccionalidad con multiplicidad. Quitar
	// comentario en constructores
	private ArrayList<Ejemplar> ejemplares;
	private ArrayList<Edicion> ediciones;
	private Reserva funcionario; // Creación de la asociación entre funcionario, obra y reserva

	public Obra() {
		super();
		this.cantEjem = 0;
		this.cantEjemDisponible = 0;
		this.titulo = "";
		this.subtitulo = "";
		this.autor1 = "";
		this.autor2 = "";
		this.autor3 = "";
		this.genero = "";
		this.isbn = 0;
		this.id = 0;
//		this.area =  "";
//		this.tipo =  "";
//		this.perteneceA = Coleccion();
		this.ejemplares = new ArrayList<Ejemplar>();
		this.ediciones = new ArrayList<Edicion>();
	}

	/**
	 * Constructor de la clase Obra.
	 * 
	 * @param titulo
	 * @param subtitulo
	 * @param autor1
	 * @param autor2
	 * @param autor3
	 * @param genero
	 * @param isbn
	 * @param id
	 * @param area
	 * @param tipo
	 */
	public Obra(String titulo, String subtitulo, String autor1, String autor2, String autor3, String genero, int isbn,
			int id, Area area, tipoObra tipo) {
		super();
		this.cantEjem = 1;
		this.cantEjemDisponible = 1;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.autor1 = autor1;
		this.autor2 = autor2;
		this.autor3 = autor3;
		this.genero = genero;
		this.isbn = isbn;
		this.id = id;
		this.area = area;
		this.tipo = tipo;
//		this.perteneceA = perteneceA;
	}

	/**
	 * Constructor de la clase Obra.
	 * 
	 * @param cantEjem
	 * @param cantEjemDisponible
	 * @param titulo
	 * @param subtitulo
	 * @param autor1
	 * @param autor2
	 * @param autor3
	 * @param genero
	 * @param isbn
	 * @param id
	 * @param area
	 * @param tipo
	 */

	public Obra(int cantEjem, int cantEjemDisponible, String titulo, String subtitulo, String autor1, String autor2,
			String autor3, String genero, int isbn, int id, Area area, tipoObra tipo) {
		super();
		this.cantEjem = cantEjem;
		this.cantEjemDisponible = cantEjemDisponible;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.autor1 = autor1;
		this.autor2 = autor2;
		this.autor3 = autor3;
		this.genero = genero;
		this.isbn = isbn;
		this.id = id;
		this.area = area;
		this.tipo = tipo;
//		this.perteneceA = perteneceA;
	}

	/**
	 * Constructor en el que solo se le pasa el titulo de la obra.
	 * 
	 * @param titulo Se le pasa el titulo a agregar.
	 */
	public Obra(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo que retorna el funcionario del tipo 'Reserva'
	 * 
	 * @return retorna el funcionario que se encuentre almacenado.
	 */
	public Reserva getFuncionario() {
		return funcionario;
	}

	/**
	 * Metodo que settea el atributo 'funcionario' de la clase.
	 * 
	 * @param funcionario Se pasa el funcionario que se quiera agregar como atributo
	 */
	public void setFuncionario(Reserva funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Metodo que retorna ediciones.
	 * 
	 * @return las ediciones que se encuentran dentro del ArrayList del tipo
	 *         Edición.
	 */

	public ArrayList<Edicion> getEdiciones() {
		return ediciones;
	}

	/**
	 * Metodo que se encarga de setear lo que este dentro del atributo 'ediciones'
	 * 
	 * @param ediciones Se pasa un ArrayList que reemplaza el/los valor/es
	 *                  guardado/s en el correspondiente atributo.
	 */
	public void setEdiciones(ArrayList<Edicion> ediciones) {
		this.ediciones = ediciones;
	}

	/**
	 * Metodo que retorna ejemplares.
	 * 
	 * @return Retorna un ArrayList con los ejemplares almacenados.
	 */
	public ArrayList<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	/**
	 * Metodo que settea el atributo "ejemplares" de la clase.
	 * 
	 * @param ejemplares Se pasa un ArrayList con los ejemplares a guardar.
	 */
	public void setEjemplares(ArrayList<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	/**
	 * Metodo que devuelve un entero con la cantidad de ejemplares de la obra (ya
	 * sea que esten disponibles o no).
	 * 
	 * @return Retorna un entero que indica la cantidad de ejemplares.
	 */
	public int getCantEjem() {
		return cantEjem;
	}

	/**
	 * Metodo que settea el atributo "cantEjem" de la clase.
	 * 
	 * @param cantEjem Se pasa la cantidad de ejemplares a agregar al atributo.
	 */
	public void setCantEjem(int cantEjem) {
		this.cantEjem = cantEjem;
	}

	/**
	 * Metodo que devuelve la cantidad de ejemplares de la obra que se encuentran disponibles.
	 * 
	 * @return Retorna un entero con la cantidad de ejemplares disponibles.
	 */
	public int getCantEjemDisponible() {
		return cantEjemDisponible;
	}

	/**
	 * Metodo que settea el atributo "cantEjemDisponible" de la clase.
	 * 
	 * @param cantEjemDisponible Se pasa la cantidad de ejemplares disponibles a agregar.
	 */
	public void setCantEjemDisponible(int cantEjemDisponible) {
		this.cantEjemDisponible = cantEjemDisponible;
	}

	/**
	 * Metodo que devuelve el titulo de la obra.
	 * 
	 * @return Retorna un String con el titulo almacenado en el atributo.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que settea el atributo "titulo" de la clase.
	 * 
	 * @param titulo Se pasa el titulo que se quiere agregar.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo que devuelve el subtitulo de la obra.
	 * 
	 * @return Retorna un String con el subtitulo guardado.
	 */
	public String getSubtitulo() {
		return subtitulo;
	}

	/**
	 * Metodo que settea el atributo "subtitulo" de la clase.
	 * 
	 * @param subtitulo Se pasa el subtitulo a agregar.
	 */
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	/**
	 * Metodo que devuelve el nombre del primer autor de la obra.
	 * 
	 * @return Retorna un texto con el nombre almacenado del primer autor de la obra.
	 */
	public String getAutor1() {
		return autor1;
	}

	/**
	 * Metodo que settea el atributo "autor1" de la clase.
	 * 
	 * @param autor1 Se pasa el nombre del primer autor, y se lo agrega al atributo.
	 */
	public void setAutor1(String autor1) {
		this.autor1 = autor1;
	}

	/**
	 * Metodo que devuelve el nombre del segundo autor de la obra.
	 * 
	 * @return Retorna un texto con el nombre guardado del segundo autor de la obra.
	 */
	public String getAutor2() {
		return autor2;
	}

	/**
	 * Metodo que settea el atributo "autor2" de la clase.
	 * 
	 * @param autor2 Se pasa el nombre del segundo autor, y se lo agrega al atributo.
	 */
	public void setAutor2(String autor2) {
		this.autor2 = autor2;
	}

	/**
	 * Metodo que devuelve el nombre del tercer autor de la obra.
	 * 
	 * @return Retorna un texto con el nombre almacenado del tercer autor de la obra.
	 */
	public String getAutor3() {
		return autor3;
	}

	/**
	 * Metodo que settea el atributo "autor3" de la clase.
	 * 
	 * @param autor3 Se pasa el nombre del tercer autor, y se lo agrega al atributo.
	 */
	public void setAutor3(String autor3) {
		this.autor3 = autor3;
	}

	/**
	 * Metodo que devuelve el genero de la obra.
	 * 
	 * @return Retorna un String con el genero almacenado en el atributo.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Metodo que settea el atributo "genero" de la clase.
	 * 
	 * @param genero Se pasa el genero de la obra, y se lo agrega al atributo.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Metodo que devuelve el ISBN (Numero Internacional Normalizado para Libros) de la obra.
	 * 
	 * @return Retorna un entero con el ISBN almacenado en el atributo.
	 */
	public int getIsbn() {
		return isbn;
	}

	
	public int getId() {
		return id;
	}

	/**
	 * Metodo que devuelve el area tematica de la obra.
	 * 
	 * @return Retorna el area almacenada en el atributo, que es de tipo "Area".
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * Metodo que settea el atributo "area" de la clase.
	 * 
	 * @param area Se pasa el area tematica a agregar al atributo.
	 */
	public void setArea(Area area) {
		this.area = area;
	}

	/**
	 * Metodo que devuelve el tipo de la obra.
	 * 
	 * @return Retorna el tipo de obra guardado en el atributo, que es de tipo "tipoObra".
	 */
	public tipoObra getTipo() {
		return tipo;
	}

	/**
	 * Metodo que settea el atributo "tipo" de la clase.
	 * 
	 * @param tipo Se pasa el tipo de obra, y se lo agrega al atributo.
	 */
	public void setTipo(tipoObra tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que se encarga de crear un array list del tipo objeto e ir agregando
	 * los atributos de la clase dentro.
	 * 
	 * @return Retorna un ArrayList con todos los atributos de la clase.
	 */
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(getCantEjem());
		lista.add(getCantEjemDisponible());
		lista.add(getTitulo());
		lista.add(getSubtitulo());
		lista.add(getAutor1());
		lista.add(getAutor2());
		lista.add(getAutor3());
		lista.add(getGenero());
		lista.add(getIsbn());
		lista.add(getId());
		lista.add(getArea());
		lista.add(getTipo());
		return lista;
	}

	/**
	 * Metodo que lee el archivo "Obras.txt" y retorna un ArrayList de todos los
	 * objetos que se encuentren ahi.
	 * 
	 * @return Retorna un ArrayList con todos los objetos existentes en el txt.
	 */
	public static ArrayList<Obra> leerTexto() {
		ArrayList<Obra> lista = new ArrayList<Obra>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Obras.txt"));
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");
				lista.add(new Obra(Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), x.nextToken(),
						x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(),
						Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), Area.valueOf(x.nextToken()),
						tipoObra.valueOf(x.nextToken())));
			}
		} catch (Exception e) {
		}
		return lista;
	}
}