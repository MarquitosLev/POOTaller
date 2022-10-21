package Biblioteca;

import java.time.LocalDate;

/**
 * Clase que contiene todos los datos de las personas que concurren a la
 * biblioteca
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 * 
 */
public abstract class Persona {
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
	 * @param nom       Se pasa un texto que contiene el/los nuevo/s nombre/s del
	 *                  sujeto y lo que hace es reemplazar el antiguo valor del
	 *                  atributo "nom" de la clase por el nuevo valor ingresado por
	 *                  parametro.
	 * 
	 * @param apellido  Se pasa un texto con el/los nuevo/s apellido/s del
	 *                  individuo. Se reemplaza el antiguo valor por el nuevo, en el
	 *                  atributo "apellido" de la clase.
	 * 
	 * @param tipDoc    Se pasa un texto con el nuevo tipo de documento que se desea
	 *                  colocar, y se reemplaza el valor antiguo de su atributo
	 *                  correspondiente de la clase con este nuevo valor.
	 * 
	 * @param numDoc    Se pasa un entero con el nuevo numero de documento a
	 *                  colocar. Y al valor antiguo del atributo "numDoc" de la
	 *                  clase se lo reemplaza por este nuevo valor.
	 * 
	 * @param correo    Se pasa un texto con el nuevo correo perteneciente a la
	 *                  persona. Se sustituye el antiguo correo por el nuevo, en su
	 *                  atributo correspondiente de la clase.
	 * 
	 * @param numCel    Se pasa un entero con el nuevo numero de celular de la
	 *                  persona. Se reemplaza el antiguo numero de celular por el
	 *                  nuevo, en el atributo "numCel" de la clase.
	 * 
	 * @param fecNac    Se pasa la fecha de nacimiento que se quiere agregar, que es
	 *                  de tipo "LocalDate". Se sustituye la fecha de nacimiento
	 *                  antigua por la nueva, en el atributo "fecNac" de la clase.
	 * 
	 * @param sex       Se pasa un texto que contiene el sexo con el que se siente
	 *                  identificado la persona. Se reemplaza el antiguo valor del
	 *                  atributo "sex" de la clase, por el nuevo valor.
	 * 
	 * @param lugarNac  Se pasa un texto con el lugar donde nacio el individuo. Se
	 *                  sustituye el antiguo valor del atributo "lugarNac" de la
	 *                  clase, por este nuevo valor ingresado.
	 * 
	 * @param domi      Se pasa un texto con el domicilio donde reside el sujeto. Se
	 *                  reemplaza, en el atributo "domi" de la clase, el viejo
	 *                  domicilio por el nuevo.
	 * 
	 * @param codPos    Aqui se encuentra el codigo postal, que es un entero. Lo que
	 *                  hace es sustituir, en su atributo correspondiente de la
	 *                  clase, el viejo codigo postal por el nuevo.
	 * 
	 * @param dep       Se pasa un texto con el departamento donde se encuentra
	 *                  ubicado la persona. Con este parametro, lo que se hace es
	 *                  reemplazar el antiguo nombre del departamento por el nuevo,
	 *                  en el atributo "dep" de la clase.
	 * 
	 * @param localidad Se pasa un texto en el que esta la localidad donde vive
	 *                  actualmente el sujeto. Se sustituye el viejo nombre de la
	 *                  localidad por el nuevo, en el atributo "localidad" de la
	 *                  clase.
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

	/**
	 * Constructor por defecto de la clase Persona
	 */
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

	/**
	 * Constructor que acepta solo el dni
	 * 
	 * @param numDoc Se pasa un entero con el numero de documento de la persona. Se
	 *               lo sustituye a ese nuevo valor por el viejo, en su atributo
	 *               correspondiente de la clase.
	 */
	public Persona(int numDoc) {
		this.numDoc = numDoc;
	}

	/**
	 * Metodo que retorna un String con el nombre de la persona.
	 * 
	 * @return Lo que devuelve es un texto con el nombre del individuo almacenado en
	 *         el atributo "nom" de la clase.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Metodo que settea el atributo "nom" de la clase.
	 * 
	 * @param nom Se pasa un texto con el nuevo nombre que se quiera agregar al
	 *            atributo de la clase.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Metodo que se encarga de retornar un texto con el apellido de la persona.
	 * 
	 * @return Retorna un String con el apellido del sujeto que esta almacenado en
	 *         el atributo "apellido" de la clase.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo encargado de settear el atributo "apellido" de la clase.
	 * 
	 * @param apellido Se pasa por parametro un texto con el nuevo apellido a
	 *                 agregar al atributo de la clase.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Metodo que se ocupa de retornar un String con el tipo de documento que tiene
	 * la persona.
	 * 
	 * @return Devuelve un String con el tipo de documento almacenado en el atributo
	 *         "tipDoc" de la clase.
	 */
	public String getTipDoc() {
		return tipDoc;
	}

	/**
	 * Metodo que tiene como objetivo settear el atributo "tipDoc" de la clase.
	 * 
	 * @param tipDoc Se pasa como parametro el tipo de documento que se quiere
	 *               añadir al atributo de la clase.
	 */
	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	/**
	 * Metodo que se encarga de retornar un valor entero con el numero de documento
	 * perteneciente a la persona.
	 * 
	 * @return Retorna el numero de documento de la persona en forma de entero, el
	 *         cual esta almacenado en el atributo "numDoc" de la clase.
	 */
	public int getNumDoc() {
		return numDoc;
	}

	/**
	 * Metodo en el cual se settea el atributo "numDoc" de la clase.
	 * 
	 * @param numDoc Se pasa el numero de documento que se quiere agregar al
	 *               atributo de la clase.
	 */
	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	/**
	 * Metodo que retorna un String con el correo correspondiente a la persona.
	 * 
	 * @return Retorna un texto con el correo de la persona almacenado en el
	 *         atributo "correo" de la clase.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Metodo que settea el atributo "correo" de la clase.
	 * 
	 * @param correo Se pasa un texto que contiene el nuevo correo que se quiere
	 *               agregar al atributo de la clase.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Metodo que tiene como finalidad retornar un entero con el numero de celular
	 * de la persona.
	 * 
	 * @return Devuelve un entero que contiene el numero de celular almacenado en el
	 *         atributo "numCel" de la clase.
	 */
	public int getNumCel() {
		return numCel;
	}

	/**
	 * Metodo que se encarga de settear el atributo "numCel" de la clase.
	 * 
	 * @param numCel Se pasa un entero con el nuevo numero de celular que se quiere añadir al atributo de la clase.
	 */
	public void setNumCel(int numCel) {
		this.numCel = numCel;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public LocalDate getFecNac() {
		return fecNac;
	}

	/**
	 * 
	 * 
	 * @param fecNac
	 */
	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getLugarNac() {
		return lugarNac;
	}

	/**
	 * 
	 * 
	 * @param lugarNac
	 */
	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getDomi() {
		return domi;
	}

	/**
	 * 
	 * 
	 * @param domi
	 */
	public void setDomi(String domi) {
		this.domi = domi;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getCodPos() {
		return codPos;
	}

	/**
	 * 
	 * 
	 * @param codPos
	 */
	public void setCodPos(int codPos) {
		this.codPos = codPos;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getDep() {
		return dep;
	}

	/**
	 * 
	 * 
	 * @param dep
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * 
	 * 
	 * @param localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		return "* Nombre: " + nom + "\n* Apellido: " + apellido + "\n* tipo DNI: " + tipDoc + ", N� DNI: " + numDoc
				+ "\n* Correo: " + correo + " - N� Celular: " + numCel + " - Fecha Nacimiento: " + fecNac + " - Sexo: "
				+ sex + "\n* Lugar Nacimiento: " + lugarNac + "\n* Domicilio: " + domi + " - Codigo Postal: " + codPos
				+ " - Departamento: " + dep + "-  Localidad: " + localidad;
	}

}
