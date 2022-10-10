package BibliotecaGraficos;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Biblioteca.tipoObra;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import Biblioteca.Area;
import java.awt.Toolkit;

public class ventanaNuevaObra extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtTitulo;
	private JTextField txtSubtitulo;
	private JTextField txtPriAutor;
	private JTextField txtSegAutor;
	private JTextField txtTerAutor;
	private JTextField txtGenero;
	private JTextField txtISBN;
	private JTextField txtID;
	private JButton btnRegistrarObra;

	public ventanaNuevaObra(final ventanaPrincipal framePrincipal) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaNuevaObra.class.getResource("/imagenes/icon.png")));
		setTitle("Nimbook - Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal.setVisible(true);
				ventanaNuevaObra.this.setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel_1_8 = new JLabel("Area:");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_8.setForeground(Color.WHITE);
		lblNewLabel_1_8.setBounds(66, 95, 66, 14);
		contentPane.add(lblNewLabel_1_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Area.values()));
		comboBox_1.setBounds(142, 91, 116, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Tipo de Obra:");
		lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7_1.setForeground(Color.WHITE);
		lblNewLabel_1_7_1.setBounds(66, 378, 66, 14);
		contentPane.add(lblNewLabel_1_7_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(tipoObra.values()));
		comboBox.setBounds(142, 374, 116, 22);
		contentPane.add(comboBox);
		
		btnRegistrarObra = new JButton("Registrar Obra");
		btnRegistrarObra.setBounds(142, 417, 116, 23);
		contentPane.add(btnRegistrarObra);
		
		JLabel lblNewLabel_1_7 = new JLabel("ID:");
		lblNewLabel_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setBounds(96, 346, 36, 14);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_6 = new JLabel("ISBN:");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setBounds(86, 315, 46, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_5 = new JLabel("G\u00E9nero:");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setBounds(86, 284, 46, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tercer Autor:");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setBounds(52, 253, 80, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("Segundo Autor:");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setBounds(52, 222, 80, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Primer Autor:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(52, 191, 80, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subtitulo:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(52, 158, 80, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(86, 127, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(142, 312, 116, 20);
		contentPane.add(txtISBN);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(142, 343, 116, 20);
		contentPane.add(txtID);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(142, 281, 116, 20);
		contentPane.add(txtGenero);
		
		txtSegAutor = new JTextField();
		txtSegAutor.setColumns(10);
		txtSegAutor.setBounds(142, 219, 116, 20);
		contentPane.add(txtSegAutor);
		
		txtTerAutor = new JTextField();
		txtTerAutor.setColumns(10);
		txtTerAutor.setBounds(142, 250, 116, 20);
		contentPane.add(txtTerAutor);
		
		txtPriAutor = new JTextField();
		txtPriAutor.setColumns(10);
		txtPriAutor.setBounds(142, 188, 116, 20);
		contentPane.add(txtPriAutor);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(142, 124, 116, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtSubtitulo = new JTextField();
		txtSubtitulo.setColumns(10);
		txtSubtitulo.setBounds(142, 155, 116, 20);
		contentPane.add(txtSubtitulo);
		btnNewButton.setBounds(43, 522, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel.setBounds(0, 0, 777, 578);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
}
