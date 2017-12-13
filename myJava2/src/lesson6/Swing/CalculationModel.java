package lesson6.Swing;

public class CalculationModel {

	// The current total is all we need to remember.
	private int tmpResult; 

	public CalculationModel() {
		tmpResult = 0;
	}

	public String getTotalString() {
		return "" + tmpResult;
	}

	public void setTotal(String n) {
		tmpResult = convertToNumber(n);
	}

	public void add(String n) {
		tmpResult += convertToNumber(n);
	}

	public void subtract(String n) {
		tmpResult -= convertToNumber(n);
	}

	public void multiply(String n) {
		tmpResult *= convertToNumber(n);
	}

	public void divide(String n) {
		tmpResult /= convertToNumber(n);
	}

	private int convertToNumber(String n) {
		return Integer.parseInt(n);
	}
}
