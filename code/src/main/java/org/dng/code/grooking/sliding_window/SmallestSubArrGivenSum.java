package org.dng.code.grooking.sliding_window;

import lombok.Builder;

@Builder
public class SmallestSubArrGivenSum {
     
     /*
     
     Problem Statement
     Given an array of positive numbers and a positive number ‘S’,
     find the length of the smallest contiguous subarray whose sum is
     greater than or equal to ‘S’. Return 0, if no such subarray exists.
     
     Example 1:
     
     Input: [2, 1, 5, 2, 3, 2], S=7
     Output: 2
     Explanation: The smallest subarray with a sum greater
     than or equal to '7' is [5, 2].
     
     Example 2:
     
     Input: [2, 1, 5, 2, 8], S=7
     Output: 1
     Explanation: The smallest subarray with a sum greater than or
     equal to '7' is [8].
     
     Example 3:
     
     Input: [3, 4, 1, 1, 6], S=8
     Output: 3
     Explanation: Smallest arrays with a sum greater than or
     equal to '8' are [3, 4, 1] or [1, 1, 6].
     
      */
     
     public int minSubArrayLen(int target, int[] nums) {
	int start = 0, end;
	int total = 0, minLen = Integer.MAX_VALUE;
	
	for (end = 0; end < nums.length; end++) {
	     total += nums[end];
	     
	     while (total >= target){
		minLen = Math.min(minLen, end - start + 1);
		total -= nums[start];
		start++;
	     }
	};
 
	return minLen == Integer.MAX_VALUE ? 0 : minLen;
     }
     
     public static void main(String[] args) {
	System.out.println(SmallestSubArrGivenSum.builder().build().minSubArrayLen(7, new int[] {2, 1, 5, 2, 3, 2} ));
	System.out.println(SmallestSubArrGivenSum.builder().build().minSubArrayLen(7, new int[] {2, 1, 5, 2, 8} ));
     }
     
}
