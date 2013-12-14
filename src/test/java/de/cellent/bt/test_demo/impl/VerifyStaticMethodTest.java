package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
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
@PrepareForTest(StaticExponentDelegateImpl.class)
public class VerifyStaticMethodTest {

	private PowerWithDelegationToStaticMethod calculator;

	@Before
	public void setup() {
		// use PowerMockito.spy!
		this.calculator = new PowerWithDelegationToStaticMethod();
		mockStatic(StaticExponentDelegateImpl.class);
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
		doReturn(exponent).when(StaticExponentDelegateImpl.class, "getExponent");
		// call method under test
		long power = calculator.power(base);
		// do assertion
		assertEquals(base * base, power);
		// verify
		verifyStatic();
		StaticExponentDelegateImpl.getExponent();
	}

}
