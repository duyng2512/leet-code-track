package org.dng.code.daily._2022;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 12/2022
 */
public class D20_JumpGame {

static Map<Integer, Index> map = new HashMap<>();

static public boolean run(int[] nums, int curIdx) {
	if (curIdx >= nums.length) {
		return false;
	}
	
	if (curIdx == nums.length - 1) {
		return true;
	}
	
	for (int i = 1; i <= nums[curIdx]; i++) {
		if (run(nums, curIdx + i)) {
			map.put(curIdx, Index.GOOD);
			return true;
		}
	}
	
	map.put(curIdx, Index.BAD);
	return false;
}

static public boolean canJump(int[] nums) {
	for (int i = 0; i < nums.length; i++) {
		map.put(i, Index.UNKNOWN);
	}
	map.put(nums.length - 1, Index.GOOD);
	return run(nums, 0);
}

public static void main(String[] args) {
	System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true
	System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false
}

/**
 * @desc: https://leetcode.com/problems/jump-game/
 */

enum Index {
	GOOD, BAD, UNKNOWN
}
}
