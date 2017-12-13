package lesson2.Exception2;


public class Steuerverwaltung {

	private ISaeule3a saeule3a;
	private int steuerbahresEinkommen;
	private int steuerbahresVermoegen;
	private int einzahlungS3a;
	private int kapitalS3a;

	Steuerverwaltung(int steuerbahresEinkommen, int steuerbahresVermoegen, int einzahlungS3a, int kapitalS3a) {
		this.steuerbahresEinkommen = steuerbahresEinkommen;
		this.steuerbahresVermoegen = steuerbahresVermoegen;
		this.einzahlungS3a = einzahlungS3a;
		this.kapitalS3a = kapitalS3a;
	}

	public void definiereKanton(String kantonCode) {
		if (kantonCode != null && kantonCode.equals("ZH")) {
			saeule3a = new Saeule3aZH();
		} else if (kantonCode != null && kantonCode.equals("SG")) {
			saeule3a = new Saeule3aSG();
		}
	}

	public int getSteuerersparnisS3a() throws KeinAbzugMoeglichAusnahme {
		return saeule3a.berechneSteuerErsparnis(steuerbahresEinkommen,
				steuerbahresVermoegen, einzahlungS3a);
	}

	public int getKapitalsteuer() throws KeineAuszahlungMoeglichAusnahme {
		return saeule3a.berechneKapitalSteuer(kapitalS3a);
	}
	

	public static void main(String[] args) 
	{
		try
		{
			
		Steuerverwaltung testZH1 = new Steuerverwaltung(600000, 500000, 6000, 850000);
		testZH1.definiereKanton("ZH");
		System.out.println("Steuerersparnis ZH 1. Fall: " + testZH1.getSteuerersparnisS3a() + ", Kapilalsteuer: " + testZH1.getKapitalsteuer());
		
		Steuerverwaltung testZH2 = new Steuerverwaltung(100000, 100000, 6670, 700000);
		testZH2.definiereKanton("ZH");
		System.out.println("Steuerersparnis ZH 2. Fall: " + testZH2.getSteuerersparnisS3a() + ", Kapilalsteuer: " + testZH2.getKapitalsteuer());
		
		Steuerverwaltung testZH3 = new Steuerverwaltung(30000, 0, 4000, 655000);
		testZH3.definiereKanton("ZH");
		System.out.println("Steuerersparnis ZH 3. Fall: " + testZH3.getSteuerersparnisS3a() + ", Kapilalsteuer: " + testZH3.getKapitalsteuer());
		
		Steuerverwaltung testZH4 = new Steuerverwaltung(400000, 20000, 5500, 390000);
		testZH4.definiereKanton("ZH");
		System.out.println("Steuerersparnis ZH 4. Fall: " + testZH4.getSteuerersparnisS3a() + ", Kapilalsteuer: " + testZH4.getKapitalsteuer());
		
		Steuerverwaltung testSG1 = new Steuerverwaltung(600000, 500000, 6000, 850000);
		testSG1.definiereKanton("SG");
		System.out.println("Steuerersparnis SG 1. Fall: " + testSG1.getSteuerersparnisS3a() + ", Kapilalsteuer: " + testSG1.getKapitalsteuer());
	}
		catch (KeinAbzugMoeglichAusnahme ex)
		{			
			System.out.println(ex.getMessage());
		}
		catch (KeineAuszahlungMoeglichAusnahme ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
