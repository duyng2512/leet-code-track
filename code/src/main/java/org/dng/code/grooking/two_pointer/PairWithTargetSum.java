package org.dng.code.grooking.two_pointer;

import java.util.HashSet;
import java.util.Set;


public class PairWithTargetSum {
    
    /*
    Problem Statement
    Given an array of sorted numbers and a target sum,
    find a pair in the array whose sum is equal to the given target.
    
    Write a function to return the indices of the two
    numbers (i.e. the pair) such that they add up to the given target.
    
    Example 1:
    
    Input: [1, 2, 3, 4, 6], target=6
    Output: [1, 3]
    Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
    
    Example 2:
    
    Input: [2, 5, 9, 11], target=11
    Output: [0, 2]
    Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
     */

public static void main(String[] args) {
	PairWithTargetSum sum = new PairWithTargetSum();
	sum.pairWithTargetSum(new int[]{2, 5, 9, 11}, 11);
	sum.pairWithTargetSum(new int[]{1, 2, 3, 4, 6}, 6);
}

public void pairWithTargetSum(int[] arr, int target) {
	int left = 0;
	int right = arr.length - 1;
	Set<Integer> result = new HashSet<>();
	
	while (left < right) {
		int total = arr[left] + arr[right];
		if (total < target) {
			left++;
		} else if (total > target) {
			right--;
		} else {
			result.add(left);
			result.add(right);
			System.out.println(result);
			return;
		}
	}
}
}
