package org.dng.code.grooking.array;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class MoveZeroes {
     
     /**
      * Given an integer array nums, move all 0's to the end of it while maintaining
      * the relative order of the non-zero elements.
      * <p>
      * Note that you must do this in-place without making a copy of the array.
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: nums = [0,1,0,3,12]
      * Output: [1,3,12,0,0]
      * Example 2:
      * <p>
      * Input: nums = [0]
      * Output: [0]
      *
      * @param nums
      */
     
     static public void moveZeroes(int[] nums) {
	int writeIdx = 0;
	
	for (int readIdx = 0; readIdx < nums.length; readIdx++) {
	     if (nums[readIdx] != 0) {
		nums[writeIdx] = nums[readIdx];
		writeIdx++;
	     }
	}
 
	for (int i = writeIdx; i < nums.length; i++) {
	     nums[i] = 0;
	}
     }
     
     public static void main(String[] args) {
	int[] arr = new int[]{0, 1, 0, 3, 12};
	moveZeroes(arr);
	System.out.println(Arrays.toString(arr));
     }
}
