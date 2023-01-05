package org.dng.code.grooking.backtrack;

import java.util.concurrent.atomic.AtomicInteger;

public class ClassicKnapsackProblems {
     
     /**
      * Introduction
      * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
      * The goal is to get the maximum profit out of the items in the knapsack.
      * Each item can only be selected once, as we don’t have multiple quantities of any item.
      * <p>
      * Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit.
      * Here are the weights and profits of the fruits:
      * <p>
      * Items: { Apple, Orange, Banana, Melon }
      * Weights: { 2, 3, 1, 4 }
      * Profits: { 4, 5, 3, 7 }
      * Knapsack capacity: 5
      * <p>
      * Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:
      * <p>
      * Apple + Orange (total weight 5) => 9 profit
      * Apple + Banana (total weight 3) => 7 profit
      * Orange + Banana (total weight 4) => 8 profit
      * Banana + Melon (total weight 5) => 10 profit
      * <p>
      * This shows that Banana + Melon is the best combination as it gives us the maximum
      * profit and the total weight does not exceed the capacity.
      */
     
     public static int solve(int[] weight, int[] profits, int cap) {
	AtomicInteger globalMax = new AtomicInteger();
	return backtrack(weight, profits, cap, 0);
     }
     
     private static int backtrack(int[] weight,
			    int[] profits,
			    int capacity,
			    int index) {
	
	// Base case
	if (capacity <= 0 || index >= weight.length) {
	     return 0;
	}
	
	// At every level there are two choice, choose of not choose current item
	int profit1 = 0;
	if (weight[index] <= capacity) {
	     profit1 = profits[index] + backtrack(weight, profits, capacity - weight[index], index + 1);
	}
	
	// Not choose current item
	int profit2 = backtrack(weight, profits, capacity, index + 1);
	
	return Math.max(profit1, profit2);
     }
     
     /**
      * Items: { Apple, Orange, Banana, Melon }
      * Weights: { 2, 3, 1, 4 }
      * Profits: { 4, 5, 3, 7 }
      * Knapsack capacity: 5
      */
     public static void main(String[] args) {
	System.out.println(solve(
	     new int[]{2, 3, 1, 4},
	     new int[]{4, 5, 3, 7},
	     5
	));
     }
}
