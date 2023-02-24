package org.dng.code.grooking.bit_manipulate;

public class NumberOf1Bits {

static public int hammingWeight(int n) {
	int count = 0;
	int mask = 1;
	int index = 32;
	
	while (index-- > 0) {
		if ((mask & n) == 1) {
			count++;
		}
		n = n >> 1;
	}
	return count;
}

}
