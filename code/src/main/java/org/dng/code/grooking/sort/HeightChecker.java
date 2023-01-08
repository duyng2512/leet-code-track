package org.dng.code.grooking.sort;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class HeightChecker {
     public int heightChecker(int[] heights) {
	int[] copy = Arrays.copyOf(heights, heights.length);
	Arrays.sort(heights);
	int count = 0;
	for (int i = 0; i < heights.length; i++) {
	     if (copy[i] != heights[i]) {
		count++;
	     }
	}
	return count;
     }
}
