package de.cellent.bt.test_demo.impl;

import de.cellent.bt.test_demo.api.ExponentDelegate;

public class PowerWithDelegationToInterface {
	
	private ExponentDelegate delegate;
	
	public void setExponentDelegate(ExponentDelegate delegate) {
		this.delegate = delegate;
	}
	
	public long power(long input) {
		int power = delegate.getExponent();
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= input;
		}
		return result;
	}
}
