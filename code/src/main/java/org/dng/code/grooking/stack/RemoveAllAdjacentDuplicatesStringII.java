package org.dng.code.grooking.stack;

import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class RemoveAllAdjacentDuplicatesStringII {

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k
 * adjacent and equal letters from s and removing them, causing the left and the right side
 * of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It is guaranteed
 * that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */

// Tree Map
static public String removeDuplicates(String s, int k) {
	Stack<Integer> stack = new Stack<>();
	Character prev = s.charAt(0);
	stack.add(1);
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append(prev);
	
	for (int i = 1; i < s.length(); i++) {
		Character cur = s.charAt(i);
		stringBuilder.append(cur);
		// System.out.println("Index " + i + " Stack " + stack + " " + stringBuilder + " prev " + prev);
		
		if (!cur.equals(prev)) {
			stack.add(1);
			prev = cur;
		} else {
			int inc = stack.pop() + 1;
			stack.add(inc); // Update last index
			if (inc == k) {
				stack.pop();
				stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - k));
				if (stringBuilder.length() >= 1) {
					prev = stringBuilder.charAt(stringBuilder.length() - 1);
				} else {
					prev = '@';
				}
			}
			;
		}
	}
	return stringBuilder.toString();
}

public static void main(String[] args) {
	System.out.println(removeDuplicates("deeedbbbdaa", 3)); // "aa"
	System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4)); // "ybth"
}
}
