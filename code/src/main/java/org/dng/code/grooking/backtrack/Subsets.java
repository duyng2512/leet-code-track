package org.dng.code.grooking.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
     
     /**
      * Given an integer array nums of unique elements, return all possible
      * subsets (the power set).
      *
      * The solution set must not contain duplicate subsets. Return the solution in any order.
      * @param nums
      * @return
      */
     public static List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> ans = new ArrayList<>();
	backtrack(ans, new ArrayList<>(), nums, 0);
	return ans;
     }
     
     private static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
	// We don't have any condition here
	ans.add(new ArrayList<>(temp));
	for (int i = start; i < nums.length; i++) {
	     temp.add(nums[i]);
	     backtrack(ans, temp, nums, i+1);
	     temp.remove(temp.size() - 1);
	}
     }
     
     public static void main(String[] args) {
	System.out.println(subsets(new int[] {3, 5, 7} ));
     }
}
