package org.dng.code.utils;

public class MiscUtils {
     
     static public void swap(int[] arr, int curIdx, int correctIdx) {
	int temp = arr[curIdx];
	arr[curIdx] = arr[correctIdx];
	arr[correctIdx] = temp;
     }
     
}
