package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToNewObject {

	public long powerOf(long input) {
		ExponentDelegateImpl exponentDelegateImpl = new ExponentDelegateImpl();
		int power = exponentDelegateImpl.getExponent();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
