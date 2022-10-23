package BibliotecaGraficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import Biblioteca.Alumno;
import Biblioteca.Area;
import Biblioteca.Docente;
import Biblioteca.Ejemplar;
import Biblioteca.tipoObra;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import javax.swing.JCheckBox;
import Biblioteca.FormaAdquirida;
import Biblioteca.Lector;
import Biblioteca.Obra;
import Biblioteca.Prestamo;
import Biblioteca.MetodosTxt;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Canvas;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textPriAutor;
	private JTextField textTerAutor;
	private JTextField textISBN;
	private JTextField textTitulo;
	private JTextField textSubtitulo;
	private JTextField textSegAutor;
	private JTextField textGenero;
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textTipoDNI;
	private JTextField textApellido;
	private JTextField textDNI;
	private JTextField textLocalidad;
	private JTextField textDepartamento;
	private JTextField textDomicilio;
	private JTextField textCorreo;
	private JTextField dateDia;
	private JTextField dateMes;
	private JTextField dateAnio;
	private JTextField textIDEjemplar;
	private JTextField textDniLector;
	private JTextField textObservacion;
	private JTextField textFuncPrestador;
	private JTextField textFuncRecibidor;
	private JTextField textIDEjemplarDevuelta;
	private JTextField textNroCelular;
	private JTextField textCodPos;
	private JTextField textLugarNac;
	private JTextField textCodUbi;
	private JTable tableMorosos;
	private JTable tablaPrestamosTerminados;
	private JTextField textCarreras;
	private JTextField textIDEjemplarExtencion;
	private JTextField textDiasExtencion;

	public ventanaPrincipal(String userWelcome) {
		MetodosTxt listFunc = new MetodosTxt();
		ventanaEditorial ventanaEdicion = new ventanaEditorial(ventanaPrincipal.this);
		inicioVentanaPrincipal(listFunc, ventanaEdicion, userWelcome);
	}

	private void inicioVentanaPrincipal(final MetodosTxt metodo, final ventanaEditorial ventanaEdicion,
			String userWelcome) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/imagenes/icon.png")));
		setType(Type.POPUP);
		setTitle("Nimbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 617);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/nombreIcon22.png")));
		logo.setBounds(401, 6, 356, 105);
		contentPane.add(logo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 98, 765, 474);
		contentPane.add(tabbedPane);

		JPanel panelPrestamo = new JPanel();
		tabbedPane.addTab("Prestamo", null, panelPrestamo, null);
		panelPrestamo.setLayout(null);

		textIDEjemplar = new JTextField();
		textIDEjemplar.setBounds(24, 82, 102, 28);
		panelPrestamo.add(textIDEjemplar);
		textIDEjemplar.setColumns(10);

		textDniLector = new JTextField();
		textDniLector.setColumns(10);
		textDniLector.setBounds(156, 82, 102, 28);
		panelPrestamo.add(textDniLector);

		JLabel lblNewLabel_4 = new JLabel("ID Ejemplar:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(24, 54, 102, 16);
		panelPrestamo.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("DNI Lector:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(156, 54, 102, 16);
		panelPrestamo.add(lblNewLabel_4_1);

		JLabel lblNewLabel_7 = new JLabel("Pr\u00E9stamo: ");
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_7.setBounds(24, 23, 102, 18);
		panelPrestamo.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("Devoluci\u00F3n: ");
		lblNewLabel_7_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_7_1.setBounds(24, 315, 102, 18);
		panelPrestamo.add(lblNewLabel_7_1);

		final JCheckBox checkDomicilio = new JCheckBox("");
		checkDomicilio.setBackground(new Color(0, 102, 153));
		checkDomicilio.setForeground(Color.WHITE);
		checkDomicilio.setBounds(24, 133, 18, 16);
		panelPrestamo.add(checkDomicilio);

		textFuncPrestador = new JTextField();
		textFuncPrestador.setColumns(10);
		textFuncPrestador.setBounds(283, 82, 102, 28);
		panelPrestamo.add(textFuncPrestador);

		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionario Prestador:");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(283, 54, 149, 16);
		panelPrestamo.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Funcionario Recibidor:");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setBounds(24, 344, 149, 16);
		panelPrestamo.add(lblNewLabel_4_1_1_1);

		textFuncRecibidor = new JTextField();
		textFuncRecibidor.setColumns(10);
		textFuncRecibidor.setBounds(24, 371, 102, 28);
		panelPrestamo.add(textFuncRecibidor);

		JLabel lblNewLabel_4_2 = new JLabel("ID Ejemplar:");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setBounds(156, 344, 102, 16);
		panelPrestamo.add(lblNewLabel_4_2);

		textIDEjemplarDevuelta = new JTextField();
		textIDEjemplarDevuelta.setColumns(10);
		textIDEjemplarDevuelta.setBounds(156, 371, 102, 28);
		panelPrestamo.add(textIDEjemplarDevuelta);

		JPanel panelEjemplar = new JPanel();
		tabbedPane.addTab("Ejemplar", null, panelEjemplar, null);
		panelEjemplar.setLayout(null);

		final JComboBox boxArea = new JComboBox();
		boxArea.setModel(new DefaultComboBoxModel(Area.values()));
		boxArea.setBounds(93, 195, 124, 26);
		panelEjemplar.add(boxArea);

		final JComboBox boxTipoObra = new JComboBox();
		boxTipoObra.setModel(new DefaultComboBoxModel(tipoObra.values()));
		boxTipoObra.setBounds(229, 195, 124, 26);
		panelEjemplar.add(boxTipoObra);

		textPriAutor = new JTextField();
		textPriAutor.setBounds(93, 126, 124, 28);
		panelEjemplar.add(textPriAutor);
		textPriAutor.setColumns(10);

		textTerAutor = new JTextField();
		textTerAutor.setColumns(10);
		textTerAutor.setBounds(366, 126, 124, 28);
		panelEjemplar.add(textTerAutor);

		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(366, 67, 124, 28);
		panelEjemplar.add(textISBN);

		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(93, 67, 124, 28);
		panelEjemplar.add(textTitulo);

		textSubtitulo = new JTextField();
		textSubtitulo.setColumns(10);
		textSubtitulo.setBounds(229, 67, 124, 28);
		panelEjemplar.add(textSubtitulo);

		textSegAutor = new JTextField();
		textSegAutor.setColumns(10);
		textSegAutor.setBounds(229, 126, 124, 28);
		panelEjemplar.add(textSegAutor);

		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(502, 126, 122, 28);
		panelEjemplar.add(textGenero);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(502, 67, 122, 28);
		panelEjemplar.add(textID);

		JLabel lblNewLabel_1 = new JLabel("Area");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(93, 167, 126, 16);
		panelEjemplar.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo de Obra");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(229, 166, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Titulo");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(93, 44, 126, 16);
		panelEjemplar.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Subtitulo");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(229, 44, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Primer Autor");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setBounds(93, 107, 126, 16);
		panelEjemplar.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Segundo Autor");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setBounds(229, 108, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_4);

		JLabel lblNewLabel_1_1_5 = new JLabel("Tercer Autor");
		lblNewLabel_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_5.setBounds(366, 107, 126, 16);
		panelEjemplar.add(lblNewLabel_1_1_5);

		JLabel lblNewLabel_1_1_6 = new JLabel("Genero");
		lblNewLabel_1_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_1_6.setBounds(502, 107, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_6);

		JLabel lblNewLabel_1_1_7 = new JLabel("ISBN");
		lblNewLabel_1_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_1_7.setBounds(366, 44, 126, 16);
		panelEjemplar.add(lblNewLabel_1_1_7);

		JLabel lblNewLabel_1_1_8 = new JLabel("ID");
		lblNewLabel_1_1_8.setForeground(Color.WHITE);
		lblNewLabel_1_1_8.setBounds(502, 44, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_8);

		final JComboBox boxAdquisicion = new JComboBox();
		boxAdquisicion.setModel(new DefaultComboBoxModel(FormaAdquirida.values()));
		boxAdquisicion.setBounds(366, 193, 124, 26);
		panelEjemplar.add(boxAdquisicion);

		JLabel lblNewLabel_1_1_8_1 = new JLabel("Forma de Adquisici\u00F3n");
		lblNewLabel_1_1_8_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_8_1.setBounds(366, 166, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_8_1);

		textObservacion = new JTextField();
		textObservacion.setBounds(93, 258, 531, 45);
		panelEjemplar.add(textObservacion);
		textObservacion.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("* Observaciones");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(93, 232, 124, 16);
		panelEjemplar.add(lblNewLabel_6);

		JPanel panelLectores = new JPanel();
		tabbedPane.addTab("Lectores", null, panelLectores, null);
		panelLectores.setLayout(null);

		final JComboBox boxTipoLector = new JComboBox();
		boxTipoLector.setModel(new DefaultComboBoxModel(new String[] { "Lector", "Alumno", "Docente" }));
		boxTipoLector.setBounds(422, 181, 122, 22);
		panelLectores.add(boxTipoLector);

		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(154, 111, 122, 28);
		panelLectores.add(textDomicilio);

		textNombre = new JTextField();
		textNombre.setBounds(20, 43, 122, 28);
		panelLectores.add(textNombre);
		textNombre.setColumns(10);

		textTipoDNI = new JTextField();
		textTipoDNI.setColumns(10);
		textTipoDNI.setBounds(288, 43, 122, 28);
		panelLectores.add(textTipoDNI);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(154, 43, 122, 28);
		panelLectores.add(textApellido);

		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(422, 43, 122, 28);
		panelLectores.add(textDNI);

		textLocalidad = new JTextField();
		textLocalidad.setColumns(10);
		textLocalidad.setBounds(556, 43, 122, 28);
		panelLectores.add(textLocalidad);

		textDepartamento = new JTextField();
		textDepartamento.setColumns(10);
		textDepartamento.setBounds(20, 111, 122, 28);
		panelLectores.add(textDepartamento);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 15, 97, 16);
		panelLectores.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Apellido");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(154, 15, 97, 16);
		panelLectores.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Tipo DNI");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(288, 15, 97, 16);
		panelLectores.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Correo");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setBounds(288, 83, 97, 16);
		panelLectores.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Localidad");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setBounds(556, 15, 97, 16);
		panelLectores.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("Departamento");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setBounds(20, 83, 97, 16);
		panelLectores.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_5_1 = new JLabel("Domicilio");
		lblNewLabel_2_5_1.setForeground(Color.WHITE);
		lblNewLabel_2_5_1.setBounds(154, 83, 97, 16);
		panelLectores.add(lblNewLabel_2_5_1);

		JLabel lblNewLabel_2_5_1_1 = new JLabel("N\u00B0 DNI");
		lblNewLabel_2_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_5_1_1.setBounds(422, 15, 97, 16);
		panelLectores.add(lblNewLabel_2_5_1_1);

		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(288, 111, 122, 28);
		panelLectores.add(textCorreo);

		dateDia = new JTextField();
		dateDia.setHorizontalAlignment(SwingConstants.LEFT);
		dateDia.setToolTipText("");
		dateDia.setBounds(154, 178, 34, 28);
		panelLectores.add(dateDia);
		dateDia.setColumns(2);

		dateMes = new JTextField();
		dateMes.setColumns(2);
		dateMes.setBounds(200, 178, 34, 28);
		panelLectores.add(dateMes);

		dateAnio = new JTextField();
		dateAnio.setColumns(4);
		dateAnio.setBounds(246, 178, 48, 28);
		panelLectores.add(dateAnio);

		JLabel lblNewLabel_2_3_1 = new JLabel("Nacimiento: d-m-y");
		lblNewLabel_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1.setBounds(154, 150, 109, 16);
		panelLectores.add(lblNewLabel_2_3_1);

		textNroCelular = new JTextField();
		textNroCelular.setColumns(10);
		textNroCelular.setBounds(466, 111, 78, 28);
		panelLectores.add(textNroCelular);

		JLabel lblNewLabel_2_3_2 = new JLabel("N\u00B0 Celular");
		lblNewLabel_2_3_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_2.setBounds(422, 83, 97, 16);
		panelLectores.add(lblNewLabel_2_3_2);

		textCodPos = new JTextField();
		textCodPos.setColumns(10);
		textCodPos.setBounds(556, 111, 122, 28);
		panelLectores.add(textCodPos);

		JLabel lblNewLabel_2_3_2_1 = new JLabel("Codigo Postal");
		lblNewLabel_2_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_2_1.setBounds(556, 83, 97, 16);
		panelLectores.add(lblNewLabel_2_3_2_1);

		final JComboBox boxSexo = new JComboBox();
		boxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "No Binario" }));
		boxSexo.setBounds(306, 179, 97, 26);
		panelLectores.add(boxSexo);

		JLabel lblNewLabel_8 = new JLabel("Sexo");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(306, 150, 53, 16);
		panelLectores.add(lblNewLabel_8);

		textLugarNac = new JTextField();
		textLugarNac.setColumns(10);
		textLugarNac.setBounds(20, 178, 122, 28);
		panelLectores.add(textLugarNac);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("Lugar de Nacimiento");
		lblNewLabel_2_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_1_2.setBounds(20, 150, 122, 16);
		panelLectores.add(lblNewLabel_2_3_1_2);

		final JTextPane muestraLector = new JTextPane();
		muestraLector.setText("*\r\n*\r\n*\r\n*\r\n*\r\n*\r\n*\r\n*");
		muestraLector.setEditable(false);
		muestraLector.setForeground(new Color(0, 0, 0));
		muestraLector.setBackground(Color.WHITE);
		muestraLector.setFont(new Font("Arial", Font.BOLD, 14));
		muestraLector.setBounds(20, 275, 725, 144);
		panelLectores.add(muestraLector);

		JLabel bienvenido = new JLabel("");
		bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenido.setForeground(new Color(0, 0, 0));
		bienvenido.setFont(new Font("Britannic Bold", Font.PLAIN, 28));
		bienvenido.setBounds(43, 19, 320, 67);
		contentPane.add(bienvenido);
		bienvenido.setText("Bienvenido, " + userWelcome + "!");

		JPanel panelEstadisticas = new JPanel();
		tabbedPane.addTab("Estadisticas", null, panelEstadisticas, null);
		panelEstadisticas.setLayout(null);

		JTabbedPane tabbedEstadisticas = new JTabbedPane(JTabbedPane.TOP);
		tabbedEstadisticas.setBounds(10, 11, 740, 424);
		panelEstadisticas.add(tabbedEstadisticas);

		JPanel ListaPrestamosActivos = new JPanel();
		tabbedEstadisticas.addTab("Morosos", null, ListaPrestamosActivos, null);
		ListaPrestamosActivos.setLayout(null);

		// TABLA QUE MUESTRA LOS PRESTAMOS ACTIVOS
		final DefaultTableModel modelo = new DefaultTableModel();
		/*
		 * nombre apellido tipo dni num dni celular ejemplares
		 */
		modelo.addColumn("Nombre Lector");
		modelo.addColumn("Apellido Lector");
		modelo.addColumn("Tipo Dni");
		modelo.addColumn("Nro Dni");
		modelo.addColumn("Nro Celular");
		modelo.addColumn("Ejemplares");

		tableMorosos = new JTable(modelo);
		tableMorosos.setBounds(43, 53, 649, 302);
		ListaPrestamosActivos.add(tableMorosos);

		// TABLA QUE MUESTRA PRESTAMOS TERMINADOS
		JPanel listaPrestamosTerminados = new JPanel();
		tabbedEstadisticas.addTab("", null, listaPrestamosTerminados, null);
		listaPrestamosTerminados.setLayout(null);

		tablaPrestamosTerminados = new JTable((TableModel) null);
		tablaPrestamosTerminados.setBounds(43, 47, 649, 302);
		listaPrestamosTerminados.add(tablaPrestamosTerminados);
		try {
			final DefaultTableModel modelo2 = new DefaultTableModel();

			modelo2.addColumn("DNI Lector");
			modelo2.addColumn("ID Ejemplar");
			modelo2.addColumn("Fecha pedido");
			modelo2.addColumn("Fecha Devuelta");
			modelo2.addColumn("Funcionario Prestador");
			modelo2.addColumn("Funcionario Devuelto");

		} catch (Exception e) {
		}

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 777, 578);
		fondo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		contentPane.add(fondo);
		setLocationRelativeTo(null);

		textCodUbi = new JTextField();
		textCodUbi.setBounds(502, 194, 122, 28);
		panelEjemplar.add(textCodUbi);
		textCodUbi.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Codigo de Ubicacion");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(502, 167, 122, 16);
		panelEjemplar.add(lblNewLabel_10);

		JLabel lblNewLabel_9 = new JLabel("A domicilio");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(48, 133, 90, 16);
		panelPrestamo.add(lblNewLabel_9);

		JLabel lblNewLabel_2_3_2_2 = new JLabel("0345");
		lblNewLabel_2_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_2_2.setBounds(422, 117, 48, 16);
		panelLectores.add(lblNewLabel_2_3_2_2);

		JLabel lblNewLabel_8_1 = new JLabel("Tipo Lector");
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(422, 151, 122, 16);
		panelLectores.add(lblNewLabel_8_1);

		textCarreras = new JTextField();
		textCarreras.setBounds(554, 182, 124, 20);
		panelLectores.add(textCarreras);
		textCarreras.setColumns(10);

		JLabel lblNewLabel_8_1_1 = new JLabel("* Carrera Docente");
		lblNewLabel_8_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1.setBounds(556, 151, 122, 16);
		panelLectores.add(lblNewLabel_8_1_1);

		JButton actualizoMorosos = new JButton("Actualizar");
		actualizoMorosos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * ACTUALIZAR LA TABLA CON LOS MOROSOS (LECTORES QUE NO DEVOLVIERON DESPUES DE
				 * FECHA A DEVOLVER
				 * 
				 */

				ArrayList<Prestamo> prestamos = Prestamo.leerTexto(1);
				ArrayList<Lector> lectores = Lector.leerTexto();
				// Vacia la tabla entera
				for (int x = modelo.getRowCount() - 1; x >= 0; x--) {
					modelo.removeRow(x);
				}
				// Busca los prestamos
				for (int i = 0; i < prestamos.size(); i++) {
					// Busca los lectores, para obtener sus atributos
					for (int j = 0; j < lectores.size(); j++) {
						// Verifica si es a domicilio, si se paso de la fecha y si el dni del lector
						// de prestamo es igual al dni de lista lector
						if (prestamos.get(i).getaDomicilio() && metodo.fechaPasada(prestamos.get(i))
								&& prestamos.get(i).getLector().getNumDoc() == lectores.get(j).getNumDoc()) {
							Object[] vec = new Object[6];
							vec[0] = lectores.get(j).getNom();
							vec[1] = lectores.get(j).getApellido();
							vec[2] = lectores.get(j).getTipDoc();
							vec[3] = lectores.get(j).getNumDoc();
							vec[4] = lectores.get(j).getNumCel();
							vec[5] = prestamos.get(i).getEjemplar().getIdEjemplar();

							// Agrega la tabla
							modelo.addRow(vec);
						}

					}
				}

			}
		});
		actualizoMorosos.setBounds(43, 362, 109, 23);
		ListaPrestamosActivos.add(actualizoMorosos);

		JButton btnRegistrarLector = new JButton("Registrar Lector");
		// Registrar Lector
		btnRegistrarLector.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODOS LOS METODOS QUE SE REALIZAN AL REGISTRAR UN NUEVO LECTOR

				// Variables para implementa en el constructor de Lector
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String tipDni = textTipoDNI.getText();
				int dni = Integer.parseInt(textDNI.getText());
				String localidad = textLocalidad.getText();
				String departamento = textDepartamento.getText();
				String domicilio = textDomicilio.getText();
				String correo = textCorreo.getText();
				int numCel = Integer.parseInt(textNroCelular.getText());
				int codPos = Integer.parseInt(textCodPos.getText());
				String lugNac = textLugarNac.getText();
				LocalDate fechaNac = LocalDate.of(Integer.parseInt(dateAnio.getText()),
						Integer.parseInt(dateMes.getText()), Integer.parseInt(dateDia.getText()));
				String sexo = (String) boxSexo.getSelectedItem();
				String tipoLector = String.valueOf(boxTipoLector.getSelectedItem());
				String carreraDocente = String.valueOf(textCarreras.getText());

				if (metodo.existeLector(dni)) {
					JOptionPane.showMessageDialog(null, "Ya se encuentra registrado", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Crea la nueva instancia de Lector

					// Muestra en pantalla de los datos ingresado
					muestraLector.setText("* Tipo: " + tipoLector + "\n* Nombre: " + nombre + "\n* Apellido: "
							+ apellido + "\n* tipo DNI: " + tipDni + ", Num DNI: " + dni + "\n* Correo: " + correo
							+ " - Num Celular: " + numCel + " - Fecha Nacimiento: " + fechaNac + " - Sexo: " + sexo
							+ "\n* Lugar Nacimiento: " + lugNac + "\n* Domicilio: " + domicilio + " - Codigo Postal: "
							+ codPos + " - Departamento: " + departamento + "-  Localidad: " + localidad
							+ "\n* Carreras del docente: " + carreraDocente);

					/*
					 * Falta el como guardar el tipo de lector en Lectores.txt
					 * 
					 */

					if (tipoLector == "Alumno") {
						// Crea el Alumno
						Lector alumno = new Alumno(nombre, apellido, tipDni, dni, correo, numCel, fechaNac, sexo,
								lugNac, domicilio, codPos, departamento, localidad);
						// Agrega al txt el nuevo Alumno
						metodo.guardar(alumno, "Lectores.txt");
					} else if (tipoLector == "Docente") {
						// Crea el docente
						Lector docente = new Docente(nombre, apellido, tipDni, dni, correo, numCel, fechaNac, sexo,
								lugNac, domicilio, codPos, departamento, localidad, carreraDocente);

						// Setea carrera de docente
						((Docente) docente).setCarrera(carreraDocente);

						// Guarda en txt al docente
						metodo.guardar(docente, "Lectores.txt");
					} else {
						// Agrega al txt el nuevo lector
						Lector lector = new Lector(nombre, apellido, tipDni, dni, correo, numCel, fechaNac, sexo,
								lugNac, domicilio, codPos, departamento, localidad);
						metodo.guardar(lector, "Lectores.txt");
					}

					// Pone en blanco las textFields
					textNombre.setText("");
					textApellido.setText("");
					textTipoDNI.setText("");
					textDNI.setText("");
					textLocalidad.setText("");
					textDepartamento.setText("");
					textCorreo.setText("");
					textNroCelular.setText("");
					textCodPos.setText("");
					textLugarNac.setText("");
					dateAnio.setText("");
					dateMes.setText("");
					dateDia.setText("");
				}
			}
		});
		btnRegistrarLector.setBounds(311, 235, 143, 28);
		panelLectores.add(btnRegistrarLector);

		JLabel fondoL = new JLabel("");
		fondoL.setBackground(Color.LIGHT_GRAY);
		fondoL.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		fondoL.setBounds(0, 0, 765, 444);
		panelLectores.add(fondoL);

		// REGISTRO OBRA/EJEMPLAR
		JButton btnRegistrar = new JButton("Registrar");// Registrar obra y ejemplar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Registrar la nueva Obra

				String titulo = textTitulo.getText();
				String subtitulo = textSubtitulo.getText();
				int isbn = Integer.parseInt(textISBN.getText());
				int id = Integer.parseInt(textID.getText());
				String priAutor = textPriAutor.getText();
				String segAutor = textSegAutor.getText();
				String terAutor = textTerAutor.getText();
				String genero = textGenero.getText();
				String codUbi = textCodUbi.getText();

				FormaAdquirida formaAdqui = FormaAdquirida.valueOf(boxAdquisicion.getSelectedItem().toString());
				String observaciones = textObservacion.getText();
				Area area = (Area) boxArea.getSelectedItem();

				tipoObra tipoObra = (tipoObra) boxTipoObra.getSelectedItem();

				Obra obra = new Obra(titulo, subtitulo, priAutor, segAutor, terAutor, genero, isbn, id, area, tipoObra);

				// Si es la primera vez que se ingresa el titulo, se agrega obra y primer
				// ejemplar
				if (metodo.existeObra(titulo)) {
					Random r = new Random();
					int ran = r.nextInt(10000);
					try {
						Ejemplar ejemplar = new Ejemplar(ran, observaciones, true, formaAdqui, codUbi, obra);
						// Guarda el primer ejemplar de la obra
						metodo.guardarEjemplar(ejemplar);

					} catch (BarcodeException e1) {
						e1.printStackTrace();
					} catch (OutputException e1) {
						e1.printStackTrace();
					}

					// Guarda la obra

				} else {
					Obra auxObra = obra;
					Random r = new Random();
					int ran = r.nextInt(10000);
					try {
						Ejemplar ejemplar = new Ejemplar(ran, observaciones, true, formaAdqui, codUbi, auxObra);
						metodo.guardar(ejemplar, "Ejemplares.txt");
					} catch (BarcodeException e1) {
						e1.printStackTrace();
					} catch (OutputException e1) {
						e1.printStackTrace();
					}
					metodo.guardar(obra, "Obras.txt");
				}

			}
		});
		btnRegistrar.setBounds(229, 325, 90, 28);
		panelEjemplar.add(btnRegistrar);

		// REALIZADO DEL PRESTAMO
		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Realizado de prestamo

				// FALTA EL COMPROBAR SI HAY EJEMPLARES DISPONIBLES DE LA OBRA (METODO)
				// USAR EL METODO DE hayDisponibles(id);

				int id = Integer.parseInt(textIDEjemplar.getText()); // Convierte a entero el id del ejemplar pasado
				int dni = Integer.parseInt(textDniLector.getText()); // Convierte a entero el DNI del lector pasado
				// Buscar existencia del Ejemplar, del lector y del funcionario
				if (metodo.existeEjemplar(id) && metodo.existeLector(dni)
						&& metodo.comprobarFuncionario(textFuncPrestador.getText())) {

					// Comprueba si hay ejemplares disponibles
					if (metodo.hayDisponibles(id)) {
						Prestamo prestamo = new Prestamo(textFuncPrestador.getText(), new Lector(dni),
								checkDomicilio.isSelected(), new Ejemplar(id));

						// Realiza los cambios de obra y ejemplar, si esta disponible y cantidad.
						metodo.ejemplarPedido(new Ejemplar(id));
						// Guarda el nuevo prestamo
						metodo.guardar(prestamo, "Prestamos.txt");
					} else {
						JOptionPane.showMessageDialog(null, "Ejemplar " + id + " ya esta prestado.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Hay datos erroneos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				textIDEjemplar.setText("");
				textDniLector.setText("");
				textFuncPrestador.setText("");
			}
		});
		btnPrestar.setBounds(156, 127, 89, 28);
		panelPrestamo.add(btnPrestar);

		JButton btnDevuelto = new JButton("Devuelto");
		btnDevuelto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metodos de ejemplares devueltos
				/**
				 * COMPROBAR SI LA FECHA SE INGRESO MAL, NO CON TRY
				 */
				LocalDateTime fechaDevuelta = LocalDateTime.now();

				String funcionario = textFuncRecibidor.getText();

				int idEjemplar = Integer.parseInt(textIDEjemplarDevuelta.getText());

				// try comprueba si existe el prestamo, sino sale error
				try {
					metodo.guardarPrestamoTerminado(fechaDevuelta, funcionario, idEjemplar);
				} catch (Exception t) {
					JOptionPane.showMessageDialog(null, "No existe el Prestamo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				textIDEjemplarDevuelta.setText("");
				textFuncRecibidor.setText("");
			}
		});
		btnDevuelto.setBounds(283, 371, 89, 28);
		panelPrestamo.add(btnDevuelto);

		textIDEjemplarExtencion = new JTextField();
		textIDEjemplarExtencion.setColumns(10);
		textIDEjemplarExtencion.setBounds(24, 256, 102, 28);
		panelPrestamo.add(textIDEjemplarExtencion);

		textDiasExtencion = new JTextField();
		textDiasExtencion.setColumns(10);
		textDiasExtencion.setBounds(156, 256, 102, 28);
		panelPrestamo.add(textDiasExtencion);

		JLabel lblNewLabel_4_3 = new JLabel("ID Ejemplar:");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setBounds(24, 229, 102, 16);
		panelPrestamo.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_3_1 = new JLabel("Dias extencion:");
		lblNewLabel_4_3_1.setForeground(Color.WHITE);
		lblNewLabel_4_3_1.setBounds(156, 229, 102, 16);
		panelPrestamo.add(lblNewLabel_4_3_1);

		JButton btnExtender = new JButton("Extender");
		btnExtender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textIDEjemplarExtencion.getText());
				int dias = Integer.parseInt(textDiasExtencion.getText());
				
				/*
				 * Metodo para extender dias al prestamo
				 */
				
			}
		});
		btnExtender.setBounds(283, 256, 89, 28);
		panelPrestamo.add(btnExtender);

		JLabel lblNewLabel_7_2 = new JLabel("Extender Pr\u00E9stamo: ");
		lblNewLabel_7_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_7_2.setBounds(24, 200, 185, 18);
		panelPrestamo.add(lblNewLabel_7_2);

		JTable tablaPrestamos = new JTable();
		tablaPrestamos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		tablaPrestamos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablaPrestamos.setForeground(Color.WHITE);
		tablaPrestamos.setBackground(new Color(128, 128, 128));
		tablaPrestamos.setBounds(427, 23, 323, 336);
		panelPrestamo.add(tablaPrestamos);
		
		JButton btnEjemplaresDisponibles = new JButton("Ejemplares");
		btnEjemplaresDisponibles.setBounds(455, 371, 89, 28);
		panelPrestamo.add(btnEjemplaresDisponibles);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
				lblNewLabel.setBounds(0, 0, 765, 444);
				panelPrestamo.add(lblNewLabel);

		JButton btnNuevaEditorial = new JButton("Nueva Editorial");
		btnNuevaEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Inicia ventana de nueva editorial para agregar una

				ventanaPrincipal.this.setVisible(false);
				ventanaEdicion.setVisible(true);

			}
		});
		btnNuevaEditorial.setBounds(366, 325, 124, 28);
		panelEjemplar.add(btnNuevaEditorial);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_3.setBounds(0, 0, 765, 444);
		panelEjemplar.add(lblNewLabel_3);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_12.setBounds(0, 0, 735, 396);
		ListaPrestamosActivos.add(lblNewLabel_12);

		JButton actualizoPrestamosTerminados = new JButton("Actualizar");
		actualizoPrestamosTerminados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		actualizoPrestamosTerminados.setBounds(43, 360, 110, 23);
		listaPrestamosTerminados.add(actualizoPrestamosTerminados);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13.setBounds(0, 0, 735, 396);
		listaPrestamosTerminados.add(lblNewLabel_13);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_11.setBounds(0, 0, 760, 446);
		panelEstadisticas.add(lblNewLabel_11);

	}
}
