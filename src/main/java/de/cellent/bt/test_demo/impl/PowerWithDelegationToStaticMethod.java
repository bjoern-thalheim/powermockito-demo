package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToStaticMethod {

	public long powerOf(long input) {
		int power = StaticPowerDelegateImpl.getPower();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
