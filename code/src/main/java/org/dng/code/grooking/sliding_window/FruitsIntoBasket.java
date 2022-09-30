package org.dng.code.grooking.sliding_window;

import lombok.Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class FruitsIntoBasket {

    /*
        Problem Statement
        Given an array of characters where each character represents a fruit tree,
        you are given two baskets and your goal is to put maximum number of fruits
        in each basket. The only restriction is that each basket can have only one type of fruit.

        You can start with any tree, but once you have started you can’t skip a tree.
        You will pick one fruit from each tree until you cannot, i.e., you will stop
        when you have to pick from a third fruit type.

        Write a function to return the maximum number of fruits in both the baskets.

        Example 1:

        Input: Fruit=['A', 'B', 'C', 'A', 'C']
        Output: 3
        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

        Example 2:

        Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
        Output: 5
        Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
        This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

        Find out the longest length of sub-arrays with at most 2 different numbers?
     */

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int windowStart = 0;
        int windowEnd;
        int maxLength = 0;

        for (windowEnd = 0; windowEnd < fruits.length; windowEnd ++) {
	  frequency.merge(fruits[windowEnd], 1, Integer::sum);

	  /* if (!frequency.containsKey(fruits[windowEnd])) {
		frequency.put(fruits[windowEnd], 1);
	      } else {
		frequency.put(fruits[windowEnd], frequency.get(fruits[windowEnd]) + 1);
	      }
	   */

	  while (frequency.size() > 2) {
	      int leftFruits = fruits[windowStart];
	      frequency.put(leftFruits, frequency.get(leftFruits) - 1);
	      if (frequency.get(leftFruits) == 0) frequency.remove(leftFruits);
	      windowStart++;
	  }
	  maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(FruitsIntoBasket.builder().build().totalFruit(new int[] {1, 2, 1}));
    }

}
