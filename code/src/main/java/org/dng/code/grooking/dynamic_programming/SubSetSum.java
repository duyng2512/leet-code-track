package org.dng.code.grooking.dynamic_programming;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class SubSetSum {
     
     /**
      * Problem Statement
      * Given a set of positive numbers, determine if a subset
      * exists whose sum is equal to a given number ‘S’.
      * <p>
      * Example 1:
      * Input: {1, 2, 3, 7}, S=6
      * Output: True
      * The given set has a subset whose sum is '6': {1, 2, 3}
      * <p>
      * Example 2:
      * Input: {1, 2, 7, 1, 5}, S=10
      * Output: True
      * The given set has a subset whose sum is '10': {1, 2, 7}
      * <p>
      * Example 3:
      * Input: {1, 3, 4, 8}, S=6
      * Output: False
      * The given set does not have any subset whose sum is equal
      * to '6'.
      */
     
     static public boolean solve(int[] arr, int sum) {
	int total = Arrays.stream(arr).sum() + 1;
	Boolean[][] memo = new Boolean[arr.length][total];
	return backtrack(memo, arr, sum, 0, 0);
     }
     
     static public boolean backtrack(Boolean[][] memo, int[] arr, int sum, int curSum, int index) {
	if (curSum == sum)
	     return true;
     
	if (index == arr.length)
	     return false;
     
	if (memo[index][curSum] != null) {
	     return memo[index][curSum];
	}
 
	boolean choose = false;
	if (curSum + arr[index] <= sum) {
	     choose = backtrack(memo, arr, sum, curSum + arr[index], index + 1);
	}
	boolean notChoose = backtrack(memo, arr, sum, curSum, index + 1);
	boolean finalResult = choose || notChoose;
	memo[index][curSum] = finalResult;
	return finalResult;
     }
     
     public static void main(String[] args) {
	System.out.println(solve(new int[] {1, 2, 7, 1, 5}, 10));
	System.out.println(solve(new int[] {1, 2, 3, 7}, 6));
	System.out.println(solve(new int[] {1, 3, 4, 8}, 6));
     }
}
