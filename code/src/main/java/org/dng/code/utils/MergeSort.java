package org.dng.code.utils;

import java.util.Arrays;

public class MergeSort {

public static void main(String[] args) {
	MergeSort sort = new MergeSort();
	int[] arr = {9, 1, 5, 4, 2};
	int[] result = sort.mergeSort(arr, 0, arr.length - 1);
	System.out.println(Arrays.toString(result));
}

public int[] mergeSort(int[] arr, int left, int right) {
	
	if (left == right) {
		int[] temp = new int[1];
		temp[0] = arr[left];
		return temp;
	}
	
	int mid = (left + right) / 2;
	int[] leftArr = mergeSort(arr, left, mid);
	int[] rightArr = mergeSort(arr, mid + 1, right);
	
	return merge(leftArr, rightArr);
}

public int[] merge(int[] first, int[] second) {
	int[] sorted = new int[first.length + second.length];
	
	int i = 0;
	int j = 0;
	int k = 0;
	
	while (i < first.length && j < second.length) {
		
		if (first[i] < second[j]) {
			sorted[k] = first[i];
			i++;
		} else {
			sorted[k] = second[j];
			j++;
		}
		k++;
	}
	
	while (i < first.length) {
		sorted[k] = first[i];
		k++;
		i++;
	}
	
	while (j < second.length) {
		sorted[k] = second[j];
		k++;
		j++;
	}
	return sorted;
}

}
