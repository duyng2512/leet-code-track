package org.dng.code.blind75.array;


import lombok.Builder;

import java.util.Arrays;

@Builder
public class NonDecreaseByModifyAtMostOne {

    public boolean isNonDecrease(int[] nums) {
        if (nums.length == 1) return false;
        int nonDecreaseIdx = -1 ;

        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if ( (nums[i-1] > nums[i+1]) || (nonDecreaseIdx != -1)) {
                    return false;
                }
                nonDecreaseIdx = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(NonDecreaseByModifyAtMostOne.builder().build().isNonDecrease(new int[]{ 0,5,2,3 }));
        System.out.println(NonDecreaseByModifyAtMostOne.builder().build().isNonDecrease(new int[]{ 3,4,2,3 }));
        System.out.println(NonDecreaseByModifyAtMostOne.builder().build().isNonDecrease(new int[]{ -1,4,2,3 }));
    }

}
