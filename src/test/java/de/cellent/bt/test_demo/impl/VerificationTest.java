package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import de.cellent.bt.test_demo.api.PowerDelegate;
import de.cellent.bt.test_demo.impl.PowerWithDelegationToInterface;

/**
 * Demo for verifying an interface with mockito.
 * 
 * @author bjoern
 */
public class VerificationTest {

	/** class under test. */
	private PowerWithDelegationToInterface calculator;

	/** mocked delegate */
	private PowerDelegate delegate;

	@Before
	public void init() {
		// instantate
		this.calculator = new PowerWithDelegationToInterface();
		// "inject"
		this.delegate = mock(PowerDelegate.class);
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
		// verify
		verify(delegate, times(1)).getPower();
	}

}
