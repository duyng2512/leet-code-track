package org.dng.code.grooking.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
     
     /**
      * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
      * You may return the answer in any order.
      *
      * Example 1:
      *
      * Input: n = 4, k = 2
      * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
      * Explanation: There are 4 choose 2 = 6 total combinations.
      * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
      * Example 2:
      *
      * Input: n = 1, k = 1
      * Output: [[1]]
      * Explanation: There is 1 choose 1 = 1 total combination.
      *
      * @param n
      * @param k
      * @return
      */
     
     public static List<List<Integer>> combine(int n, int k) {
	// Create result array
	List<List<Integer>> result = new ArrayList<>();
 
	/**
	 * Intuitive, Create a temp array,
	 * we loop through start to n and
	 * add each item to temp array, when
	 * temp array is full (equal k) we pop
	 * the temp to result array.
	 *
	 * In for loop we skip already exist element
	 * For back tracking problems, clear the last
	 * element is a must
	 */
	
	backtracking(result, new ArrayList<>(), n, k, 1);
	return result;
     }
     
     public static void backtracking(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
	if (temp.size() == k) {
	     result.add(new ArrayList<>(temp));
	} else {
	     for (int i = start; i <= n; i++) {
		if (temp.contains(i)) continue;
		temp.add(i);
		backtracking(result, temp, n, k, i+1);
		temp.remove(temp.size()-1);
	     }
	}
     }
     
     public static void main(String[] args) {
	System.out.println(combine(4, 2));
     }
     
}
