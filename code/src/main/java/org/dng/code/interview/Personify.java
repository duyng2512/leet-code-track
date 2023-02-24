package org.dng.code.interview;

import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class Personify {

public static boolean solve(String expression) {
	Stack<Character> stack = new Stack<>();
	
	for (int i = 0; i < expression.length(); i++) {
		if (expression.charAt(i) == '(' ||
					expression.charAt(i) == '[' ||
					expression.charAt(i) == '{') {
			stack.push(expression.charAt(i));
		} else {
			// Valid
			if (expression.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			}
			// Valid
			if (expression.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}
			
			// Valid
			if (expression.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			}
		}
	}
	return stack.isEmpty();
}

public static void main(String[] args) {
	System.out.println(solve("}{}"));
}

}
