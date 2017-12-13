package lesson1.Interface;
/**
 * 
 * @author Ahmet
 * @version 0.9
 */


public class Saeule3aZH implements ISaeule3a {
	
	public int berechneSteuerErsparnis(int steuerbahresEinkommen, int steuerbahresVermoegen, int einzahlungS3a) {
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
		return einzahlungS3a;
		
	}
	
	public int berechneKapitalSteuer(int kapitalS3a){
		if (kapitalS3a>= 0){
			double ruekgabe = kapitalS3a;
			ruekgabe = ruekgabe/100*7.2;
			return (int) ruekgabe;
		}
		return kapitalS3a;
		
	}

}
