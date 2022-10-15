package Biblioteca;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class listaObra {
	ArrayList<Obra> listaObras;
	
	public void guardar(Obra obra){
		guardarObras(obra);
	}
	/*public boolean existe(String user) {
		listaObras = new ArrayList<Obra>();
		try {
			FileReader fr = new FileReader("Obras.txt");
			BufferedReader br = new BufferedReader(fr);
			String lector;
			while ((lector=br.readLine()) !=null) {			//Lee el archivo hasta el siguiente salto de linea
				StringTokenizer X = new StringTokenizer(lector, "-");  //Se crea un String hasta que aparezca el "-"
				listaObras.add(new Obra(X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken(), X.nextToken()));   
			}
		} catch (Exception e) {
		}
		if(listaObras.size() == 0) return false;
		for(int i = 0; i < listaObras.size(); i++) {		//Recorre el ArrayList hasta encontrar alguna coincidencia
			if(listaObras.get(i).getUsuario().equals(user)){
				return true;
			}
		}
		return false;
	}*/
	public static void guardarObras(Obra obra){
		try {
			File functxt = new File("Obras.txt");
			if (!functxt.exists()) {	//Crea el archivo txt en caso de que no exista
				functxt.createNewFile();
            }
			FileWriter crear = new FileWriter("Obras.txt", true); //Crea archivo de texto
			BufferedWriter br = new BufferedWriter(crear); //Escribe los datos asignados
			PrintWriter escribir = new PrintWriter(br);
			escribir.print(obra.getCantEjem()+"-");
			escribir.print(obra.getCantEjemDisponible()+"-");
			escribir.print(obra.getTitulo()+"-");
			escribir.print(obra.getSubtitulo()+"-");
			escribir.print(obra.getAutor1()+"-");
			escribir.print(obra.getAutor2()+"-");
			escribir.print(obra.getAutor3()+"-");
			escribir.print(obra.getGenero()+"-");
			escribir.print(obra.getIsbn()+"-");
			escribir.print(obra.getId()+"-");
			escribir.print(obra.getArea()+"-");
			escribir.print(obra.getTipo()+"-");
			escribir.print(obra.getEjemplares()+"-");
			escribir.print(obra.getEdiciones()+"-");
			escribir.print(obra.getFuncionario()+"-");
			escribir.close();
		} catch (Exception e) {
		}
	}
	}
