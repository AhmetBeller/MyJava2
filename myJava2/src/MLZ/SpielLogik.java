package MLZ;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class SpielLogik 
{	
	public static int zeileoderspalte = 4;
	public  Integer[][] spielfeld;
	private Integer leeresspielfeld_zeile;
	private Integer leeresspielfeld_spalte;
	private Integer anzahlzuege;
	
	
	public Integer[][] getSpielfeld() // get Methode
	{
		return spielfeld;
	}
	
	public Integer getAnzahlZuege()
	{
	 return anzahlzuege;
	}
			
	private void tausche(SpielfeldKoordinate selektiertesFeld)
	{	
		spielfeld[leeresspielfeld_zeile][leeresspielfeld_spalte]=spielfeld[selektiertesFeld.getZeile()][selektiertesFeld.getSpalte()];
		spielfeld[selektiertesFeld.getZeile()][selektiertesFeld.getSpalte()]=null;
		leeresspielfeld_zeile=selektiertesFeld.getZeile();
		leeresspielfeld_spalte=selektiertesFeld.getSpalte();
	}

	public boolean verschiebeZahl(SpielfeldKoordinate selektiertesFeld)
	{
		
		if (leeresspielfeld_zeile == selektiertesFeld.getZeile()){
			if ((leeresspielfeld_spalte == selektiertesFeld.getSpalte()- 1) ||(leeresspielfeld_spalte == selektiertesFeld.getSpalte()+ 1))
			{
				tausche(selektiertesFeld);
				anzahlzuege++;
			}
		}
		else if(leeresspielfeld_spalte == selektiertesFeld.getSpalte()){
			if ((leeresspielfeld_zeile == selektiertesFeld.getZeile()- 1) ||(leeresspielfeld_zeile == selektiertesFeld.getZeile()+ 1))
			{	
				tausche(selektiertesFeld);
				anzahlzuege++;
			}
		}
		return spielIstFertigUndKorrekt();
	}
	
	private boolean spielIstFertigUndKorrekt()
	{
		Integer zahl = 1;
		for (int z=0; z<zeileoderspalte; z++)
		{
			for (int s=0; s<zeileoderspalte; s++)
			{
				if (spielfeld[z][s] != zahl)
						return false;
				zahl++;
				if (zahl == (zeileoderspalte * zeileoderspalte))
					return true;
			}
		}
		return true;	
	}
	
	public void erstelleNeuesSpielfeld(int anzahlSpaltenoderZeilen)
	{	
		anzahlzuege = 0;
		if(anzahlSpaltenoderZeilen>0)
		{
			List<Integer> zahlen = new ArrayList<Integer>();
			int maximum = anzahlSpaltenoderZeilen * anzahlSpaltenoderZeilen;
			for(int i =1; i<=maximum; i++)
			{
				zahlen.add(i);
				Collections.shuffle(zahlen);
			}
			
			spielfeld = new Integer[anzahlSpaltenoderZeilen][anzahlSpaltenoderZeilen];
			for(int i = 0; i<anzahlSpaltenoderZeilen; i++){
				for(int j = 0; j<anzahlSpaltenoderZeilen; j++){
					spielfeld[i][j] = zahlen.get(i * anzahlSpaltenoderZeilen + j);
					if(spielfeld[i][j] == maximum)
					{
						spielfeld[i][j] = null;
						leeresspielfeld_zeile = i;
						leeresspielfeld_spalte = j;
					}
				}				
			}
			return;			
		}	
	}
	
}
