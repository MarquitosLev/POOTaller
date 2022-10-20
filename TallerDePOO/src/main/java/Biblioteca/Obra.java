package Biblioteca;
import java.util.ArrayList;

/**
 * Clase que representa a las obras que se tienen registradas en la biblioteca
 * 
 * @author Leandro González Fister
 * @author Marcos Leiva
 * @author Sebastián Etchepare
 * 
 * */

public class Obra implements guardado{
	
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
	private Area area; //Enumeracion
	private tipoObra tipo; //Enumeracion
	//private Coleccion perteneceA; //Unidireccionalidad con multiplicidad. Quitar comentario en constructores
	private ArrayList<Ejemplar> ejemplares;
	private ArrayList<Edicion> ediciones;
	//Creación de la asociación entre funcionario, obra y reserva;
	private Reserva funcionario;

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
	public Obra(String titulo, String subtitulo, String autor1, String autor2, String autor3, String genero, int isbn, int id, Area area, tipoObra tipo) {
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
	
	public Obra(int cantEjem, int cantEjemDisponible, String titulo, String subtitulo, String autor1, String autor2, String autor3, String genero, int isbn, int id, Area area, tipoObra tipo) {
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
	
	public Obra(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Función que retorna el funcionario del tipo 'Reserva'
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
	 * Función que retorna ediciones.
	 * 
	 * @return las ediciones que se encuentran dentro del ArrayList del tipo Edición.
	 */
	
	public ArrayList<Edicion> getEdiciones() {
		return ediciones;
	}

	/**
	 * Metodo que se encarga de setear lo que se encuentre dentro del atributo 'ediciones'
	 * 
	 * @param ediciones Se pasa como parámetro, un ArrayList que reemplaza el valor guardado en el correspondiente atributo.
	 */
	public void setEdiciones(ArrayList<Edicion> ediciones) {
		this.ediciones = ediciones;
	}

	/**
	 * 
	 * @return
	 */
	
	public ArrayList<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(ArrayList<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getCantEjem() {
		return cantEjem;
	}
	public void setCantEjem(int cantEjem) {
		this.cantEjem = cantEjem;
	}
	public int getCantEjemDisponible() {
		return cantEjemDisponible;
	}
	public void setCantEjemDisponible(int cantEjemDisponible) {
		this.cantEjemDisponible = cantEjemDisponible;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getAutor1() {
		return autor1;
	}
	public void setAutor1(String autor1) {
		this.autor1 = autor1;
	}
	public String getAutor2() {
		return autor2;
	}
	public void setAutor2(String autor2) {
		this.autor2 = autor2;
	}
	public String getAutor3() {
		return autor3;
	}
	public void setAutor3(String autor3) {
		this.autor3 = autor3;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getIsbn() {
		return isbn;
	}
	public int getId() {
		return id;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public tipoObra getTipo() {
		return tipo;
	}
	public void setTipo(tipoObra tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Metodo que se encarga de crear un array list del tipo objeto e ir agregando los atributos de la clase dentro. 
	 */
	
	public ArrayList<Object> obtenerLista() {
		ArrayList<Object>  lista = new ArrayList<Object> ();
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
}