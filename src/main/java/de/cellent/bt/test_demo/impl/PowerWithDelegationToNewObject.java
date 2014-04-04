package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToNewObject {

	public long power(long base) {
		ExponentDelegateImpl exponentDelegateImpl = new ExponentDelegateImpl();
		int exponent = exponentDelegateImpl.getExponent();
		long power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}
}
