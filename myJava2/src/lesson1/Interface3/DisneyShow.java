package lesson1.Interface3;

public class DisneyShow {
	
	private int anzahl = 5;
	private Zuschauer[] zuschauer = new Zuschauer[anzahl];
	private int arrayIndex = 0;
	
	public void addObserver(Zuschauer besucher)
	{
		if (arrayIndex < zuschauer.length)
		{
			zuschauer[arrayIndex] = besucher;
			arrayIndex++;
			System.out.println(besucher +" wurde registriert.");
		}
		else
		{
			System.out.println(besucher +" wurde nicht registriert.");
		}
	}
	
	public void deleteObservers()
	{
		zuschauer = new Zuschauer[anzahl];
	}
	
	public void deleteObserver(Zuschauer pZuschauer)
	{
		for(int i = 0; i < anzahl; i++)
		{
			if(zuschauer[i] == pZuschauer)
			{
				zuschauer[i] = null;
				System.out.println(pZuschauer + " hat sich deregistriert.");
				return;
			}
		}
	}
	
	public void notifyObserver()
	{
		for(Zuschauer temp: zuschauer)
		{
			if(temp != null)
			{
				temp.update();
			}
		}
	}
}
