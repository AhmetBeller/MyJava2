package lesson2.Rekursion;

public class Kaninchen_Fibonacci_Zahlen {

	public static void main(String[] args) 
	{
		for(int i = 1; i <= 12; i++)
		{
			System.out.println("Kaninchenpaar (Monat: "+i+") : " 
		+Kaninchen_Fibonacci_Zahlen.nextGen(i));
		}
	}
	
	static int nextGen(int i)
	{
		if (i <= 0)
			return 0;
		else if(i==1)
			return 1;
		else
			return nextGen(i-1) + nextGen(i-2);
	}

}
