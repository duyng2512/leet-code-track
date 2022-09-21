package org.dng.code.blind75.array;

import lombok.Builder;

@Builder
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxVol = 0;
        int startIdx = 0;
        int endIdx = height.length-1;


        for (int i = 0; i < height.length; i++) {
            // Calculate Current Area
            int currentVol = ( (endIdx - startIdx) * Math.min(height[endIdx], height[startIdx]));
            maxVol = Math.max(currentVol, maxVol);

            if (height[endIdx] > height[startIdx]) {
                startIdx ++;
            } else {
                endIdx --;
            }

        }
        return maxVol;
    }

    public static void main(String[] args) {
        System.out.println(ContainerWithMostWater.builder().build().maxArea(new int[]{1, 1}));
        System.out.println(ContainerWithMostWater.builder().build().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
