package lesson1.Interface2;

public class Faxgeraet  implements Fax{

	static int aufrufe = 0;
	private int faxID;
	Faxgeraet(){
		aufrufe++;
		faxID = aufrufe;
	}
	
	public void senden(String sendeRef) {
		 System.out.println("Absender ist: Fax" + faxID + "\n");
		 
		 System.out.println(faxsimulation);
		 System.out.println(sendeRef + "\n");
	}

}
