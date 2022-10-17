package org.dng.code.grooking.two_pointer;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.TabExpander;

@Builder
public class SubArrWithProductTarget {
    /*
    
    Problem Statement 
    Given an array with positive numbers and a target number, 
    find all of its contiguous sub arrays whose product is less
    than the target number.

    Example 1:
    Input: [2, 5, 3, 10], target = 30
    Output: [2], [5], [2, 5], [3], [5, 3], [10]
    Explanation: There are six contiguous sub arrays whose product
    is less than the target.

    Example 2:
    Input: [8, 2, 6, 5], target = 50
    Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5] 
    Explanation: There are seven contiguous sub arrays whose product
    is less than the target.

    */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
    
        int currentProduct = 1;
        int startIndex = 0;
        int result = 0;
        Set<List<Integer>> resultSet = new HashSet<>();
    
        for (int i = 0; i < nums.length; i++) {
            currentProduct *= nums[i];
            while (currentProduct >= k && startIndex < nums.length) {
                currentProduct /= nums[startIndex];
                startIndex++;
            }
            result += i - startIndex + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubArrWithProductTarget.builder()
             .build()
             .numSubarrayProductLessThanK(new int[] {2, 5, 3, 10}, 30 ));
    }

}
