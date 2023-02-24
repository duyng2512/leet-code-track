package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class FirstKPositiveMissing {

     /*
          Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
          Return the kth positive integer that is missing from this array.
          
          Example 1:
          Input: arr = [2,3,4,7,11], k = 5
          Output: 9
          Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
          Example 2:
          
          Input: arr = [1,2,3,4], k = 2
          Output: 6
          Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
      */

static public void swap(int[] arr, int curIdx, int correctIdx) {
	int temp = arr[curIdx];
	arr[curIdx] = arr[correctIdx];
	arr[correctIdx] = temp;
}

private static void cyclicSort(int[] arr) {
	int i = 0;
	while (i < arr.length) {
		int correctIdx = (arr[i] - 1);
		if (correctIdx >= 0 && correctIdx < arr.length && arr[i] != arr[correctIdx]) swap(arr, i, correctIdx);
		else i++;
	}
}

public static void main(String[] args) {
	System.out.println(FirstKPositiveMissing.builder().build().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
	
}

public int findKthPositive(int[] arr, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < arr.length; i++) {
		map.put(arr[i], i);
	}
	int count = 0;
	for (int i = 1; i < arr[arr.length - 1]; i++) {
		if (!map.containsKey(i)) count++;
		if (count == k) return i;
	}
	if (count < k) return arr[arr.length - 1] + (k - count);
	return -1;
}

}
