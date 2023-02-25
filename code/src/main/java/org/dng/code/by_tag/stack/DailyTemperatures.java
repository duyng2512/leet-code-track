package org.dng.code.by_tag.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author duyntc 12/2022
 */
public class DailyTemperatures {

public static void main(String[] args) {

}

/**
 * @desc: https://leetcode.com/problems/daily-temperatures/
 */

public int[] dailyTemperatures(int[] temperatures) {
	int[] result = new int[temperatures.length];
	Arrays.fill(result, 0);
	Stack<Integer> stack = new Stack<>();
	
	for (int curDay = 0; curDay < temperatures.length; curDay++) {
		int currentTemp = temperatures[curDay];
		
		while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
			int prevDay = stack.pop();
			result[prevDay] = curDay - prevDay;
		}
		
		stack.push(curDay);
	}
	
	return result;
}
}
