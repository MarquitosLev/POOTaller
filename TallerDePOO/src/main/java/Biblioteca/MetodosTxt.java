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
	 * @param ruta  Se pasa la ruta donde los datos serian guardado.
	 * 
	 * @throws en caso de que esl guardad al txt falle.
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
	 * Funciion que controla si un usuario ya se encuentra registrado dentro de la
	 * aplicacion.
	 * 
	 * @param user Se le pasa el parámetro 'user', atributo perteneciente a
	 *             'Funcionario', para comprobar si el mismo ya existe dentro del
	 *             ArrayList de funcionario.
	 * 
	 * @return Retorna 'Verdadero' o 'Falso' para indicar si el funcionario se
	 *         encuentra o no guardado en el ArrayList.
	 * 
	 * @throws en caso que al leer el txt, falle.
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
	 * 
	 * @throws en caso de que esl guardad al txt falle.
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
	public boolean existeObra(String titu, String sub) {

		ArrayList<Obra> datoObra = Obra.leerTexto();

		if (datoObra.size() == 0) {
			return false;
		}

		for (int i = 0; i < datoObra.size(); i++) {
			if ((datoObra.get(i).getTitulo().equals(titu) && datoObra.get(i).getSubtitulo().equals(sub))) {
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
	 * @param ejemplar Se le pasa como parámetro el ejemplar que quiere ser
	 *                 añadido al ArrayList y posteriormente al .txt
	 * 
	 * @throws en caso de que esl guardad al txt falle.
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

	/**
	 * Comprueba si existe el ejemplar segun id ejemplar.
	 * 
	 * @param id
	 * @return retorna true si el ejemplar existe en el .txt, caso contrario, false.
	 * 
	 */
	public boolean existeEjemplar(int id) {
		listaEjemplar = Ejemplar.leerTexto();

		if (listaEjemplar.size() == 0) {
			return false;
		}

		for (int i = 0; i < listaEjemplar.size(); i++) {
			if (listaEjemplar.get(i).getIdEjemplar() == id) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Metodo llamado cuando se solicita el ejemplar * Cambia disponibilidad de
	 * ejemplar * Aumenta en 1 las veces solicitadas * Decrementa los ejemplares
	 * disponibles en obra
	 * 
	 * 
	 * @param ejemplar que contiene el id
	 */
	public void ejemplarPedido(Ejemplar ejemplar) {

		ArrayList<Ejemplar> datosEjemplar = new ArrayList<Ejemplar>();
		try {
			BufferedReader br3 = new BufferedReader(new FileReader("Ejemplares.txt"));
			String ejemplarNoDisponible;
			while ((ejemplarNoDisponible = br3.readLine()) != null) {
				StringTokenizer x = new StringTokenizer(ejemplarNoDisponible, "/");
				datosEjemplar.add(new Ejemplar(Integer.parseInt(x.nextToken()), x.nextToken(),
						Boolean.parseBoolean(x.nextToken()), FormaAdquirida.valueOf(x.nextToken()),
						LocalDateTime.parse(x.nextToken()), x.nextToken(), new Obra(x.nextToken()),
						Integer.parseInt(x.nextToken())));
			}
		} catch (Exception e) {
		}
		Ejemplar ejem = new Ejemplar();
		for (int j = 0; j < datosEjemplar.size(); j++) {
			if ((datosEjemplar.get(j).getIdEjemplar() == (ejemplar.getIdEjemplar()))) {
				datosEjemplar.get(j).setDisponible(false);
				datosEjemplar.get(j).setCantPedidas(datosEjemplar.get(j).getCantPedidas() + 1);
				ejem = datosEjemplar.get(j);
				break;
			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Ejemplares.txt"));
			bw.write("");
			bw.close();
			for (int i = 0; i < datosEjemplar.size(); i++) {
				guardar(datosEjemplar.get(i), "Ejemplares.txt");
			}
		} catch (Exception e) {
		}

		ArrayList<Obra> datosObra = Obra.leerTexto();

		for (int i = 0; i < datosObra.size(); i++) {
			if ((datosObra.get(i).getTitulo().equals(ejem.getObra().getTitulo()))) {
				datosObra.get(i).setCantEjemDisponible(datosObra.get(i).getCantEjemDisponible() - 1);
				break;
			}
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Obras.txt"));
			bw.write("");
			bw.close();
			for (int i = 0; i < datosObra.size(); i++) {
				guardar(datosObra.get(i), "Obras.txt");
			}
		} catch (Exception e) {
		}

	}

	/**
	 * Al devolverlo cambia: * aumenta cantidad disponibles a obra
	 * 
	 * @param ejemplar Compara el titulo de las obras
	 */
	public void AumentoEjemplarDisponible(String ejemplar) {

		ArrayList<Obra> datosObra = Obra.leerTexto();
		for (int j = 0; j < datosObra.size(); j++) { // Recorre el nuevo ArrayList agregando 1 ejemplar
			// a la obra ingresada
			if ((datosObra.get(j).getTitulo().equals(ejemplar))) {
				datosObra.get(j).setCantEjemDisponible(datosObra.get(j).getCantEjemDisponible() + 1);
				break;
			}
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Obras.txt"));
			bw.write("");
			bw.close();
			for (int q = 0; q < datosObra.size(); q++) {
				guardar(datosObra.get(q), "Obras.txt");
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Guarda en "PrestamosTerminados.txt" los datos de los prestamos finalizados
	 * Tambien comprueba si se le acredita multa al lector. Cambia disponibilidad
	 * del ejemplar a true
	 * 
	 * @param fechaDevuelta
	 * @param funcionario
	 * @param ejemplar
	 * 
	 * @throws en caso que al escribir falle
	 */
	public void guardarPrestamoTerminado(LocalDateTime fechaDevuelta, String funcionario, int ejemplar) {

		if (comprobarFuncionario(funcionario)) {

			if (existeEjemplar(ejemplar)) {

				ArrayList<Prestamo> datosPrestamo = Prestamo.leerTexto(1);
				for (int i = 0; i < datosPrestamo.size(); i++) {
					Ejemplar EjemplarAux = new Ejemplar(ejemplar);
					if (datosPrestamo.get(i).getEjemplar().getIdEjemplar() == EjemplarAux.getIdEjemplar()) {
						Prestamo aux = datosPrestamo.get(i);
						Prestamo prestamoDevuelto = new Prestamo(aux.getFechaHoraPrestada(),
								aux.getFuncionarioPrestador(), aux.getFechaHoraADevolver(), fechaDevuelta, funcionario,
								aux.getaDomicilio(), aux.getLector(), aux.getEjemplar());

						Long comparacion = ChronoUnit.DAYS.between(aux.getFechaHoraADevolver(), fechaDevuelta);
						if (comparacion > 0) {
							ArrayList<Lector> lectores = Lector.leerTexto();
							for (int b = 0; b < lectores.size(); b++) {
								if (lectores.get(b).getNumDoc() == aux.getLector().getNumDoc()) {
									lectores.get(b).setEstaMultado(true);
									lectores.get(b).setCanMulta(lectores.get(b).getCanMulta() + 1);
									lectores.get(b)
											.setDiasMultado(lectores.get(b).getDiasMultado() + (comparacion * 3));
									Multa multa = new Multa((comparacion * 3), new Prestamo(ejemplar));
									guardar(multa, "Multas.txt");
									try {
										BufferedWriter bw2 = new BufferedWriter(new FileWriter("Lectores.txt"));
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
						datosPrestamo.remove(i);

						try {
							File txt = new File("PrestamosTerminados.txt");
							if (!txt.exists()) {
								txt.createNewFile();
							}
							FileWriter fw = new FileWriter("PrestamosTerminados.txt", true);
							BufferedWriter br = new BufferedWriter(fw);
							PrintWriter escribir = new PrintWriter(br);
							try {
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

						ArrayList<Ejemplar> datosEjemplar = Ejemplar.leerTexto();

						String nuevo = "";
						for (int t = 0; t < datosEjemplar.size(); t++) {
							if ((datosEjemplar.get(t).getIdEjemplar() == ejemplar)) {

								nuevo = datosEjemplar.get(t).getObra().getTitulo();

								datosEjemplar.get(t).setDisponible(true);

								break;
							}
						}

						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter("Ejemplares.txt"));
							bw.write("");
							bw.close();
							for (int y = 0; y < datosEjemplar.size(); y++) {
								guardar(datosEjemplar.get(y), "Ejemplares.txt");
							}
						} catch (Exception e) {
						}

						try {
							BufferedWriter bw2 = new BufferedWriter(new FileWriter("Prestamos.txt"));
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

	/**
	 * Compara si la fecha a devolver fue antes o despues de la realizacion.
	 * 
	 * @param pres
	 * @return true: si se paso de la fecha a devolver fa�se: si no se paso de la
	 *         fecha
	 */
	public boolean fechaPasada(Prestamo pres) {
		Long x = ChronoUnit.DAYS.between(pres.getFechaHoraADevolver(), LocalDateTime.now());
		if (x < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Verifica si hay ejemplares existentes para prestar
	 * 
	 * @param id
	 * @return true si el recorrida de obra es igual al de los ejemplares y si la
	 *         cantidad disponible es mayor a 0
	 */
	public boolean hayDisponibles(int id) {
		ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
		ArrayList<Obra> obras = Obra.leerTexto();

		for (int i = 0; i < obras.size(); i++) {
			for (int t = 0; t < ejemplares.size(); t++) {
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

	/**
	 * Extiende el plazo del prestamo, en caso de que lo solicite un lector
	 * 
	 * @param dias     dias a extender
	 * @param ejemplar ejemplar para identificar el prestamo
	 * @throws En caso de que no exista el prestamo
	 */
	public void extenderDias(int dias, int ejemplar) {
		ArrayList<Prestamo> prestamos = Prestamo.leerTexto(1);
		Boolean aux = true;
		try {
			for (int i = 0; i < prestamos.size(); i++) {
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
		} catch (Exception e) {
		}
		if (aux == true) {
			JOptionPane.showMessageDialog(null, "Ejemplar " + ejemplar + " no se encuentra en Prestamos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se han extendido " + dias + " dias al prestamo", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Imprime en un campo de texto los ejemplares segun el area seleccionada
	 * 
	 * 
	 * @param textArea  Relleno del campo de texto con los datos
	 * @param boxArea2	Enumeracion de las areas
	 */
	public void imprimirEjemplaresArea(JTextArea textArea, JComboBox boxArea2) {
		ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
		ArrayList<Obra> obras = Obra.leerTexto();
		for (int i = 0; i < ejemplares.size(); i++) {
			for (int j = 0; j < obras.size(); j++) {
				if (ejemplares.get(i).getObra().getTitulo().equals(obras.get(j).getTitulo())) {
					if (obras.get(j).getArea().equals(boxArea2.getSelectedItem())) {
						if (ejemplares.get(i).getDisponible()) {
							textArea.append(obras.get(j).getTitulo() + " - " + ejemplares.get(i).getIdEjemplar() + " - "
									+ obras.get(j).getCantEjemDisponible() + "\n");
							textArea.append("----------------------------------------\n");
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo que devuelve un ArrayList de los lectores con mas multas en cierta fecha dada
	 * 
	 * @param fechaMin fecha inicio de intervalo
	 * @param fechaMax fecha final de intervalo
	 * @return ArrayList con las multas entre las fechas
	 */
	public ArrayList<Multa> lectoresPorFecha(LocalDateTime fechaMin, LocalDateTime fechaMax) {
		ArrayList<Multa> multas = Multa.leerTexto();
		ArrayList<Multa> multasEnFecha = new ArrayList<Multa>();
		try {

			for (int i = 0; i < multas.size(); i++) {
				Long menor = ChronoUnit.DAYS.between(fechaMin.truncatedTo(ChronoUnit.DAYS),
						multas.get(i).getFechaHoraMultado().truncatedTo(ChronoUnit.DAYS));
				Long mayor = ChronoUnit.DAYS.between(fechaMax.truncatedTo(ChronoUnit.DAYS),
						multas.get(i).getFechaHoraMultado().truncatedTo(ChronoUnit.DAYS));
				if ((menor >= 0 && mayor <= 0)) {
					multasEnFecha.add(multas.get(i));
				}
			}
		} catch (Exception c) {
			JOptionPane.showMessageDialog(null, "No Ingreso fechas", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return multasEnFecha;
	}

	/**
	 * Ordena lectores segun cantidad de multas
	 * @return ArrayList con los lectores ordenados segun multas aplicadas
	 */
	public ArrayList<Lector> ordenarLectoresPorMulta() {
		ArrayList<Lector> lectores = Lector.leerTexto();
		Collections.sort(lectores, new OrdenarLectores());
		return lectores;
	}

	/**
	 * Metodo que realiza la reserva de un ejemplar
	 * 
	 * @param id  Id del Ejemplar
	 * @param dni	Dni del lector que lo reserva
	 * @param func Funcionario que lo reservo
	 */
	public void reservar(int id, int dni, String func) {

		ArrayList<Prestamo> prestamos = Prestamo.leerTexto(1);
		ArrayList<Lector> lectores = Lector.leerTexto();

		for (int b = 0; b < prestamos.size(); b++) {
			if (prestamos.get(b).getEjemplar().getIdEjemplar() == id) {
				for (int i = 0; i < lectores.size(); i++) {
					if (lectores.get(i).getNumDoc() == dni) {
						Reserva reserva = new Reserva(new Lector(dni), new Ejemplar(id),
								prestamos.get(b).getFechaHoraADevolver(), new Funcionario(func));
						guardar(reserva, "Reservas.txt");
					}

				}
			}
		}

	}

	/**
	 * ArrayList con obras solicitadas por Alumno y Docente
	 * @return ArrayList con obras solicitadas por Alumno y Docente
	 */
	public ArrayList<Obra> obrasPorAlumDoc() {
		ArrayList<Obra> obras = Obra.leerTexto();
		Collections.sort(obras, new ordenarObraAlumDoc());
		return obras;
	}

	/**
	 * ArrayList con obras solicitadas por publico en general
	 * @return ArrayList con obras solicitadas por publico en general
	 */
	public ArrayList<Obra> obrasGeneral() {
		ArrayList<Obra> obras = Obra.leerTexto();
		Collections.sort(obras, new ordenarObraGeneral());
		return obras;
	}

	/**
	 * Guarda el tipo de lector en Obras.txt
	 * @param prestamo Busca el prestamo para modificarlo
	 */
	public void guardarTipoEnObra(Prestamo prestamo) {
		ArrayList<Obra> obras = Obra.leerTexto();
		ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
		int aux = 0;
		for (int j = 0; j < ejemplares.size(); j++) {
			if (ejemplares.get(j).getIdEjemplar() == prestamo.getEjemplar().getIdEjemplar()) {
				for (int h = 0; h < obras.size(); h++) {
					if (obras.get(h).getTitulo().equals(ejemplares.get(j).getObra().getTitulo())) {
						aux = h;
						break;
					}
				}
			}
		}
		ArrayList<Lector> lectores = Lector.leerTexto();
		for (int i = 0; i < lectores.size(); i++) {
			if (lectores.get(i).getNumDoc() == prestamo.getLector().getNumDoc()) {
				if (String.valueOf(lectores.get(i).getClase()).equals("Alumno")
						|| String.valueOf(lectores.get(i).getClase()).equals("Docente")) {
					obras.get(aux).setPedidaPorAlumDoc(obras.get(aux).getPedidaPorAlumDoc() + 1);
				} else {
					obras.get(aux).setPedidaGeneral(obras.get(aux).getPedidaGeneral() + 1);
				}
				break;
			}
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Obras.txt"));// Vacia el txt
			bw.write("");
			bw.close();
			for (int i = 0; i < obras.size(); i++) {
				guardar(obras.get(i), "Obras.txt");
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Obras que se encuentran reservadas a partir de una fecha determinada.
	 * 
	 * @param fecha parametro para comparar las fechas de las reservas.
	 * @return ArrayList con las reservas segun fechas
	 */
	public ArrayList<Reserva> obrasReservadasPorFecha(LocalDateTime fecha) {
		ArrayList<Reserva> reservasPorFecha = new ArrayList<Reserva>();
		ArrayList<Reserva> reservas = Reserva.leerTexto();
		for (int i = 0; i < reservas.size(); i++) {
			Long comp = ChronoUnit.DAYS.between(fecha, reservas.get(i).getFechaReserva());
			if (comp >= 0) {
				reservasPorFecha.add(reservas.get(i));
			}
		}
		return reservasPorFecha;
	}
}
