package org.dng.code.blind75.array;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] currentTotal = new int[nums.length];
        currentTotal[0] = nums[0];
        int maxTotal = nums[0];

        int startIndex = 0;
        int endIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (currentTotal[i-1] < 0) {
                currentTotal[i] = nums[i];
            } else {
                currentTotal[i] = nums[i] + currentTotal[i-1];  // If the previous subarray is positive, it is worth to be added
            }
            maxTotal = Math.max(currentTotal[i], maxTotal);
        }

        System.out.println("Start " + startIndex + " end " + endIndex);
        return maxTotal;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSubarray.builder().build().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
