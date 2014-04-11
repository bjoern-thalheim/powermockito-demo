package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import de.cellent.bt.test_demo.impl.PowerWithDelegationToSuperclass;

/**
 * Demo for mocking a delegation to an internal method of the class under test with mockito.
 * 
 * @author bjoern
 */
public class K_InvokePrivateTest {

	/** class under test. */
	private PowerWithDelegationToSuperclass calculator;

	@Before
	public void init() {
		// instantiate
		this.calculator = spy(new PowerWithDelegationToSuperclass());
	}

	/**
	 * Test 2**2.
	 * @throws Exception May be thrown by {@link Whitebox#invokeMethod(Object, String, Object...)}.
	 */
	@Test
	public void testPower2() throws Exception {
		// setup all necessary values.
		int exponent = 2;
		long base = 2;
		// mock
		doReturn(exponent).when(calculator).getExponent();
		// assert
		Long result = Whitebox.invokeMethod(calculator, "power", base);
		assertEquals(new Long((long) Math.pow(base, exponent)), result);
	}

}
