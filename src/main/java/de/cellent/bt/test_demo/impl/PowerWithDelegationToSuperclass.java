package de.cellent.bt.test_demo.impl;


public class PowerWithDelegationToSuperclass extends PowerSuperClass {
	
	public long powerOf(long input) {
		int power = getPower();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
