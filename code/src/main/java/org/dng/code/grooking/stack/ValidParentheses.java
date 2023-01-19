package org.dng.code.grooking.stack;

import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class ValidParentheses {
     
     /**
      * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
      * determine if the input string is valid.
      * <p>
      * An input string is valid if:
      * <p>
      * Open brackets must be closed by the same type of brackets.
      * Open brackets must be closed in the correct order.
      * Every close bracket has a corresponding open bracket of the same type.
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input: s = "()"
      * Output: true
      * Example 2:
      * <p>
      * Input: s = "()[]{}"
      * Output: true
      * Example 3:
      * <p>
      * Input: s = "(]"
      * Output: false
      */
     
     static public boolean isValid(String s) {
	Stack<Character> stack = new Stack<>();
 
	for (int i = 0; i < s.length(); i++) {
	     char c = s.charAt(i);
	     
	     if (c == '[' || c == '{' || c == '(') {
		stack.add(c);
	     }
	     
	     if (c == ']') {
		if (stack.isEmpty() || stack.peek() != '[') return false;
		stack.pop();
	     }
	     
	     if (c == '}') {
		if (stack.isEmpty() || stack.peek() != '{') return false;
		stack.pop();
	     }
	     
	     if (c == ')') {
		if (stack.isEmpty() || stack.peek() != '(') return false;
		stack.pop();
	     }
	}
	return stack.size() == 0;
     }
     
     public static void main(String[] args) {
	System.out.println(isValid( "()[]{}"));
	System.out.println(isValid( "(]"));
	System.out.println(isValid( ")("));
     }
}
