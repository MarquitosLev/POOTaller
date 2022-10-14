package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import BibliotecaGraficos.ventanaRegistro;

public class listaFuncionario {
	ArrayList<Funcionario> datosFunc = new ArrayList<Funcionario>();
	File functxt= new File ("Funcionarios.txt");
	
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
	
	public void guardarFuncionario(Funcionario funcionario){
		try {
			if (!functxt.exists()) {	//Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
            }
			BufferedWriter lector = new BufferedWriter(new PrintWriter(functxt)); //Escribe los datos asignados
			lector.write(" - " + funcionario.getUsuario());
			lector.write(" - " + funcionario.getContrasenia());
			lector.close();
		} catch (Exception e) {
		}
		//mostrararchivos();
	}
	/*public static void mostrararchivos() {
		try
        {
            FileReader fr=new FileReader("Funcionarios.txt");
            BufferedReader br=new BufferedReader(fr);
            String cadena;
            while((cadena=br.readLine())!=null) //cuando en la siguiente linea leída no haya nada significa que terminó de leer los datos del archivo
            {
                System.out.println(""+cadena); 
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
		}
	*/
	
}
