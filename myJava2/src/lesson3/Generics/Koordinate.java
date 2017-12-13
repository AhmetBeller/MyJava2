package lesson3.Generics;

public class Koordinate<T> {

	private T a;
	private T b;
	
	public Koordinate(T a, T b)
	{
		this.a = a;
		this.b = b;
	}
	
	public T getX()
	{
		return a;
	}
	
	public void setX(T a)
	{
		this.a = a;
	}
	
	public T getY()
	{
		return b;
	}
	
	public void setY(T b)
	{
		this.b = b;
	}
	
	public String toString()
	{
		return ("x = " + a + " ,y = " + b);
	}
}
