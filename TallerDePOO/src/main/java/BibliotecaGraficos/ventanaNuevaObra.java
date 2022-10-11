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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Biblioteca.tipoObra;
import Biblioteca.Area;
import Biblioteca.Obra;
import Biblioteca.listaObra;

import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import java.awt.ScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Font;

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

	public ventanaNuevaObra(final ventanaPrincipal framePrincipal, final listaObra listaObras) {
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
		
		final JTextArea textMuestra = new JTextArea();
		textMuestra.setEditable(false);
		textMuestra.setBackground(Color.GRAY);
		textMuestra.setFont(new Font("Arial", Font.BOLD, 20));
		textMuestra.setBounds(385, 90, 337, 350);
		contentPane.add(textMuestra);
		
		JLabel lblNewLabel_1_8 = new JLabel("Area:");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_8.setForeground(Color.WHITE);
		lblNewLabel_1_8.setBounds(66, 95, 66, 14);
		contentPane.add(lblNewLabel_1_8);
		
		final JComboBox areaObra = new JComboBox();
		areaObra.setModel(new DefaultComboBoxModel(Area.values()));
		areaObra.setBounds(142, 91, 116, 22);
		contentPane.add(areaObra);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Tipo de Obra:");
		lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7_1.setForeground(Color.WHITE);
		lblNewLabel_1_7_1.setBounds(66, 378, 66, 14);
		contentPane.add(lblNewLabel_1_7_1);
		
		final JComboBox tipoObraNueva = new JComboBox();
		tipoObraNueva.setModel(new DefaultComboBoxModel(tipoObra.values()));
		tipoObraNueva.setBounds(142, 374, 116, 22);
		contentPane.add(tipoObraNueva);
		
		btnRegistrarObra = new JButton("Registrar Obra");
		btnRegistrarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Area area = (Area) areaObra.getSelectedItem();
				String tit = txtTitulo.getText();
				String subt = txtSubtitulo.getText();
				String priAut = txtPriAutor.getText();
				String segAut = txtSegAutor.getText();
				String terAut = txtTerAutor.getText();
				String gen = txtGenero.getText();
				int isbn = Integer.parseInt(txtISBN.getText());
				int id = Integer.parseInt(txtID.getText());
				tipoObra tipo =(tipoObra) tipoObraNueva.getSelectedItem();
				Obra obra = new Obra(tit, subt, priAut, segAut, terAut, gen, isbn, id, area, tipo);
				listaObras.agregar(obra);
				textMuestra.append(tit + " - " + priAut + " - " + gen + " - " + isbn + "\n");;
			}
		});
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
