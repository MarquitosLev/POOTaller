package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import BibliotecaGraficos.ventanaRegistro;

public class listaFuncionario {
	ArrayList<Funcionario> datosFunc;
	ArrayList<Lector> datosLector;
	public void agregar(Funcionario obj) {
		guardarFuncionario(obj);
	}
	
	public boolean existe(String user) {
		datosFunc = new ArrayList<Funcionario>();
		try {
			FileReader fr = new FileReader("Funcionarios.txt");
			BufferedReader br = new BufferedReader(fr);
			String lector;
			while ((lector=br.readLine()) !=null) {			//Lee el archivo hasta el siguiente salto de linea
				StringTokenizer X = new StringTokenizer(lector, "-");  //Se crea un String hasta que aparezca el "-"
				datosFunc.add(new Funcionario(X.nextToken(), X.nextToken()));   
			}
		} catch (Exception e) {
		}
		if(datosFunc.size() == 0) return false;
		for(int i = 0; i < datosFunc.size(); i++) {		//Recorre el ArrayList hasta encontrar alguna coincidencia
			if(datosFunc.get(i).getUsuario().equals(user)){
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
	
	public void guardarFuncionario(Funcionario funcionario){
		try {
			File functxt = new File("Funcionarios.txt");
			if (!functxt.exists()) {	//Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
            }
			FileWriter fw= new FileWriter ("Funcionarios.txt", true);
			BufferedWriter br = new BufferedWriter(fw); //Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(funcionario.getUsuario()+"-");
			escribir.write(funcionario.getContrasenia() + "-"+"\n");
			escribir.close();
		} catch (Exception e) {
		}
	}
	
	public void guardarLector(Lector lector){
		try {
			File functxt = new File("Lectores.txt");
			if (!functxt.exists()) {	//Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
            }
			FileWriter fw= new FileWriter ("Lectores.txt", true);
			BufferedWriter br = new BufferedWriter(fw); //Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.write(lector.getNom()+"-");
			escribir.write(lector.getApellido() + "-");
			escribir.write(lector.getTipDoc() + "-");
			escribir.write(lector.getNumDoc() + "-");
			escribir.write(lector.getCorreo() + "-");
			escribir.write(lector.getNumCel() + "-");
			escribir.write(lector.getFecNac() + "-");
			escribir.write(lector.getSex() + "-");
			escribir.write(lector.getDomi() + "-");
			escribir.write(lector.getCodPos() + "-");
			escribir.write(lector.getDep() + "-");
			escribir.write(lector.getLocalidad() + "-");
			escribir.write(lector.getCanMulta() + "-");
			escribir.write(lector.getEstaMultado() + "-");
			for (int i = 0; i<lector.getEjemplar().size(); i++) {
				escribir.write(lector.getEjemplar().get(i) + "-");
			}
			System.out.println(escribir);
			escribir.close();
		} catch (Exception e) {
		}
	}
	
}
