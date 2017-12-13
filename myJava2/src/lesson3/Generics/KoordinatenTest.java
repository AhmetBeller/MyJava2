package lesson3.Generics;

public class KoordinatenTest {
	
	public static void main(String[] args) 
	{
		Koordinate<Float> k1_float = new Koordinate<Float>(5.55f, 8.88f);
		Koordinate<Float> k2_float = new Koordinate<Float>(6.00f, 9.78f);
		
		Koordinate<Double> k1_double = new Koordinate<Double>(5.45, 2.25);
		Koordinate<Double> k2_double = new Koordinate<Double>(7.00, 10.11);
		
		System.out.println("Koordinaten1: "+ k1_float);
		System.out.println("Koordinaten1: "+ k2_float);
		System.out.println("---------------------------------");
		System.out.println("Koordinaten1: "+ k1_double);
		System.out.println("Koordinaten2: "+ k2_double);
	}
}
