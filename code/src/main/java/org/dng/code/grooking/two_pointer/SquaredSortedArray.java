package org.dng.code.grooking.two_pointer;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class SquaredSortedArray {
     /*
	Problem Statement
	Given a sorted array, create a new array containing
	squares of all the number of the input array in the
	sorted order.
	
	Example 1:
	     Input: [-2, -1, 0, 2, 3]
	     4 - 9
	     4 - 4
	     4 - 0 --> Swap
	     
	     Output: [0, 1, 4, 4, 9]
	
	Example 2:
	     Input: [-3, -1, 0, 1, 2]
	     Output: [0 1 1 4 9]
      */
     
     public int[] sortedSquares(int[] nums) {
	int[] result = new int[nums.length];
	
	int index = nums.length - 1;
	int left = 0, right = nums.length - 1;
	
	while(left <= right) {
	     int leftSquare = nums[left] * nums[left];
	     int rightSquare = nums[right] * nums[right];
	     
	     if (rightSquare > leftSquare) {
		result[index] = rightSquare;
		right --;
	     } else {
		result[index] = leftSquare;
		left++;
	     }
	     index --;
	}
	return result;
     }
     
     public static void main(String[] args) {
	System.out.println(Arrays.toString(SquaredSortedArray.builder().build().sortedSquares(new int[]{-3, -1, 0, 1, 2})));
     }

}
