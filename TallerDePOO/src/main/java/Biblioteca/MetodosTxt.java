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

public class MetodosTxt {
	ArrayList<Funcionario> datosFunc;
	ArrayList<Integer> datosLector;
	ArrayList<String> datoObra;
	ArrayList<Integer> datoEjemplar;
	
	public void agregar(Funcionario obj) {
		guardarFuncionario(obj);
	}
	
	/*public static void guardar(Class nuevo, String ruta) {
		try {
			File txt = new File(ruta);
			if (!txt.exists()) { // Crea el archivo txt en caso de que no exista
				txt.createNewFile();
			}
			FileWriter fw = new FileWriter(ruta, true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			n
		} catch(Exception e) {
			
		}
	}
	*/
	public boolean existe(String user) {
		datosFunc = new ArrayList<Funcionario>();
		try {
			FileReader fr = new FileReader("Funcionarios.txt");
			BufferedReader br = new BufferedReader(fr);
			String lector;
			while ((lector = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer X = new StringTokenizer(lector, "-"); // Se crea un String hasta que aparezca el "-"
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

	public boolean comprobarContrasenia(String pass) {

		for (int i = 0; i < datosFunc.size(); i++) {
			if (this.datosFunc.get(i).getContrasenia().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	public void guardarFuncionario(Funcionario funcionario) {
		try {
			File functxt = new File("Funcionarios.txt");
			if (!functxt.exists()) { // Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
			}
			FileWriter fw = new FileWriter("Funcionarios.txt", true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(funcionario.getUsuario() + "-");
			escribir.write(funcionario.getContrasenia() + "-" + "\n");
			escribir.close();
		} catch (Exception e) {
		}
	}

	public void guardarLector(Lector lector) {
		try {
			File functxt = new File("Lectores.txt");
			if (!functxt.exists()) { // Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
			}
			FileWriter fw = new FileWriter("Lectores.txt", true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(lector.getNom() + "/");
			escribir.write(lector.getApellido() + "/");
			escribir.write(lector.getTipDoc() + "/");
			escribir.write(lector.getNumDoc() + "/");
			escribir.write(lector.getCorreo() + "/");
			escribir.write(lector.getNumCel() + "/");
			escribir.write(lector.getFecNac() + "/");
			escribir.write(lector.getSex() + "/");
			escribir.write(lector.getDomi() + "/");
			escribir.write(lector.getCodPos() + "/");
			escribir.write(lector.getDep() + "/");
			escribir.write(lector.getLocalidad() + "/");
			escribir.write(lector.getCanMulta() + "/");
			escribir.write(lector.getEstaMultado() + "/" + "\n");
			escribir.close();
		} catch (Exception e) {
		}
	}
	
	public void guardarPrestamo(Prestamo prestamo) {
		try {
			File functxt = new File("Prestamos.txt");
			if (!functxt.exists()) { // Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
			}
			FileWriter fw = new FileWriter("Prestamos.txt", true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(prestamo.getFechaHoraPrestada() + "/");
			escribir.write(prestamo.getFuncionarioPrestador() + "/");
			escribir.write(prestamo.getFechaHoraADevolver() + "/");
			escribir.write(prestamo.getLector().getNumDoc() + "/");
			escribir.write(prestamo.getEjemplar().getIdEjemplar() + "/");
			escribir.write(prestamo.getFuncionarioPrestador() + "/");
			escribir.close();
		} catch (Exception e) {
		}
	}

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
		try {
			File functxt = new File("Obras.txt");
			if (!functxt.exists()) { // Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
			}
			FileWriter fw = new FileWriter("Obras.txt", true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(obra.getTitulo() + "/");
			escribir.write(obra.getCantEjem() + "/");
			escribir.write(obra.getCantEjemDisponible() + "/");
			escribir.write(obra.getSubtitulo() + "/");
			escribir.write(obra.getAutor1() + "/");
			escribir.write(obra.getAutor2() + "/");
			escribir.write(obra.getAutor3() + "/");
			escribir.write(obra.getGenero() + "/");
			escribir.write(obra.getIsbn() + "/");
			escribir.write(obra.getId() + "/");
			escribir.write(obra.getArea() + "/");
			escribir.write(obra.getTipo() + "/" + "\n");

			escribir.close();
		} catch (Exception e) {
		}
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
		
		for (int i = 0; i < datosObra.size(); i++) {
			if ((datosObra.get(i).equals(ejemplar.getObra()))) {
				datosObra.get(i).setCantEjem(datosObra.get(i).getCantEjem() + 1);
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() + 1);
			}
		}
		
		
		try {
			File functxt = new File("Obras.txt");
			functxt.delete();
			functxt.createNewFile();
			for (int i = 0; i> datosObra.size(); i++) {
			FileWriter fw = new FileWriter("Obras.txt", true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(datosObra.get(i).getTitulo() + "/");
			escribir.write(datosObra.get(i).getCantEjem() + "/");
			escribir.write(datosObra.get(i).getCantEjemDisponible() + "/");
			escribir.write(datosObra.get(i).getSubtitulo() + "/");
			escribir.write(datosObra.get(i).getAutor1() + "/");
			escribir.write(datosObra.get(i).getAutor2() + "/");
			escribir.write(datosObra.get(i).getAutor3() + "/");
			escribir.write(datosObra.get(i).getGenero() + "/");
			escribir.write(datosObra.get(i).getIsbn() + "/");
			escribir.write(datosObra.get(i).getId() + "/");
			escribir.write(datosObra.get(i).getArea() + "/");
			escribir.write(datosObra.get(i).getTipo() + "/" + "\n");

			escribir.close();
			}
		} catch (Exception e) {
		}
		try {
			File functxt = new File("Ejemplares.txt");
			if (!functxt.exists()) { // Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
			}
			FileWriter fw = new FileWriter("Ejemplares.txt", true);
			BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(ejemplar.getIdEjemplar() + "/");
			escribir.write(ejemplar.getObservaciones() + "/");
			escribir.write(ejemplar.getDisponible() + "/");
			escribir.write(ejemplar.getFechaAdquisicion() + "/");
			escribir.write(ejemplar.getCodUbicacion() + "/");
			escribir.write(ejemplar.getObra() + "/");
			escribir.write(ejemplar.getCantPedidas() + "/" + "\n");
			escribir.close();
			
		} catch (Exception e) {
		}
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
