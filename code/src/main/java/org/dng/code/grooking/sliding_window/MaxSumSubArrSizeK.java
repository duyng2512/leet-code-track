package org.dng.code.grooking.sliding_window;

import lombok.Builder;

@Builder
public class MaxSumSubArrSizeK {
     
     /*
     	Problem Statement #
	Given an array of positive numbers and a positive number ‘k’,
	find the maximum sum of any contiguous subarray of size ‘k’.
	
	Example 1:
	Input: [2, 1, 5, 1, 3, 2], k=3
	Output: 9
	Explanation: Subarray with maximum sum is [5, 1, 3].
	
	Example 2:
	Input: [2, 3, 4, 1, 5], k=2
	Output: 7
	Explanation: Subarray with maximum sum is [3, 4].
      */

public static void main(String[] args) {
	System.out.println(MaxSumSubArrSizeK.builder()
							   .build()
							   .maxSubArrOfSizeK(new int[]{2, 3, 4, 1, 5}, 2));
	
	System.out.println(MaxSumSubArrSizeK.builder()
							   .build()
							   .maxSubArrOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3));
}

public int maxSubArrOfSizeK(int[] arr, int k) {
	int start = 0, end;
	int max = 0, total = 0;
	for (end = 0; end < arr.length; end++) {
		total += arr[end];
		if (end - start + 1 > k) {
			total -= arr[start];
			start++;
		}
		max = Math.max(total, max);
	}
	return max;
}
}
