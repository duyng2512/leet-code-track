package org.dng.code.grooking.binary_search;

public class SearchInsertPosition {
     
     public static int searchInsert(int[] nums, int target) {
	int pivot, left = 0;
	int right = nums.length - 1;
	
	while (left <= right) {
	     pivot = (left + right) / 2;
	     if (nums[pivot] == target) return pivot;
	     else if (nums[pivot] > target) {
		right = pivot - 1;
	     } else {
		left = pivot + 1;
	     }
	}
	
	return left;
     }
     
     public static void main(String[] args) {
     }
     
}
