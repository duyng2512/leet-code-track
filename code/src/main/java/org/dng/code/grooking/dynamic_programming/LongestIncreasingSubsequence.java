package org.dng.code.grooking.dynamic_programming;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class LongestIncreasingSubsequence {
     
     /**
      * Given an integer array nums, return the length of the longest strictly increasing
      * subsequence
      * .
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: nums = [10,9,2,5,3,7,101,18,19]
      * Output: 4
      * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
      * Example 2:
      * <p>
      * Input: nums = [0,1,0,3,2,3]
      * Output: 4
      * Example 3:
      * <p>
      * Input: nums = [7,7,7,7,7,7,7]
      * Output: 1
      */
     
     // 0 1 0 3 2 3
     static public int lengthOfLIS(int[] nums) {
	int[] result = new int[nums.length];
	Arrays.fill(result, 1);
	
	for (int i = 0; i < nums.length; i++) {
	     for (int j = 0; j < i; j++) {
		if (nums[j] < nums[i]) {
		     result[i] = Math.max(result[i], result[j] + 1);
		}
	     }
	}
	
	int longest = 0;
	for (int j : result) {
	     longest = Math.max(longest, j);
	}
	return longest;
     }
     
     
     public static void main(String[] args) {
	int[] arr;
	arr = new int[]{0, 1, 0, 3, 2, 3}; // 4
	System.out.println("Result: " + lengthOfLIS(arr));
	
	arr = new int[]{7, 7, 7, 7, 7, 7, 7}; // 1
	System.out.println("Result: " + lengthOfLIS(arr));
	
	arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18}; // 4
	System.out.println("Result: " + lengthOfLIS(arr));
	
	arr = new int[]{4, 10, 4, 3, 8, 9}; // 3
	System.out.println("Result: " + lengthOfLIS(arr));
     }
}
