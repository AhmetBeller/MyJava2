package lesson4.Streams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Datein_erzeugen_kopieren_loeschen {
	
	//Datei erzeugen
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
	// Verzeichnis erzeugen
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
	
	// Datei kopieren
		public static void kopieren(Path sourcePath, Path targetPath) {
			System.out.println("Copy from " + sourcePath.toAbsolutePath() + " to "	+ targetPath.toAbsolutePath());
			try {
				Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);// Falls die Ziel Datei bereit existiert wird diese ersetzt
				//Files.copy(sourcePath, targetPath, StandardCopyOption.COPY_ATTRIBUTES);// Dateiatribute werden mitkopiert (Originales Erstelldatum usw.)
			} catch (IOException e) {
				System.err.println("sourceFile nicht gefunden!");
				e.printStackTrace();
			}
		}
	
	// Loesche Verzeichnis oder Datei
		public static void loesche(Path file){
			try {
				if (Files.exists(file)){
					Files.delete(file);
				}else{
					System.err.println("Objekt nicht vorhanden!");
				}
			}catch (IOException e){
				System.err.println("Probleme beim Loeschen: " + e.getMessage());
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		
		Path path = erzeugeVerzeichnis("tmp");
		Path aktuellpath = erzeugeDatei(path, "test_datei_1.txt");
		System.out.println(path);
		//-----------------------------------------------------------------------	
		FileWriter fw;
		PrintWriter pw = null;
		try
		{
			fw = new FileWriter(aktuellpath.toFile());
			pw = new PrintWriter(fw);
			pw.println("Ein wenig Text.\n Noch mehr Text");			
		}		
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		pw.close();
		//------------------------------------------------------------------------
		FileSystem filesystem = FileSystems.getDefault();
		Path sourcepath = aktuellpath;
		Path targetpath = erzeugeDatei(path, "test_datei_2.txt");
		kopieren(sourcepath, targetpath);
		//-----------------------------------------------------------------------
		Path deleteObject = aktuellpath;
		loesche(deleteObject);
	}

}
