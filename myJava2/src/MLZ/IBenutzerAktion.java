package MLZ;


import java.util.Collection;

public interface IBenutzerAktion 
{
	String Benutzer_Aktion_verschieben = "Ein Feld verschoben";
	String Benutzer_Aktion_neues_Spiel = "Neues Spiel begonnen";
	String Benutzer_Aktion_erfolgreich_beendet = "Spiel erfolgreich beendet";
	
	void protokolliereBenutzerAktion(String benutzerAktion) throws 
	BenutzerAktionException;
	
	void leseAllBenutzerAktion() throws
	BenutzerAktionException;
}
