package org.dng.code.algo.binary;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class BinarySearch {

public static void main(String[] args) {
	System.out.println(BinarySearch.builder().build().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2));
}

public int search(int[] arr, int target) {
	if (arr.length == 0) return -1;
	int mid = Math.floorDiv(arr.length, 2);
	if (arr[mid] < target) {
		return search(Arrays.copyOfRange(arr, mid + 1, arr.length), target);
	} else if (arr[mid] > target) {
		return search(Arrays.copyOfRange(arr, 0, mid), target);
	} else {
		return mid;
	}
}

int binarySearch(int[] arr, int x) {
	int l = 0, r = arr.length - 1;
	while (l <= r) {
		int m = (r + l) / 2;
		
		// Check if x is present at mid
		if (arr[m] == x)
			return m;
		
		// If x greater, ignore left half
		if (arr[m] < x)
			l = m + 1;
			
			// If x is smaller, ignore right half
		else
			r = m - 1;
	}
	
	// if we reach here, then element was
	// not present
	return -1;
}

}
