package org.dng.code.grooking.two_pointer;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class DutchNationalFlagProblems {

public static void main(String[] args) {
	DutchNationalFlagProblems.builder()
			.build()
			.sortColors(new int[]{1, 0, 2, 1, 0});
	DutchNationalFlagProblems.builder()
			.build()
			.sortColors(new int[]{2, 0, 2, 1, 1, 0});
}

/*
Problem Statement
Given an array containing 0s, 1s and 2s, sort the array in-place.
You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue;
and since our input array also consists of three different numbers that
is why it is called Dutch National Flag issue.

Example 1:
Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]

Example 2:
Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]


The idea of solution is to move curr pointer along the array,
if nums[curr] = 0 - swap it with nums[p0], if nums[curr] = 2 - swap
it with nums[p2].
 */
public void sortColors(int[] nums) {
	int left = 0, i = 0;
	int right = nums.length - 1;
	
	while (i <= right) {
		int temp = nums[i];
		if (nums[i] == 2) {
			// Swap
			nums[i] = nums[right];
			nums[right] = temp;
			right--;
		} else if (nums[i] == 0) {
			// Swap
			nums[i] = nums[left];
			nums[left] = temp;
			left++;
			i++;
		} else {
			i++;
		}
	}
	
	System.out.println(Arrays.toString(nums));
}
}
