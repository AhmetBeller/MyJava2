package lesson3.Generics;

public class Buch implements Comparable<Buch> {
	
	private String titel;
	private String autor;
	private String sprache;
	private int seitenzahl;
	
	public Buch(String titel, String autor, String sprache, int seitenzahl)
	{
		this.titel = titel;
		this.autor = autor;
		this.sprache = sprache;
		this.seitenzahl = seitenzahl;
	}
	
	public String get_titel()
	{
		return titel;
	}
	
	public void set_titel(String titel)
	{
		this.titel = titel;
	}
	
	public String get_autor()
	{
		return autor;
	}
	
	public void set_autor(String autor)
	{
		this.autor = autor;
	}
	
	public String get_sprache()
	{
		return sprache;
	}
	
	public void set_sprache(String sprache)
	{
		this.sprache = sprache;
	}
	
	public int get_seitenzahl()
	{
		return seitenzahl;
	}
	
	public void set_seitenzahl(int seitenzahl)
	{
		this.seitenzahl = seitenzahl;
	}
	
	public int compareTo(Buch b) // sortiert nach Titel
	{
		return titel.compareTo(b.get_titel());
	}


}
