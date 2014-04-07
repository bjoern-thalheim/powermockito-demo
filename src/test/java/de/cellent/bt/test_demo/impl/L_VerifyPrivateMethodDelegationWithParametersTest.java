package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * The method under test delegates to a private internal method. This has to be mocked via reflection/powermock or the
 * visibility would have to be adapted.
 * 
 * @author bjoern
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerWithDelegationToPrivateMethodWithParameter.class)
public class L_VerifyPrivateMethodDelegationWithParametersTest {

	/**
	 * Class under Test.
	 */
	private PowerWithDelegationToPrivateMethodWithParameter calculator;

	/**
	 * Init Class under Test.
	 */
	@Before
	public void setup() {
		calculator = spy(new PowerWithDelegationToPrivateMethodWithParameter());
	}

	@Test
	public void privatePartialMockingWithPowerMock() throws Exception {
		int exponent = 2;
		long base = 2;
		doReturn(exponent).when(calculator, "getExponent", Matchers.anyInt());
		long power = calculator.power(base);
		assertEquals(base * base, power);
		verifyPrivate(calculator, times(1)).invoke("getExponent", 1);
	}
}
