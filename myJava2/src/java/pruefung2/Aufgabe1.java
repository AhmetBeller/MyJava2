package java.pruefung2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Aufgabe1 {

	static PrintWriter pw;
	static int wert;
	private static Scanner sc;
		
	public static Integer zahlen(int wert)
	{
		try{
								
			FileWriter fw = new FileWriter("Zahlengolge.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);					
			
			for(int i= 1; i < wert ; i++)
			{	
				pw.println("Pruefung Aufgabe 1");
				pw.println(wert);								
			}				
		pw.close();
	}
	catch(IOException e)
	{
		System.out.println("Fehler beim erstellen der Datei");		
	}
		return null;
	}
	
	public static void main(String[] args)
	{
		
		sc = new Scanner(System.in);
		System.out.print("Gebe die Gesamtzeilen an: " +sc);
		String zahl = sc.next();
		wert = Integer.parseInt(zahl);
		zahlen(wert);
	}
		
}
