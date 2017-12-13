package MLZ;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BenutzerAktionFilesystem implements IBenutzerAktion
{
	PrintWriter pw = null;
	List<String> protokollieren = new ArrayList<String>();
	
	// Prüfe welche Benutzeraktion ausgewählt ist und schreibe das Datum und die Uhrzeit in die Liste.
	@Override
	public void protokolliereBenutzerAktion(String benutzerAktion) throws BenutzerAktionException {
	
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
						
			if(benutzerAktion == Benutzer_Aktion_verschieben)
			{
				protokollieren.add(time.format(new Date())+" "+date.format(new Date())+" "+ Benutzer_Aktion_verschieben);
							
			}
			else if(benutzerAktion == Benutzer_Aktion_neues_Spiel)
			{
				protokollieren.add(time.format(new Date())+" "+date.format(new Date())+" "+Benutzer_Aktion_neues_Spiel);
				
			}
			else if(benutzerAktion == Benutzer_Aktion_erfolgreich_beendet)
			{
				protokollieren.add(time.format(new Date())+" "+date.format(new Date())+" "+Benutzer_Aktion_erfolgreich_beendet);
			}				
	
	}

	// Alle Benutzeraktionen werden in die Textdatei geschrieben. Ausserdem in eine Liste geschrieben und 
	// nach einem neuen Spielbeginn in die Konsole ausgegeben.
	@Override
	public void leseAllBenutzerAktion() throws BenutzerAktionException {
		
		String filename = "Protokoll.txt";
		Path tmpfile = Paths.get(System.getProperty("user.dir"));		
		
		tmpfile = tmpfile.resolve(filename); 
		try{
			if(!Files.exists(tmpfile)){
				Files.createFile(tmpfile);
			}
			else
			{
				Files.delete(tmpfile);
			}
			pw = new PrintWriter(new FileWriter(filename));
			Iterator iter = protokollieren.iterator();
			while(iter.hasNext())
			{
				 Object o = iter.next(); 
	             pw.println(o);
			}
			pw.close();
			
			
			for(String texte : protokollieren)
			{
				System.out.println(texte);
			}
		  }
			catch(Exception ex)
			{
				System.out.println("Das Lesen des Protokolls ist nicht möglich.");
			}	
		}
	}