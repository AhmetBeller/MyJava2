package lesson6.Swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BoxVolumenGUIc extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel labelHoehe;
	private JLabel labelBreite;
	private JLabel labelTiefe;
	private JLabel labelErgebnis;
	private JSlider schiebereglerHoehe;
	private JSlider schiebereglerBreite;
	private JSlider schiebereglerTiefe;
	private JTextField textErgebnis;
	private JButton schaltflaecheBerechnen;
	private JButton schaltflaecheLeeren;
	private ChangeListener berechneErgebnisListener;

	public BoxVolumenGUIc() {
		super("Box-Volumen-Rechner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 340);
		this.initialisiereKomponenten();
		this.ordneKomponenten();
		this.registriereListener();
		setVisible(true);
	}

	private void initialisiereKomponenten() {
		labelHoehe = new JLabel("Höhe:");
		labelBreite = new JLabel("Breite:");
		labelTiefe = new JLabel("Tiefe:");
		labelErgebnis = new JLabel("Ergebnis:");
		this.schiebereglerHoehe = this.erstelleSchieberegler(20, 60);
		this.schiebereglerBreite = this.erstelleSchieberegler(20, 60);
		this.schiebereglerTiefe = this.erstelleSchieberegler(40, 100);
		this.textErgebnis = new JTextField();
		this.textErgebnis.setEditable(false);
		this.schaltflaecheBerechnen = new JButton("Berechnen");
		this.schaltflaecheLeeren = new JButton("Leeren");
		this.berechneErgebnisListener = new BerechneErgebnisListener();
	}
	
	private JSlider erstelleSchieberegler(int minimum, int maximum) {
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMinorTickSpacing(5);
		schieberegler.setMajorTickSpacing(10);
		return schieberegler;
	}

	private void ordneKomponenten() {
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);

		c.gridx = 0;
		c.gridy = 0;
		this.getContentPane().add(this.labelHoehe, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		this.getContentPane().add(this.schiebereglerHoehe, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		this.getContentPane().add(new JLabel("cm"), c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		this.getContentPane().add(this.labelBreite, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		this.getContentPane().add(this.schiebereglerBreite, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		this.getContentPane().add(new JLabel("cm"), c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		this.getContentPane().add(this.labelTiefe, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		this.getContentPane().add(this.schiebereglerTiefe, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		this.getContentPane().add(new JLabel("cm"), c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		this.getContentPane().add(this.labelErgebnis, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		this.getContentPane().add(this.textErgebnis, c);
		
		c.gridx = 3;
		c.gridwidth = 1;
		this.getContentPane().add(new JLabel("cm^3"), c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		this.getContentPane().add(this.schaltflaecheBerechnen, c);
		
		c.gridx = 2;
		this.getContentPane().add(this.schaltflaecheLeeren, c);
	}

	private class BerechneErgebnisListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			aktualisiereErgebnis();
		}
	}
	
	private void aktualisiereErgebnis() {
		int hoehe = this.schiebereglerHoehe.getValue();
		int breite = this.schiebereglerBreite.getValue();
		int tiefe = this.schiebereglerTiefe.getValue();
		int ergebnis = hoehe * breite * tiefe;
		this.textErgebnis.setText(String.valueOf(ergebnis));
	}
	
	private void registriereListener() {
		this.schiebereglerHoehe.addChangeListener(this.berechneErgebnisListener);
		this.schiebereglerBreite.addChangeListener(this.berechneErgebnisListener);
		this.schiebereglerTiefe.addChangeListener(this.berechneErgebnisListener);
		
		/*
		// alternativ via Button berechnen
		schaltflaecheBerechnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aktualisiereErgebnis();
			}
		});
		*/
	}

	public static void main(String[] args) {
		BoxVolumenGUIc gui=new BoxVolumenGUIc();
	}
}
