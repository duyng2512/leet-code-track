package org.dng.code.grooking.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class HouseRobber {

static public int rob(int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	return run(map, nums, 0);
}

static public int run(Map<Integer, Integer> map, int[] nums, int index) {
	// When exceed just return base case = 0  for computation
	if (index >= nums.length) {
		return 0;
	}
	
	if (map.containsKey(index)) {
		return map.get(index);
	}
	
	// Because we can not take adjacent house, so we have to
	// choose take the next-next house or not take it at all
	
	int choose = run(map, nums, index + 2) + nums[index];
	int notChoose = run(map, nums, index + 1);
	
	map.put(index, Math.max(choose, notChoose));
	
	return map.get(index);
}

static public int runArray(int[] nums) {
	int N = nums.length;
	int[] result = new int[N + 1];
	
	// Base case
	result[N] = 0;
	result[N - 1] = nums[N - 1];
	
	for (int i = N - 2; i >= 0; i--) {
		result[i] = Math.max(nums[i] + result[i + 2], result[i + 1]);
	}
	
	return result[0];
}

public static void main(String[] args) {
	System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
	System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // 12
	System.out.println(runArray(new int[]{1, 2, 3, 1})); // 4
	System.out.println(runArray(new int[]{2, 7, 9, 3, 1})); // 12
}
}
