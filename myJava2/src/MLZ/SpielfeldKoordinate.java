package MLZ;

public class SpielfeldKoordinate 
{
	public int zeile;
	public int spalte;
	
	public SpielfeldKoordinate(int zeile, int spalte)
	{
		this.zeile = zeile;
		this.spalte = spalte;
	}
	
	public int getSpalte()
	{
		return spalte;
	}
	
	public int getZeile()
	{
		return zeile;
	}
}
