package de.cellent.bt.test_demo.impl;

import de.cellent.bt.test_demo.api.PowerDelegate;

public class PowerWithDelegationToInterface {
	
	private PowerDelegate delegate;
	
	public void setPowerDelegate(PowerDelegate delegate) {
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
