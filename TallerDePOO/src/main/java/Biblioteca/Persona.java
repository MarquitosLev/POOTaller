package Biblioteca;
import java.time.LocalDate;

/**
 * Clase que contiene todos los datos de las personas que concurren a la biblioteca
 * @author Santiago Fernandez Gomez
 * 
 */
abstract class Persona {
	private String nom;
	private String apellido;
	private String tipDoc;
	private int numDoc;
	private String correo;
	private int numCel;
	private LocalDate fecNac;
	private String sex;
	private String lugarNac;
	private String domi;
	private int codPos;
	private String dep;
	private String localidad;
	
	/**
	 * Constructor parametrizado de la clase Persona
	 * 
	 * @param nom
	 * @param apellido
	 * @param tipDoc
	 * @param numDoc
	 * @param correo
	 * @param numCel
	 * @param fecNac
	 * @param sex
	 * @param lugarNac
	 * @param domi
	 * @param codPos
	 * @param dep
	 * @param localidad
	 */
	public Persona(String nom, String apellido, String tipDoc, int numDoc, String correo, int numCel, LocalDate fecNac,
			String sex, String lugarNac, String domi, int codPos, String dep, String localidad) {
		this.nom = nom;
		this.apellido = apellido;
		this.tipDoc = tipDoc;
		this.numDoc = numDoc;
		this.correo = correo;
		this.numCel = numCel;
		this.fecNac = fecNac;
		this.sex = sex;
		this.lugarNac = lugarNac;
		this.domi = domi;
		this.codPos = codPos;
		this.dep = dep;
		this.localidad = localidad;	
	}
	
	//Constructor por defecto de la clase Persona
	public Persona() {
		this.nom = "";
		this.apellido = "";
		this.tipDoc = "";
		this.numDoc = 0;
		this.correo = "";
		this.numCel = 0;
		this.fecNac = LocalDate.of(2022, 02, 05);
		this.sex = "";
		this.lugarNac = "";
		this.domi = "";
		this.codPos = 0;
		this.dep = "";
		this.localidad = "";
	}
	
	
	//Constructor que acepta solo el dni
	public Persona(int numDoc) {
		this.numDoc = numDoc;
	}
	
	/**
	 * Funcion que retorna el nombre de la persona que es de tipo 'String'
	 * 
	 * @return un String con el nombre del individuo
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Metodo que settea el atributo "nom" de la clase
	 * 
	 * @param nom Se pasa el nombre que se quiera agregar al atributo de la clase 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Funcion que se encarga de retornar el apellido de la persona
	 * 
	 * @return un String con el apellido del sujeto
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo encargado de settear el atributo "apellido" de la clase 
	 * 
	 * @param apellido Se pasa por parametro el apellido a agregar al atributo de la clase
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Funcion que se ocupa de retornar el tipo de documento que tiene la persona
	 * 
	 * @return un String en el que se indica que tipo de documento posee
	 */
	public String getTipDoc() {
		return tipDoc;
	}

	/**
	 * Metodo que tiene como objetivo settear el atributo "tipDoc" de la clase
	 * 
	 * @param tipDoc Se pasa como parametro el tipo de documento que se quiere añadir al atributo de la clase
	 */
	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	public int getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getNumCel() {
		return numCel;
	}

	public void setNumCel(int numCel) {
		this.numCel = numCel;
	}

	public LocalDate getFecNac() {
		return fecNac;
	}

	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLugarNac() {
		return lugarNac;
	}

	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}

	public String getDomi() {
		return domi;
	}

	public void setDomi(String domi) {
		this.domi = domi;
	}

	public int getCodPos() {
		return codPos;
	}

	public void setCodPos(int codPos) {
		this.codPos = codPos;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String toString() {
		return "* Nombre: " + nom + "\n* Apellido: " + apellido + "\n* tipo DNI: " + tipDoc + ", N� DNI: " + numDoc
				+ "\n* Correo: " + correo + " - N� Celular: " + numCel + " - Fecha Nacimiento: " + fecNac + " - Sexo: " + sex + "\n* Lugar Nacimiento: "
				+ lugarNac + "\n* Domicilio: " + domi + " - Codigo Postal: " + codPos + " - Departamento: " + dep + "-  Localidad: " + localidad;
	}
	
	
}
