package org.dng.code.grooking.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
     
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
