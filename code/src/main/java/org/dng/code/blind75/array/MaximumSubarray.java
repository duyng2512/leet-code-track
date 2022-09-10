package org.dng.code.blind75.array;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int currentTotal = nums[0];
        int maxTotal = nums[0];

        int startIndex = 0;
        int endIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (currentTotal + nums[i] < nums[i]) {
                currentTotal = nums[i]; // Get rid of the negative part
                startIndex = i;
            } else {
                currentTotal = currentTotal + nums[i];
            }

            if (maxTotal < currentTotal) {
                maxTotal = currentTotal;
                endIndex = i;
            }
        }
        return maxTotal;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSubarray.builder().build().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
