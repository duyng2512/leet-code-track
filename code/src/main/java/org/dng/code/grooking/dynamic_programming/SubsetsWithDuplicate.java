package org.dng.code.grooking.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicate {

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * @param nums
 * @return
 */

public static List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> ans = new ArrayList<>();
	Arrays.sort(nums);
	backtrack(ans, new ArrayList<>(), nums, 0);
	return ans;
}

private static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
	ans.add(new ArrayList<>(temp));
	for (int i = start; i < nums.length; i++) {
		if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
		temp.add(nums[i]);
		backtrack(ans, temp, nums, i + 1);
		temp.remove(temp.size() - 1);
	}
}

public static void main(String[] args) {
	
}
}
