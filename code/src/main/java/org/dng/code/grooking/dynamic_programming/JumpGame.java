package org.dng.code.grooking.dynamic_programming;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class JumpGame {

static Index[] memo;

static public boolean canJumpFromPosition(int position, int[] nums) {
	
	if (memo[position] != Index.UNKNOWN) {
		return memo[position] == Index.GOOD;
	}
	
	// Prevent array out of bound index
	int furthestStep = Math.min(position + nums[position], nums.length - 1);
	
	for (int nextStep = position + 1; nextStep <= furthestStep; nextStep++) {
		if (canJumpFromPosition(nextStep, nums)) {
			memo[position] = Index.GOOD;
			return true;
		}
	}
	memo[position] = Index.BAD;
	return false;
}

static public boolean canJump(int[] nums) {
	memo = new Index[nums.length];
	Arrays.fill(memo, Index.UNKNOWN);
	memo[nums.length - 1] = Index.GOOD;
	return canJumpFromPosition(0, nums);
}

public static void main(String[] args) {
	System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true
	System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false
}

/**
 * https://leetcode.com/problems/jump-game/
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * which makes it impossible to reach the last index.
 */

enum Index {
	GOOD, BAD, UNKNOWN
}
}
