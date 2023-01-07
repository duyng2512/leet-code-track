package org.dng.code.grooking.array;

/**
 * @author duyntc 01/2023
 */
public class MaxConsecutiveOnes {
     
     static public int findMaxConsecutiveOnes(int[] nums) {
	int start = 0;
	int end;
	int total = Integer.MIN_VALUE;
	
	for (end = 0; end < nums.length; end++) {
	     if (nums[end] == 0) {
		total = Math.max(end - start, total);
		start = end + 1;
	     }
	}
	
	total = Math.max(end - start, total);
	return total;
     }
     
     public static void main(String[] args) {
	int[] arr = new int[]{1, 1, 0, 1, 1, 1};
	System.out.println(findMaxConsecutiveOnes(arr));
	
	arr = new int[]{1, 0, 1, 1, 0, 1};
	System.out.println(findMaxConsecutiveOnes(arr));
	
     }
     
}
