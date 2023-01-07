package org.dng.code.grooking.array;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class MergeSortedArray {
     
     /**
      * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
      * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
      * <p>
      * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
      * <p>
      * The final sorted array should not be returned by the function, but instead be stored inside
      * the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements
      * denote the elements that should be merged, and the last n elements are set to 0 and should be
      * ignored. nums2 has a length of n.
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
      * Output: [1,2,2,3,5,6]
      * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
      * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
      * Example 2:
      * <p>
      * Input: nums1 = [1], m = 1, nums2 = [], n = 0
      * Output: [1]
      * Explanation: The arrays we are merging are [1] and [].
      * The result of the merge is [1].
      *
      * @param nums1
      * @param m
      * @param nums2
      * @param n
      */
     
     public void merge(int[] nums1, int m, int[] nums2, int n) {
	int[] num1Copy = Arrays.copyOfRange(nums1, 0, m);
	
	int p1 = m - 1, p2 = n - 1;
	
	for (int p = m + n - 1; p >= 0; p--) {
	     if (p2 < 0)
		break;
	     
	     if (p1 >= 0 && num1Copy[p1] < nums2[p2]) {
		nums1[p] = num1Copy[p2--];
	     } else {
		nums1[p] = nums2[p1--];
	     }
	     
	}
     }
     
}
