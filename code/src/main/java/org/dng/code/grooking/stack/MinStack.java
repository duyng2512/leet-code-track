package org.dng.code.grooking.stack;

import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class MinStack {
Stack<int[]> main = new Stack<>();

public MinStack() {
}

;

public static void main(String[] args) {
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	System.out.println(minStack.getMin());
	minStack.pop();
	System.out.println(minStack.top());
	System.out.println(minStack.getMin());
}

public void push(int val) {
	int[] element = new int[2];
	element[0] = val;
	
	if (main.isEmpty()) {
		element[1] = val;
	} else {
		int curMin = main.peek()[1];
		element[1] = Math.min(val, curMin);
	}
	main.push(element);
}

public void pop() {
	main.pop();
}

public int top() {
	return main.peek()[0];
}

public int getMin() {
	return main.peek()[1];
}
}
