package lesson4.Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

public class Zufallszahlen {
	
	static PrintWriter pw;
	static double wert;
	public static Double zufallszahlen(double wert)
	{
		try{
			FileWriter fw = new FileWriter("Zufallszahlen.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);					
			
			for(int i= 0; i<10; i++)
			{
				double zufall = Math.random()*3;
				pw.println(zufall);				
			}				
		pw.close();
	}
	catch(IOException e)
	{
		System.out.println("Fehler beim erstellen der Datei");		
	}
		return null;
	}
	
	 public static void zeilenleser(double wert)
	 {
		 double durch = 0;
		 double sum = 0;
		 int i = 0;
		 Path path = Paths.get("Zufallszahlen.txt");
		 try{
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);			
			String line;			
			while((line = reader.readLine())!= null)
			{	
				System.out.println("Zeile " + ++i + "   " +line);
				double zahlen = Double.parseDouble(line);
				sum = sum + zahlen;
				System.out.println("");
				System.out.println("Die Summe beträgt: " + sum);
				durch = sum/wert;
				System.out.println("Der Durchschnitt beträgt: " + durch);
			}					
					
		 }
		 catch(IOException e)
		 {
			 System.err.print(e);
		 }
	 			
	 }
	
 public static void main(String[] args) 
 
 	{		
	 	zufallszahlen(10);
	 	//zeilenleser(10);
	}

}
