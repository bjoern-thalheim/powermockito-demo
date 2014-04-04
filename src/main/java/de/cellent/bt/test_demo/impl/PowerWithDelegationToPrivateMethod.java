package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToPrivateMethod {

	public long power(long base) {
		int exponent = getExponent();
		long power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}

	private int getExponent() {
		return 0;
	}
}
