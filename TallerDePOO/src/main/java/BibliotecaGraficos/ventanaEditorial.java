package BibliotecaGraficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Biblioteca.Obra;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ventanaEditorial extends JFrame {

	private JPanel contentPane;
	private JTextField textEditorial;
	private JTextField textPais;
	private JTextField textNum;
	private JTextField textAnio;
	private JTextField textVolumen;
	private JTextField textPaginas;
	private JTextField textIdioma;
	private JTextField textObra;

	public ventanaEditorial(ventanaPrincipal ventanaPrincipal) {
		ventanaNuevaEditorial(ventanaPrincipal);
	}

	public void ventanaNuevaEditorial(final ventanaPrincipal ventanaPrincipal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vuelve a ventanaPrincipal

				ventanaPrincipal.setVisible(true);
				ventanaEditorial.this.dispose();
			}
		});
		btnNewButton.setBounds(10, 310, 89, 23);
		contentPane.add(btnNewButton);

		textEditorial = new JTextField();
		textEditorial.setBounds(79, 68, 86, 20);
		contentPane.add(textEditorial);
		textEditorial.setColumns(10);

		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(209, 68, 86, 20);
		contentPane.add(textPais);

		textNum = new JTextField();
		textNum.setColumns(10);
		textNum.setBounds(336, 68, 86, 20);
		contentPane.add(textNum);

		textAnio = new JTextField();
		textAnio.setColumns(10);
		textAnio.setBounds(79, 136, 86, 20);
		contentPane.add(textAnio);

		textVolumen = new JTextField();
		textVolumen.setColumns(10);
		textVolumen.setBounds(209, 136, 86, 20);
		contentPane.add(textVolumen);

		textPaginas = new JTextField();
		textPaginas.setColumns(10);
		textPaginas.setBounds(336, 136, 86, 20);
		contentPane.add(textPaginas);

		textIdioma = new JTextField();
		textIdioma.setColumns(10);
		textIdioma.setBounds(209, 201, 86, 20);
		contentPane.add(textIdioma);

		JLabel lblNewLabel_1 = new JLabel("Editorial");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(79, 43, 86, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Pais");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(209, 43, 86, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Numero");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(336, 43, 86, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("A\u00F1o");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(79, 111, 86, 14);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Volumen");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBounds(209, 111, 86, 14);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Paginas");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setBounds(336, 111, 86, 14);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Idioma");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setBounds(209, 176, 86, 14);
		contentPane.add(lblNewLabel_1_6);

		JButton btnRegEdicion = new JButton("Registrar Editorial");
		btnRegEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String edicion = textEditorial.getText();
				String pais = textPais.getName();
				int numero = Integer.parseInt(textNum.getText());
				int anio = Integer.parseInt(textAnio.getText());
				int paginas = Integer.parseInt(textPaginas.getText());
				int volumen = Integer.parseInt(textVolumen.getText());
				String idioma = textIdioma.getText();
				String tituloObra = textObra.getText();

				Obra obra = buscarObra();

				// Edicion edicion = new Edicion(edicion, pais, numero, anio, volumen, paginas,
				// idioma );

			}
		});
		btnRegEdicion.setBounds(183, 248, 138, 23);
		contentPane.add(btnRegEdicion);

		textObra = new JTextField();
		textObra.setColumns(10);
		textObra.setBounds(336, 201, 86, 20);
		contentPane.add(textObra);

		JLabel text = new JLabel("Título de Obra");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setForeground(Color.WHITE);
		text.setBounds(336, 176, 86, 14);
		contentPane.add(text);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaEditorial.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel.setBounds(0, 0, 505, 344);
		contentPane.add(lblNewLabel);
	}

	protected Obra buscarObra() {
		
		return null;
	}
}
