package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToNewObject {

	public long powerOf(long input) {
		PowerDelegateImpl powerDelegateImpl = new PowerDelegateImpl();
		int power = powerDelegateImpl.getPower();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
