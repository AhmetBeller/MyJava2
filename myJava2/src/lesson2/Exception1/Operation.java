package lesson2.Exception1;

public class Operation {

	public static double Wurzel(double x) throws NegativeNumberException
	{
	  if(x < 0)
		  {
		  throw new NegativeNumberException("Üngültige Eingabe: Ihre Eingabe ist eine negative Zahl");
		  }
	  else
	  {
		  return Math.sqrt(x);
	  }
	}
	
	public static void main(String[] args)
	{
		try 
		{
			double erg = Operation.Wurzel(-25);
			System.out.println("Ergebnis ist: " + erg);
		}
		catch (NegativeNumberException ex)
		{
			System.out.println(ex.getMessage());
     		ex.printStackTrace();
		}
		
	}
}
