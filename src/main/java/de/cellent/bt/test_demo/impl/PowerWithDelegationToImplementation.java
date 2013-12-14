package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToImplementation {

	private ExponentDelegateImpl delegate;

	public void setExponentDelegate(ExponentDelegateImpl delegate) {
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
