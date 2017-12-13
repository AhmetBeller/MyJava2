package lesson6.Swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxVolumenGUIb extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel labelHoehe;
	private JLabel labelBreite;
	private JLabel labelTiefe;
	private JLabel labelErgebnis;
	private JTextField textHoehe;
	private JTextField textBreite;
	private JTextField textTiefe;
	private JTextField textErgebnis;
	private JButton schaltflaecheBerechnen;
	private JButton schaltflaecheLeeren;

	public BoxVolumenGUIb() {
		super("Box-Volumen-Rechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		initialisiereKomponenten();
		ordneKomponenten();
		registriereListener();
		setVisible(true);
	}

	private void initialisiereKomponenten() {
		labelHoehe = new JLabel("Höhe:");
		labelBreite = new JLabel("Breite:");
		labelTiefe = new JLabel("Tiefe:");
		labelErgebnis = new JLabel("Ergebnis:");
		textHoehe = new JTextField();
		textBreite = new JTextField();
		textTiefe = new JTextField();
		textErgebnis = new JTextField();
		textErgebnis.setEditable(false);
		schaltflaecheBerechnen = new JButton("Berechnen");
		schaltflaecheLeeren = new JButton("Leeren");
	}

	private void ordneKomponenten() {
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);

		c.gridx = 0;
		c.gridy = 0;
		getContentPane().add(labelHoehe, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		getContentPane().add(textHoehe, c);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		getContentPane().add(new JLabel("cm"), c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		getContentPane().add(labelBreite, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		getContentPane().add(textBreite, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		getContentPane().add(new JLabel("cm"), c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		getContentPane().add(labelTiefe, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		getContentPane().add(textTiefe, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		getContentPane().add(new JLabel("cm"), c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		getContentPane().add(labelErgebnis, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		getContentPane().add(textErgebnis, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		getContentPane().add(new JLabel("cm^3"), c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		getContentPane().add(schaltflaecheBerechnen, c);
		
		c.gridx = 2;
		getContentPane().add(schaltflaecheLeeren, c);
	}

	private void registriereListener() {
		schaltflaecheBerechnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer hoehe = Integer.parseInt(textHoehe.getText());
				Integer breite = Integer.parseInt(textBreite.getText());
				Integer tiefe = Integer.parseInt(textTiefe.getText());
				Integer ergebnis = hoehe * breite * tiefe;
				textErgebnis.setText(ergebnis.toString());
			}
		});
		schaltflaecheLeeren.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textHoehe.setText("");
				textBreite.setText("");
				textTiefe.setText("");
			}
		});
	}

	public static void main(String[] args) {
		BoxVolumenGUIb gui=new BoxVolumenGUIb();
	}
}
