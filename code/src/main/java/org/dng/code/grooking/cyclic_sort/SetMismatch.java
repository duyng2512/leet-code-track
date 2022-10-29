package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Builder
public class SetMismatch {
     
     /*
	You have a set of integers s, which originally contains all the numbers from 1 to n.
	
	Unfortunately, due to some error, one of the numbers in s got duplicated to another
	number in the set, which results in repetition of one number and loss of another number.
 
	You are given an integer array nums representing the data status of this set after the error.
	
	Find the number that occurs twice and the number that is missing and return them in the form of an array.
	
	Example 1:
	
	Input: nums = [1,2,2,4]
	Output: [2,3]
	Example 2:
	
	Input: nums = [1,1]
	Output: [1,2]
      */
     
     static void cyclicSort(int[] arr) {
	int i = 0;
	while (i < arr.length) {
	     int correctIdx = arr[i] - 1;
	     if (arr[i] != arr[correctIdx]) swap(arr, i, correctIdx);
	     else i++;
	}
     }
     
     static void swap(int[] arr, int curIdx, int correctIdx) {
	int temp = arr[curIdx];
	arr[curIdx] = arr[correctIdx];
	arr[correctIdx] = temp;
     }
     
     public int[] findErrorNums(int[] nums) {
	Set<Integer> result = new HashSet<>();
	cyclicSort(nums);
	for (int i = 0; i < nums.length; i++) {
	     if (nums[i] - 1 != i) {
		result.add(nums[i]);
		result.add(i+1);
	     }
	}
	return result.stream().mapToInt(Integer::intValue).toArray();
     }
     
     public static void main(String[] args) {
	System.out.println(Arrays.toString(SetMismatch.builder().build().findErrorNums(new int[]{1, 2, 2, 4})));
     }
}
