package org.dng.code.by_tag.dynamic_programming;

import java.util.Arrays;

public class HouseRobber {
	
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
	
	// Iterative solution
	// robFrom(i) = max( robFrom(i+1), robFrom(i+2)+nums(i) )
	// next = robFrom(i+1)
	// nextPlusOne = robFrom(i+2)
	
	// How to update ?
	// next = current
	// nextPlusOne = next
	public int robIterative(int[] nums) {
		
		int N = nums.length;
		
		// Special handling for empty array case.
		if (N == 0) {
			return 0;
		}
		
		int next = nums[0];
		int nextPlusOne = 0;
		
		for (int i = 1; i < N; i++) {
			
			int current = Math.max(next, nextPlusOne + nums[i]);
			
			nextPlusOne = next;
			
			next = current;
		}
		return next;
	}
	
}
