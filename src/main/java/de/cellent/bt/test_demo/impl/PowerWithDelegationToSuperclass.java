package de.cellent.bt.test_demo.impl;


public class PowerWithDelegationToSuperclass extends PowerSuperClass {
	
	public long power(long input) {
		int power = getExponent();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
