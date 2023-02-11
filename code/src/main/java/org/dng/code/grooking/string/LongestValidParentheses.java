package org.dng.code.grooking.string;

import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class LongestValidParentheses {
     
     /**
      * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
      * substring
      * .
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: s = "(()"
      * Output: 2
      * Explanation: The longest valid parentheses substring is "()".
      * Example 2:
      * <p>
      * Input: s = ")()())"
      * Output: 4
      * Explanation: The longest valid parentheses substring is "()()".
      * Example 3:
      * <p>
      * Input: s = ""
      * Output: 0
      *
      * @param s
      * @return
      */
     
     // ((()))
     // Stack: -1 (
     // -1 0 1 2
     // -1 0 1   index = 3
     static public int longestValidParentheses(String s) {
	Stack<Integer> stack = new Stack<>();
	stack.push(-1);
	
	int result = 0;
	
	for (int i = 0; i < s.length(); i++) {
	     
	     // If element = ( then push index to stack
	     if (s.charAt(i) == '(') {
		stack.push(i);
	     } else {
		stack.pop();
		
		if (stack.isEmpty()) {
		     stack.push(i);
		} else {
		     result = Math.max(result, i - stack.peek());
		}
	     }
	}
	return result;
     }
     
     public static void main(String[] args) {
	// s = "(()" = 2
	System.out.println(longestValidParentheses("(()"));
	
	// s = ")()())" = 4
	System.out.println(longestValidParentheses(")()())"));
 
	// s = "" = 0
	System.out.println(longestValidParentheses(""));
     }
}
