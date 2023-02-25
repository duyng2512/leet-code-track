package org.dng.code.by_tag.array;

public class SmallestPositiveInteger {
	boolean[] arr = new boolean[100000];
	
	public int solution(int[] A) {
		for (int j : A) {
			if (j >= 0) {
				arr[j] = true;
			}
		}
		
		for (int i = 1; i < arr.length ; i++) {
			if (!arr[i]) return i + 1;
		}
		
		return -1;
	}
	
}
