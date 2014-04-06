package de.cellent.bt.test_demo.impl;

import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
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
@PrepareForTest(PowerWithDelegationToNewObject.class)
public class F_MockNewObjectTest {

	private PowerWithDelegationToNewObject calculator;
	
	/** Mocked Delegate. */
	private ExponentDelegateImpl delegate;

	@Before
	public void setup() {
		// use PowerMockito.spy!
		this.calculator = new PowerWithDelegationToNewObject();
		// create mocked Delegate
		delegate = Mockito.mock(ExponentDelegateImpl.class);
	}

	/**
	 * @throws Exception
	 *             Then the Test has failed.
	 */
	@Test
	public void test() throws Exception {
		int exponent = 2;
		long base = 2;
		// setup the Constructor call
		whenNew(ExponentDelegateImpl.class).withNoArguments().thenReturn(delegate);
		// setup the call to the constructed object.
		Mockito.doReturn(exponent).when(delegate).getExponent();
		// call method under test
		long power = calculator.power(base);
		// do assertion
		assertEquals(base * base, power);
		// verifyNew - don't forget the .withNoArguments.
		verifyNew(ExponentDelegateImpl.class).withNoArguments();
		// verify call
		Mockito.verify(delegate, Mockito.times(1)).getExponent();
	}

}
