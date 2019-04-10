package lab_3_kiemthu;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator cal = new Calculator();

	@Test
	public void test_add() {
		assertEquals(17,cal.add(14,3));
	}
	@Test
	public void test_sub() {
		assertEquals(-5,cal.sub(3,8));
	}
	@Test
	public void test_mul() {
		assertEquals(12,cal.mul(4,3));
	}

	@Test
	public void test_div_1() {
		assertEquals(4,cal.div(24,6));
	}
	@Test
	public void test_div_2() {
		assertEquals(2,cal.div(8,3));
	}
	@Test(expected =
			ArithmeticException.class)
	public void test_div_3() {
		assertEquals(2,cal.div(5,0));
	}
	
	@Test
	public void test_add_arr_1() {
		int[] arr = {1,2,3,4,5};
		assertEquals(15, cal.add(arr));		
	}
	@Test
	public void test_add_arr_2() {
		int[] arr = {3,8,-24,14,-6,4,3};
		assertEquals(2, cal.add(arr));		
	}
}
