package lesson4.Streams;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		
		FileReader fr;
		int c;
		try
		{
			fr = new FileReader("Hallo.txt");
			while ((c=fr.read())!= -1)
			{
				System.out.print((char) c);
			}
			fr.close();
		}catch (IOException e)
		{
			System.out.println("Scheisse");
		}
	}

}
