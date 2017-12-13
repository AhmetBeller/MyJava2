package lesson1.Interface3;

public class Testklasse {
	
	public static void main(String[] args) {
		
		DisneyShow show = new DisneyShow();
		Zuschauer fritz = new Parkbesucher("Fritz");
		Zuschauer franz = new Parkbesucher("Franz");
		Parkbesucher frieda = new Parkbesucher("Frieda");
		Parkbesucher hans = new Parkbesucher("Hans");
		Parkbesucher heinz = new Parkbesucher("Heinz");
		Parkbesucher hanna = new Parkbesucher("Hanna");
		
		show.addObserver(fritz);
		show.addObserver(franz);
		show.addObserver(frieda);
		show.addObserver(hans);
		show.addObserver(heinz);
		show.addObserver(hanna);
		
		System.out.println("\nJetzt wird in der Show ein Spezialeffekt gezeigt");
		show.notifyObserver();
		show.deleteObserver(franz);
		System.out.println("\nJetzt wird in der Show noch ein Spezialeffekt gezeigt");
		show.notifyObserver();
	}

}
