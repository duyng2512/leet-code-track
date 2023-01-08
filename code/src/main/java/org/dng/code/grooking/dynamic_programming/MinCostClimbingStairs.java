package org.dng.code.grooking.dynamic_programming;

/**
 * @author duyntc 01/2023
 */
public class MinCostClimbingStairs {
     
     /**
      * You are given an integer array cost where cost[i] is the cost of ith step
      * on a staircase. Once you pay the cost, you can either climb one or two steps.
      * <p>
      * You can either start from the step with index 0, or the step with index 1.
      * <p>
      * Return the minimum cost to reach the top of the floor.
      * <p>
      * Example 1:
      * <p>
      * Input: cost = [10,15,20]
      * Output: 15
      * Explanation: You will start at index 1.
      * - Pay 15 and climb two steps to reach the top.
      * The total cost is 15.
      * Example 2:
      * <p>
      * Input: cost = [1,100,1,1,1,100,1,1,100,1]
      * Output: 6
      * Explanation: You will start at index 0.
      * - Pay 1 and climb two steps to reach index 2.
      * - Pay 1 and climb two steps to reach index 4.
      * - Pay 1 and climb two steps to reach index 6.
      * - Pay 1 and climb one step to reach index 7.
      * - Pay 1 and climb two steps to reach index 9.
      * - Pay 1 and climb one step to reach the top.
      * The total cost is 6.
      */
     
     static public int minCostClimbingStairs(int[] cost) {
	int[] memo = new int[cost.length];
	for (int i = 0; i < cost.length; i++) {
	     memo[i] = -1;
	}
	return Math.min(runRecursive(memo, cost, 0), runRecursive(memo, cost, 1));
     }
     
     static public int runRecursive(int[] memo, int[] cost, int index) {
	// Base case
	if (index >= cost.length) {
	     return 0;
	}
	
	if (memo[index] != -1) {
	     return memo[index];
	}
	
	int oneStep = runRecursive(memo, cost, index + 1) + cost[index];
	int twoStep = runRecursive(memo, cost, index + 2) + cost[index];
	
	int result = Math.min(oneStep, twoStep);
	memo[index] = result;
	return result;
     }
     
     public static void main(String[] args) {
	System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
	System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
     }
}
