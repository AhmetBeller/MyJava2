package lesson5.Swing.Uebungen;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
	
	private Container contentPane;
	private JButton plus, minus, divi, multi, loeschen;
	private JTextField operand1, operand2;
	private JLabel lbl_erg;
	
	public Calculator()
	{
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("Operand 1: ", JLabel.RIGHT));
		operand1 = new JTextField(4);
		contentPane.add(operand1);
		
		contentPane.add(new JLabel("Operand 2: ", JLabel.RIGHT));
		operand2 = new JTextField(4);
		contentPane.add(operand2);
		
		contentPane.add(plus = new JButton("Addieren"));
		plus.addActionListener(new OperatorListener('+'));
		contentPane.add(plus);
		
		contentPane.add(minus = new JButton("Subtrahieren"));
		minus.addActionListener(new OperatorListener('-'));
		contentPane.add(minus);
		
		contentPane.add(divi = new JButton("Dividieren"));
		divi.addActionListener(new OperatorListener('/'));
		contentPane.add(divi);
		
		contentPane.add(multi = new JButton("Multiplizieren"));
		multi.addActionListener(new OperatorListener('*'));
		contentPane.add(multi);
		
		contentPane.add(new JLabel("Ergebnis: ", JLabel.RIGHT));
		contentPane.add(lbl_erg = new JLabel(""));
		lbl_erg.setOpaque(true);
		lbl_erg.setBackground(Color.RED);
		
		contentPane.add(loeschen = new JButton("Löschen"));
		loeschen.addActionListener(new OperatorListener('o'));
		contentPane.add(loeschen);		
	}

	
	private class OperatorListener implements ActionListener
	{
		private char oper;
		
		public OperatorListener(char oper)
		{
			this.oper = oper;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double oper1 = Double.valueOf(operand1.getText());
			double oper2 = Double.valueOf(operand2.getText());
			double erg = 0;
			
			if(oper == 'o')
			{
				lbl_erg.setText("");
				operand1.setText("");
				operand2.setText("");
				return;
			}
			
			try
			{
			if(oper == '+')
			{
				erg = oper1 + oper2;
			}
			else if(oper == '-')
			{
				erg = oper1 - oper2;
			}
			else if(oper == '*')
			{
				erg = oper1 * oper2;
			}
			else if(oper == '/')
			{
				erg = oper1 / oper2;
			}
			
			lbl_erg.setText("" + erg);
			}
			catch (Exception e1)
			{
				lbl_erg.setText("Unzulässige Eingabe");
			}
		}
	}

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		calc.setTitle("Calculator");
		calc.setSize(550, 110);
		calc.setVisible(true);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
