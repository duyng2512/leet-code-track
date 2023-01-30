package org.dng.code.grooking.dynamic_programming;

/**
 * @author duyntc 01/2023
 */
public class JumpGameII {
     
     /**
      * https://leetcode.com/problems/jump-game-ii/
      * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
      * <p>
      * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
      * if you are at nums[i], you can jump to any nums[i + j] where:
      * <p>
      * 0 <= j <= nums[i] and
      * i + j < n
      * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you
      * can reach nums[n - 1].
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: nums = [2,3,1,1,4]
      * Output: 2
      * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
      * then 3 steps to the last index.
      * Example 2:
      * <p>
      * Input: nums = [2,3,0,1,4]
      * Output: 2
      */
     
     static public int jump(int[] nums) {
	// Using window sliding
	int cnt = 0, low = 0, high = 0, n = nums.length;
	while (high < n - 1) {
	     int maxJump = 0;
	     for (int i = low; i <= high; i++) {
		maxJump = Math.max(maxJump, i + nums[i]);
	     }
	     low = high + 1;
	     high = maxJump;
	     cnt++;
	}
	return cnt;
     }
     
     public static void main(String[] args) {
	System.out.println(jump(new int[]{2, 3, 1, 1, 4})); // 2
	// System.out.println(jump(new int[]{2, 3, 0, 1, 4})); // 2
     }
}
