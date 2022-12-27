package org.dng.code.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 12/2022
 */
public class D20_JumpGame {
     
     /**
      * @desc: https://leetcode.com/problems/jump-game/
      */
     
     enum Index {
	GOOD, BAD, UNKNOWN
     }
     
     static Map<Integer, Index> map = new HashMap<>();
     
     static public boolean run(int[] nums, int curIdx) {
	if (curIdx >= nums.length) {
	     return false;
	}
	
	if (curIdx == nums.length - 1) {
	     return true;
	}
	boolean res = false;
	for (int i = 1; i <= nums[curIdx]; i++) {
	     res = res || run(nums, curIdx + i);
	}
	return res;
     }
     
     static public boolean canJump(int[] nums) {
	return run(nums, 0);
     }
     
     public static void main(String[] args) {
	System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true
	System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false
     }
}
