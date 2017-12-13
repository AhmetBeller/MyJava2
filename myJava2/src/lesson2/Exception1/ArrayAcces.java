package lesson2.Exception1;


public class ArrayAcces {
	
	public static int accessArray (int[] array, int index)
	{
				
		try
			{ 
				index = array[index];
				
				System.out.print("Index "+index+ " ist verfügbar.");					
								
			}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.print("Index "+ index +" liegt ausserhalb der Array Grenze");
		}
		return index;
	  }
	
	
	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		accessArray(array, 1);
		
		
	}

}
