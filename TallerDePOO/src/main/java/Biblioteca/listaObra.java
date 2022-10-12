package Biblioteca;
import java.io.*;
import java.util.ArrayList;
public class listaObra {
	ArrayList<Obra> listaObras = new ArrayList<Obra>();
	
	public void guardar(Obra obra){
		listaObras.add(obra);
		guardarObras(obra);
	}
	
	public static void guardarObras(Obra obra){
		try {
			FileWriter crear = new FileWriter("/Registros/Obras.txt", true); //Crea archivo de texto
			BufferedWriter lector = new BufferedWriter(crear); //Se le pasa el archivo
			PrintWriter escribir = new PrintWriter(lector); //Imprime en el archivo
			escribir.print(" - " + obra.getCantEjem());
			escribir.print(" - " + obra.getCantEjemDisponible());
			escribir.print(" - " + obra.getTitulo());
			escribir.print(" - " + obra.getSubtitulo());
			escribir.print(" - " + obra.getAutor1());
			escribir.print(" - " + obra.getAutor2());
			escribir.print(" - " + obra.getAutor3());
			escribir.print(" - " + obra.getGenero());
			escribir.print(" - " + obra.getIsbn());
			escribir.print(" - " + obra.getId());
			escribir.print(" - " + obra.getArea());
			escribir.print(" - " + obra.getTipo());
			escribir.print(" - " + obra.getEjemplares());
			escribir.print(" - " + obra.getEdiciones());
			escribir.print(" - " + obra.getFuncionario());
			escribir.close();
		} catch (Exception e) {
		}
	}
}
