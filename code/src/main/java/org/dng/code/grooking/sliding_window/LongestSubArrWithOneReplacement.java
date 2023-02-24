package org.dng.code.grooking.sliding_window;


import lombok.Builder;

@Builder
public class LongestSubArrWithOneReplacement {

    /*
        Problem Statement
        Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
        find the length of the longest contiguous subarray having all 1s.

        	Example 1:

        	Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        	Output: 6
        	Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

        	Example 2:

        	Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
    	Output: 9
	Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */


public static void main(String[] args) {
	System.out.println(LongestSubArrWithOneReplacement.builder().build().longestOnes(new int[]{0, 0, 1, 1, 1, 0}, 2));
}

public int longestOnes(int[] nums, int k) {
	int left = 0, right;
	int maxLength = Integer.MIN_VALUE;
	int countZero = 0;
	for (right = 0; right < nums.length; right++) {
		if (nums[right] == 0) {
			countZero++;
		}
		
		// When number of Zero exceed allow 0, shrink the window
		while (countZero > k && left <= right) {
			if (nums[left] == 0) {
				countZero--; // decrease the k allow
			}
			left++;
		}
		maxLength = Math.max(maxLength, right - left + 1);
	}
	return maxLength;
}

}
