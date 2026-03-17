import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathTest {
	Math math;
	
	@BeforeEach
	void setup() {// called before every test method
		math = new Math();
	}
	
	@Test
	void testDivide() {
		int result = math.divide(25, 5);
		assertEquals(5,result);
	}
	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, ()->{
			math.divide(25, 0);
		});
		
	}
	@Test
	void testDivideWithNegativeDivisor() {
		int result = math.divide(25, -5);
		assertEquals(-5,result);
	}

	@Test
	void testAddWithArray() {
		int result = math.addWithArray(new Integer[]{2,3,4,5});
		assertEquals(14,result);
	}

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		
		int result = math.add(2, 5);
		assertEquals(7,result);
	}
	@Test
	void testAddNegativeNumbers() {
		Math math = new Math();
		int result = math.add(-2, -5);
		assertEquals(-7,result);
	}
	@Test
	void testAddNegativeAndPositiveNumbers() {
		Math math = new Math();
		int result = math.add(2, -5);
		assertEquals(-3,result);
	}



}
