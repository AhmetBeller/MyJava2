package lesson7.Test.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest2 {
	
	@Test
	public void testGetArea() {
		Rectangle rect = new Rectangle();
		rect.setHeight(6);
		rect.setWidth(7);
		assertEquals(42, rect.getArea());
	}

}
