package org.dng.code.grooking.stack;

import java.util.Stack;

/**
 * @author duyntc 01/2023
 */
public class DecodeString {
     
     /*
	Given an encoded string, return its decoded string.
 
	The encoding rule is: k[encoded_string], where the encoded_string
	inside the square brackets is being repeated exactly k times.
	Note that k is guaranteed to be a positive integer.
	
	You may assume that the input string is always valid; there are no
	extra white spaces, square brackets are well-formed, etc. Furthermore,
	you may assume that the original data does not contain any digits and
	that digits are only for those repeat numbers, k. For example, there
	will not be input like 3a or 2[4].
	
	The test cases are generated so that the length of the output will never
	exceed 105.
      */
     
     static public String decodeString(String s) {
	StringBuilder builder = new StringBuilder(s);
	Stack<int[]> stack = new Stack<>();
	int count = 0;
	
	for (int i = 0; i < s.length(); i++) {
	     char cur = s.charAt(i);
	     if (cur == '[') {
		count++;
	     }
	}
	
	int index = 1;
	
	while (count > 0) {
	     char cur = builder.charAt(index);
	     
	     if (cur == '[') {
		int k = getNum(builder.toString(), index);
		int[] element = new int[2];
		element[0] = k;
		element[1] = index;
		stack.push(element);
		index++;
	     } else if (cur == ']') {
		int k = stack.peek()[0];
		int start = stack.peek()[1];
		int end = builder.toString().indexOf(']', start);
		stack.pop();
		
		String inside = builder.substring(start + 1, end);
		String orgString = builder.toString();
		String replaceString = k + "[" + inside + "]";
		String newString = inside.repeat(Math.max(0, k));
		String modifiedString = orgString.replace(replaceString, newString);
		builder = new StringBuilder(modifiedString);
		count--;
		index = index - replaceString.length() + newString.length();
	     } else {
		index++;
	     }
	}
	return builder.toString();
     }
     
     public static int getNum(String s, int index) {
	int start = index;
	while (true) {
	     if (start == 0) break;
	     if (Character.isDigit(s.charAt(start - 1))) {
		start--;
	     } else {
		break;
	     }
	}
	return Integer.parseInt(s.substring(start, index));
     }
     
     public static void main(String[] args) {
	System.out.println(decodeString("100[leetcode]"));
	System.out.println(decodeString("3[a]2[bc]")); // aaabcbc
	System.out.println(decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
	System.out.println(decodeString("3[a2[c]]")); // accaccacc
     }
}
