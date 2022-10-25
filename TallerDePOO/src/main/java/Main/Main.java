package Main;

import java.awt.EventQueue;

import BibliotecaGraficos.ventana;
/**
 * 
 * @author Grupo 8
 *
 */
public class Main {

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

}
