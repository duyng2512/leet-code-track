package org.dng.code.grooking.dynamic_programming;

/**
 * @author duyntc 01/2023
 */
public class ClimbingStairs {
     
     /**
      * You are climbing a staircase. It takes n steps to reach the top.
      * <p>
      * Each time you can either climb 1 or 2 steps. In how many distinct
      * ways can you climb to the top?
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: n = 2
      * Output: 2
      * Explanation: There are two ways to climb to the top.
      * 1. 1 step + 1 step
      * 2. 2 steps
      * Example 2:
      * <p>
      * Input: n = 3
      * Output: 3
      * Explanation: There are three ways to climb to the top.
      * 1. 1 step + 1 step + 1 step
      * 2. 1 step + 2 steps
      * 3. 2 steps + 1 step
      */
     
     static public int climbStairs(int n) {
	int[] memo = new int[n + 1];
	for (int i = 0; i < n + 1; i++) {
	     memo[i] = -1;
	}
	return runRecursive(n, memo);
     }
     
     static public int runRecursive(int n, int[] memo) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (n == 2) return 2;
	
	if (memo[n] != -1) {
	     return memo[n];
	}
	
	memo[n] = runRecursive(n - 1, memo) + runRecursive(n - 2, memo);
	
	return memo[n];
     }
     
     static public int runArray(int n) {
	int[] arr = new int[n + 1];
	
	if (n <= 2) return n;
	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 2;
	
	for (int i = 3; i < n + 1; i++) {
	     arr[i] = arr[i - 1] + arr[i - 2];
	}
	
	return arr[n];
     }
     
     public static void main(String[] args) {
	System.out.println(climbStairs(10)); // 89
	System.out.println(runArray(10)); // 89
     }
}
