package lesson2.Exception2;


public interface ISaeule3a {
	/**
	 * Berechnung der Steuerersparnis, wenn in die S3a einbezahlt wird.
	 * @param steuerbahresEinkommen
	 * @param steuerbahresVermoegen
	 * @param einzahlungS3a
	 * @return
	 */
	int berechneSteuerErsparnis(int steuerbahresEinkommen, int steuerbahresVermoegen, int einzahlungS3a)
	throws KeinAbzugMoeglichAusnahme;
			
	
	/**
	 * Berechne der Kapitalsteuer, wenn das Kapital der S3a ausbezahlt wird.
	 * @param kapitalS3a
	 * @return
	 */
	int berechneKapitalSteuer(int kapitalS3a)
	throws KeineAuszahlungMoeglichAusnahme;
	
	}
			

