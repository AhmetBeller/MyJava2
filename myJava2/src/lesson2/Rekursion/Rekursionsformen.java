package lesson2.Rekursion;

public class Rekursionsformen {
	
	public static void stepDown1(int n)
	{
		if (n==0)
		{
			return;
		}
		System.out.print(n + ", ");
		stepDown1(n-1);
	}
	
	public static void stepDown2(int n)
	{
		if (n==0)
		{
			return;
		}
		stepDown2(n-1);
		System.out.print(n + ", ");
	}
	

	public static void main(String[] args) {
		
		//stepDown1(10);
		stepDown2(10);
	}
}
