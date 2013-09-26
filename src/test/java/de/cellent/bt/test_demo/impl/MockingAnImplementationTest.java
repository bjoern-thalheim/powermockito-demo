package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Demo for mocking an implementation with mockito.
 * 
 * @author bjoern
 */
public class MockingAnImplementationTest {

	/** class under test. */
	private PowerWithDelegationToImplementation calculator;

	/** mocked delegate */
	private PowerDelegateImpl delegate;

	@Before
	public void init() {
		// instantate
		this.calculator = new PowerWithDelegationToImplementation();
		// "inject"
		this.delegate = spy(new PowerDelegateImpl());
		calculator.setPowerDelegate(delegate);
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
		doReturn(power).when(delegate).getPower();
		// assert
		assertEquals(base * base /* out */, calculator.powerOf(base /* in */));
	}

}
