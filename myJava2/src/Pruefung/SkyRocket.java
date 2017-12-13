package Pruefung;

public class SkyRocket extends Rocket{
	
	int effectPower = 0;

	SkyRocket(int effectPowerIn, int altitudeIn ){
		super(altitudeIn);
		effectPower = effectPowerIn;
		SkyRocket1();
	}
	
	
	public static void SkyRocket1(){
		System.out.println("The sky rocket is displaying a Yellow star effect...");
	}
	public static void produceEffect() {
		
	}
}
