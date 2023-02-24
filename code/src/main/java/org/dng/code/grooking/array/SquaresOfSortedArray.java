package org.dng.code.grooking.array;

/**
 * @author duyntc 01/2023
 */
public class SquaresOfSortedArray {

public int[] sortedSquares(int[] nums) {
	int[] result = new int[nums.length];
	
	int left = 0, right = nums.length - 1;
	int index = nums.length - 1;
	
	while (left <= right) {
		int numLeft = nums[left] * nums[left];
		int numRight = nums[right] * nums[right];
		
		if (numLeft > numRight) {
			result[index] = numLeft;
			left++;
		} else {
			result[index] = numRight;
			right--;
		}
		index--;
	}
	return result;
}

}
