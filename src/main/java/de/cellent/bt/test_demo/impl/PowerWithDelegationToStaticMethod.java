package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToStaticMethod {

	public long power(long base) {
		int exponent = StaticExponentDelegateImpl.getExponent();
		long power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}
}
