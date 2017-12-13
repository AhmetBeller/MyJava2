package lesson1.Interface;
/**
 * 
 * @author Michael
 * @version 0.9
 */

public class Saeule3aSG implements ISaeule3a {
	/**
	 * Konstante Kapital Steuerfuss im Kanton SG
	 */
	private static final double KAPITAL_STEUERFUSS_SG = 8.75;
	/**
	 * @return enthaelt berechnete Steuerersparnis 
	 */
	public int berechneSteuerErsparnis(int steuerbahresEinkommen, int steuerbahresVermoegen, int einzahlungS3a) {
		double ruekgabe = einzahlungS3a;
		if(steuerbahresEinkommen > 0 && steuerbahresVermoegen > 0) {
			return (int) (ruekgabe/3.9);
		}
		return einzahlungS3a; 
	}
	
	public int berechneKapitalSteuer(int kapitalS3a){
		if (kapitalS3a>= 0){
			double ruekgabe = kapitalS3a;
			ruekgabe = ruekgabe/100*KAPITAL_STEUERFUSS_SG;
			return (int) ruekgabe;
		}
		return kapitalS3a;
		
	}
}
