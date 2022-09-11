package org.dng.code.blind75.array;

import lombok.Builder;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
public class MaximumProductSubArr {

    /*
        	Given an integer array nums, find a contiguous non-empty subarray within
        	the array that has the largest product, and return the product.

        	The test cases are generated so that the answer will fit in a 32-bit integer.
        	A subarray is a contiguous subsequence of the array.

        	Example 1:
        	Input: nums = [2,3,-2,4]
        	Output: 6
        	Explanation: [2,3] has the largest product 6.

        	Example 2:
        	Input: nums = [-2,0,-1]
        	Output: 0
        	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

        	Example 3:
        	Input: nums = [9, 4, -1, 2, -8]
        	Output: 0
        	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

	Example 4:
        	Input: nums = [9, 4, -1, 2, 8]

        	Now if we have a negative number at arr[i+1] and if min_prod[i] is negative,
        	then the product of the two will be positive and can potentially be the largest
        	product. So, the key point here is to maintain both the max_prod and min_prod
        	such that at iteration i, they refer to the max and min product ending at index i-1.


     */

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int currMax = Math.max(max_so_far * nums[i], min_so_far * nums[i]);
            int currMin = Math.min(max_so_far * nums[i], min_so_far * nums[i]);
            max_so_far = Math.max(nums[i], currMax);
            min_so_far = Math.min(nums[i], currMin);
            result = Math.max(max_so_far, result);
        }

        return result;
    }

    public int maxInThree(int a, int b, int c) {
        if (a >= b && a >= c) return a;
        else if (b >= a && b >= c) return b;
        else return c;
    }

    public int minInThree(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        else if (b <= a && b <= c) return b;
        else return c;
    }

    public static void main(String[] args) {
        System.out.println(MaximumProductSubArr.builder().build().maxProduct(new int[] {-2, 0, -1} ));
        System.out.println(MaximumProductSubArr.builder().build().maxProduct(new int[] {2, 3, -2, 4} ));
        System.out.println(MaximumProductSubArr.builder().build().maxProduct(new int[] {9, 4, -1, 2, -8} ));
        System.out.println(MaximumProductSubArr.builder().build().maxProduct(new int[] {0, 2} ));
        System.out.println(MaximumProductSubArr.builder().build().maxProduct(new int[] {3,-1, 4} ));
        System.out.println(MaximumProductSubArr.builder().build().maxProduct(new int[] {2,-5, -2, -4, 3} ));
    }

}
