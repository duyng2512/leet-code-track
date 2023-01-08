package org.dng.code.grooking.array;

/**
 * @author duyntc 01/2023
 */
public class RemoveDuplicatesSortedArray {
     
     public int removeDuplicates(int[] nums) {
	int writeIdx = 1;
	for (int readIdx = 1; readIdx < nums.length; readIdx++) {
	     
	     // Not duplicate then let it be the right index
	     if (nums[readIdx - 1] != nums[readIdx]) {
		nums[writeIdx] = nums[readIdx];
		writeIdx++;
	     }
	}
	
	return writeIdx;
     }
     
}
