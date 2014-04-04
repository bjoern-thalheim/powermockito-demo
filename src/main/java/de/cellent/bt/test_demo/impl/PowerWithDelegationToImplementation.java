package de.cellent.bt.test_demo.impl;

public class PowerWithDelegationToImplementation {

	private ExponentDelegateImpl delegate;

	public void setExponentDelegate(ExponentDelegateImpl delegate) {
		this.delegate = delegate;
	}

	public long power(long base) {
		int exponent = delegate.getExponent();
		long power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}
}
