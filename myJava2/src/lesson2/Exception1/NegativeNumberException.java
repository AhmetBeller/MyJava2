package lesson2.Exception1;


public class NegativeNumberException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8610748962625192515L;

	public NegativeNumberException()
	{
		super();
	}

	public  NegativeNumberException(String msg){
		super(msg);
	}

}
