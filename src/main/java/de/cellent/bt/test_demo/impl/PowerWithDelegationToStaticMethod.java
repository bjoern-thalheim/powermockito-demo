package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToStaticMethod {

	public long power(long input) {
		int power = StaticExponentDelegateImpl.getExponent();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
