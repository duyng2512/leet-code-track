package org.dng.code.grooking.array;


import lombok.Builder;

import java.util.Arrays;

@Builder
public class MinimumInSortedArr {
     
     // Array is sorted but rotated, we need to find the smallest elements
     // 4 5 1 2 3
     
     public int findMin(int[] nums) {
	if (nums.length == 1) return nums[0];
	
	int mid = nums.length / 2;
	// Abnormal case
	if (nums[mid] < nums[mid - 1]) {
	     return nums[mid];
	}
	
	if (nums[mid] > nums[nums.length - 1]) {
	     // Min value belong the right part
	     return findMin(Arrays.copyOfRange(nums, mid, nums.length));
	} else {
	     // Min value belong the left part
	     return findMin(Arrays.copyOfRange(nums, 0, mid));
	}
     }

    public static void main(String[] args) {
        System.out.println(MinimumInSortedArr.builder().build().findMin(new int[]{ 21, 50, 1, 3, 7, 9, 19 }));
        System.out.println(MinimumInSortedArr.builder().build().findMin(new int[]{ 21, 33, 76, 90, 180, 330, -1, 1, 3, 5, 7, 10}));
        System.out.println(MinimumInSortedArr.builder().build().findMin(new int[]{12, 1 , 2, 5, 9, 10}));
        System.out.println(MinimumInSortedArr.builder().build().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(MinimumInSortedArr.builder().build().findMin(new int[] {11, 13, 15, 17} ));
    }

}
