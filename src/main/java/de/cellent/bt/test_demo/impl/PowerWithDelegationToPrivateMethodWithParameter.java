package de.cellent.bt.test_demo.impl;

import java.util.Random;

public class PowerWithDelegationToPrivateMethodWithParameter {

	private int getExponent(int seed) {
		return new Random(seed).nextInt(17);
	}

	public long power(long base) {
		int exponent = getExponent(1);
		long power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}
}
