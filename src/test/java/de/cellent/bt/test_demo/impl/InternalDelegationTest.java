package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Demo for mocking a delegation to an internal method of the class under test with mockito.
 * 
 * @author bjoern
 */
public class InternalDelegationTest {

	/** class under test. */
	private PowerWithDelegationToSuperclass calculator;

	@Before
	public void init() {
		// instantate
		this.calculator = spy(new PowerWithDelegationToSuperclass());
	}

	/**
	 * Test 2**2.
	 */
	@Test
	public void testPower2() {
		// setup all necessary values.
		int power = 2;
		long base = 2;
		// mock
		doReturn(power).when(calculator).getPower();
		// assert
		assertEquals(base * base /* out */, calculator.powerOf(base /* in */));
	}

}