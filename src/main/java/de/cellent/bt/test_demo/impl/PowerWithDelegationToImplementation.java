package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToImplementation {

	private PowerDelegateImpl delegate;

	public void setPowerDelegate(PowerDelegateImpl delegate) {
		this.delegate = delegate;
	}

	public long powerOf(long input) {
		int power = delegate.getPower();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
