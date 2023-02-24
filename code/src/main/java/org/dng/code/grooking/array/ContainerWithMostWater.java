package org.dng.code.grooking.array;

import lombok.Builder;

@Builder
public class ContainerWithMostWater {

public static void main(String[] args) {
	System.out.println(ContainerWithMostWater.builder().build().maxArea(new int[]{1, 1}));
	System.out.println(ContainerWithMostWater.builder().build().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
}

/**
 * You are given an integer array height of length n. There are n vertical
 * lines drawn such that the two endpoints of the ith line are (i, 0) and
 * (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that
 * the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 */

public int maxArea(int[] height) {
	
	int maxVol = 0;
	int startIdx = 0;
	int endIdx = height.length - 1;
	
	for (int i = 0; i < height.length; i++) {
		// Calculate Current Area
		
		int w = endIdx - startIdx;
		int h = Math.min(height[endIdx], height[startIdx]);
		
		int currentVol = (w * h);
		maxVol = Math.max(currentVol, maxVol);
		
		// Intuitive here is that we want to keep the
		// higher height since it will give more water
		if (height[endIdx] > height[startIdx]) {
			startIdx++;
		} else {
			endIdx--;
		}
		
	}
	return maxVol;
}
}
