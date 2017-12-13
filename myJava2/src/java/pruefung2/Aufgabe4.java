package java.pruefung2;
	
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

	public class Aufgabe4 extends JFrame {
		private static final long serialVersionUID = 1L;
		private JLabel Eingabewert;
		private JLabel Resultat;	
		private JTextField eingabetext;
		private JTextField resultattext;
		private JButton schaltflaecheBerechnen;
		private JLabel er;
		
		

		public Aufgabe4() {
			super("Rechner");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(350, 200);
			initialisiereKomponenten();
			ordneKomponenten();
			registriereListener();
			setVisible(true);
		}

		private void initialisiereKomponenten() {
			Eingabewert = new JLabel("Eingabewert:");
			Resultat = new JLabel("Resultat:");
			
			eingabetext = new JTextField();
			resultattext = new JTextField();
			schaltflaecheBerechnen = new JButton("Berechnen");
			er = new JLabel(" ");
		}

		private void ordneKomponenten() {
			getContentPane().setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(4, 4, 4, 4);

			c.gridx = 0;
			c.gridy = 0;
			getContentPane().add(Eingabewert, c);

			c.gridx = 1;
			c.gridwidth = 2;
			getContentPane().add(Resultat, c);

			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			getContentPane().add(eingabetext, c);

			c.gridx = 1;
			c.gridwidth = 2;
			getContentPane().add(resultattext, c);

			c.gridy = 4;
			c.gridwidth = 1;
			getContentPane().add(schaltflaecheBerechnen, c);
			
			c.gridx = 2;
			getContentPane().add(er, c);
		}
		

		private void registriereListener() {
			schaltflaecheBerechnen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Integer eing = Integer.parseInt(eingabetext.getText());
					Integer res = Integer.parseInt(resultattext.getText());					
						if (res !=0)
							{eing = res;}									
						else{
						er = new JLabel("Die Eingabe ist ungültig");
					}												
			}	
			
			});
		}
		
		public static void main(String[] args) 
		{			
			new Aufgabe4();
		}
	
			}		


