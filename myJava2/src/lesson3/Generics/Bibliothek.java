
package lesson3.Generics;

import java.util.ArrayList;
import java.util.Collections;

import lesson3.Generics.AutorComparator;

//Aufgaben a) & b)
public class Bibliothek {
	
	 ArrayList<Buch> buecherListe = new ArrayList<Buch>();
	
	public Bibliothek()
	{	
	}
	
	public void init()
	{
		buecherListe.add(new Buch ("Lord of the Rings" , "Ahmet" , "Deutsch" , 800));
		buecherListe.add(new Buch ("JAVA macht Spass" , "Samet" , "Englisch" , 600));
		buecherListe.add(new Buch ("C# Programmieren" , "Beller" , "Deutsch" , 500));
		buecherListe.add(new Buch("SQL-Server" , "Beller Ahmet" , "Engisch" , 400));
		buecherListe.add(new Buch ("LABVIEW für Anfänger" , "Hans Müller" , "Deutsch" , 400));
	}
	
	public void addBuch(Buch buch)
	{
		buecherListe.add(buch);
	}
	
	public void printListe()
	{
		for(Buch buch : buecherListe)
			System.out.println(buch.get_titel() +", "+ buch.get_autor() +", "+ 
		buch.get_sprache() +", "+ buch.get_seitenzahl());
	}
	
	public void sortiereBucher()
	{
		// Aufruf ohne Comparator sortiert nach Titel (siehe Comparable Interface in der Buch Klasse)
	    // Aufruf mit AutorComparator sortiert nach Autor (es könnte auch ein zweiter Comparator für Titel 
		// implementiert werden und dabei das Comparable Interface in der Buch Klasse gelöscht werden)
		AutorComparator autorComparator = new AutorComparator();
		//autorComparator.compare(buecherListe.get(0), buecherListe.get(4));
		Collections.sort(buecherListe, autorComparator);
	}
	
	public static void main(String[] args) 
	{
		Bibliothek bibliothek = new Bibliothek();
		bibliothek.init();
		bibliothek.sortiereBucher();
		bibliothek.printListe();
	}
}
