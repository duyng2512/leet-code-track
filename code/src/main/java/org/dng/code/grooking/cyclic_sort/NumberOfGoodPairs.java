package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class NumberOfGoodPairs {

// 0, 0 => 2*1 = 1
// 0, 0, 0 => 3 3*2 / 2
// 0, 0, 0, 0 => 6 4*3 = 6
// 1, 2, 3, 4, 5 => 10 5*4 / 2 = 10
     
     /*
	Given an array of integers nums, return the number of good pairs.
 
	A pair (i, j) is called good if nums[i] == nums[j] and i < j.
	
	Example 1:
	
	Input: nums = [1,2,3,1,1,3]
	Output: 4
	Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
	Example 2:
	
	Input: nums = [1,1,1,1]
	Output: 6
	Explanation: Each pair in the array are good.
	Example 3:
	
	Input: nums = [1,2,3]
	Output: 0
      */

public static void main(String[] args) {
	int result = NumberOfGoodPairs.builder().build().numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
	System.out.println(result);
	result = NumberOfGoodPairs.builder().build().numIdenticalPairs(new int[]{1, 1, 1, 1});
	System.out.println(result);
}

public int numIdenticalPairs(int[] nums) {
	if (nums.length == 1) return 0;
	Arrays.sort(nums);
	int prev = nums[0];
	int count = 1;
	int total = 0;
	for (int i = 1; i < nums.length; i++) {
		if (nums[i] == prev) {
			count++;
		} else {
			prev = nums[i];
			total += count * (count - 1) / 2;
			count = 1;
		}
	}
	total += count * (count - 1) / 2;
	return total;
}

}
