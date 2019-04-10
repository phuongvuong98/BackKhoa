package lab_3_kiemthu;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {
	Line line, line1;
	@Test(expected =
			ArithmeticException.class)
	public void testgetSlope_1() {
		line = new Line(3.0, 4.0, 3.0, 14.0);
		line.getSlope();
	}
	@Test
	public void testgetSlope_2() {
		line = new Line(2.0, 4.0, 3.0, 8.0);
		assertEquals(4.0, line.getSlope(),0.001);
	}
	@Test
	public void testgetSlope_3() {
		line = new Line(2.0, 3.0, 8.0, 3.0);
		assertEquals(0.0, line.getSlope(),0.001);
	}
	@Test
	public void testgetDistance_1() {
		line = new Line(14.0, -3.0, 8.0, 3.0);
		assertEquals(10.0, line.getDistance(), 0.001);
	}
	@Test
	public void testgetDistance_2() {
		line = new Line(24.0, 6.0, 3.0, 8.0);
		assertEquals(21.095, line.getDistance(), 0.001);
	}
	@Test
	public void testgetDistance_3() {
		line = new Line(3.0, 4.0, 3.0, 8.0);
		assertEquals(4.0, line.getDistance(), 0.001);
	}
	@Test()
	public void testparallelTo_1() {
		line = new Line(2.0, 1.0, 3.0, 8.0);
		line1 = new Line(2.0, 1.0, 8.0, 3.0);
		assertFalse(line.parallelTo(line1));
	}
	@Test()
	public void testparallelTo_2() {
		line = new Line(2.0, 1.0, 3.0, 8.0);
		line1 = new Line(3.0, 4.5, 4.0, 11.5);
		assertTrue(line.parallelTo(line1));
	}
	@Test()
	public void testparallelTo_3() {
		line = new Line(3.4, 14.3, 6.4, 24.6);
		line1 = new Line(6.3, 4.3, 8.3, 14.3);
		assertTrue(line.parallelTo(line1));
	}
}
