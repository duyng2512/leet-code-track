package org.dng.code.grooking.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class RemoveKDigit {

/**
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * <p>
 * <p>
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output
 * must not contain leading zeroes.
 * <p>
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing
 * which is 0.
 */


static public String removeKdigits(String num, int k) {
	/*
	Intuitive: we want to keep an increasing value sequence.
	1 2 3 4 5 2 6 4
	
	when x = 2, 5 > 2, start to remove from stack until 2 == 2
	when x = 4, 6 > 4, start to remove from stack until 4 > 2
	
	Every step we add element to stack.
	
	When we detect s[i] > s[i+1] -> non increasing order.
	We start to remove until the stack peek is <= cur
	
	Case 1: if we do not remove enough K digit -> Just remove some of them
	at the end of the stack.
	
	Case 2: Remove some leading zeros
	
	Case 3: We remove all of them -> Return "0"
		
	 */
	
	if (k >= num.length()) return "0";
	
	Stack<Integer> stack = new Stack<>();
	for (int i = 0; i < num.length(); i++) {
		int cur = Character.getNumericValue(num.charAt(i));
		while (!stack.isEmpty() && stack.peek() > cur && k > 0) {
			stack.pop();
			k--;
		}
		stack.push(cur);
	}
	
	// When we remove all of them
	if (stack.size() == 0) return "0";
	
	// Pop the remains
	while (k > 0) {
		stack.pop();
		k--;
	}
	
	List<Integer> list = new LinkedList<>(stack);
	if (list.size() == 1) return listToString(list);
	
	// Remove zeros at the first line
	int firstZeros = 0;
	for (Integer integer : list) {
		if (integer != 0) {
			break;
		} else {
			firstZeros++;
		}
	}
	list = list.subList(firstZeros, list.size());
	if (list.size() == 0) return "0";
	return listToString(list);
}

public static String listToString(List<Integer> list) {
	StringBuilder builder = new StringBuilder();
	list.forEach(s -> builder.append(s.toString()));
	return builder.toString();
}

public static void main(String[] args) {
	// System.out.println(removeKdigits("12345264", 4)); // 1224
	// System.out.println(removeKdigits("190909", 3)); // 9
	System.out.println(removeKdigits("10", 1)); // 9
}

}
