package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * La clase se encarga de almacenar un conjunto de metodos que sirven para
 * guardar elementos y acciones como prestamos, obra, Ejemplar, funcionario,
 * dentro de ArrayLists, los recorridos de dichas clases y a la vez que
 * verifican su existencia o no.
 * 
 * @author Leandro Gonzalez Fister
 * @author Marcos Leiva
 * @author Sebastian Etchepare
 * @author Santiago Fernandez Gomez
 */
public class MetodosTxt {
	ArrayList<Funcionario> datosFunc;
	ArrayList<Integer> datosLector;
	ArrayList<String> datoObra;
	ArrayList<Prestamo> listaPrestamo;
	ArrayList<Ejemplar> listaEjemplar;
	ArrayList<Obra> listaObra;
	ArrayList<Lector> listaLector;

	/**
	 * Guarda cualquier objeto que se pase por parámetro dentro de alguna de los 4
	 * ArrayLists creados en la clase. Seria como una funcion de guardado general.
	 * 
	 * @param nuevo Corresponde al objeto que va a ser agregado al ArrayList. Como
	 *              se indica, debe ser o implementar la interfaz 'guardado'
	 * 
	 * @param ruta  Se pasa la ruta donde los datos serán guardado.
	 */

	public void guardar(guardado nuevo, String ruta) {
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

	/**
	 * Función que controla si un usuario ya se encuentra registrado dentro de la
	 * aplicacion.
	 * 
	 * @param user Se le pasa el parámetro 'user', atributo perteneciente a
	 *             'Funcionario', para comprobar si el mismo ya existe dentro del
	 *             ArrayList de funcionario.
	 * 
	 * @return Retorna 'Verdadero' o 'Falso' para indicar si el funcionario se
	 *         encuentra o no guardado en el ArrayList.
	 */
	public boolean comprobarFuncionario(String user) {
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
	 * Metodo que busca en los archivos .txt si existe una determinada obra.
	 * 
	 * @param titu Se le pasa el titulo de la obra para buscar si se encuentra o no
	 *             almacenada.
	 * 
	 * @return Retorna 'Verdadero' en caso de encontrar alguna coicidencia y 'Falso'
	 *         en caso contrario.
	 */
	public boolean existeObra(String titu) {
		datoObra = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Obras.txt"));
			String obra;
			while ((obra = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
				StringTokenizer x = new StringTokenizer(obra, "/");
				x.nextToken();
				x.nextToken();
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
	 * le suma 1 a la cantidad de ejemplares y cantidad de ejemplares disponibles a
	 * la obra
	 * 
	 * @param ejemplar Se le pasa como parámetro el ejemplar que quiere ser añadido
	 *                 al ArrayList y posteriormente al .txt
	 */
	public void guardarEjemplar(Ejemplar ejemplar) {
		ArrayList<Obra> datosObra = Obra.leerTexto();

		for (int i = 0; i < datosObra.size(); i++) { // Recorre el nuevo ArrayList agregando 1 ejemplar a la obra
														// ingresada
			if ((datosObra.get(i).getTitulo().equals(ejemplar.getObra().getTitulo()))) {
				datosObra.get(i).setCantEjem(datosObra.get(i).getCantEjem() + 1);
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() + 1);
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("Obras.txt"));
					bw.write("");
					bw.close();
					for (int j = 0; j < datosObra.size(); j++) {
						guardar(datosObra.get(j), "Obras.txt");
					}
				} catch (Exception e) {
				}
				break;

			}
		}
		guardar(ejemplar, "Ejemplares.txt");
	}

	public boolean existeEjemplar(int id) {
		listaEjemplar = Ejemplar.leerTexto();

		if (listaEjemplar.size() == 0) {
			return false;
		}

		for (int i = 0; i < listaEjemplar.size(); i++) {
			if (listaEjemplar.get(i).getIdEjemplar() == id) {
				return true;// retorna true si el id se encuentra en el txt
			}
		}
		return false;

	}

	// Metodo llamado cuando se solicita el ejemplar
	public void ejemplarPedido(Ejemplar ejemplar) { // Pide un Ejemplar solo con el atributo ID

		ArrayList<Ejemplar> datosEjemplar = new ArrayList<Ejemplar>();
		try {
			BufferedReader br3 = new BufferedReader(new FileReader("Ejemplares.txt"));
			String ejemplarNoDisponible;
			while ((ejemplarNoDisponible = br3.readLine()) != null) { // Lee el archivo hasta el siguiente salto de
																		// linea
				StringTokenizer x = new StringTokenizer(ejemplarNoDisponible, "/");
				datosEjemplar.add(new Ejemplar(Integer.parseInt(x.nextToken()), x.nextToken(),
						Boolean.parseBoolean(x.nextToken()), FormaAdquirida.valueOf(x.nextToken()),
						LocalDateTime.parse(x.nextToken()), x.nextToken(), new Obra(x.nextToken()),
						Integer.parseInt(x.nextToken())));// agrega al arraylist de String
			}
		} catch (Exception e) {
		}
		Ejemplar ejem = new Ejemplar(); // Auxiliar para guardar el ejemplar que se actualizo
		for (int j = 0; j < datosEjemplar.size(); j++) { // Recorre el ArrayList de Ejemplares buscando el ejemplar
															// prestado para
			if ((datosEjemplar.get(j).getIdEjemplar() == (ejemplar.getIdEjemplar()))) { // colocandole la disponibilidad
																						// en false
				datosEjemplar.get(j).setDisponible(false); // Setea en falso la disponibilidad
				datosEjemplar.get(j).setCantPedidas(datosEjemplar.get(j).getCantPedidas() + 1); // Incrementa en 1 la
																								// cantidad de veces
																								// pedidas del ejemplar
				ejem = datosEjemplar.get(j);
				break;

			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Ejemplares.txt"));// Vacia el txt
			bw.write("");
			bw.close();
			for (int i = 0; i < datosEjemplar.size(); i++) {
				guardar(datosEjemplar.get(i), "Ejemplares.txt"); // Guarda todos los ejemplares ya actualizados
			}
		} catch (Exception e) {
		}

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

		for (int i = 0; i < datosObra.size(); i++) { // Recorre el nuevo ArrayList quitando 1 ejemplar disponible a la
														// obra
			if ((datosObra.get(i).getTitulo().equals(ejem.getObra().getTitulo()))) {
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() - 1);
				break;
			}
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Obras.txt"));// Vacia el txt
			bw.write("");
			bw.close();
			for (int i = 0; i < datosObra.size(); i++) {
				guardar(datosObra.get(i), "Obras.txt");
			}
		} catch (Exception e) {
		}

	}

	public void AumentoEjemplarDisponible(String ejemplar) {

		ArrayList<Obra> datosObra = Obra.leerTexto();
		for (int j = 0; j < datosObra.size(); j++) { // Recorre el nuevo ArrayList agregando 1 ejemplar
			// a la obra // ingresada
			if ((datosObra.get(j).getTitulo().equals(ejemplar))) {
				datosObra.get(j).setCantEjemDisponible(datosObra.get(j).getCantEjemDisponible() + 1);
				break;
			}
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Obras.txt"));// Vacia el txt
			bw.write("");
			bw.close();
			for (int q = 0; q < datosObra.size(); q++) {
				guardar(datosObra.get(q), "Obras.txt");
			}
		} catch (Exception e) {
		}
	}

	public void guardarPrestamoTerminado(LocalDateTime fechaDevuelta, String funcionario, int ejemplar) {

		if (comprobarFuncionario(funcionario)) { // Comprueba que el funcionario exista

			if (existeEjemplar(ejemplar)) { // Comprueba que el ejemplar exista

				ArrayList<Prestamo> datosPrestamo = Prestamo.leerTexto(1);

				// Recorre el ArrayList de Prestamos buscando el que
				// coincide con el ejemplar ingresado
				for (int i = 0; i < datosPrestamo.size(); i++) {
					Ejemplar EjemplarAux = new Ejemplar(ejemplar);
					if (datosPrestamo.get(i).getEjemplar().getIdEjemplar() == EjemplarAux.getIdEjemplar()) {
						Prestamo aux = datosPrestamo.get(i);
						Prestamo prestamoDevuelto = new Prestamo(aux.getFechaHoraPrestada(),
								aux.getFuncionarioPrestador(), aux.getFechaHoraADevolver(), fechaDevuelta, funcionario,
								aux.getaDomicilio(), aux.getLector(), aux.getEjemplar());
						
						System.out.println("Si");
						// Metodo para agregar una multa al lector
						Long comparacion = ChronoUnit.DAYS.between(aux.getFechaHoraADevolver(), fechaDevuelta);
						System.out.println(comparacion);
						if(comparacion > 0) {
							ArrayList<Lector> lectores = Lector.leerTexto();
							for (int b = 0; b < lectores.size();b++) {
								 if (lectores.get(b).getNumDoc() == aux.getLector().getNumDoc()) {
									lectores.get(b).setEstaMultado(true);
									lectores.get(b).setCanMulta(lectores.get(b).getCanMulta()+1);
									lectores.get(b).setDiasMultado(lectores.get(b).getDiasMultado()+(comparacion*3));
									Multa multa = new Multa((comparacion*3), new Prestamo(ejemplar));
									guardar(multa, "Multas.txt");
									try {
										BufferedWriter bw2 = new BufferedWriter(new FileWriter("Lectores.txt"));// Vacia el txt
										bw2.write("");
										bw2.close();
										for (int l = 0; l < lectores.size(); l++) {
											guardar(lectores.get(l), "Lectores.txt");
										}
									} catch (Exception e) {
									}
									break;
								}
							}
							
						}
						datosPrestamo.remove(i); // Despues de crear el prestamoDevuelto borra el prestamo del array
							
						try {
							File txt = new File("PrestamosTerminados.txt");
							if (!txt.exists()) { // Crea el archivo txt en caso de que no exista
								txt.createNewFile();
							}
							FileWriter fw = new FileWriter("PrestamosTerminados.txt", true);
							BufferedWriter br = new BufferedWriter(fw); // Escribe los datos asignados
							PrintWriter escribir = new PrintWriter(br);
							try { // Escribe todos los atributos del prestamo teminado en el txt
								escribir.write(prestamoDevuelto.getFechaHoraPrestada() + "/");
								escribir.write(prestamoDevuelto.getFuncionarioPrestador() + "/");
								escribir.write(prestamoDevuelto.getFechaHoraADevolver() + "/");
								escribir.write(prestamoDevuelto.getFechaDevuelta() + "/");
								escribir.write(prestamoDevuelto.getFuncionarioDevuelta() + "/");
								escribir.write(prestamoDevuelto.getaDomicilio() + "/");
								escribir.write(prestamoDevuelto.getLector().getNumDoc() + "/");
								escribir.write(prestamoDevuelto.getEjemplar().getIdEjemplar() + "/");
							} catch (Exception e) {
							}
							escribir.write("\n");
							escribir.close();
						} catch (Exception e) {

						}

						// Obtengo los ejemplares del Ejemplares.txt
						ArrayList<Ejemplar> datosEjemplar = Ejemplar.leerTexto();

						// busco el ejemplar con el id ingresado
						String nuevo = "";
						for (int t = 0; t < datosEjemplar.size(); t++) {
							if ((datosEjemplar.get(t).getIdEjemplar() == ejemplar)) {

								nuevo = datosEjemplar.get(t).getObra().getTitulo();

								// AL DEVOLVEL SETEA DISPONIBILIDAD A TRUE
								datosEjemplar.get(t).setDisponible(true);

								break;
							}
						}

						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter("Ejemplares.txt"));// Vacia el txt
							bw.write("");
							bw.close();
							for (int y = 0; y < datosEjemplar.size(); y++) {
								guardar(datosEjemplar.get(y), "Ejemplares.txt");
							}
						} catch (Exception e) {
						}

						try {
							BufferedWriter bw2 = new BufferedWriter(new FileWriter("Prestamos.txt"));// Vacia el txt
							bw2.write("");
							bw2.close();
							for (int l = 0; l < datosPrestamo.size(); l++) {
								guardar(datosPrestamo.get(l), "Prestamos.txt");
							}
						} catch (Exception e) {
						}
						AumentoEjemplarDisponible(nuevo);
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe el Ejemplar", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existe el Funcionario", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean fechaPasada(Prestamo pres) {
		Long x = ChronoUnit.DAYS.between(pres.getFechaHoraADevolver(), LocalDateTime.now()); // 20-10 < 21-10
		if (x < 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hayDisponibles(int id) {
		ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
		ArrayList<Obra> obras = Obra.leerTexto();

		for (int i = 0; i < obras.size(); i++) {
			for (int t = 0; t < ejemplares.size(); t++) {
				// Si el id del ejemplar y el titulo de obra y ejemplar son iguales, es
				// verdadero

				if (ejemplares.get(t).getIdEjemplar() == id
						&& ejemplares.get(t).getObra().getTitulo().equals(obras.get(i).getTitulo())) {
					if (obras.get(i).getCantEjemDisponible() > 0) {
						return true;
					}

				}
			}
		}

		return false;
	}
	
	public void extenderDias(int dias, int ejemplar) {
		ArrayList<Prestamo> prestamos = Prestamo.leerTexto(1);
		Boolean aux = true;
		try {
			for (int i = 0; i<prestamos.size(); i++) {
				if (prestamos.get(i).getEjemplar().getIdEjemplar() == ejemplar) {
					prestamos.get(i).setFechaHoraADevolver(prestamos.get(i).getFechaHoraADevolver().plusDays(dias));
					
					BufferedWriter bw = new BufferedWriter(new FileWriter("Prestamos.txt"));// Vacia el txt
					bw.write("");
					bw.close();
					for (int q = 0; q < prestamos.size(); q++) {
						guardar(prestamos.get(q), "Prestamos.txt");
					}
					aux = false;
				break;
				}
			}
		} catch(Exception e) {
		}
		if (aux == true) {
			JOptionPane.showMessageDialog(null, "Ejemplar " + ejemplar + " no se encuentra en Prestamos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se han extendido " + dias + " dias al pr�stamo", "Exito", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void imprimirEjemplaresArea(JTextArea textArea, JComboBox boxArea2) {
		ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
		ArrayList<Obra> obras = Obra.leerTexto();
		/**
		 * Recorre ejemplares
		 */
		for (int i = 0; i < ejemplares.size(); i++) {
			/**
			 * recorre obras
			 */
			for (int j = 0; j < obras.size(); j++) {
				/*
				 * Verifica si estan en la misma obra
				 */
				if (ejemplares.get(i).getObra().getTitulo().equals(obras.get(j).getTitulo())) {
					/*
					 * Verifica si es el area indicada
					 */
					if (obras.get(j).getArea().equals(boxArea2.getSelectedItem())) {
						/*
						 * verifica disponibilidad del ejemplar
						 */
						if (ejemplares.get(i).getDisponible()) {
							/*
							 * agrega al texto los datos (Titulo - IDEjemplar - Cantidad Disponible)
							 */
							textArea.append(obras.get(j).getTitulo() + " - " + ejemplares.get(i).getIdEjemplar()
									+ " - " + obras.get(j).getCantEjemDisponible() + "\n");
							textArea.append("----------------------------------------\n");
						}
					}
				}
			}
		}
	}
	
	//Metodo que devuelve un ArrayList de los lectores con mas multas en cierta fecha dada
	public ArrayList<Multa> lectoresPorFecha(LocalDateTime fechaMin, LocalDateTime fechaMax){
		ArrayList<Multa> multas = Multa.leerTexto();
		ArrayList<Multa> multasEnFecha = new ArrayList<Multa>();
		for (int i = 0; i < multas.size(); i++) {
			Long menor = ChronoUnit.DAYS.between(fechaMin, multas.get(i).getFechaHoraMultado());
			Long mayor = ChronoUnit.DAYS.between(fechaMax, multas.get(i).getFechaHoraMultado());
			if (menor <= 0 && mayor >= 0) {
				multasEnFecha.add(multas.get(i));
			}
		}
		return multasEnFecha;
	}
	
	public ArrayList<Lector> ordenarLectoresPorMulta(){
		ArrayList<Lector> lectores = Lector.leerTexto();
		Collections.sort(lectores, new OrdenarLectores());
		return lectores;
	}
  }
