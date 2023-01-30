package org.dng.code.grooking.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
     
     /**
      * Given an array of distinct integers candidates and a target integer target,
      * return a list of all unique combinations of candidates where the chosen numbers
      * sum to target. You may return the combinations in any order.
      *
      * The same number may be chosen from candidates an unlimited number of times. Two
      * combinations are unique if the frequency of at least one of the chosen numbers is different.
      *
      * The test cases are generated such that the number of unique combinations that sum up to target
      * is less than 150 combinations for the given input.
      *
      *
      * Example 1:
      * Input: candidates = [2,3,6,7], target = 7
      * Output: [[2,2,3],[7]]
      * Explanation:
      * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
      * 7 is a candidate, and 7 = 7.
      * These are the only two combinations.
      * Example 2:
      *
      * Input: candidates = [2,3,5], target = 8
      * Output: [[2,2,2,2],[2,3,3],[3,5]]
      * Example 3:
      *
      * Input: candidates = [2], target = 1
      * Output: []
      * @param candidates
      * @param target
      * @return
      */
     
     public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	List<List<Integer>> result = new ArrayList<>();
	backtracking(result, new ArrayList<>(), target, 0, candidates);
	return result;
     }
     
     public static void backtracking(List<List<Integer>> result,
			       List<Integer> temp,
			       int remain,
			       int start,
			       int[] candidates) {
	if (remain < 0) {
	     return;
	} else if (remain == 0){
	     result.add(new ArrayList<>(temp));
	} else {
	     for (int i = start; i < candidates.length ; i++) {
		temp.add(candidates[i]);
		backtracking(result, temp, remain - candidates[i], i, candidates);
		temp.remove(temp.size()-1);
	     }
	}
     }
     
     public static void main(String[] args) {
	System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
     }
}
