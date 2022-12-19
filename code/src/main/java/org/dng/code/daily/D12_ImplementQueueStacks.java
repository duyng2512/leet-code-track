package org.dng.code.daily;

import java.util.Stack;

class MyQueue {
     
     Stack<Integer> first = new Stack<>();
     Stack<Integer> last = new Stack<>();
     
     public MyQueue() {
     }
     
     public void push(int x) {
	first.push(x);
     }
     
     public int pop() {
	if (first.size() == 0) {
	     return 0;
	}
	
	if (first.size() == 1) {
	     return first.pop();
	}
	
	while (first.size() != 1) {
	     last.push(first.pop());
	}
	
	int result = first.pop();
	
	while (last.size() > 0) {
	     first.push(last.pop());
	}
	
	return result;
     }
     
     public int peek() {
	if (first.size() == 0) {
	     return 0;
	}
	
	if (first.size() == 1) {
	     return first.peek();
	}
	
	while (first.size() != 1) {
	     last.push(first.pop());
	}
	
	int result = first.peek();
	
	while (last.size() > 0) {
	     first.push(last.pop());
	}
	
	return result;
     }
     
     public boolean empty() {
	return first.isEmpty();
     }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class D12_ImplementQueueStacks {
     
     /**
      * @desc: https://leetcode.com/problems/implement-queue-using-stacks/
      */
     
     public static void main(String[] args) {
	MyQueue obj = new MyQueue();
	obj.push(1);
	obj.push(2);
	int param_2 = obj.pop();
	int param_3 = obj.peek();
	boolean param_4 = obj.empty();
 
	System.out.println(param_2);
	System.out.println(param_3);
	System.out.println(param_4);
     }
     
}
