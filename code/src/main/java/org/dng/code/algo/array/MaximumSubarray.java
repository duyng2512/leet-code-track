package org.dng.code.algo.array;

import lombok.Builder;

@Builder
public class MaximumSubarray {

public static void main(String[] args) {
	System.out.println(MaximumSubarray.builder().build().maxSubArray(new int[]{-2, 3, 4, 1}));
}

public int maxSubArray(int[] nums) {
	int[] currentTotal = new int[nums.length];
	currentTotal[0] = nums[0];
	int maxTotal = nums[0];
	
	for (int i = 1; i < nums.length; i++) {
		if (currentTotal[i - 1] < 0) {
			currentTotal[i] = nums[i];
		} else {
			currentTotal[i] = nums[i] + currentTotal[i - 1];
			// If the previous subarray is positive, it is worth to be added
		}
		maxTotal = Math.max(currentTotal[i], maxTotal);
	}
	return maxTotal;
}
}
