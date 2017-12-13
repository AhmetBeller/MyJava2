package lesson1.Interface3;

public class Parkbesucher implements Zuschauer {

	private String name;
	public Parkbesucher(String name)
	{
		this.name = name;
	}
	
	public void update()
	{
		int zufallszahl = ((int) (Math.random() * 10));
		if(zufallszahl < 5)
		{
			System.out.println(name + " sagt: \"Wow! \"");
		}
		else
		{
			System.out.println(name + " sagt: \"Cool! \"");
		}
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
