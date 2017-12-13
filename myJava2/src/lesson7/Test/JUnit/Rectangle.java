package lesson7.Test.JUnit;

public class Rectangle {

	private int height;
	private int width;

	// Constructors
	public Rectangle() {
		height = 0;
		width = 0;
	}

	public Rectangle(int h, int w) {
		height = h;
		width = w;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getArea() {
		return height * width;
	}

	public String toString() {
		return "Rectangle: height=" + height + "; width=" + width + "; area="
				+ getArea() + ".";
	}
}
