package BibliotecaGraficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JToggleButton;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Toolkit;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;

	public ventanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/imagenes/icono.png")));
		setType(Type.POPUP);
		setTitle("Nimbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 617);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel.setBounds(0, 0, 777, 578);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		
		
	}
}
