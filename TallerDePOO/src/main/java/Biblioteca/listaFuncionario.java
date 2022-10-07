package Biblioteca;

import java.util.ArrayList;

public class listaFuncionario {
	ArrayList<Funcionario> datosFunc = new ArrayList<Funcionario>();

	public void agregar(Funcionario obj) {
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
	
	
}
