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
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
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
import Biblioteca.Edicion;
import Biblioteca.Ejemplar;
import Biblioteca.tipoObra;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import javax.swing.JCheckBox;
import Biblioteca.FormaAdquirida;
import Biblioteca.Funcionario;
import Biblioteca.Lector;
import Biblioteca.Obra;
import Biblioteca.Prestamo;
import Biblioteca.Reserva;
import Biblioteca.MetodosTxt;
import Biblioteca.Multa;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;

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
	private JTextField textCarreras;
	private JTextField textIDEjemplarExtencion;
	private JTextField textDiasExtencion;
	private JTable tableSegEditorial;
	private JTextField textEditorialBusca;
	private JTextField diaInicio;
	private JTextField mesInicio;
	private JTextField anioInicio;
	private JTextField diaFinal;
	private JTextField mesFinal;
	private JTextField anioFinal;
	private JTextField diaReser;
	private JTextField mesReser;
	private JTextField anioReser;

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
		textDniLector.setBounds(136, 82, 102, 28);
		panelPrestamo.add(textDniLector);

		JLabel lblNewLabel_4 = new JLabel("ID Ejemplar:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(24, 54, 102, 16);
		panelPrestamo.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("DNI Lector:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(136, 54, 102, 16);
		panelPrestamo.add(lblNewLabel_4_1);

		JLabel lblNewLabel_7 = new JLabel("Pr\u00E9stamo: ");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_7.setBounds(24, 23, 102, 18);
		panelPrestamo.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("Devoluci\u00F3n: ");
		lblNewLabel_7_1.setBackground(new Color(102, 153, 153));
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_7_1.setBounds(24, 315, 102, 18);
		panelPrestamo.add(lblNewLabel_7_1);

		final JCheckBox checkDomicilio = new JCheckBox("");
		checkDomicilio.setBackground(new Color(0, 102, 153));
		checkDomicilio.setForeground(Color.WHITE);
		checkDomicilio.setBounds(136, 161, 18, 16);
		panelPrestamo.add(checkDomicilio);

		textFuncPrestador = new JTextField();
		textFuncPrestador.setColumns(10);
		textFuncPrestador.setBounds(24, 149, 102, 28);
		panelPrestamo.add(textFuncPrestador);

		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionario Prestador:");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(24, 121, 149, 16);
		panelPrestamo.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Funcionario Recibidor:");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setBounds(136, 344, 149, 16);
		panelPrestamo.add(lblNewLabel_4_1_1_1);

		textFuncRecibidor = new JTextField();
		textFuncRecibidor.setColumns(10);
		textFuncRecibidor.setBounds(136, 371, 102, 28);
		panelPrestamo.add(textFuncRecibidor);

		JLabel lblNewLabel_4_2 = new JLabel("ID Ejemplar:");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setBounds(24, 344, 102, 16);
		panelPrestamo.add(lblNewLabel_4_2);

		textIDEjemplarDevuelta = new JTextField();
		textIDEjemplarDevuelta.setColumns(10);
		textIDEjemplarDevuelta.setBounds(24, 371, 102, 28);
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
		boxTipoLector.setBounds(449, 263, 122, 22);
		panelLectores.add(boxTipoLector);

		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(181, 193, 122, 28);
		panelLectores.add(textDomicilio);

		textNombre = new JTextField();
		textNombre.setBounds(47, 125, 122, 28);
		panelLectores.add(textNombre);
		textNombre.setColumns(10);

		textTipoDNI = new JTextField();
		textTipoDNI.setColumns(10);
		textTipoDNI.setBounds(315, 125, 122, 28);
		panelLectores.add(textTipoDNI);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(181, 125, 122, 28);
		panelLectores.add(textApellido);

		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(449, 125, 122, 28);
		panelLectores.add(textDNI);

		textLocalidad = new JTextField();
		textLocalidad.setColumns(10);
		textLocalidad.setBounds(583, 125, 122, 28);
		panelLectores.add(textLocalidad);

		textDepartamento = new JTextField();
		textDepartamento.setColumns(10);
		textDepartamento.setBounds(47, 193, 122, 28);
		panelLectores.add(textDepartamento);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(47, 97, 97, 16);
		panelLectores.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Apellido");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(181, 97, 97, 16);
		panelLectores.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Tipo DNI");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(315, 97, 97, 16);
		panelLectores.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Correo");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setBounds(315, 165, 97, 16);
		panelLectores.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Localidad");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setBounds(583, 97, 97, 16);
		panelLectores.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("Departamento");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setBounds(47, 165, 97, 16);
		panelLectores.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_5_1 = new JLabel("Domicilio");
		lblNewLabel_2_5_1.setForeground(Color.WHITE);
		lblNewLabel_2_5_1.setBounds(181, 165, 97, 16);
		panelLectores.add(lblNewLabel_2_5_1);

		JLabel lblNewLabel_2_5_1_1 = new JLabel("N\u00B0 DNI");
		lblNewLabel_2_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_5_1_1.setBounds(449, 97, 97, 16);
		panelLectores.add(lblNewLabel_2_5_1_1);

		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(315, 193, 122, 28);
		panelLectores.add(textCorreo);

		dateDia = new JTextField();
		dateDia.setHorizontalAlignment(SwingConstants.LEFT);
		dateDia.setToolTipText("");
		dateDia.setBounds(181, 260, 34, 28);
		panelLectores.add(dateDia);
		dateDia.setColumns(2);

		dateMes = new JTextField();
		dateMes.setColumns(2);
		dateMes.setBounds(227, 260, 34, 28);
		panelLectores.add(dateMes);

		dateAnio = new JTextField();
		dateAnio.setColumns(4);
		dateAnio.setBounds(273, 260, 48, 28);
		panelLectores.add(dateAnio);

		JLabel lblNewLabel_2_3_1 = new JLabel("Nacimiento: d-m-y");
		lblNewLabel_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1.setBounds(181, 232, 109, 16);
		panelLectores.add(lblNewLabel_2_3_1);

		textNroCelular = new JTextField();
		textNroCelular.setColumns(10);
		textNroCelular.setBounds(493, 193, 78, 28);
		panelLectores.add(textNroCelular);

		JLabel lblNewLabel_2_3_2 = new JLabel("N\u00B0 Celular");
		lblNewLabel_2_3_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_2.setBounds(449, 165, 97, 16);
		panelLectores.add(lblNewLabel_2_3_2);

		textCodPos = new JTextField();
		textCodPos.setColumns(10);
		textCodPos.setBounds(583, 193, 122, 28);
		panelLectores.add(textCodPos);

		JLabel lblNewLabel_2_3_2_1 = new JLabel("Codigo Postal");
		lblNewLabel_2_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_2_1.setBounds(583, 165, 97, 16);
		panelLectores.add(lblNewLabel_2_3_2_1);

		final JComboBox boxSexo = new JComboBox();
		boxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "No Binario" }));
		boxSexo.setBounds(333, 261, 97, 26);
		panelLectores.add(boxSexo);

		JLabel lblNewLabel_8 = new JLabel("Sexo");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(333, 232, 53, 16);
		panelLectores.add(lblNewLabel_8);

		textLugarNac = new JTextField();
		textLugarNac.setColumns(10);
		textLugarNac.setBounds(47, 260, 122, 28);
		panelLectores.add(textLugarNac);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("Lugar de Nacimiento");
		lblNewLabel_2_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_1_2.setBounds(47, 232, 122, 16);
		panelLectores.add(lblNewLabel_2_3_1_2);

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

		JPanel ListaMorosos = new JPanel();
		tabbedEstadisticas.addTab("Morosos", null, ListaMorosos, null);
		ListaMorosos.setLayout(null);

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
		tableMorosos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tableMorosos.setBounds(43, 11, 649, 302);
		ListaMorosos.add(tableMorosos);

		JPanel listaObrasSolicitadas = new JPanel();
		tabbedEstadisticas.addTab("Obras Solicitadas", null, listaObrasSolicitadas, null);
		listaObrasSolicitadas.setLayout(null);
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
		lblNewLabel_9.setBounds(160, 161, 90, 16);
		panelPrestamo.add(lblNewLabel_9);

		JLabel lblNewLabel_2_3_2_2 = new JLabel("0345");
		lblNewLabel_2_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_2_2.setBounds(449, 199, 48, 16);
		panelLectores.add(lblNewLabel_2_3_2_2);

		JLabel lblNewLabel_8_1 = new JLabel("Tipo Lector");
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(449, 233, 122, 16);
		panelLectores.add(lblNewLabel_8_1);

		textCarreras = new JTextField();
		textCarreras.setBounds(581, 264, 124, 20);
		panelLectores.add(textCarreras);
		textCarreras.setColumns(10);

		JLabel lblNewLabel_8_1_1 = new JLabel("* Carrera Docente");
		lblNewLabel_8_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1.setBounds(583, 233, 122, 16);
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
		actualizoMorosos.setBounds(313, 343, 109, 23);
		ListaMorosos.add(actualizoMorosos);

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
		btnRegistrarLector.setBounds(308, 317, 143, 28);
		panelLectores.add(btnRegistrarLector);

		JLabel lblNewLabel_14 = new JLabel("Registro de Lectores");
		lblNewLabel_14.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 41));
		lblNewLabel_14.setForeground(new Color(75, 0, 130));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(140, 12, 480, 61);
		panelLectores.add(lblNewLabel_14);

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

				Obra obra = new Obra(titulo, subtitulo, priAutor, segAutor, terAutor, genero, isbn,area, tipoObra);

				// Si es la primera vez que se ingresa el titulo, se agrega obra y primer
				// ejemplar
				if (metodo.existeObra(titulo, subtitulo)) {
					try {
						Ejemplar ejemplar = new Ejemplar(id, observaciones, true, formaAdqui, codUbi, obra);
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
					try {
						Ejemplar ejemplar = new Ejemplar(id, observaciones, true, formaAdqui, codUbi, auxObra);
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
						JOptionPane.showMessageDialog(null, "Prestamo realizado", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						// Reserva de un ejemplar
						metodo.reservar(id, dni, textFuncPrestador.getText());
						JOptionPane.showMessageDialog(null, "Ejemplar reservado", "Reservado",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Hay datos erroneos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				textIDEjemplar.setText("");
				textDniLector.setText("");
				textFuncPrestador.setText("");
			}
		});
		btnPrestar.setBounds(283, 115, 89, 28);
		panelPrestamo.add(btnPrestar);

		JButton btnDevuelto = new JButton("Devuelto");
		btnDevuelto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metodos de ejemplares devueltos
				LocalDateTime fechaDevuelta = LocalDateTime.now();
				// try comprueba si existe el prestamo, sino sale error
				try {
					// variables
					String funcionario = textFuncRecibidor.getText();
					int idEjemplar = Integer.parseInt(textIDEjemplarDevuelta.getText());
					// guardado
					metodo.guardarPrestamoTerminado(fechaDevuelta, funcionario, idEjemplar);
					JOptionPane.showMessageDialog(null, "Ejemplar devuelto", "Exito", JOptionPane.INFORMATION_MESSAGE);
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
		textDiasExtencion.setBounds(136, 256, 102, 28);
		panelPrestamo.add(textDiasExtencion);

		JLabel lblNewLabel_4_3 = new JLabel("ID Ejemplar:");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setBounds(24, 229, 102, 16);
		panelPrestamo.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_3_1 = new JLabel("Dias extencion:");
		lblNewLabel_4_3_1.setForeground(Color.WHITE);
		lblNewLabel_4_3_1.setBounds(136, 229, 102, 16);
		panelPrestamo.add(lblNewLabel_4_3_1);

		JLabel lblNewLabel_7_2 = new JLabel("Extender Pr\u00E9stamo: ");
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_7_2.setBounds(24, 200, 185, 18);
		panelPrestamo.add(lblNewLabel_7_2);

		final JTextArea textDispo = new JTextArea();
		textDispo.setEditable(false);
		textDispo.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		textDispo.setBounds(402, 25, 328, 335);
		panelPrestamo.add(textDispo);

		JScrollPane scroll = new JScrollPane(textDispo);
		scroll.setBounds(414, 23, 316, 337);
		panelPrestamo.add(scroll);

		/*
		 * Actualiza los ejemplares disponibles
		 */
		JButton btnEjemplaresDisponibles = new JButton("Ejemplares Disponibles");
		btnEjemplaresDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDispo.setText("");
				ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
				for (int i = 0; i < ejemplares.size(); i++) {

					if (ejemplares.get(i).getDisponible()) {
						textDispo.append(
								ejemplares.get(i).getIdEjemplar() + " - " + ejemplares.get(i).getObra().getTitulo()
										+ " - " + ejemplares.get(i).getObservaciones() + "\n");
						textDispo
								.append("--------------------------------------------------------------------------\n");
					}

				}

			}
		});
		btnEjemplaresDisponibles.setBounds(474, 381, 179, 18);
		panelPrestamo.add(btnEjemplaresDisponibles);

		JButton btnExtender = new JButton("Extender");
		btnExtender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textIDEjemplarExtencion.getText());
				int dias = Integer.parseInt(textDiasExtencion.getText());
				metodo.extenderDias(dias, id);
				/*
				 * Metodo para extender dias al prestamo
				 */

			}
		});
		btnExtender.setBounds(283, 256, 89, 28);
		panelPrestamo.add(btnExtender);

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
		ListaMorosos.add(lblNewLabel_12);

		final JTextArea textSoliObra = new JTextArea();
		textSoliObra.setBounds(273, 12, 435, 352);
		listaObrasSolicitadas.add(textSoliObra);

		JButton btnAlumDoc = new JButton("Alumno / Docente");
		btnAlumDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * ACTUALIZA OBRAS MAS SOLICITADAS POR ALUMNO Y DOCENTE
				 */
				ArrayList<Lector> lectores = Lector.leerTexto();
				ArrayList<Ejemplar> ejemplares = Ejemplar.leerTexto();
				try {
					FileReader fr = new FileReader("PrestamosTerminados.txt");
					BufferedReader br = new BufferedReader(fr);
					String l;
					int dni = 0;
					int idEj = 0;
					while ((l = br.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea

						StringTokenizer x = new StringTokenizer(l, "/"); // Se crea un String hasta que aparezca el "-"
						x.nextToken();
						x.nextToken();
						x.nextToken();
						x.nextToken();
						x.nextToken();
						x.nextToken();
						dni = Integer.parseInt(x.nextToken());
						idEj = Integer.parseInt(x.nextToken());

						/*
						 * Busca tipo de lector
						 */
						try {
							FileReader f = new FileReader("Lectores.txt");
							BufferedReader b = new BufferedReader(f);
							String li;
							String tipo = "";
							while ((li = b.readLine()) != null) { // Lee el archivo hasta el siguiente salto de linea
								StringTokenizer x1 = new StringTokenizer(li, "/");
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								x1.nextToken();
								tipo = x1.nextToken();

								for (int i = 0; i < lectores.size(); i++) {

									if (tipo.equals("Docente")
											|| tipo.equals("Alumno") && (lectores.get(i).getNumDoc() == dni)) {
										for (int j = 0; j < ejemplares.size(); j++) {

											if (ejemplares.get(j).getIdEjemplar() == idEj) {

												textSoliObra.append(ejemplares.get(j).getObra().getTitulo() + " - "
														+ tipo + " - " + ejemplares.get(j).getIdEjemplar() + "\n");
												textSoliObra.append("-----------------\n");
											}
										}
									}
								}

							}
						} catch (Exception c) {
						}

					}
				} catch (Exception c) {
				}

			}
		});
		btnAlumDoc.setBounds(63, 120, 155, 23);
		listaObrasSolicitadas.add(btnAlumDoc);

		JButton btnPublicoGeneral = new JButton("Publico General");
		btnPublicoGeneral.setBounds(63, 209, 155, 23);
		listaObrasSolicitadas.add(btnPublicoGeneral);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13.setBounds(0, 0, 735, 396);
		listaObrasSolicitadas.add(lblNewLabel_13);

		JPanel ObrasEditorial = new JPanel();
		tabbedEstadisticas.addTab("Obras s/Editorial", null, ObrasEditorial, null);
		ObrasEditorial.setLayout(null);

		final DefaultTableModel modelEdic = new DefaultTableModel();
		modelEdic.addColumn("Editorial");
		modelEdic.addColumn("Obra");

		tableSegEditorial = new JTable(modelEdic);
		tableSegEditorial.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tableSegEditorial.setBounds(332, 45, 328, 306);
		ObrasEditorial.add(tableSegEditorial);

		JButton btnBuscarEjemplarEditorial = new JButton("Buscar");
		btnBuscarEjemplarEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Listado de Obras Segun Editorial elegida
				Object[] vec = new Object[2];
				int entradas = 0;
				for (int x = modelEdic.getRowCount() - 1; x >= 0; x--) {
					modelEdic.removeRow(x);
				}
				try {
					String editorial = textEditorialBusca.getText();
					ArrayList<Edicion> ediciones = Edicion.leerTexto();

					for (int j = 0; j < ediciones.size(); j++) {
						if (ediciones.get(j).getEditorial().equals(editorial)) {
							entradas++;
							vec[0] = ediciones.get(j).getEditorial();
							vec[1] = ediciones.get(j).getObra().getTitulo();

							// Agrega la tabla
							modelEdic.addRow(vec);

						}
					}
					if (entradas == 0) {
						JOptionPane.showMessageDialog(null, "No existe la editorial", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception c) {
					JOptionPane.showMessageDialog(null, "No existe la editorial", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnBuscarEjemplarEditorial.setBounds(100, 197, 94, 26);
		ObrasEditorial.add(btnBuscarEjemplarEditorial);

		textEditorialBusca = new JTextField();
		textEditorialBusca.setBounds(152, 157, 94, 20);
		ObrasEditorial.add(textEditorialBusca);
		textEditorialBusca.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Buscar Editorial:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(12, 154, 130, 26);
		ObrasEditorial.add(lblNewLabel_5);

		JLabel lblNewLabel_13_1 = new JLabel("");
		lblNewLabel_13_1.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13_1.setBounds(0, 0, 735, 396);
		ObrasEditorial.add(lblNewLabel_13_1);

		JPanel EjemplaresArea = new JPanel();
		tabbedEstadisticas.addTab("Ejemplar s/Area", null, EjemplaresArea, null);
		EjemplaresArea.setLayout(null);

		final JComboBox boxArea2 = new JComboBox();
		boxArea2.setModel(new DefaultComboBoxModel(Area.values()));
		boxArea2.setBounds(118, 102, 124, 26);
		EjemplaresArea.add(boxArea2);

		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		textArea.setBounds(290, 42, 379, 283);
		EjemplaresArea.add(textArea);

		JButton btnBuscarEjemplaresArea = new JButton("Buscar");
		btnBuscarEjemplaresArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Ejemplares disponibles para prestamo para un area de referencia determinada.
				 */
				textArea.setText("");
				int select = boxArea2.getSelectedIndex();

				switch (select) {
				case (0):
					// Matematicas
					metodo.imprimirEjemplaresArea(textArea, boxArea2);
					break;
				case (1):
					// Programacion
					metodo.imprimirEjemplaresArea(textArea, boxArea2);
					break;
				case (2):
					// Contabilidad
					metodo.imprimirEjemplaresArea(textArea, boxArea2);
					break;
				case (3):
					// Ad Empresas
					metodo.imprimirEjemplaresArea(textArea, boxArea2);
					break;
				case (4):
					// S. Operativo
					metodo.imprimirEjemplaresArea(textArea, boxArea2);
					break;
				case (5):
					// Otro
					metodo.imprimirEjemplaresArea(textArea, boxArea2);
					break;
				}

			}
		});
		btnBuscarEjemplaresArea.setBounds(135, 163, 94, 26);
		EjemplaresArea.add(btnBuscarEjemplaresArea);

		JLabel lblNewLabel_13_1_1 = new JLabel("");
		lblNewLabel_13_1_1
				.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13_1_1.setBounds(0, 0, 735, 396);
		EjemplaresArea.add(lblNewLabel_13_1_1);

		JPanel RankingMultados = new JPanel();
		tabbedEstadisticas.addTab("RankingMultados", null, RankingMultados, null);
		RankingMultados.setLayout(null);

		final JTextArea textRank = new JTextArea();
		textRank.setEditable(false);
		textRank.setBounds(55, 12, 625, 289);
		RankingMultados.add(textRank);

		JScrollPane scrollRank = new JScrollPane(textRank);
		scrollRank.setBounds(33, 25, 668, 276);
		RankingMultados.add(scrollRank);

		/*
		 * Ranking de multados
		 * 
		 */
		JButton btnRankingMultados = new JButton("Buscar");
		btnRankingMultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRank.setText("");
				// ranking multados
				ArrayList<Lector> multas = metodo.ordenarLectoresPorMulta();
				for (int i = 0; i < multas.size(); i++) {
					textRank.append(multas.get(i).toString() + "\n");
					textRank.append("\n");
				}
			}
		});
		btnRankingMultados.setBounds(320, 330, 94, 26);
		RankingMultados.add(btnRankingMultados);

		JLabel lblNewLabel_13_1_2 = new JLabel("");
		lblNewLabel_13_1_2
				.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13_1_2.setBounds(0, 0, 735, 396);
		RankingMultados.add(lblNewLabel_13_1_2);

		JPanel MultadosPorPeriodo = new JPanel();
		tabbedEstadisticas.addTab("Multados", null, MultadosPorPeriodo, null);
		MultadosPorPeriodo.setLayout(null);

		diaInicio = new JTextField();
		diaInicio.setBounds(150, 113, 37, 20);
		MultadosPorPeriodo.add(diaInicio);
		diaInicio.setColumns(10);

		mesInicio = new JTextField();
		mesInicio.setColumns(10);
		mesInicio.setBounds(199, 113, 37, 20);
		MultadosPorPeriodo.add(mesInicio);

		anioInicio = new JTextField();
		anioInicio.setColumns(10);
		anioInicio.setBounds(251, 113, 60, 20);
		MultadosPorPeriodo.add(anioInicio);

		diaFinal = new JTextField();
		diaFinal.setColumns(10);
		diaFinal.setBounds(150, 166, 37, 20);
		MultadosPorPeriodo.add(diaFinal);

		mesFinal = new JTextField();
		mesFinal.setColumns(10);
		mesFinal.setBounds(199, 166, 37, 20);
		MultadosPorPeriodo.add(mesFinal);

		anioFinal = new JTextField();
		anioFinal.setColumns(10);
		anioFinal.setBounds(251, 166, 60, 20);
		MultadosPorPeriodo.add(anioFinal);

		final JTextArea textFined = new JTextArea();
		textFined.setEditable(false);
		textFined.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		textFined.setBounds(0, 111, 366, 302);
		MultadosPorPeriodo.add(textFined);

		JScrollPane scrollFined = new JScrollPane(textFined);
		scrollFined.setBounds(357, 53, 339, 282);
		MultadosPorPeriodo.add(scrollFined);

		/*
		 * Listado de lectores que tuvieron multas en cierto periodo de tiempo.
		 */
		JButton btnMultadosFechas = new JButton("Buscar");
		btnMultadosFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFined.setText("");
				int diaI = Integer.parseInt(diaInicio.getText());
				int mesI = Integer.parseInt(mesInicio.getText());
				int anioI = Integer.parseInt(anioInicio.getText());

				int diaF = Integer.parseInt(diaFinal.getText());
				int mesF = Integer.parseInt(mesFinal.getText());
				int anioF = Integer.parseInt(anioFinal.getText());

				LocalDateTime fechaInicio = LocalDateTime.of(anioI, mesI, diaI, 0, 0);
				LocalDateTime fechaFinal = LocalDateTime.of(anioF, mesF, diaF, 0, 0);

				ArrayList<Multa> multas = metodo.lectoresPorFecha(fechaInicio, fechaFinal);
				ArrayList<Lector> lectores = Lector.leerTexto();
				for (int j = 0; j < multas.size(); j++) {
					for (int i = 0; i < lectores.size(); i++) {
						if (multas.get(j).getLector().getNumDoc() == lectores.get(i).getNumDoc()) {

							textFined.append(lectores.get(i).getNom() + " - " + lectores.get(i).getNumDoc() + " - "
									+ multas.get(j).getFechaHoraMultado() + "\n");
							textFined.append("************************************\n");

						}

					}
				}
			}
		});
		btnMultadosFechas.setBounds(150, 235, 94, 26);
		MultadosPorPeriodo.add(btnMultadosFechas);

		JLabel lblNewLabel_15 = new JLabel("Fecha Inicial:");
		lblNewLabel_15.setForeground(new Color(255, 255, 255));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setBounds(0, 115, 132, 16);
		MultadosPorPeriodo.add(lblNewLabel_15);

		JLabel lblNewLabel_15_1 = new JLabel("Fecha Final:");
		lblNewLabel_15_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_15_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15_1.setBounds(0, 168, 132, 16);
		MultadosPorPeriodo.add(lblNewLabel_15_1);

		JLabel lblNewLabel_16_1 = new JLabel("DIA");
		lblNewLabel_16_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_16_1.setBounds(150, 85, 37, 16);
		MultadosPorPeriodo.add(lblNewLabel_16_1);

		JLabel lblNewLabel_16_2 = new JLabel("A\u00D1O");
		lblNewLabel_16_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_16_2.setBounds(251, 85, 60, 16);
		MultadosPorPeriodo.add(lblNewLabel_16_2);

		JLabel lblNewLabel_16_1_1 = new JLabel("MES");
		lblNewLabel_16_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_1_1.setForeground(Color.WHITE);
		lblNewLabel_16_1_1.setBounds(199, 85, 37, 16);
		MultadosPorPeriodo.add(lblNewLabel_16_1_1);

		JLabel lblNewLabel_16 = new JLabel("Lectores con multas en un periodo de tiempo");
		lblNewLabel_16.setForeground(new Color(75, 0, 130));
		lblNewLabel_16.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(0, 4, 353, 79);
		MultadosPorPeriodo.add(lblNewLabel_16);

		JLabel lblNewLabel_13_1_2_1 = new JLabel("");
		lblNewLabel_13_1_2_1
				.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13_1_2_1.setBounds(0, 0, 735, 396);
		MultadosPorPeriodo.add(lblNewLabel_13_1_2_1);

		JPanel Reservadas = new JPanel();
		tabbedEstadisticas.addTab("Reservadas", null, Reservadas, null);
		Reservadas.setLayout(null);

		diaReser = new JTextField();
		diaReser.setColumns(10);
		diaReser.setBounds(103, 154, 37, 20);
		Reservadas.add(diaReser);

		mesReser = new JTextField();
		mesReser.setColumns(10);
		mesReser.setBounds(152, 154, 37, 20);
		Reservadas.add(mesReser);

		anioReser = new JTextField();
		anioReser.setColumns(10);
		anioReser.setBounds(204, 154, 60, 20);
		Reservadas.add(anioReser);

		JLabel lblNewLabel_17 = new JLabel("Fecha:");
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setBounds(12, 156, 73, 16);
		Reservadas.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Obras que se encuentran reservadas a partir de una fecha determinada.");
		lblNewLabel_18.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(30, 12, 658, 33);
		Reservadas.add(lblNewLabel_18);

		final JTextArea obrasReservadas = new JTextArea();
		obrasReservadas.setBounds(345, 57, 300, 295);
		Reservadas.add(obrasReservadas);
		
		JScrollPane scrollPane = new JScrollPane(obrasReservadas);
		scrollPane.setBounds(328, 57, 317, 299);
		Reservadas.add(scrollPane);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Obras que se encuentran reservadas a partir de una fecha determinada
				 */
				obrasReservadas.setText("");
				int diaR = Integer.parseInt(diaReser.getText());
				int mesR = Integer.parseInt(mesReser.getText());
				int anioR = Integer.parseInt(anioReser.getText());

				LocalDateTime fecha = LocalDateTime.of(anioR, mesR, diaR, 0, 0);
				ArrayList<Reserva> reservas = metodo.obrasReservadasPorFecha(fecha);
				ArrayList<Obra> obras = Obra.leerTexto();
				ArrayList<Ejemplar> ejemplar = Ejemplar.leerTexto();
				for (int z = 0; z < reservas.size(); z++) {
					for (int l = 0; l < ejemplar.size(); l++) {
						if (ejemplar.get(l).getIdEjemplar() == reservas.get(z).getEjemplarReservado().getIdEjemplar()) {
							for (int a = 0; a < obras.size(); a++) {
								/*
								 * Si el titulo es igual al de la obra, pone los datos de obra
								 */
								if (obras.get(a).getTitulo().equals(ejemplar.get(l).getObra().getTitulo())) {
									obrasReservadas
											.append(ejemplar.get(l).getIdEjemplar() + " - " + obras.get(a).getTitulo()
													+ " - " + reservas.get(z).getFechaReserva() + "\n");
									obrasReservadas.append("*******************************************************\n");
								}
							}
						}

					}
				}

			}

		});
		btnNewButton.setBounds(122, 199, 98, 26);
		Reservadas.add(btnNewButton);

		JLabel lblNewLabel_13_1_2_1_1 = new JLabel("");
		lblNewLabel_13_1_2_1_1
				.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_13_1_2_1_1.setBounds(0, 0, 735, 396);
		Reservadas.add(lblNewLabel_13_1_2_1_1);
		
		

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_11.setBounds(0, 0, 760, 446);
		panelEstadisticas.add(lblNewLabel_11);

	}
}
