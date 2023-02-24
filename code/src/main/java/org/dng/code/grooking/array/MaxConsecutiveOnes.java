package org.dng.code.grooking.array;

/**
 * @author duyntc 01/2023
 */
public class MaxConsecutiveOnes {

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 */

static public int findMaxConsecutiveOnes(int[] nums) {
	// Intuitive: using sliding window, we keep track of number 1
	// When there is number 0 appear, cut the sequence
	// and update Max
	
	int start = 0;
	int end;
	int total = Integer.MIN_VALUE;
	
	for (end = 0; end < nums.length; end++) {
		if (nums[end] == 0) {
			total = Math.max(end - start, total);
			start = end + 1;
		}
	}
	
	total = Math.max(end - start, total);
	return total;
}

public static void main(String[] args) {
	int[] arr = new int[]{1, 1, 0, 1, 1, 1};
	System.out.println(findMaxConsecutiveOnes(arr));
	
	arr = new int[]{1, 0, 1, 1, 0, 1};
	System.out.println(findMaxConsecutiveOnes(arr));
	
}

}
