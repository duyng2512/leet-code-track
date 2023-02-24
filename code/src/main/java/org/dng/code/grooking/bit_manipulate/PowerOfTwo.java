package org.dng.code.grooking.bit_manipulate;

public class PowerOfTwo {

/**
 * Time: O(1)
 * Space: O(1)
 */
public boolean isPowerOfTwo(int n) {
	// Any number power of two is bigger than 0
	if (n <= 0)
		return false;
	return (n & (n - 1)) == 0;
}

}
