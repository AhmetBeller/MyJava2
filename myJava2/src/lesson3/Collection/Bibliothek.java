package lesson3.Collection;

import java.util.ArrayList;
import java.util.Collections;

//Aufgaben a) & b)
public class Bibliothek {
	
	 ArrayList<String> buecherListe = new ArrayList<String>();
	
	public Bibliothek()
	{	
	}
	
	public void init()
	{
		buecherListe.add(("Lord of the Rings"));
		buecherListe.add(("JAVA macht Spass"));
		buecherListe.add(("C# Programmieren"));
		buecherListe.add(("SQL-Server"));
		buecherListe.add(("LABVIEW für Anfänger"));
	}
	
	public void addBuch(String buch)
	{
		buecherListe.add(buch);
	}
	
	public void printListe()
	{
		for(String buch : buecherListe)
			System.out.println(buch);
	}
	
	public void sortiereBucher()
	{
		Collections.sort(buecherListe);
	}
	
	public static void main(String[] args) 
	{
		Bibliothek bibliothek = new Bibliothek();
		bibliothek.init();
		bibliothek.sortiereBucher();
		bibliothek.printListe();
		
	}
}
