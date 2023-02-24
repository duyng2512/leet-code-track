package org.dng.code.grooking.two_pointer;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class ThreeSumToCloset {
     
     /*
     Triplet Sum Close to Target (medium)
     
     Problem Statement
     Given an array of unsorted numbers and a target number, find a
     triplet in the array whose sum is as close to the target number
     than possible, return the sum of the triplet.
     If there are more than one such triplet, return the sum of the
     triplet with the smallest sum.
     
     Example 1:
     Input: [-2, 0, 1, 2], target=2
     Output: 1
     Explanation: The triplet [-2, 1, 2] has the closest sum to
     the target.
     
     Example 2:
     Input: [-3, -1, 1, 2], target=1
     Output: 0
     Explanation: The triplet [-3, 1, 2] has the closest sum to
     the target.
     
     Example 3:
     Input: [1, 0, 1, 1], target=100
     Output: 3
     Explanation: The triplet [1, 1, 1] has the closest sum to the
     target.
      */

public static void main(String[] args) {
	// Input: [-2, 0, 1, 2], target=2   -2 1 2
	System.out.println(ThreeSumToCloset.builder().build().threeSumClosest(new int[]{-2, 0, 1, 2}, 2));
	System.out.println(ThreeSumToCloset.builder().build().threeSumClosest(new int[]{1, 0, 1, 1}, 100));
}

public int threeSumClosest(int[] nums, int target) {
	int result = 0;
	int diff = Integer.MAX_VALUE;
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
		int current = nums[i];
		
		int left = i + 1;
		int right = nums.length - 1;
		while (left < right) {
			int curTotal = current + nums[left] + nums[right];
			int curDiff = Math.abs(target - (curTotal));
			
			// We found a new pair
			if (curDiff < diff) {
				diff = curDiff;
				result = curTotal;
			}
			
			// Update
			if (curTotal > target) {
				right--;
			} else if (curTotal < target) {
				left++;
			} else {
				return result;
			}
		}
	}
	return result;
}

}
