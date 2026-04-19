import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator c = new Calculator();
		int result = c.add(2, 3);
		assertEquals(5, result);

	}

	@Test
	void testSubtract() {
		Calculator cal = new Calculator();
		int res = cal.subtract(10, 5);
		assertEquals(5, res);
	}

	@Test
	void testSubtractwithnegative() {
		Calculator calci = new Calculator();
		int resu = calci.subtract(-2, -3);
		assertEquals(1, resu);
	}

}
