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
import javax.swing.JList;
import javax.swing.ListSelectionModel;

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
	private JTextField textNumCel;

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
		tabbedPane.addTab("Préstamo", null, panelPrestamo, null);
		panelPrestamo.setLayout(null);
		
		final JList listaUsuarioPrestamo = new JList();
		listaUsuarioPrestamo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaUsuarioPrestamo.setBounds(453, 26, 255, 381);
		panelPrestamo.add(listaUsuarioPrestamo);
		
		JLabel fondoP = new JLabel("");
		fondoP.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		fondoP.setBounds(0, 0, 760, 446);
		panelPrestamo.add(fondoP);
		
		JPanel panelEjemplar = new JPanel();
		tabbedPane.addTab("Ejemplar", null, panelEjemplar, null);
		panelEjemplar.setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(366, 192, 90, 28);
		panelEjemplar.add(btnNewButton);
		
		JComboBox boxArea = new JComboBox();
		boxArea.setModel(new DefaultComboBoxModel(Area.values()));
		boxArea.setBounds(93, 69, 124, 26);
		panelEjemplar.add(boxArea);
		
		JComboBox boxTipoObra = new JComboBox();
		boxTipoObra.setModel(new DefaultComboBoxModel(tipoObra.values()));
		boxTipoObra.setBounds(229, 69, 124, 26);
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
		textISBN.setBounds(95, 192, 124, 28);
		panelEjemplar.add(textISBN);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(366, 67, 124, 28);
		panelEjemplar.add(textTitulo);
		
		textSubtitulo = new JTextField();
		textSubtitulo.setColumns(10);
		textSubtitulo.setBounds(502, 64, 124, 28);
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
		textID.setBounds(231, 192, 122, 28);
		panelEjemplar.add(textID);
		
		JLabel lblNewLabel_1 = new JLabel("Area");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(93, 41, 126, 16);
		panelEjemplar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de Obra");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(229, 40, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Titulo");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(366, 44, 126, 16);
		panelEjemplar.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Subtitulo");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(502, 41, 124, 16);
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
		lblNewLabel_1_1_7.setBounds(93, 166, 126, 16);
		panelEjemplar.add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_1_1_8 = new JLabel("ID");
		lblNewLabel_1_1_8.setForeground(Color.WHITE);
		lblNewLabel_1_1_8.setBounds(229, 166, 124, 16);
		panelEjemplar.add(lblNewLabel_1_1_8);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel_3.setBounds(0, 0, 765, 444);
		panelEjemplar.add(lblNewLabel_3);
		
		JPanel panelLectores = new JPanel();
		tabbedPane.addTab("Lectores", null, panelLectores, null);
		panelLectores.setLayout(null);
		
		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(153, 120, 122, 28);
		panelLectores.add(textDomicilio);
		
		textNombre = new JTextField();
		textNombre.setBounds(21, 51, 122, 28);
		panelLectores.add(textNombre);
		textNombre.setColumns(10);
		
		textTipoDNI = new JTextField();
		textTipoDNI.setColumns(10);
		textTipoDNI.setBounds(285, 51, 122, 28);
		panelLectores.add(textTipoDNI);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(153, 51, 122, 28);
		panelLectores.add(textApellido);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(417, 51, 122, 28);
		panelLectores.add(textDNI);
		
		textLocalidad = new JTextField();
		textLocalidad.setColumns(10);
		textLocalidad.setBounds(549, 51, 122, 28);
		panelLectores.add(textLocalidad);
		
		textDepartamento = new JTextField();
		textDepartamento.setColumns(10);
		textDepartamento.setBounds(21, 120, 122, 28);
		panelLectores.add(textDepartamento);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(21, 24, 97, 16);
		panelLectores.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(153, 24, 97, 16);
		panelLectores.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tipo DNI");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(285, 24, 97, 16);
		panelLectores.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setBounds(285, 93, 97, 16);
		panelLectores.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Localidad");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setBounds(549, 24, 97, 16);
		panelLectores.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Departamento");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setBounds(21, 93, 97, 16);
		panelLectores.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Domicilio");
		lblNewLabel_2_5_1.setForeground(Color.WHITE);
		lblNewLabel_2_5_1.setBounds(153, 90, 97, 16);
		panelLectores.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("N\u00B0 DNI");
		lblNewLabel_2_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_5_1_1.setBounds(417, 24, 97, 16);
		panelLectores.add(lblNewLabel_2_5_1_1);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(285, 120, 122, 28);
		panelLectores.add(textCorreo);
		
		dateDia = new JTextField();
		dateDia.setHorizontalAlignment(SwingConstants.LEFT);
		dateDia.setToolTipText("");
		dateDia.setBounds(417, 120, 34, 28);
		panelLectores.add(dateDia);
		dateDia.setColumns(2);
		
		dateMes = new JTextField();
		dateMes.setColumns(2);
		dateMes.setBounds(461, 120, 34, 28);
		panelLectores.add(dateMes);
		
		dateAnio = new JTextField();
		dateAnio.setColumns(4);
		dateAnio.setBounds(505, 120, 48, 28);
		panelLectores.add(dateAnio);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Nacimiento: d-m-y");
		lblNewLabel_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1.setBounds(417, 93, 109, 16);
		panelLectores.add(lblNewLabel_2_3_1);
				
		JButton btnRegUsuario = new JButton("Registrar");
		btnRegUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnRegUsuario.setBounds(279, 399, 89, 23);
		panelLectores.add(btnRegUsuario);
		
		textNumCel = new JTextField();
		textNumCel.setColumns(10);
		textNumCel.setBounds(21, 182, 122, 28);
		panelLectores.add(textNumCel);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("N° Celular");
		lblNewLabel_2_5_2.setForeground(Color.WHITE);
		lblNewLabel_2_5_2.setBounds(21, 159, 97, 16);
		panelLectores.add(lblNewLabel_2_5_2);
		
		
		JLabel fondoL = new JLabel("");
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
