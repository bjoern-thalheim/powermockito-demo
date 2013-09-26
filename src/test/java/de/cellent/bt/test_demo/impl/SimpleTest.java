package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.cellent.bt.test_demo.impl.SquareCalculator;

/**
 * Obviously, this test is a piece of cake.
 * 
 * @author bjoern
 */
public class SimpleTest {

	/** Class under Test. */
	private SquareCalculator calculator;
	
	@Before
	public void setup() {
		calculator = new SquareCalculator();
	}
	
	@Test
	public void testCalculate() {
		assertEquals(0, calculator.calculate(0));
		assertEquals(1, calculator.calculate(1));
		assertEquals(4, calculator.calculate(2));
		assertEquals(289, calculator.calculate(17));
		assertEquals(1, calculator.calculate(-1));
		assertEquals(4, calculator.calculate(-2));
		assertEquals(289, calculator.calculate(-17));
	}

}
