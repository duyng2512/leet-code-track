package org.dng.code.grooking.array;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class RemoveElement {
     
     /**
      * Example 1:
      * <p>
      * Input: nums = [3,2,2,3], val = 3
      * Output: 2, nums = [2,2,_,_]
      * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
      * It does not matter what you leave beyond the returned k (hence they are underscores).
      * Example 2:
      * <p>
      * Input: nums = [0,1,2,2,3,0,4,2], val = 2
      * Output: 5, nums = [0,1,4,0,3,_,_,_]
      * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
      * Note that the five elements can be returned in any order.
      * It does not matter what you leave beyond the returned k (hence they are underscores).
      */
     
     static public int removeElement(int[] nums, int val) {
	int writeIdx = 0;
	for (int readIdx = 0; readIdx < nums.length; readIdx++) {
	     if (nums[readIdx] != val) {
		nums[writeIdx] = nums[readIdx];
		writeIdx++;
	     }
	}
	System.out.println(Arrays.toString(nums));
	return writeIdx;
     }
     
     
     public static void main(String[] args) {
	int[] arr = new int[]{3, 2, 2, 3};
	System.out.println(removeElement(arr, 3));
	
	arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
	System.out.println(removeElement(arr, 2));
     }
     
}
