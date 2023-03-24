package org.dng.code.grooking.two_pointer;

import java.util.Arrays;

public class RemoveDuplicate {
     /*
     Example 1:
     
	Input: nums = [1,1,2]
          Output: 2, nums = [1,2,_]
          Explanation: Your function should return k = 2,
          with the first two elements of nums being 1 and 2 respectively.
          It does not matter what you leave beyond the returned k
          (hence they are underscores).
	
     Example 2:
	Input: nums = [0,0,1,1,1,2,2,3,3,4]
          Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
          Explanation: Your function should return k = 5, with
          the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
          It does not matter what you leave beyond the returned k (hence
          they are underscores).
          
          1, 2, 2, 2, 3, 3, 4, 4, 5
          
          1, 2, 3, 2, 3, 3, 4, 4, 5
          
      */
     
     /*
          Intuitive:
          
          Let assume array have 5 unique index:
          If in correct order, each time we encounter a duplicate,
          it should be in the duplicate count value.
          
     
      */

public static void main(String[] args) {
	RemoveDuplicate duplicate = new RemoveDuplicate();
	int result = duplicate.removeDuplicate(new int[]{2, 3, 3, 3, 6, 9, 9});
}

// 0 0 1 2 2 3
// 0 1 2 2 2 3
// 0 1 2 3 2 3

public int removeDuplicate(int[] nums) {
	int dupIdx = 1; // Always add first index
	for (int i = 1; i < nums.length; i++) {
		if (nums[i] != nums[i - 1]) { // encounter non duplicate
			nums[dupIdx] = nums[i];
			dupIdx++;
		}
	}
	
	return dupIdx;
}

}
