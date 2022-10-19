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
import java.util.Vector;

/**
 * La clase se encarga de almacenar un conjunto de métodos que sirven para guardar elementos y acciones como 
 * préstamos, obra, Ejemplar, funcionario, dentro de ArrayLists, a la vez que verifican su existencia o no.
 * 
 * @author Sebastián Etchepare
 *
 */

public class MetodosTxt  {
	ArrayList<Funcionario> datosFunc;
	ArrayList<Integer> datosLector;
	ArrayList<String> datoObra;
	ArrayList<Integer> datoEjemplar;
	
	/**
	 * 
	 * @param obj Un objeto del tipo funcionario que es pasado por parámetro, para luego ser almacenado en un ArrayList
	 * 			  a través de otro método llamada "guardarFuncionario"
	 */
	public void agregar(Funcionario obj) {
		guardarFuncionario(obj);
	}
	
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
				System.out.println(x);
				System.out.println("Entr� al guardado");
				for (int i = 0; i < x.size(); i++) {
					escribir.write(x.get(i) + "/");
				}
			} catch (Exception e) {
			}
			escribir.write("\n");
			escribir.close();
		} catch(Exception e) {
			
		}
	}
	
	/**
	 * 
	 * @param user Se le pasa el parámetro 'user', atributo perteneciente a 'Funcionario', para comprobar si el mismo ya 
	 * existe dentro del ArrayList de funcionario. 
	 * @return retorna 'verdadero' o 'Falso' para indicar si el funcionario se encuentra o no guardado en el ArrayList. 
	 */
	public boolean existe(String user) {
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
 * Método encargado de controlar si la contraseña se encuentra o no dentro del ArrayList
 * @param pass Se pasa el parámetro para controlar si se encuentra como contraseña dentro del ArrayList de funcionarios
 * @return Si la contraseña pasada por parámetro coincide con alguna de las que se encuentra dentro del ArrayList, entonces retorna 'Verdadero'
 * sino, 'Falso'
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
 * Método que se encarga de escribir/almacenar los datos de un funcionario dentro del archivo 'Funcionarios.txt'
 * @param funcionario Se le pasa un funcionario, cuyos datos serán guardados dentro del archivo '.txt'
 */
	public void guardarFuncionario(Funcionario funcionario) {
		guardar(funcionario, "Funcionarios.txt");
	}
	/**
	 * Método encargado de escribir/almacenar los datos del objeto 'Lector' dentro del archivo 'Lectores.txt'
	 * @param lector Se le pasa un objeto del tipo 'Lector'  para que sus datos sean tomados y escritos en el '.txt'
	 */
	public void guardarLector(Lector lector) {
		guardar(lector, "Lectores.txt");
	}
	
	/**
	 * Método encargado de escribir/almacenar los datos del objeto 'Préstamo' dentro del archivo 'Prestamos.txt'
	 * @param prestamo Se le pasa un objeto del tipo 'Prestamo' para tomar sus datos y guardarlos en el .txt
	 */
	
	public void guardarPrestamo(Prestamo prestamo) {
		guardar(prestamo, "Prestamos.txt");

	}

	/**
	 * Método encargado de comprobar que el lector ya se encuentra almacenado dentro del ArrayList de Lectores.
	 * 
	 * @param dni Se utilizar el DNI del mismo con clave para saber si se encuentra o no. 
	 * 
	 * @return En el caso de que el DNI se encuentre, retorna verdadero, por ende, el lector existe. En caso
	 * contrario, retorna falso
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

	public void guardarObra(Obra obra) {
		guardar(obra, "Obras.txt");
	}

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

	public void guardarEjemplar(Ejemplar ejemplar) {
		ArrayList<Obra> datosObra = new ArrayList<Obra>();
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("Obras.txt"));
			String obra;
			while ((obra = br2.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(obra, "/");
				datosObra.add(new Obra(Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()), x.nextToken(), x.nextToken(),
						x.nextToken(), x.nextToken(), x.nextToken(), x.nextToken(), Integer.parseInt(x.nextToken()), Integer.parseInt(x.nextToken()),
								Area.valueOf(x.nextToken()), tipoObra.valueOf(x.nextToken())));// agrega al arraylist de String	
			}
		} catch (Exception e) {
		}
		
		for (int i = 0; i < datosObra.size(); i++) {	//Recorre el nuevo ArrayList agregando 1 ejemplar a la obra ingresada
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
	public boolean existeEjemplar(int id) {
		datoEjemplar = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Ejemplares.txt"));
			String ejemplar;
			while ((ejemplar = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(ejemplar, "/");
				datoObra.add(x.nextToken());// agrega al arraylist de int
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
}
