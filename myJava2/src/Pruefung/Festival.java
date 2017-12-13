package Pruefung;

public class Festival {

	public static void main(String[] args) {
		
		Firework[] fireworks = new Firework[3];
		
		fireworks[0] = new Fountain();
		fireworks[1] = new SkyRocket(100,250);
		fireworks[2] = new BottleRocket(30);
		
		showFirework(fireworks);
		System.out.println("The show is over");

	}

	public static void showFirework(Firework[] fireworks) {

	}

}
