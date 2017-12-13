package lesson6.Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lesson6.Swing.CalculationModel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JTextField displayTextField;
	private CalculationModel calcModel;
	private boolean startNumber = true;
	private String previousOperator = "=";

	private static final Font CALCULATOR_FONT = new Font("monspaced",Font.PLAIN, 20);

	public Calculator() {

		calcModel = new CalculationModel();

		// calculator display
		displayTextField = new JTextField("0", 15);
		displayTextField.setHorizontalAlignment(JTextField.RIGHT);
		displayTextField.setFont(CALCULATOR_FONT);

		// number buttons
		String[] numberButtonOrder = { "7", "8", "9", "4", "5", "6", "1", "2",
				"3", " ", "0", " " };
		JPanel numberButtonPanel = new JPanel();
		numberButtonPanel.setLayout(new GridLayout(5, 3, 1, 1));
		for (int i = 0; i < numberButtonOrder.length; i++) {
			JButton numberButton = new JButton(numberButtonOrder[i]);
			if (numberButtonOrder[i].equals(" ")) {
				// dummy button
				numberButton.setEnabled(false);
				numberButton.setVisible(false);
			} else {
				// put a digit button in the GUI.
				numberButton.addActionListener(new NumberButtonListener());
				numberButton.setFont(CALCULATOR_FONT);
			}
			numberButtonPanel.add(numberButton);
		}

		// operation buttons
		JPanel operationButtonPanel = new JPanel();
		operationButtonPanel.setLayout(new GridLayout(5, 1, 2, 2));
		// if the components should be resizable, the gridlayout works best
		// the boxlayout could be used as well
		//operationButtonPanel.setLayout(new BoxLayout(operationButtonPanel,BoxLayout.Y_AXIS));
		String[] operationButtonOrder = { "+", "-", "*", "/", "=" };
		for (int i = 0; i < operationButtonOrder.length; i++) {
			JButton oprationButton = new JButton(operationButtonOrder[i]);
			oprationButton.addActionListener(new OperationButtonListener());
			oprationButton.setFont(CALCULATOR_FONT);
			operationButtonPanel.add(oprationButton);
		}

		// clear button
		JPanel clearButtonPanel = new JPanel();
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(CALCULATOR_FONT);
		clearButton.addActionListener(new ClearButtonListener());
		clearButtonPanel.setLayout(new FlowLayout());

		clearButtonPanel.add(clearButton);

		// content pane
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout(5, 5));
		content.add(displayTextField, BorderLayout.NORTH);
		content.add(numberButtonPanel, BorderLayout.CENTER);
		content.add(operationButtonPanel, BorderLayout.EAST);
		content.add(clearButtonPanel, BorderLayout.SOUTH);

		// 10 pixel frame
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// JFrame properties
		this.getContentPane().add(content);
		this.pack();
		this.setTitle("Swing Calculator");
		this.setResizable(true);
	}

	private void resetCalculator() {
		startNumber = true; // true => expecting number, not operator
		displayTextField.setText("0");
		previousOperator = "=";
		calcModel.setTotal("0");
	}

	class NumberButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Get text from button
			String digit = e.getActionCommand(); 
			if (startNumber) {
				// This is the first digit, clear field and set
				displayTextField.setText(digit);
				startNumber = false;
			} else {
				// Add this digit to the end of the display field
				displayTextField.setText(displayTextField.getText() + digit);
			}
		}
	}

	class OperationButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// The calculator is always in one of two states.
			// 1. A number must be entered -- an operator is wrong.
			// 2. An operator must be entered.
			if (startNumber) { // Error: needed number, not operator
				// in this state we're expecting a number, but got an operator.
				resetCalculator();
				displayTextField.setText("ERROR - No operator");
			} else {
				// ... We're expecting an operator.
				startNumber = true; // Next thing must be a number
				try {
					// Get value from display field, convert, do previousOperator
					// If this is the first operator, previousOperator will be =.
					String displayText = displayTextField.getText();

					if (previousOperator.equals("=")) {
						calcModel.setTotal(displayText);
					} else if (previousOperator.equals("+")) {
						calcModel.add(displayText);
					} else if (previousOperator.equals("-")) {
						calcModel.subtract(displayText);
					} else if (previousOperator.equals("*")) {
						calcModel.multiply(displayText);
					} else if (previousOperator.equals("/")) {
						calcModel.divide(displayText);
					}

					displayTextField.setText("" + calcModel.getTotalString());

				} catch (NumberFormatException ex) {
					resetCalculator();
					displayTextField.setText("Error");
				}

				// ... set previousOperator for the next operator.
				previousOperator = e.getActionCommand();
			}
		}
	}

	class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			resetCalculator();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Calculator calculatorWindow = new Calculator();
		calculatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorWindow.setVisible(true);

	}

}
