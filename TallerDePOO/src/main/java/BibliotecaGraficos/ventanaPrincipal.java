package BibliotecaGraficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Biblioteca.listaObra;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import Biblioteca.Area;
import Biblioteca.tipoObra;
import javax.swing.JCheckBox;
import Biblioteca.FormaAdquirida;
import Biblioteca.Lector;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Canvas;

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
	private JTextField textIDLector;
	private JTextField otroArea;
	private JTextField otroTipoObra;
	private JTextField otroAdquisicion;
	private JTextField textField_2;
	private JTextField textDiaDevuelto;
	private JTextField textMesDevuelta;
	private JTextField textAnioDevuelta;
	private JTextField textFuncPrestador;
	private JTextField textFuncRecibidor;
	private JTextField textIDEjemplarDevuelta;
	private JTextField textNroCelular;
	private JTextField textCodPos;
	private JTextField textLugarNac;

	public ventanaPrincipal() {
		inicioVentanaPrincipal();
	}

	private void inicioVentanaPrincipal() {
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
		logo.setBounds(210, 6, 356, 105);
		contentPane.add(logo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 98, 765, 474);
		contentPane.add(tabbedPane);

		JPanel panelPrestamo = new JPanel();
		tabbedPane.addTab("Prestamo", null, panelPrestamo, null);
		panelPrestamo.setLayout(null);

		textIDEjemplar = new JTextField();
		textIDEjemplar.setBounds(27, 93, 102, 28);
		panelPrestamo.add(textIDEjemplar);
		textIDEjemplar.setColumns(10);

		textIDLector = new JTextField();
		textIDLector.setColumns(10);
		textIDLector.setBounds(159, 93, 102, 28);
		panelPrestamo.add(textIDLector);

		JLabel lblNewLabel_4 = new JLabel("ID Ejemplar");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(27, 65, 102, 16);
		panelPrestamo.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("ID Lector");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(159, 65, 102, 16);
		panelPrestamo.add(lblNewLabel_4_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("A domicilio");
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBounds(436, 98, 103, 18);
		panelPrestamo.add(chckbxNewCheckBox);

		JLabel lblNewLabel_7 = new JLabel("Pr\u00E9stamo: ");
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_7.setBounds(27, 28, 102, 18);
		panelPrestamo.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("Devoluci\u00F3n: ");
		lblNewLabel_7_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_7_1.setBounds(27, 162, 102, 18);
		panelPrestamo.add(lblNewLabel_7_1);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("Fecha devuelta (d - m - a) :");
		lblNewLabel_2_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1_1.setBounds(27, 198, 149, 16);
		panelPrestamo.add(lblNewLabel_2_3_1_1);

		textDiaDevuelto = new JTextField();
		textDiaDevuelto.setToolTipText("");
		textDiaDevuelto.setHorizontalAlignment(SwingConstants.LEFT);
		textDiaDevuelto.setColumns(2);
		textDiaDevuelto.setBounds(27, 226, 34, 28);
		panelPrestamo.add(textDiaDevuelto);

		textMesDevuelta = new JTextField();
		textMesDevuelta.setColumns(2);
		textMesDevuelta.setBounds(73, 226, 34, 28);
		panelPrestamo.add(textMesDevuelta);

		textAnioDevuelta = new JTextField();
		textAnioDevuelta.setColumns(4);
		textAnioDevuelta.setBounds(119, 226, 48, 28);
		panelPrestamo.add(textAnioDevuelta);

		textFuncPrestador = new JTextField();
		textFuncPrestador.setColumns(10);
		textFuncPrestador.setBounds(286, 93, 102, 28);
		panelPrestamo.add(textFuncPrestador);

		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionario Prestador:");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(286, 65, 149, 16);
		panelPrestamo.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Funcionario Recibidor:");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setBounds(208, 198, 149, 16);
		panelPrestamo.add(lblNewLabel_4_1_1_1);

		textFuncRecibidor = new JTextField();
		textFuncRecibidor.setColumns(10);
		textFuncRecibidor.setBounds(208, 226, 102, 28);
		panelPrestamo.add(textFuncRecibidor);

		JLabel lblNewLabel_4_2 = new JLabel("ID Ejemplar");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setBounds(357, 198, 102, 16);
		panelPrestamo.add(lblNewLabel_4_2);

		textIDEjemplarDevuelta = new JTextField();
		textIDEjemplarDevuelta.setColumns(10);
		textIDEjemplarDevuelta.setBounds(357, 226, 102, 28);
		panelPrestamo.add(textIDEjemplarDevuelta);

		JButton btnNewButton_1_1 = new JButton("Devuelto");
		btnNewButton_1_1.setBounds(496, 226, 89, 28);
		panelPrestamo.add(btnNewButton_1_1);

		final JLabel resumenPrestamo = new JLabel("");
		resumenPrestamo.setVerticalAlignment(SwingConstants.TOP);
		resumenPrestamo.setForeground(Color.WHITE);
		resumenPrestamo.setHorizontalAlignment(SwingConstants.LEFT);
		resumenPrestamo.setFont(new Font("Poor Richard", Font.BOLD, 16));
		resumenPrestamo.setBounds(43, 283, 679, 123);
		panelPrestamo.add(resumenPrestamo);

		JPanel panelEjemplar = new JPanel();
		tabbedPane.addTab("Ejemplar", null, panelEjemplar, null);
		panelEjemplar.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Registrar la nueva Obra

			}
		});
		btnNewButton.setBounds(305, 356, 90, 28);
		panelEjemplar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Prestar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setBounds(561, 93, 89, 28);
		panelPrestamo.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel.setBounds(0, 0, 765, 444);
		panelPrestamo.add(lblNewLabel);

		JComboBox boxArea = new JComboBox();
		boxArea.setModel(new DefaultComboBoxModel(Area.values()));
		boxArea.setBounds(93, 195, 124, 26);
		panelEjemplar.add(boxArea);

		JComboBox boxTipoObra = new JComboBox();
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

		JComboBox boxAdquisicion = new JComboBox();
		boxAdquisicion.setModel(new DefaultComboBoxModel(FormaAdquirida.values()));
		boxAdquisicion.setBounds(366, 193, 124, 26);
		panelEjemplar.add(boxAdquisicion);

		JLabel lblNewLabel_1_1_8_1 = new JLabel("Forma de Adquisici\u00F3n");
		lblNewLabel_1_1_8_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_8_1.setBounds(366, 166, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_8_1);

		otroArea = new JTextField();
		otroArea.setBounds(93, 233, 124, 28);
		panelEjemplar.add(otroArea);
		otroArea.setColumns(10);

		otroTipoObra = new JTextField();
		otroTipoObra.setColumns(10);
		otroTipoObra.setBounds(229, 233, 124, 28);
		panelEjemplar.add(otroTipoObra);

		otroAdquisicion = new JTextField();
		otroAdquisicion.setColumns(10);
		otroAdquisicion.setBounds(366, 233, 124, 28);
		panelEjemplar.add(otroAdquisicion);

		JLabel lblNewLabel_5 = new JLabel("*Otro");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(41, 239, 40, 16);
		panelEjemplar.add(lblNewLabel_5);

		textField_2 = new JTextField();
		textField_2.setBounds(93, 299, 531, 45);
		panelEjemplar.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("* Observaciones");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(93, 273, 124, 16);
		panelEjemplar.add(lblNewLabel_6);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_3.setBounds(0, 0, 765, 444);
		panelEjemplar.add(lblNewLabel_3);

		JPanel panelLectores = new JPanel();
		tabbedPane.addTab("Lectores", null, panelLectores, null);
		panelLectores.setLayout(null);

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
		dateDia.setBounds(288, 181, 34, 28);
		panelLectores.add(dateDia);
		dateDia.setColumns(2);

		dateMes = new JTextField();
		dateMes.setColumns(2);
		dateMes.setBounds(334, 181, 34, 28);
		panelLectores.add(dateMes);

		dateAnio = new JTextField();
		dateAnio.setColumns(4);
		dateAnio.setBounds(380, 181, 48, 28);
		panelLectores.add(dateAnio);

		JLabel lblNewLabel_2_3_1 = new JLabel("Nacimiento: d-m-y");
		lblNewLabel_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1.setBounds(288, 153, 109, 16);
		panelLectores.add(lblNewLabel_2_3_1);

		textNroCelular = new JTextField();
		textNroCelular.setColumns(10);
		textNroCelular.setBounds(422, 111, 122, 28);
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
		boxSexo.setBounds(440, 182, 97, 26);
		panelLectores.add(boxSexo);

		JLabel lblNewLabel_8 = new JLabel("Sexo");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(440, 153, 53, 16);
		panelLectores.add(lblNewLabel_8);

		textLugarNac = new JTextField();
		textLugarNac.setColumns(10);
		textLugarNac.setBounds(154, 181, 122, 28);
		panelLectores.add(textLugarNac);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("Lugar de Nacimiento");
		lblNewLabel_2_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_1_2.setBounds(154, 153, 122, 16);
		panelLectores.add(lblNewLabel_2_3_1_2);
		
		final JTextPane muestraLector = new JTextPane();
		muestraLector.setForeground(new Color(0, 0, 0));
		muestraLector.setBackground(Color.WHITE);
		muestraLector.setFont(new Font("Arial", Font.BOLD, 14));
		muestraLector.setBounds(43, 275, 678, 146);
		panelLectores.add(muestraLector);


		JButton btnRegistrarLector = new JButton("Registrar Lector");
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

				// Crea la nueva instancia de Lector
				Lector lector = new Lector(nombre, apellido, tipDni, dni, correo, numCel, fechaNac, sexo, lugNac,
						domicilio, codPos, departamento, localidad);

				// Muestra en pantalla de los datos ingresado
				muestraLector.setText("* Nombre: " + nombre + "\n* Apellido: " + apellido + "\n* tipo DNI: " + tipDni + ", N° DNI: " + dni
						+ "\n* Correo: " + correo + " - N° Celular: " + numCel + " - Fecha Nacimiento: " + fechaNac + " - Sexo: " + sexo + "\n* Lugar Nacimiento: "
						+ lugNac + "\n* Domicilio: " + domicilio + " - Codigo Postal: " + codPos + " - Departamento: " + departamento + "-  Localidad: " + localidad);
				
				//Agrega al txt el nuevo lector
			}
		});
		btnRegistrarLector.setBounds(311, 235, 143, 28);
		panelLectores.add(btnRegistrarLector);

		
		JLabel fondoL = new JLabel("");
		fondoL.setBackground(Color.LIGHT_GRAY);
		fondoL.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		fondoL.setBounds(0, 0, 765, 444);
		panelLectores.add(fondoL);

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 777, 578);
		fondo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		contentPane.add(fondo);
		setLocationRelativeTo(null);

	}
}
