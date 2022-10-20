package BibliotecaGraficos;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Biblioteca.Funcionario; //importa clase funcionario
import Biblioteca.MetodosTxt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class ventanaRegistro extends JFrame{

	private JPanel contentPane;
	private JTextField userReg;
	private JPasswordField passReg;
	private Funcionario func;

	public ventanaRegistro(final MetodosTxt listaFunc, final ventana frame) {
		setTitle("Registro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaRegistro.class.getResource("/imagenes/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ventanaRegistro.class.getResource("/imagenes/icono.png")));
		lblNewLabel_2.setBounds(124, 22, 96, 96);
		contentPane.add(lblNewLabel_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				ventanaRegistro.this.dispose();
				userReg.setText("");
				passReg.setText("");
			}
		});
		btnVolver.setBounds(120, 338, 103, 23);
		contentPane.add(btnVolver);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userReg.getText();
				String pass = new String(passReg.getPassword());
				func = new Funcionario(user, pass);
				if(user.length() == 0 && pass.length() == 0) {//Comprueba si no se ingreso nada
					JOptionPane.showMessageDialog(null, "No ingres� datos", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					 if(listaFunc.existe(user)) {//Comprueba si ya existeFuncionario
						 JOptionPane.showMessageDialog(null, "Usuario ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
						 userReg.setText("");
						 passReg.setText("");
					 }else {
						 MetodosTxt.guardar(func, "Funcionarios.txt");
						 userReg.setText("");
						 passReg.setText("");
						 frame.setVisible(true);
						 ventanaRegistro.this.dispose();
					 }
				}
				
				
			}
		});
		btnRegistro.setBounds(120, 260, 103, 23);
		contentPane.add(btnRegistro);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nueva Contrase\u00F1a: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(38, 204, 122, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nuevo Usuario: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(38, 147, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		userReg = new JTextField();
		userReg.setBounds(170, 144, 86, 20);
		contentPane.add(userReg);
		userReg.setColumns(10);
		
		//userReg.setText("");
		
		passReg = new JPasswordField();
		passReg.setBounds(170, 201, 86, 20);
		contentPane.add(passReg);
		
		//passReg.setText("");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaRegistro.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		lblNewLabel.setBounds(0, 0, 344, 411);
		contentPane.add(lblNewLabel);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}