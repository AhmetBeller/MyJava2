package MLZ;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpielLogikTest {

	SpielLogik logik = new SpielLogik();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void neuesSpielfelderstellen()
	{		
		logik.erstelleNeuesSpielfeld(2);
		logik.getSpielfeld()[0][0] = 1;
		logik.getSpielfeld()[0][1] = 2;
		logik.getSpielfeld()[1][0] = 3;
		logik.getSpielfeld()[1][1] = null;
		assertTrue(logik.getSpielfeld().length==2);						
	}
	
	// Hier muss unbedingt in der Klasse SpiellLogik die Collection.shuffle 
	//Methode auskommentiert werden.		
	@Test 
	public void Verschieben_korrektWerten() // Mit Korrekten Werten
	{
		int z = 1;
		int s = 0;
		SpielfeldKoordinate kor = new SpielfeldKoordinate(s, z);
		
		logik.erstelleNeuesSpielfeld(2);
		logik.verschiebeZahl(kor);
		assertTrue(logik.getSpielfeld()[1][1] == 2);
	}
	
	// Wahl Nummer 1 im Spield, ist nicht möglich zum Verschieben
	@Test 
	public void Verschieben_fehlerhaftWerten() // Mit fehlerhaften Werten
	{
		int z = 1;  
		int s = 0;
		SpielfeldKoordinate kor = new SpielfeldKoordinate(s, z);
		
		logik.erstelleNeuesSpielfeld(2);
		logik.verschiebeZahl(kor);
		assertFalse(logik.getSpielfeld()[1][1] == 1);
	}
	
	
	
	
	
	
	
}



	
