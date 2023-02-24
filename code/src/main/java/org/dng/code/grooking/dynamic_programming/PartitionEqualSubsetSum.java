package org.dng.code.grooking.dynamic_programming;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class PartitionEqualSubsetSum {

/**
 * Given an integer array nums, return true if you can partition
 * the array into two subsets such that the sum of the elements
 * in both subsets is equal or false otherwise.
 * <p>
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

static public boolean canPartition(int[] nums) {
	int total = Arrays.stream(nums).sum();
	Boolean[][] memo = new Boolean[nums.length + 1][total];
	return backtrack(memo, nums, 0, 0, 0);
}

/**
 * 3 2 1
 *
 * @param nums
 * @param sum1
 * @param sum2
 * @param index
 * @return
 */

static public boolean backtrack(Boolean[][] memo, int[] nums, int sum1, int sum2, int index) {
	if (index == nums.length) {
		return sum1 == sum2;
	} else {
		boolean result;
		
		if (memo[index][sum1] != null) {
			result = memo[index][sum1];
		} else {
			
			/**
			 * Intuitive: at every index, we have two choice, choose or notChoose current index to add
			 * to sum left or sum right
			 * We can use memo, to remember with this index, this sum, can lead to a success path or not
			 */
			
			boolean choose = backtrack(memo, nums, sum1 + nums[index], sum2, index + 1);
			boolean notChoose = backtrack(memo, nums, sum1, sum2 + nums[index], index + 1);
			result = choose || notChoose;
			memo[index][sum1] = result;
		}
		return result;
	}
}

public static void main(String[] args) {
	System.out.println(canPartition(new int[]{1, 5, 11, 5}));
}

}
