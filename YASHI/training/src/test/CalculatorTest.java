package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import training.Calculator;

class CalculatorTest {

	@Test
	void test() {
		Calculator c = new Calculator();
		int r = c.calc();
		assertEquals(3,r,"wrong");
	}

}
