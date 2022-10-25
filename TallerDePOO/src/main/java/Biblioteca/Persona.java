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
	 * Constructor usado para crear a la persona.
	 * 
	 * @param nom       Se pasa un texto que contiene el/los nombre/s del sujeto
	 * 
	 * @param apellido  Se pasa un texto con el/los apellido/s del individuo.
	 * 
	 * @param tipDoc    Se pasa un texto con el tipo de documento a colocar.
	 * 
	 * @param numDoc    Se pasa un entero con el numero de documento a colocar.
	 * 
	 * @param correo    Se pasa un texto con el correo perteneciente a la persona.
	 * 
	 * @param numCel    Se pasa un entero con el numero de celular de la persona.
	 * 
	 * @param fecNac    Se pasa la fecha de nacimiento que se quiere agregar, que es
	 *                  de tipo "LocalDate".
	 * 
	 * @param sex       Se pasa un texto que contiene el sexo con el que se siente
	 *                  identificado la persona.
	 * 
	 * @param lugarNac  Se pasa un texto con el lugar donde nacio el individuo.
	 * 
	 * @param domi      Se pasa un texto con el domicilio donde reside el sujeto.
	 * 
	 * @param codPos    Aqui se encuentra el codigo postal, que es un entero.
	 * 
	 * @param dep       Se pasa un texto con el departamento donde se encuentra
	 *                  ubicado la persona.
	 * 
	 * @param localidad Se pasa un texto en el que esta la localidad donde vive
	 *                  actualmente el sujeto.
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
	 * Constructor que acepta solo el dni.
	 * 
	 * @param numDoc Se pasa un entero con el numero de documento de la persona.
	 */
	public Persona(int numDoc) {
		this.numDoc = numDoc;
	}

	/**
	 * Metodo que retorna un String con el nombre de la persona.
	 * 
	 * @return Lo que devuelve es un texto con el nombre del individuo almacenado.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Metodo que settea el atributo "nom" de la clase.
	 * 
	 * @param nom Se pasa un texto con el nuevo nombre a agregar.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Metodo que se encarga de retornar un texto con el apellido de la persona.
	 * 
	 * @return Retorna un String con el apellido del sujeto que esta almacenado.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo encargado de settear el atributo "apellido" de la clase.
	 * 
	 * @param apellido Se pasa un texto con el nuevo apellido a agregar.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Metodo que retorna un String con el tipo de documento que tiene la persona.
	 * 
	 * @return Devuelve un String con el tipo de documento almacenado.
	 */
	public String getTipDoc() {
		return tipDoc;
	}

	/**
	 * Metodo que tiene como objetivo settear el atributo "tipDoc" de la clase.
	 * 
	 * @param tipDoc Se pasa como parametro el tipo de documento que se quiere
	 *               añadir.
	 */
	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	/**
	 * Metodo que retorna un entero con el numero de documento perteneciente a la
	 * persona.
	 * 
	 * @return Retorna el numero de documento almacenado de la persona en forma de
	 *         entero.
	 */
	public int getNumDoc() {
		return numDoc;
	}

	/**
	 * Metodo en el cual se settea el atributo "numDoc" de la clase.
	 * 
	 * @param numDoc Se pasa el numero de documento que se quiere agregar.
	 */
	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	/**
	 * Metodo que retorna un String con el correo correspondiente a la persona.
	 * 
	 * @return Retorna un texto con el correo de la persona almacenado.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Metodo que settea el atributo "correo" de la clase.
	 * 
	 * @param correo Se pasa un texto que contiene el nuevo correo que se quiere
	 *               agregar.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Metodo que devuelve un entero con el numero de celular de la persona.
	 * 
	 * @return Devuelve un entero que contiene el numero de celular almacenado.
	 */
	public int getNumCel() {
		return numCel;
	}

	/**
	 * Metodo que se encarga de settear el atributo "numCel" de la clase.
	 * 
	 * @param numCel Se pasa un entero con el nuevo numero de celular que se quiere
	 *               añadir.
	 */
	public void setNumCel(int numCel) {
		this.numCel = numCel;
	}

	/**
	 * Metodo que retorna la fecha de nacimiento de la persona en forma de
	 * "LocalDate".
	 * 
	 * @return Retorna un "LocalDate" con la fecha de nacimiento que se encuentra
	 *         guardada.
	 */
	public LocalDate getFecNac() {
		return fecNac;
	}

	/**
	 * Metodo encargado de settear el atributo "fecNac" de la clase.
	 * 
	 * @param fecNac Se pasa una nueva fecha de nacimiento, de tipo "LocalDate".
	 */
	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	/**
	 * Metodo que se encarga de retornar un String con el sexo de la persona.
	 * 
	 * @return Devuelve un String con el valor almacenado.
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Metodo que settea el atributo "sex" de la clase.
	 * 
	 * @param sex Se pasa un texto con el nuevo valor del sexo de la persona.
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Metodo que se encarga de devolver un String con el lugar de nacimiento de la
	 * persona.
	 * 
	 * @return Retorna un String con el valor guardado.
	 */
	public String getLugarNac() {
		return lugarNac;
	}

	/**
	 * Metodo que se ocupa de settear el atributo "lugarNac" de la clase.
	 * 
	 * @param lugarNac Se pasa un texto con el lugar de nacimiento que se quiere
	 *                 agregar.
	 */
	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}

	/**
	 * Metodo que retorna un String con el domicilio donde vive la persona.
	 * 
	 * @return Devuelve un String con el valor que se encuentra guardado.
	 */
	public String getDomi() {
		return domi;
	}

	/**
	 * Metodo que se encarga de settear el atributo "domi" de la clase.
	 * 
	 * @param domi Se pasa un texto con el nuevo domicilio a agregar.
	 */
	public void setDomi(String domi) {
		this.domi = domi;
	}

	/**
	 * Metodo que devuelve un entero con el codigo postal del individuo.
	 * 
	 * @return Retorna el codigo postal almacenado, en forma de entero.
	 */
	public int getCodPos() {
		return codPos;
	}

	/**
	 * Metodo que settea el atributo "codPos" de la clase.
	 * 
	 * @param codPos Se le pasa un valor entero con el codigo postal que se quiere
	 *               agregar.
	 */
	public void setCodPos(int codPos) {
		this.codPos = codPos;
	}

	/**
	 * Metodo que retorna un String con el departamento donde vive la persona.
	 * 
	 * @return Devuelve un String con el departamento guardado.
	 */
	public String getDep() {
		return dep;
	}

	/**
	 * Metodo que settea el atributo "dep" de la clase.
	 * 
	 * @param dep Se le pasa un String con el departamento a agregar.
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}

	/**
	 * Metodo que retorna un String con la localidad donde reside el individuo.
	 * 
	 * @return Devuelve un String con la localidad que esta almacenada.
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Metodo que se encarga de settear el atributo "localidad" de la clase.
	 * 
	 * @param localidad Se le pasa un String con la localidad que se desea agregar.
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * Metodo que se encarga de retornar un String con todos los datos de la clase.
	 * 
	 * @return Devuelve un String con todos los datos almacenados.
	 */
	public String toString() {
		return nom + " - " + apellido + " - " + tipDoc + " - " + numDoc + " - " + correo + " - " + numCel + " - "
				+ fecNac + " - " + sex + " - " + lugarNac + " - " + domi + " - " + codPos + " - " + dep + " - "
				+ localidad;
	}

}
