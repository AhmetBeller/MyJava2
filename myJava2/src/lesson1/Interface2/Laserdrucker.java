package lesson1.Interface2;

public class Laserdrucker implements Drucker {

	static int aufrufe = 0;
	private int lDruckerID;
	Laserdrucker(){
		aufrufe++;
		lDruckerID = aufrufe;
	}


	public void drucken(String druckRef) {
		 System.out.println("Drucker Laser" + lDruckerID + " meldet sich\n");
		 
		 System.out.println(drucksimulation);
		 System.out.println(druckRef + "\n");
		
	}

}


