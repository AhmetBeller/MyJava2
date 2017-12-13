package lesson7.Test.JUnit;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RectangleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testRectangleArea() {
		Rectangle rect = new Rectangle();
		assertTrue(rect.getArea() == 0);
	}

	@Test
	public void testRectangleHeight() {
		Rectangle rect = new Rectangle();
		assertTrue(rect.getHeight() == 0);
	}

	@Test
	public void testRectangleWidth() {
		Rectangle rect = new Rectangle();
		assertTrue(rect.getWidth() == 0);
	}

	@Test
	public void testRectangleIntInt1() {
		Rectangle rect = new Rectangle(2, 3);
		assertTrue(rect.getHeight() == 2);
	}

	@Test
	public void testRectangleIntInt2() {
		Rectangle rect = new Rectangle(2, 3);
		assertTrue(rect.getWidth() == 3);
	}

	@Test
	public void testSetHeight() {
		Rectangle rect = new Rectangle();
		rect.setHeight(7);
		assertEquals(7, rect.getHeight());
	}

	@Test
	public void testSetWidth() {
		Rectangle rect = new Rectangle();
		rect.setWidth(8);
		assertEquals(8, rect.getWidth());
	}

	@Test
	public void testGetArea() {
		Rectangle rect = new Rectangle(5, 4);
		assertEquals(20, rect.getArea());
	}

}
