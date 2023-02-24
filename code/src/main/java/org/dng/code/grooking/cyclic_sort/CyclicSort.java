package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class CyclicSort {
     
     /*
	Problem Statement
	We are given an array containing ‘n’ objects. Each object, when created, was assigned a
	unique number from 1 to ‘n’ based on their creation sequence.
	This means that the object with sequence number ‘3’ was created just before the object
	with sequence number ‘4’.
	
	Write a function to sort the objects in-place on their creation sequence number in O(n)
	and without any extra space.
	For simplicity, let’s assume we are passed an integer array containing only the sequence
	numbers, though each number is actually an object.
	
	Example 1:
	
	Input: [3, 1, 5, 4, 2]
	Output: [1, 2, 3, 4, 5]
	
	Example 2:
	
	Input: [2, 6, 4, 3, 1, 5]
	Output: [1, 2, 3, 4, 5, 6]
	
	Example 3:
	
	Input: [1, 5, 6, 4, 3, 2]
	Output: [1, 2, 3, 4, 5, 6]
      */

// 4, 5, 6, 1, 3

// 6, 5, 4, 1, 3

public static void swap(int[] arr, int currIdx, int correctIdx) {
	int temp = arr[currIdx];
	arr[currIdx] = arr[correctIdx];
	arr[correctIdx] = temp;
}

public static void main(String[] args) {
	CyclicSort cyclicSort = CyclicSort.builder().build();
	cyclicSort.cyclicSortV2(new int[]{4, 5, 6, 2, 1, 3});
}

public void cyclicSort(int[] arr) {
	int n = arr.length;
	int i = 0;
	int item = arr[i];
	while (i < n) {
		int count = 0;
		int j = 0;
		while (j < n) {
			if (item > arr[j]) count++;
			j++;
		}
		
		if (count == i) {
			i++;
		} else {
			int temp = arr[count];
			swap(arr, i, count);
			item = temp;
		}
	}
	
	System.out.println("After sort :  ");
	System.out.print(Arrays.toString(arr));
}

public void cyclicSortV2(int[] arr) {
	int i = 0;
	while (i < arr.length) {
		int correctPos = arr[i] - 1;
		if (arr[i] != arr[correctPos]) swap(arr, i, correctPos);
		else i++;
	}
	System.out.println("After sort :  ");
	System.out.print(Arrays.toString(arr));
}

}
