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

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;

	public ventanaPrincipal() {
		listaObra listaObras = new listaObra();
		ventanaNuevaObra regNuevaObra = new ventanaNuevaObra(ventanaPrincipal.this, listaObras);
		
		inicioVentanaPrincipal(regNuevaObra);
	}

	private void inicioVentanaPrincipal(final ventanaNuevaObra regNuevaObra) {
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/logoTotal.png")));
		lblNewLabel_1.setBounds(197, 39, 383, 107);
		contentPane.add(lblNewLabel_1);
		
		JButton btnPrestamo = new JButton("Prestamo\r\n");
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnPrestamo.setBounds(86, 188, 176, 28);
		contentPane.add(btnPrestamo);
		
		JButton btnNuevaObra = new JButton("Registrar Nueva Obra");
		btnNuevaObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.this.setVisible(false);
				regNuevaObra.setVisible(true);
			}
		});
		btnNuevaObra.setBounds(86, 228, 176, 28);
		contentPane.add(btnNuevaObra);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 777, 578);
		lblNewLabel.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		
	}
}
