package lesson4.I_O;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Datei_anlegen {
	
	public static Path erzeugeDatei(Path dir, String fileName)
	{
		Path tmpFile = dir;
		tmpFile = tmpFile.resolve(fileName);
		try
		{
			if(!Files.exists(tmpFile))
			{
				Files.createFile(tmpFile);
			}			
		}
		catch(IOException e)
		{
			System.out.println("Probleme beim File erstellen: " + e.getMessage());
			e.printStackTrace();
		}
		return tmpFile;
	}

	public static void main(String[] args) {
		
		Path dir = Paths.get(System.getProperty("user.dir"));
		Path path = erzeugeDatei(dir, "newFile");
		System.out.println(path);

	}

}
