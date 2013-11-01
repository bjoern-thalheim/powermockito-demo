package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@PrepareForTest(PowerWithDelegationToPrivateMethod.class)
public class VerifyPrivateMethodDelegationTest {

	private PowerWithDelegationToPrivateMethod calculator;

	@Before
	public void setup() {
		// use PowerMockito.spy!
		this.calculator = spy(new PowerWithDelegationToPrivateMethod());
	}

	/**
	 * @throws Exception
	 *             Then the Test has failed.
	 */
	@Test
	public void test() throws Exception {
		int exponent = 2;
		long base = 2;
		// spy private method.
		doReturn(exponent).when(calculator, "getPower");
		// call method under test
		long power = calculator.powerOf(base);
		// do assertion
		assertEquals(base * base, power);
		// verify with Powermock.
		verifyPrivate(calculator, times(1)).invoke("getPower");
	}

}
