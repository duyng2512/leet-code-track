package org.dng.code.grooking.sliding_window;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class NoRepeatSubStr {
     
     /*
	Problem Statement
	Given a string, find the length of the longest
	substring which has no repeating characters.
	
	Example 1:
	Input: String="aabccbb"
	Output: 3
	Explanation: The longest substring without
	any repeating characters is "abc".
	
	Example 2:
	Input: String="abbbb"
	Output: 2
	Explanation: The longest substring without
	any repeating characters is "ab".
	
	Example 3:
	Input: String="abccde"
	Output: 3
	Explanation: Longest substrings without
	any repeating characters are "abc" & "cde".
      */

public static void main(String[] args) {
	System.out.println(NoRepeatSubStr.builder()
							   .build()
							   .lengthOfLongestSubstring("abccde"));
	
	System.out.println(NoRepeatSubStr.builder()
							   .build()
							   .lengthOfLongestSubstring("abbbb"));
}

public int lengthOfLongestSubstring(String s) {
	int start = 0, end;
	int max = 0;
	Map<Character, Integer> map = new HashMap<>();
	
	for (end = 0; end < s.length(); end++) {
		if (map.containsKey(s.charAt(end))) {
			// This already in map, so we start to "cut" the substring
			// so that they do not contain the repeat part
			start = Math.max(start, map.get(s.charAt(end)) + 1);
		}
		map.put(s.charAt(end), end);
		max = Math.max(max, end - start + 1);
	}
	return max;
}
}
