package lesson2.Exception2;


public class Saeule3aSG implements ISaeule3a {
	/**
	 * Konstante Kapital Steuerfuss im Kanton SG
	 */
	private static final double KAPITAL_STEUERFUSS_SG = 8.75;
	/**
	 * @return enthaelt berechnete Steuerersparnis 
	 */
	public int berechneSteuerErsparnis(int steuerbahresEinkommen, int steuerbahresVermoegen, int einzahlungS3a) 
	throws KeinAbzugMoeglichAusnahme{
		double ruekgabe = einzahlungS3a;
		if(steuerbahresEinkommen > 0 && steuerbahresVermoegen > 0) {
			return (int) (ruekgabe/3.9);
		}
		throw new KeinAbzugMoeglichAusnahme("Kein Abzug moöglich");
	}
	
	public int berechneKapitalSteuer(int kapitalS3a)
	throws KeineAuszahlungMoeglichAusnahme{
		if (kapitalS3a>= 0){
			double ruekgabe = kapitalS3a;
			ruekgabe = ruekgabe/100*KAPITAL_STEUERFUSS_SG;
			return (int) ruekgabe;
		}
		throw new KeineAuszahlungMoeglichAusnahme("Keine Auzahlung möglich");
		
	}
}
