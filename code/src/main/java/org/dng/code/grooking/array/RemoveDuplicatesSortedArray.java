package org.dng.code.grooking.array;

/**
 * @author duyntc 01/2023
 */
public class RemoveDuplicatesSortedArray {
     
     public int removeDuplicates(int[] nums) {
	int dupIdx = 1;
	for (int i = 1; i < nums.length; i++) {
	     
	     // Not duplicate then let it be the right index
	     if (nums[i - 1] != nums[i]) {
		nums[dupIdx] = nums[i];
		dupIdx++;
	     }
	}
	
	return dupIdx;
     }
     
}
