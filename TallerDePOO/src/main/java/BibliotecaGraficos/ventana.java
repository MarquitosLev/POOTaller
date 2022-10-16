package BibliotecaGraficos;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import Biblioteca.Funcionario;
import Biblioteca.listaFuncionario;

import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.script.*;

public class ventana extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField contrasenia;
	private listaFuncionario listaFunc;
	
	//PRINCIPAL
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor que crea ventana
	public ventana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/imagenes/icon.png")));
		listaFunc = new listaFuncionario();
		ventanaRegistro frameReg = new ventanaRegistro(listaFunc, ventana.this);
		ventanaInicio(frameReg, listaFunc);
	}

	public void ventanaInicio(final ventanaRegistro frameReg, final listaFuncionario listaFunc) {
		setTitle("Iniciar Sesi\u00F3n\r\n");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ventana.class.getResource("/imagenes/icono.png")));
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setFont(new Font("Dubai", Font.BOLD, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(124, 11, 96, 111);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(129, 189, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(129, 133, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u00BFNo tiene una cuenta? \r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(48, 363, 132, 21);
		contentPane.add(lblNewLabel);
		
		//FUNCIONARIO
		//Contrasenia
		contrasenia = new JPasswordField();
		contrasenia.setEchoChar('*');
		contrasenia.setBounds(129, 214, 86, 20);
		contentPane.add(contrasenia);
		
		//Usuario
		usuario = new JTextField();
		usuario.setBounds(129, 158, 86, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		/*Botones*/
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.this.setVisible(false);//Pone invisible la ventana anterior
				frameReg.setVisible(true); //Pone visible la ventana de Registro
			}

		});
		btnRegistrarse.setBounds(189, 361, 108, 23);
		contentPane.add(btnRegistrarse);
		
		
		
		JButton btnInicioSesion = new JButton("Iniciar Sesi\u00F3n");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Inicio de Sesion
				
				
				String user = usuario.getText();
				String pass = new String(contrasenia.getPassword());
				
				if(listaFunc.existe(user) && listaFunc.comprobarContrasenia(pass)) {
					ventanaPrincipal framePrincipal = new ventanaPrincipal();
					ventana.this.setVisible(false);
					framePrincipal.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "No se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
					usuario.setText("");
					contrasenia.setText("");
				}
				
			}
		});
		btnInicioSesion.setBounds(111, 269, 121, 37);
		contentPane.add(btnInicioSesion);
		/*Botones*/
		
		
		//Fondo
		JLabel fondoIS = new JLabel("");
		fondoIS.setIcon(new ImageIcon(ventana.class.getResource("/imagenes/fondoInicioSesion.jpg")));
		fondoIS.setBounds(0, 0, 344, 411);
		contentPane.add(fondoIS);
		
	}

}