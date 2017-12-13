package lesson5.Swing;

import java.awt.event.*;
import javax.swing.*;

public class Swing_Beispiel {
	
	private JFrame fenster = new MyFrame();	
	private JMenuBar mnHauptmenue = new MyMenue();
	
	public Swing_Beispiel()
	{
		fenster.setJMenuBar(mnHauptmenue);
		fenster.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Swing_Beispiel bsp = new Swing_Beispiel();
	}
	
	
	

}
