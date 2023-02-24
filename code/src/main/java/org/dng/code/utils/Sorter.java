package org.dng.code.utils;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class Sorter {

/**
 * Selection sort: intuitive select the min element of the
 * array swap the min_index with the current index
 */
static public void selectionSort(int[] arr) {
	int minIdx;
	for (int i = 0; i < arr.length; i++) {
		minIdx = i;
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[j] < arr[minIdx]) {
				minIdx = j;
			}
		}
		int temp = arr[i];
		arr[i] = arr[minIdx];
		arr[minIdx] = temp;
	}
}

/**
 * Insertion sort: intuitive for every index, swap all inversion from 0 -> current index
 */
static public void insertionSort(int[] arr) {
	int index;
	for (int i = 1; i < arr.length; i++) {
		index = i;
		while (index > 0 && arr[index - 1] > arr[index]) {
			int temp = arr[index];
			arr[index] = arr[index - 1];
			arr[index - 1] = temp;
			index -= 1;
		}
	}
}

/**
 * Counting sort: for special array: length = N and value from 0 -> N
 * Example: [0, 6, 4, 2, 1, 3, 5] N = 6
 *
 * @param args
 */

public static void main(String[] args) {
	int[] arr;
	arr = new int[]{9, 2, 3, 1};
	selectionSort(arr);
	System.out.println(Arrays.toString(arr));
	
}
}
