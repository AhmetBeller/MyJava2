package lesson2.Exception2;

public class KeineAuszahlungMoeglichAusnahme extends Exception {
	
	public KeineAuszahlungMoeglichAusnahme()
	{
		super();
	}
	
	public KeineAuszahlungMoeglichAusnahme(String msg)
	{
		super(msg);
	}

}
