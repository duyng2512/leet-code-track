package org.dng.code.grooking.array;

/**
 * @author duyntc 01/2023
 */
public class DuplicateZeros {

static public void duplicateZeros(int[] arr) {
	boolean prev = false;
	for (int i = 0; i < arr.length; i++) {
		if (prev) {
			prev = false;
			continue;
		}
		
		if (arr[i] == 0) {
			int start = i + 2;
			if (start < arr.length) {
				for (int j = arr.length - 1; j >= start; j--) {
					arr[j] = arr[j - 1];
				}
			}
			if (i + 1 < arr.length) arr[i + 1] = 0;
			prev = true;
		}
	}
}

public static void main(String[] args) {
	duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
}
}
     

