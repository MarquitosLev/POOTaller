package Biblioteca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import BibliotecaGraficos.ventanaRegistro;

public class listaFuncionario {
	ArrayList<Funcionario> datosFunc = new ArrayList<Funcionario>();

	public void agregar(Funcionario obj) {
		guardarFuncionario(obj);
		datosFunc.add(obj);
	}
	
	public boolean existe(String user) {
		if(datosFunc.size() == 0) return false;
		for(int i = 0; i < datosFunc.size(); i++) {
			if(this.datosFunc.get(i).getUsuario().equals(user)){
				return true;
			}
		}
		return false;
	}
	
	public boolean comprobarContrasenia(String pass) {

		for(int i = 0; i < datosFunc.size(); i++) {
			if(this.datosFunc.get(i).getContrasenia().equals(pass)){
				return true;
			}
		}
		return false;
	}
	
	public static void guardarFuncionario(Funcionario funcionario){
		//File archivo = new File("G:\\Mi unidad\\Carrera\\Programación orientada a objetos\\GitHub\\POOTaller\\TallerDePOO\\src\\main\\java\\Registros\\Funcionarios.txt");
		//File archivo = new File("TallerDePOO\\Registros.Funcionarios.txt" );
		try {
			//if (!archivo.exists()) {
			//	archivo.createNewFile();
            //}
			FileWriter crear = new FileWriter("TallerDePOO\\Registros.Funcionarios.txt", true); //Crea archivo de texto
			BufferedWriter lector = new BufferedWriter(crear); //Se le pasa el archivo
			//PrintWriter escribir = new PrintWriter(crear); //Imprime en el archivo
			lector.write(" - " + funcionario.getUsuario());
			lector.write(" - " + funcionario.getContrasenia());
			lector.close();
		} catch (Exception e) {
		}
	}
	
	
}
