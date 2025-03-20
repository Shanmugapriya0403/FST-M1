package junitpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator calculator;
	@BeforeEach
	public void setUp() {
		calculator=new Calculator();
	}
	@Test
	@DisplayName("4*5 is 20")
	public void testMultiply() {
		Assertions.assertEquals(20,calculator.multiply(4, 5));
	}
}
