package org.dng.code.grooking.bitwise_xor;

public class SingleNumberII {

/*

	Given an integer array nums where every element appears three times except for one,
	which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99

 */
public static int singleNumber(int[] nums) {
	int a = 0;
	for (int num : nums) {
		a ^= num;
	}
	return a;
}

public static void main(String[] args) {
	System.out.println(singleNumber(new int[]{1, 1, 2}));
}
}
