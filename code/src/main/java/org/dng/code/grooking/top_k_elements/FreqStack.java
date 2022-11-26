package org.dng.code.grooking.top_k_elements;

import java.util.*;

public class FreqStack {
     
     /*
     	https://leetcode.com/problems/maximum-frequency-stack/
      */
     Map<Integer, Stack<Integer>> group;
     Map<Integer, Integer> map;
     int maxFreq = 0;
     
     public FreqStack() {
	group = new HashMap<>();
	map = new HashMap<>();
     }
     
     public void push(int val) {
	int freq = map.getOrDefault(val, 0) + 1;
	map.put(val, freq);
	if (freq > maxFreq) {
	     maxFreq = freq;
	}
	group.computeIfAbsent(freq, z -> new Stack<>()).push(val);
     }
     
     public int pop() {
	int pop = group.get(maxFreq).pop();
	map.put(pop, map.get(pop) - 1);
	if (group.get(maxFreq).size() == 0) {
	     maxFreq --;
	}
	return pop;
     }
     
     public static void main(String[] args) {
	// 5], [7], [5], [7], [4], [5]
	FreqStack stack = new FreqStack();
	stack.push(5);
	stack.push(7);
	stack.push(5);
	stack.push(7);
	stack.push(4);
	stack.push(5);
 
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	
     }
     
}
