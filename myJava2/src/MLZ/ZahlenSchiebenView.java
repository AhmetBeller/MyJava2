package MLZ;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ZahlenSchiebenView extends JFrame {
	private static final long serialVersionUID = 8873764207008940410L;
	SpielLogik spielLogik = new SpielLogik();
	BenutzerAktionFilesystem aktion = new BenutzerAktionFilesystem();
	ActionListener neu = new SpielfeldListener();
	ActionListener ver = new VerschiebListener();
	private Integer[][] feld;
	private GridLayout gridlayout;
	private Container contentPane;
	private JTextField displayzuege;
	private JButton neuesSpiel;
	private JLabel anzahlzuege;
	private JLabel Spielbeschreibung;
	private JLabel textbeimSpiel;
	private JPanel panel;
	private JTextArea text;
	private static final Font GAME_FONT = new Font("monspaced", Font.BOLD, 15);

	public void initialisiereKomponenten() {
		contentPane = getContentPane();
		anzahlzuege = new JLabel("Anzahl Züge:");
		anzahlzuege.setFont(GAME_FONT);
		
		displayzuege = new JTextField(5);
		displayzuege.setHorizontalAlignment(JTextField.CENTER);
		displayzuege.setEditable(false);
		displayzuege.setFont(GAME_FONT);
		
		neuesSpiel = new JButton("Neues Spiel");
		textbeimSpiel = new JLabel(" ");
		textbeimSpiel.setFont(GAME_FONT);
		panel = new JPanel();
		Spielbeschreibung = new JLabel("Spielbeschreibung:");
		text = new JTextArea("Alle Zahlen der Reihe nach \nsortieren. Das leere Feld \nmuss unten rechts sein.");
		text.setFont(GAME_FONT);
	}
	// Der Konstruktor dieser Klasse
	public void ZahlenSchiebenView() {
		setSize(300, 450);
		setLocation(150, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Zahlen sortieren");
		initialisiereKomponenten();
	
		neuesSpiel.addActionListener(neu);		
		spielLogik.erstelleNeuesSpielfeld(SpielLogik.zeileoderspalte);
		neuesfelderstellen();
		
		ordnenKomponenten();
		spielfeldAbfuellen();
		validate();
	}
	// Die Komponenten auf Frame bzw. Container ordnen
	private void ordnenKomponenten() {

		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);
		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(anzahlzuege, c);

		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 0;
		contentPane.add(displayzuege, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 0;
		contentPane.add(neuesSpiel, c);
		
		c.insets = new Insets(4, 4, 20, 4);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 3;
		contentPane.add(textbeimSpiel, c);

		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 6;
		contentPane.add(panel, c);


		c.gridx = 0;
		c.gridy = 112;
		contentPane.add(Spielbeschreibung, c);

		c.gridx = 0;
		c.gridy = 250;
		contentPane.add(text, c);

		setVisible(true);
	}
   // Spielfeld mit Buttons abfuellen.
	private void spielfeldAbfuellen()
	{		
		gridlayout = new GridLayout(0, SpielLogik.zeileoderspalte, 10, 10);
		panel.setLayout(gridlayout);
		panel.removeAll();
		if (spielLogik.getSpielfeld() != null) {
			feld = spielLogik.getSpielfeld();
			for (int i = 0; i < feld.length; i++) {
				for (int j = 0; j < feld[i].length; j++) {
					JButton btn;
					if (feld[i][j] != null){
						btn = new JButton(String.valueOf(feld[i][j]));
					} else{
						btn = new JButton(" ");					
						}											
						btn.addActionListener(ver);	
						panel.add(btn);	
					}				
				}
			setVisible(true);
			}					
	}
	// Hier was das Feld beim Druck auf Button Neues Spiel aktiviert.
	private void neuesfelderstellen() {
		spielLogik.erstelleNeuesSpielfeld(SpielLogik.zeileoderspalte);
		spielfeldAbfuellen();
		textbeimSpiel.setText(" ");
		displayzuege.setText("0");
	}
	
	// Dieser Listener bewirkt, dass ein neues Spiel beginnt und die bisherigen Aktionen ausgegeben werden.		
	private class SpielfeldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Object source = e.getSource();
			if (source == neuesSpiel)
			{
				neuesfelderstellen();
				try {
					aktion.protokolliereBenutzerAktion("Neues Spiel begonnen");
					aktion.leseAllBenutzerAktion();
				} catch (BenutzerAktionException e1) {
					JOptionPane.showMessageDialog(null, "Der Button hat keine Funktion");
					e1.printStackTrace();
				}
				
			}
		}		
	}
	// Hier wird geprüft, ob eine Zahl verschoben werden kann und der selektierte Wert wird in die Konsole geschrieben.
	private class VerschiebListener implements ActionListener{	
		public Integer zahl;
		
		@Override		
		public void actionPerformed(ActionEvent e) {					
				
			try{
				JButton gedrueckt = (JButton) e.getSource();
				zahl = Integer.parseInt(gedrueckt.getText());
				if(zahl != null){
					System.out.println("Das Feld "+zahl+" ist selektiert");
					for (int z = 0; z < SpielLogik.zeileoderspalte; z++)
					{
						for (int s = 0; s < SpielLogik.zeileoderspalte; s++)
						{
							if (feld[z][s] == zahl)							{
																
								SpielfeldKoordinate sk = new SpielfeldKoordinate(z,s);
								if (spielLogik.verschiebeZahl(sk))
								{
									textbeimSpiel.setText("Das Spiel ist fertig");
									System.out.println("Das Spiel ist fertig");	
									aktion.protokolliereBenutzerAktion("Spiel erfolgreich beendet");
								}
								
								spielfeldAbfuellen();
								displayzuege.setText(" " + spielLogik.getAnzahlZuege());
								try{
									if(!spielLogik.verschiebeZahl(sk)){
										aktion.protokolliereBenutzerAktion("Ein Feld verschoben");
									}
								}
								catch(BenutzerAktionException ex)
								{
									JOptionPane.showMessageDialog(null, "Error: Programmfehler");
								}							
								return;
							
							}
						}
					}
				}	
			   }
				catch (Exception ex)
				{
					System.out.println("Null-Button");
				}
			
			return;
			}
		
		}	
	// Main-Methode
	public static void main(String[] args) {
		ZahlenSchiebenView spiel = new ZahlenSchiebenView();	
		spiel.ZahlenSchiebenView();
	}
}
