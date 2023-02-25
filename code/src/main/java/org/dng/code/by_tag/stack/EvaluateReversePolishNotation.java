package org.dng.code.by_tag.stack;

import java.util.Stack;

/**
 * @author duyntc 12/2022
 */
public class EvaluateReversePolishNotation {

/**
 * @desc: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */

static Stack<Integer> stack = new Stack<>();

static int calculate(int a, int b, String operator) {
	switch (operator) {
		case ("+"):
			return a + b;
		case ("-"):
			return a - b;
		case ("*"):
			return a * b;
		case ("/"):
			return a / b;
		default:
			return 0;
	}
}

static public int evalRPN(String[] tokens) {
	for (String token : tokens) {
		if (token.equals("+") ||
					token.equals("-") ||
					token.equals("/") ||
					token.equals("*")) {
			
			int second = stack.pop();
			int first = stack.pop();
			int result = calculate(first, second, token);
			stack.push(result);
		} else {
			stack.push(Integer.parseInt(token));
		}
	}
	return stack.peek();
}

public static void main(String[] args) {
	String[] tokens = new String[]{"2", "1", "+", "3", "*"};
	System.out.println(evalRPN(tokens));
}
}
