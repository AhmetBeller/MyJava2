package lesson5.Swing;

import java.awt.event.*;
import javax.swing.*;

public class BtnKlickListener implements ActionListener {
	
	private MyFrame fenster;
	BtnKlickListener(MyFrame fenster)
	{
		this.fenster = fenster;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Gedrückt");
		fenster.setLabelText("Button wurde aktiviert");
	}

}
