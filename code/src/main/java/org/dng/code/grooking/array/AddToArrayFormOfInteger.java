package org.dng.code.grooking.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
     
     /**
      * The array-form of an integer num is an array representing its digits in left to right order.
      * <p>
      * For example, for num = 1321, the array form is [1,3,2,1].
      * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: num = [1,2,0,0], k = 34
      * Output: [1,2,3,4]
      * Explanation: 1200 + 34 = 1234
      * Example 2:
      * <p>
      * Input: num = [2,7,4], k = 181
      * Output: [4,5,5]
      * Explanation: 274 + 181 = 455
      * Example 3:
      * <p>
      * Input: num = [2,1,5], k = 806
      * Output: [1,0,2,1]
      * Explanation: 215 + 806 = 1021
      */
     
     // 9222
     //  923 = 10
     // 12 -> 3
     // 1 -> 2
     // 0 -> 9
     
     // [1,2,0,0] -> [0, 0, 2, 1]
     // [4, 3]
     
     // 2 1 5
     // 8 0 6 9 9
     // 0 2 1 // 1
     
     // 0
     // 3 2
     // 3 2
     
     /**
      * Input: num = [1,2,0,0], k = 34
      * <p>
      * 4 3 2 1
      * <p>
      * num = [2,1,5], k = 806
      * <p>
      * 1 / 81
      * 2 / 8
      * 0 / 0
      * <p>
      * Output: [1,2,3,4]
      * Explanation: 1200 + 34 = 1234
      *
      * @param num
      * @param k
      * @return
      */
     static public List<Integer> addToArrayForm(int[] num, int k) {
	List<Integer> list = new ArrayList<>();
	int index = num.length;
	
	while (--index >= 0 || k > 0) {
	     if (index >= 0) k += num[index]; // For case when k still there for example 2 1 5 + 8 0 6
	     list.add(k % 10);
	     k /= 10;
	}
	
	Collections.reverse(list);
	return list;
     }
     
     public static void main(String[] args) {
	System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
	System.out.println(addToArrayForm(new int[]{2, 7, 4}, 181));
	System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
	System.out.println(addToArrayForm(new int[]{0}, 23));
	
     }
     
}
