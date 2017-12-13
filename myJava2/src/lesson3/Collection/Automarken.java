package lesson3.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Automarken {

	private static List <String> marken = new ArrayList<String>();
	
	private static void init_automarken()
	{
		marken.add("Audi");
		marken.add("Nissan");
		marken.add("Kia");
		marken.add("Porsche");
		marken.add("Toyota");
		marken.add("BMW");
	}
	
	public static void pruefe_automarken(String auto)
	{
		if(marken.contains(auto))
		{
			System.out.println("Die Marke ist in der Liste enthalten: " + auto);
		}
		else
		{
			System.out.println("Sorry! Keine Marke gefunden!");
		}
	}
	
	public static void loeschen_automarken()
	{
		System.out.println("Die Liste entählt: " + marken.size()+ " Elemente");
		marken.remove(marken.size() -1 );
		System.out.println("Die Liste entählt: " + marken.size()+ " Elemente");
	}
	
	private static List<String> erstellen_subliste(int startIndex, int endIndex)
	{
		if((startIndex <= endIndex) && (startIndex >= 0) && (marken != null) && (endIndex < marken.size()-1))
		{
			List<String> subList = marken.subList(startIndex, endIndex);
			return subList;
		}
		return marken;	
	}
	
	private static void iterator()
	{
		int startIndex = 0;
		int endIndex = 2;
		
		List<String> subList = erstellen_subliste(startIndex, endIndex);
		System.out.println("**** Iteration mit foreach durch die Liste ++++");
		for (String auto : subList) 
		{
			System.out.println(auto);
		}
		
		System.out.println("**** Automatische Iteration durch die Liste (toString() der Liste) ****");
		System.out.println(subList);
	}
	
	public static void main(String[] args) 
	{
		init_automarken();
		pruefe_automarken("Audi");
		pruefe_automarken("Mercedes");
		pruefe_automarken("Kia");		
		loeschen_automarken();	
		iterator();
	
	}
	
}
