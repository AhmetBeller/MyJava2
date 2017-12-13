package lesson5.Swing;

import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{
	
	private JLabel lblText;
	private JButton btnKlick;
	private JPanel pnlAnwendung;
	
	public void setLabelText(String text)
	{
		lblText.setText(text);
	}
	
	MyFrame()
	{
		setSize(300, 250);
		setLocation(150, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meine erste GUI");
		pnlAnwendung = new JPanel();
		btnKlick = new JButton("Klick mich");
		ActionListener al  = new BtnKlickListener(this);
		btnKlick.addActionListener(al);
		
		lblText = new JLabel("noch nicht geklickt");
		pnlAnwendung.add(btnKlick);
		pnlAnwendung.add(lblText);
		this.getContentPane().add(pnlAnwendung);
	}

}
