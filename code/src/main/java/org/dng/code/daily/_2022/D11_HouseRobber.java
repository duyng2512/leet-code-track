package org.dng.code.daily._2022;

import java.util.Arrays;

public class D11_HouseRobber {

/**
 * @desc: https://leetcode.com/problems/house-robber/
 */

private int[] memo;

int findMax(int[] nums, int i) {
	if (i >= nums.length) {
		return 0;
	}
	if (memo[i] != -1) return memo[i];
	
	// Choosing between rob this house or skip to the next home
	int ans = Math.max(findMax(nums, i + 1), findMax(nums, i + 2) + nums[i]);
	
	if (memo[i] == -1) memo[i] = ans;
	
	return ans;
}

public int rob(int[] nums) {
	memo = new int[nums.length];
	Arrays.fill(memo, -1);
	return findMax(nums, 0);
}

}
