package org.dng.code.grooking.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
     
     /*
          Problem Statement
          Given a set of distinct numbers, find all of its permutations.
          
          Permutation is defined as the re-arranging of the elements of the set.
          For example, {1, 2, 3} has the following six permutations:
          
          {1, 2, 3}
          {1, 3, 2}
          {2, 1, 3}
          {2, 3, 1}
          {3, 1, 2}
          {3, 2, 1}
          If a set has ‘n’ distinct elements it will have n!n! permutations.
          
          Example 1:
          
          Input: [1,3,5]
          Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
      */


//     public static List<List<Integer>> permute(int[] nums) {
//          List<List<Integer>> list = new ArrayList<>();
//	backtrack(list, new ArrayList<>(), nums);
//          return list;
//     }

private static void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
	if (tempList.size() == nums.length) {
		ans.add(new ArrayList<>(tempList));
	} else {
		for (int num : nums) {
			
			/**
			 * Intuitive: add one number to current temp array
			 */
			
			if (tempList.contains(num)) continue;
			tempList.add(num);
			backtrack(ans, tempList, nums);
			tempList.remove(tempList.size() - 1);
		}
	}
}


/**
 * https://leetcode.com/problems/permutations/solutions/222300/permutations/
 * Here is a backtrack function which takes the index of the first integer to consider as an argument backtrack(first).
 * <p>
 * If the first integer to consider has index n that means that the current permutation is done.
 * Iterate over the integers from index first to index n - 1.
 * Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).
 * Proceed to create all permutations which starts from i-th integer : backtrack(first + 1).
 * Now backtrack, i.e. swap(nums[first], nums[i]) back.
 *
 * @param result
 * @param temp
 * @param n
 * @param first
 */
private static void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int first) {
	
	// Base case
	if (first == n) {
		result.add(new ArrayList<>(temp));
	}
	
	// Other case
	for (int i = first; i < n; i++) {
		Collections.swap(temp, first, i);
		backtrack(result, temp, n, first + 1);
		// Swap back
		Collections.swap(temp, first, i);
	}
}

private static List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	
	ArrayList<Integer> numList = new ArrayList<>();
	for (int num : nums)
		numList.add(num);
	
	backtrack(result, numList, nums.length, 0);
	return result;
}

public static void main(String[] args) {
	int[] arr = new int[]{1, 2, 3};
	System.out.println(permute(arr));
	
}

}
