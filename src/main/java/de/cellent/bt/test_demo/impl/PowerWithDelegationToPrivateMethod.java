package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToPrivateMethod {

	public long powerOf(long input) {
		int power = getPower();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}

	private int getPower() {
		return 0;
	}
}
