package org.dng.code.grooking.two_pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duyntc 02/2023
 */
public class HappyNumber {
     
     
     /**
      * https://leetcode.com/problems/happy-number/description/?envType=study-plan&id=level-2
      * <p>
      * A happy number is a number defined by the following process:
      * <p>
      * Starting with any positive integer, replace the number by the sum of the squares of its digits.
      * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
      * Those numbers for which this process ends in 1 are happy.
      * Return true if n is a happy number, and false if not.
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: n = 19
      * Output: true
      * Explanation:
      * 12 + 92 = 82
      * 82 + 22 = 68
      * 62 + 82 = 100
      * 12 + 02 + 02 = 1
      * Example 2:
      * <p>
      * Input: n = 2
      * Output: false
      * <p>
      * // 2
      * // 4
      * // 16
      * //
      */
     
     
     public int takeSquare(int n) {
	List<Integer> segment = new ArrayList<>();
	while (n != 0) {
	     segment.add(n % 10);
	     n /= 10;
	}
	int total = 0;
	for (Integer val : segment) {
	     total += Math.pow(val, 2);
	}
	return total;
     }
     
     public boolean isHappy(int n) {
	int slow = takeSquare(n);
	int fast = takeSquare(takeSquare(n));
	
	while (true) {
	     if (slow == fast && fast != 1) return false;
	     if (fast == 1) return true;
	     
	     slow = takeSquare(slow);
	     fast = takeSquare(takeSquare(fast));
	}
     }
     
     public static void main(String[] args) {
	
     }
}
