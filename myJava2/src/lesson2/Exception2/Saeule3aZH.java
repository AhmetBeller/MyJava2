package lesson2.Exception2;



public class Saeule3aZH implements ISaeule3a {
	
	public int berechneSteuerErsparnis(int steuerbahresEinkommen, int steuerbahresVermoegen, int einzahlungS3a) 
	   throws KeinAbzugMoeglichAusnahme{
		double ruekgabe = einzahlungS3a;
		if(steuerbahresEinkommen > 500000 && steuerbahresVermoegen > 1000000){
			return (int) (ruekgabe/3);
		} else if(steuerbahresEinkommen > 500000 && steuerbahresVermoegen <= 1000000){
			return (int) (ruekgabe/3.5);
		} else if(steuerbahresEinkommen > 200000 && steuerbahresEinkommen <= 500000){
			return (int) (ruekgabe/3.75);
		} else if(steuerbahresEinkommen >= 30000 && steuerbahresEinkommen <= 200000){
			return (int) (ruekgabe/3.95);
		}
		throw new KeinAbzugMoeglichAusnahme("Kein Abzug moeglich"); 
		
	}
	
	public int berechneKapitalSteuer(int kapitalS3a) 
		throws KeineAuszahlungMoeglichAusnahme{
		if (kapitalS3a>= 0){
			double ruekgabe = kapitalS3a;
			ruekgabe = ruekgabe/100*7.2;
			return (int) ruekgabe;
		}
		throw new KeineAuszahlungMoeglichAusnahme("Keine Auzahlung möglich");
		
	}

}
