package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import de.cellent.bt.test_demo.impl.ExponentDelegateImpl;
import de.cellent.bt.test_demo.impl.PowerWithDelegationToImplementation;

/**
 * Demo for mocking an implementation with mockito.
 * 
 * @author bjoern
 */
public class MockingAnImplementationTest {

	/** class under test. */
	private PowerWithDelegationToImplementation calculator;

	/** mocked delegate */
	private ExponentDelegateImpl delegate;

	@Before
	public void init() {
		// instantate
		this.calculator = new PowerWithDelegationToImplementation();
		// "inject"
		this.delegate = spy(new ExponentDelegateImpl());
		calculator.setExponentDelegate(delegate);
	}

	/**
	 * Test 2**2.
	 */
	@Test
	public void testPower2() {
		// setup all necessary values.
		int exponent = 2;
		long base = 2;
		// mock
		doReturn(exponent).when(delegate).getExponent();
		// assert
		assertEquals(base * base /* out */, calculator.power(base /* in */));
	}

}
