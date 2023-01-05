package org.dng.code.grooking.backtrack;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class OnesAndZeroes {
     
     /**
      * You are given an array of binary strings strs and two integers m and n.
      * <p>
      * Return the size of the largest subset of strs such that there are at most
      * m 0's and n 1's in the subset.
      * <p>
      * A set x is a subset of a set y if all elements of x are also elements of y.
      * <p>
      * <p>
      * Example 1:
      * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
      * Output: 4
      * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
      * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
      * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
      * <p>
      * <p>
      * Example 2:
      * Input: strs = ["10","0","1"], m = 1, n = 1
      * Output: 2
      * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
      */
     
     static int count(String str, int num) {
	int res = 0;
	for (int i = 0; i < str.length(); i++) {
	     if (Character.getNumericValue(str.charAt(i)) == num) {
		res++;
	     }
	}
	return res;
     }
     
     static int[] count0;
     static int[] count1;
     
     static public int findMaxForm(String[] strs, int m, int n) {
	
	count0 = new int[strs.length];
	count1 = new int[strs.length];
	for (int i = 0; i < strs.length; i++) {
	     count0[i] = count(strs[i], 0);
	     count1[i] = count(strs[i], 1);
	}
	int total0 = Arrays.stream(count0).sum() + 1;
	int total1 = Arrays.stream(count1).sum() + 1;
	
	
	Integer[][][] memo = new Integer[strs.length][total0][total1];
	return backtrack(memo, strs, m, n, 0, 0, 0, 0);
     }
     
     static public int backtrack(Integer[][][] memo, String[] strings, int max0, int max1, int cur0, int cur1, int total, int index) {
	// Base case
	if (index == strings.length) {
	     return total;
	} else {
	     
	     // At every index we have two choice, choose or not choose current element
	     // If choose
	     
	     int result;
	     
	     if (memo[index][cur0][cur1] != null) {
		result = memo[index][cur0][cur1];
	     } else {
		
		int maxChoose = -1;
		
		if (cur0 + count0[index] <= max0 && cur1 + count1[index] <= max1) {
		     maxChoose = backtrack(memo,
			strings,
			max0,
			max1,
			cur0 + count0[index],
			cur1 + count1[index],
			total + 1,
			index + 1);
		}
		
		int maxNotChoose = backtrack(memo,
		     strings,
		     max0,
		     max1,
		     cur0,
		     cur1,
		     total,
		     index + 1);
		
		result = Math.max(maxChoose, maxNotChoose);
	     }
	     memo[index][cur0][cur1] = result;
	     return result;
	     
	}
     }
     
     public static void main(String[] args) {
	// ["10","0001","111001","1","0"], m = 5, n = 3 --> 4
	String[] strings = new String[]{"10", "0001", "111001", "1", "0"};
	
	// ["10","0","1"], m = 1, n = 1 ---> 2
	strings = new String[]{"10", "0", "1"};
	
	// ---> 9
	strings = new String[]{"0111000", "010101", "111", "000010", "01101", "0", "1", "01", "1010", "00", "1111", "001", "111000", "011", "10", "1101001111"};
	System.out.println(findMaxForm(strings, 9, 80));
     }
     
}
