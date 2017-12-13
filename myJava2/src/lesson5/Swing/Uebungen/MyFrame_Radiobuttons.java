package lesson5.Swing.Uebungen;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;


public class MyFrame_Radiobuttons extends JFrame {
	
	private static final long serialVersionUID = 5448939629676122342L;
	private JMenuBar hauptmenu = new JMenuBar();
	public JCheckBoxMenuItem blau = new JCheckBoxMenuItem("blau");
	public JCheckBoxMenuItem gelb = new JCheckBoxMenuItem("gelb");
	public JCheckBoxMenuItem rot = new JCheckBoxMenuItem("rot");
	
	MyFrame_Radiobuttons()
	{
		setSize(300, 250);
		setLocation(150, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meine erste GUI");
		JMenu menuDatei = new JMenu("Datei");
		menuDatei.setMnemonic('D');
		hauptmenu.add(menuDatei);
		
		
		JMenu hintergrund = new JMenu("Hintergrundfarbe");
		hintergrund.add(blau);
		hintergrund.add(rot);
		hintergrund.add(gelb);	

		
		blau.setSelected(true);						
		rot.setSelected(true);						
		gelb.setSelected(true);
		
		
		ButtonGroup gruppe = new ButtonGroup();
		gruppe.add(blau);
		gruppe.add(rot);
		gruppe.add(gelb);	
		
		menuDatei.add(hintergrund);
		
		this.setJMenuBar(hauptmenu);
	
		
		ItemListener itemListener = new MyItemListener();
		gelb.addItemListener(itemListener);
		blau.addItemListener(itemListener);
		rot.addItemListener(itemListener);
	}
	
	private void aendernfarbe(Color color)
	{
		this.getContentPane().setBackground(color);
	}
	
	private class MyItemListener implements ItemListener {	
		
		@Override
		public void itemStateChanged(ItemEvent e)
		{
			if(blau.isSelected())
			{
				aendernfarbe(Color.BLUE);
			}
			else if(rot.isSelected())
			{
				aendernfarbe(Color.RED);
			}
			else if(gelb.isSelected())
			{
				aendernfarbe(Color.YELLOW);
			}
				
		}
	}
}
	

