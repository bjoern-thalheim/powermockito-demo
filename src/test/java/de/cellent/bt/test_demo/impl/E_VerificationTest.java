package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import de.cellent.bt.test_demo.api.ExponentDelegate;
import de.cellent.bt.test_demo.impl.PowerWithDelegationToInterface;

/**
 * Demo for verifying an interface with mockito.
 * 
 * @author bjoern
 */
public class E_VerificationTest {

	/** class under test. */
	private PowerWithDelegationToInterface calculator;

	/** mocked delegate */
	private ExponentDelegate delegate;

	@Before
	public void init() {
		// instantate
		this.calculator = new PowerWithDelegationToInterface();
		// "inject"
		this.delegate = mock(ExponentDelegate.class);
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
		// verify
		verify(delegate, never()).getExponent();
	}

}
