package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * La clase se encarga de almacenar un conjunto de metodos que sirven para
 * guardar elementos y acciones como prestamos, obra, Ejemplar, funcionario,
 * dentro de ArrayLists, los recorridos de dichas clases y a la vez que
 * verifican su existencia o no.
 * 
 * @author Sebastian Etchepare
 *
 */

public class MetodosTxt {
	ArrayList<Funcionario> datosFunc;
	ArrayList<Integer> datosLector;
	ArrayList<String> datoObra;
	ArrayList<Integer> datoEjemplar;

	/**
	 * Guarda cualquier objeto que se pase por parámetro dentro de alguna de los 4
	 * ArrayLists creados en la clase. Seria como una funcion de guardado general.
	 * 
	 * @param nuevo Corresponde al objeto que va a ser agregado al ArrayList. Como
	 *              se indica, debe ser o implementar la interfaz 'guardado'
	 * 
	 * @param ruta  Se pasa la ruta donde los datos serán guardado.
	 */

	public static void guardar(guardado nuevo, String ruta) {
		try {
			File txt = new File(ruta);
			if (!txt.exists()) { // Crea el archivo txt en caso de que no exista
				txt.createNewFile();
			}
			FileWriter fw = new FileWriter(ruta, true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			try {
				ArrayList<Object> x = nuevo.obtenerLista();
				for (int i = 0; i < x.size(); i++) {
					escribir.write(x.get(i) + "/");
				}
			} catch (Exception e) {
			}
			escribir.write("\n");
			escribir.close();
		} catch (Exception e) {

		}
	}
<<<<<<< HEAD

=======
	
	
>>>>>>> 1914f0d5eb580dbea03ca848fbe52d62cb495019
	/**
	 * Función que controla si un usuario ya se encuentra registrado dentro de la
	 * aplicacion.
	 * 
	 * @param user Se le pasa el parámetro 'user', atributo perteneciente a
	 *             'Funcionario', para comprobar si el mismo ya existe dentro del
	 *             ArrayList de funcionario.
	 * 
	 * @return retorna 'verdadero' o 'Falso' para indicar si el funcionario se
	 *         encuentra o no guardado en el ArrayList.
	 */
	public boolean existeFuncionario(String user) {
		datosFunc = new ArrayList<Funcionario>();
		try {
			FileReader fr = new FileReader("Funcionarios.txt");
			BufferedReader br = new BufferedReader(fr);
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer X = new StringTokenizer(lector, "/"); // Se crea un String hasta que aparezca el "-"
				datosFunc.add(new Funcionario(X.nextToken(), X.nextToken()));
			}
		} catch (Exception e) {
		}
		if (datosFunc.size() == 0)
			return false;
		for (int i = 0; i < datosFunc.size(); i++) { // Recorre el ArrayList hasta encontrar alguna coincidencia
			if (datosFunc.get(i).getUsuario().equals(user)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo encargado de controlar si la contraseña se encuentra o no dentro del
	 * ArrayList.
	 * 
	 * @param pass Se pasa el parametro para controlar si se encuentra como
	 *             contraseña dentro del ArrayList de funcionarios.
	 * 
	 * @return Si la contraseña pasada por parametro coincide con alguna de las que
	 *         se encuentra dentro del ArrayList, entonces retorna 'Verdadero' sino,
	 *         'Falso'
	 */
	public boolean comprobarContrasenia(String pass) {

		for (int i = 0; i < datosFunc.size(); i++) {
			if (this.datosFunc.get(i).getContrasenia().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo encargado de comprobar que el lector ya se encuentra almacenado dentro
	 * del ArrayList de Lectores.
	 * 
	 * @param dni Se utilizar el DNI del mismo con clave para saber si se encuentra
	 *            o no.
	 * 
	 * @return En el caso de que el DNI se encuentre, retorna verdadero, por ende,
	 *         el lector existe. En caso contrario, retorna falso
	 */

	public boolean existeLector(int dni) {
		datosLector = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Lectores.txt"));
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");

				// x.nextToken() necesarios para llegar al numero de documento
				x.nextToken();
				x.nextToken();
				x.nextToken();
				int doc = Integer.parseInt(x.nextToken());// Parsea a entero el numero de dni

				datosLector.add(doc);// agrega al arraylist de enteros
			}
		} catch (Exception e) {
		}

		if (datosLector.size() == 0) {
			return false;
		}

		for (int i = 0; i < datosLector.size(); i++) {
			if ((datosLector.get(i).equals(dni))) {
				return true;// retorna true si el dni se encuentra en el txt
			}
		}
		return false;
	}

	/**
	 * Función que busca en los archivos .txt si existe una determinada obra.
	 * 
	 * @param titu Se le pasa el tilulo de la obra para buscar si se encuentra o no
	 *             almacenada.
	 * 
	 * @return retorna 'Verdadero' en caso de encontrar alguna coicidencia y 'Falso'
	 *         encaso contrario.
	 */
	public boolean existeObra(String titu) {
		datoObra = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Obras.txt"));
			String obra;
			while ((obra = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(obra, "/");
				datoObra.add(x.nextToken());// agrega al arraylist de String
			}
		} catch (Exception e) {
		}

		if (datoObra.size() == 0) {
			return false;
		}

		for (int i = 0; i < datoObra.size(); i++) {
			if ((datoObra.get(i).equals(titu))) {
				return true;// retorna true si el titulo se encuentra en el txt
			}
		}
		return false;
	}

	/**
	 * Metodo que se encarga de guardar un ejemplar dentro de un archivo .txt y se
	 * le suma 1 a la cantiad de ejemplares de y cantidad de ejemplares disponibles
	 * a la obra
	 * 
	 * @param ejemplar Se le pasa como parámetro el ejemplar que quiere ser
	 *                 añadido al ArrayList y posteriormente al .txt
	 */

	public void guardarEjemplar(Ejemplar ejemplar) {
		ArrayList<Obra> datosObra = new ArrayList<Obra>();
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("Obras.txt"));
			String obra;
			while ((obra = br2.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(obra, "/");
				datosObra.add(new Obra(Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), x.nextToken(),
						x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(),
						Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), Area.valueOf(x.nextToken()),
						tipoObra.valueOf(x.nextToken())));// agrega al arraylist de String
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < datosObra.size(); i++) { // Recorre el nuevo ArrayList agregando 1 ejemplar a la obra
														// ingresada
			if ((datosObra.get(i).equals(ejemplar.getObra()))) {
				datosObra.get(i).setCantEjem(datosObra.get(i).getCantEjem() + 1);
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() + 1);
				break;
			}
		}

		try {
			File functxt = new File("Obras.txt");
			functxt.delete();
			functxt.createNewFile();
			for (int i = 0; i < datosObra.size(); i++) {
				guardar(datosObra.get(i), "Obras.txt");
			}
		} catch (Exception e) {
		}
		guardar(ejemplar, "Ejemplares.txt");
	}
<<<<<<< HEAD

=======
	
>>>>>>> 1914f0d5eb580dbea03ca848fbe52d62cb495019
	public boolean existeEjemplar(int id) {
		datoEjemplar = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Ejemplares.txt"));
			String ejemplar;
			while ((ejemplar = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(ejemplar, "/");
				datoEjemplar.add(Integer.parseInt(x.nextToken()));// agrega al arraylist de int
			}
		} catch (Exception e) {
		}

		if (datoEjemplar.size() == 0) {
			return false;
		}

		for (int i = 0; i < datoEjemplar.size(); i++) {
			if ((datoEjemplar.get(i).equals(id))) {
				return true;// retorna true si el id se encuentra en el txt
			}
		}
		return false;

	}

	public void ejemplarPedido(Ejemplar ejemplar) {
		ArrayList<Obra> datosObra = new ArrayList<Obra>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Obras.txt"));
			String obra;
			while ((obra = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(obra, "/");
				datosObra.add(new Obra(Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), x.nextToken(),
						x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(),
						Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), Area.valueOf(x.nextToken()),
						tipoObra.valueOf(x.nextToken())));// agrega al arraylist de String
			}
		} catch (Exception e) {
		}
<<<<<<< HEAD

		for (int i = 0; i < datosObra.size(); i++) { // Recorre el nuevo ArrayList quitando 1 ejemplar disponible a la
														// obra
			if ((datosObra.get(i).equals(ejemplar.getObra()))) {
=======
		
		for (int i = 0; i < datosObra.size(); i++) {	//Recorre el nuevo ArrayList quitando 1 ejemplar disponible a la obra
			if ((datosObra.get(i).getTitulo().equals(ejemplar.getObra().getTitulo()))) {
>>>>>>> 1914f0d5eb580dbea03ca848fbe52d62cb495019
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() - 1);
				break;
			}
		}

		try {
			File functxt = new File("Obras.txt");
			functxt.delete();
			functxt.createNewFile();
			for (int i = 0; i < datosObra.size(); i++) {
				guardar(datosObra.get(i), "Obras.txt");
			}
		} catch (Exception e) {
		}

		ArrayList<Ejemplar> datosEjemplar = new ArrayList<Ejemplar>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Ejemplares.txt"));
			String ejemplarNoDisponible;
<<<<<<< HEAD
			while ((ejemplarNoDisponible = br3.readLine()) != null) { // Lee el archivo hasta el siguiente salto de
																		// linea
				StringTokenizer x = new StringTokenizer(ejemplarNoDisponible, "/");
				datosEjemplar.add(new Ejemplar(Integer.parseInt(x.nextToken()), x.nextToken(),
						Boolean.parseBoolean(x.nextToken()), FormaAdquirida.valueOf(x.nextToken()), x.nextToken(),
						new Obra()));// agrega al arraylist de String
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < datosEjemplar.size(); i++) { // Recorre el nuevo ArrayList quitando 1 ejemplar disponible a
															// la obra
			if ((datosObra.get(i).equals(ejemplar.getObra()))) {
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() - 1);
=======
			while ((ejemplarNoDisponible = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(ejemplarNoDisponible, "/");
				datosEjemplar.add(new Ejemplar(Integer.parseInt(x.nextToken()), x.nextToken(), Boolean.parseBoolean(x.nextToken()), 
						FormaAdquirida.valueOf(x.nextToken()), x.nextToken(), new Obra(x.nextToken())));// agrega al arraylist de String	
			}
		} catch (Exception e) {
		}
		
		for (int i = 0; i < datosEjemplar.size(); i++) {
			if ((datosEjemplar.get(i).equals(ejemplar))) {
				datosEjemplar.get(i).setDisponible(false);
>>>>>>> 1914f0d5eb580dbea03ca848fbe52d62cb495019
				break;
			}
		}
		try {
			File functxt = new File("Ejemplares.txt");
			functxt.delete();
			functxt.createNewFile();
<<<<<<< HEAD
			for (int i = 0; i < datosObra.size(); i++) {
				guardar(datosObra.get(i), "Ejemplares.txt");
=======
			for (int i = 0; i < datosEjemplar.size(); i++) {
			guardar(datosEjemplar.get(i), "Ejemplares.txt");
>>>>>>> 1914f0d5eb580dbea03ca848fbe52d62cb495019
			}
		} catch (Exception e) {
		}
	}
<<<<<<< HEAD

	public static Ejemplar buscarEjemplar(int id) {
		ArrayList<Ejemplar> datosEjemplar = new ArrayList<Ejemplar>();
		try {
			BufferedReader br3 = new BufferedReader(new FileReader("Ejemplares.txt"));
			String ejemplar;
			while ((ejemplar = br3.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(ejemplar, "/");
				datosEjemplar.add(new Ejemplar(Integer.parseInt(x.nextToken()), x.nextToken(),
						Boolean.parseBoolean(x.nextToken()), FormaAdquirida.valueOf(x.nextToken()), x.nextToken(),
						new Obra()));// agrega al arraylist de String. VA A CREAR UNA OBRA VACIA EN CONSTRUCTOR
			}
		} catch (Exception e) {
		}

		for (int b = 0; b < datosEjemplar.size(); b++) {
			if (datosEjemplar.get(b).getIdEjemplar() == id) {
				// Busca el id, si es igual, retorna el ejemplar, sino returna null.
				System.out.println("Entro for ej");
				return datosEjemplar.get(b);
			}
		}
		return null;

	}

	public static Lector buscarLector(int dni) {
		ArrayList<Lector> datosLector = new ArrayList<Lector>();
		try {
			BufferedReader br3 = new BufferedReader(new FileReader("Lectores.txt"));
			String lector;
			while ((lector = br3.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(lector, "/");
				datosLector.add(new Lector(x.nextToken(), x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()),
						x.nextToken(), Integer.parseInt(x.nextToken()), LocalDate.now(), x.nextToken(), x.nextToken(),
						x.nextToken(), Integer.parseInt(x.nextToken()), x.nextToken(), x.nextToken()));
				// agrega al arraylist de String
			}
		} catch (Exception e) {
		}

		for (int b = 0; b < datosLector.size(); b++) {
			if (datosLector.get(b).getNumDoc() == dni) {
				// Busca el dni, si es igual, retorna el Lector, sino returna null.
				return datosLector.get(b);
			}
		}
		return null;
	}
=======
	
	
>>>>>>> 1914f0d5eb580dbea03ca848fbe52d62cb495019
}
