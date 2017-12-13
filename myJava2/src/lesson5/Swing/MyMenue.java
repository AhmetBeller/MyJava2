package lesson5.Swing;

import java.awt.event.*;
import javax.swing.*;

public class MyMenue extends JMenuBar{
	
	private JMenu mnDatei = new JMenu("Datei");
	
	MyMenue()
	{
		mnDatei.setMnemonic('D');
		add(mnDatei);
		JMenuItem mnOeffnen = new JMenuItem("Öffnen", 'f');
		JMenuItem mnSpeichern = new JMenuItem("Speicher", 's');
		JMenuItem mnSchliessen = new JMenuItem("Schliessen", 'c');
		JMenuItem mnBeenden = new JMenuItem("Beenden", 'b');
		
		mnDatei.add(mnOeffnen);
		mnDatei.add(mnSpeichern);
		mnDatei.add(mnSchliessen);
		mnDatei.addSeparator();
		
		JMenu mnTools = new JMenu("Tools");
		JMenuItem mnRechner = new JMenuItem("Taschenrechner");
		mnTools.add(mnRechner);
		JMenuItem mnAdressBuch = new JMenuItem("Adressbuch");
		mnTools.add(mnAdressBuch);
		mnDatei.add(mnTools);
		mnDatei.addSeparator();
		
		JMenu mnHintergrundfarbe = new JMenu("Hintergrundfarbe");
		ButtonGroup gruppe = new ButtonGroup();
		JRadioButtonMenuItem rot = new JRadioButtonMenuItem("rot");
		rot.setSelected(true);
		mnHintergrundfarbe.add(rot);
		JRadioButtonMenuItem blau = new JRadioButtonMenuItem("blau");
		blau.setSelected(true);
		mnHintergrundfarbe.add(blau);
		JRadioButtonMenuItem gelb = new JRadioButtonMenuItem("gelb");
		gelb.setSelected(true);
		mnHintergrundfarbe.add(gelb);
		gruppe.add(rot);
		gruppe.add(blau);
		gruppe.add(gelb);
		mnDatei.add(mnHintergrundfarbe);
		mnDatei.addSeparator();
		
		JMenu mnWaehrungen = new JMenu("erlaubte Währung");
		JCheckBoxMenuItem mnEuro = new JCheckBoxMenuItem("Euro");
		JCheckBoxMenuItem mnGlobo = new JCheckBoxMenuItem("Globo");
		
		mnWaehrungen.add(mnEuro);
		mnWaehrungen.add(mnGlobo);
		
		mnDatei.add(mnWaehrungen);
		mnDatei.addSeparator();
		
		mnDatei.add(mnBeenden);
		
	}

}
