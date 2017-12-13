package lesson4.I_O;

import java.io.IOException;
import java.nio.file.*;

public class Verzeichnis_anlegen {
	
	public static Path erzeugeVerzeichnis(String subDir)
	{
		Path tmpPath = Paths.get(System.getProperty("user.dir"));
		tmpPath = tmpPath.resolve(subDir);
		try
		{
			if(!Files.exists(tmpPath))
			{
				Files.createDirectory(tmpPath);
			}			
		}
		catch(IOException e)
		{
			System.out.println("Probleme beim Verzeichnis erstellen: " + e.getMessage());
			e.printStackTrace();
		}
		return tmpPath;
	}

	public static void main(String[] args) {
		
		Path path = erzeugeVerzeichnis("newDirectory");
		System.out.println(path);
	}

}
