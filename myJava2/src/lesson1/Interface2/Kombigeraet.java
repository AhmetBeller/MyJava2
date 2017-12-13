package lesson1.Interface2;

public class Kombigeraet implements Drucker, Fax {

	static int aufrufe = 0;
	private int kombiID;
	Kombigeraet(){
		aufrufe++;
		kombiID = aufrufe;
	}


	public void drucken(String druckRef) {
		 System.out.println("Kombigeraet" + kombiID + " meldet sich\n");
		 
		 System.out.println(drucksimulation);
		 System.out.println(druckRef + "\n");	
	}

	@Override
	public void senden(String sendeRef) {
		 System.out.println("Absender ist: Kombigeraet" + kombiID + "\n");
		 
		 System.out.println(faxsimulation);
		 System.out.println(sendeRef + "\n");	
	}
}



