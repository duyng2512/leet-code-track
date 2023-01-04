package org.dng.code.grooking.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class ReplaceSubstringBalancedString {
     
     /*
	You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
 
	A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.
	
	Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
	
	Input: s = "QWER"
	Output: 0
	Explanation: s is already balanced.
	
	
	Input: s = "QQWE"
	Output: 1
	Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
      */
     
     static boolean isPerfect(Map<Character, Integer> map) {
	return map.entrySet().stream().noneMatch(e -> e.getValue() > 0);
     }
     
     static public int balancedString(String s) {
	
	/*
		Intuitive, first we count all character in string
		then we find to exceed one of them. For example there are 6 Qs in suppose to be 3 Qs,
		then there are 3Qs exceed. After the that the problems change to find the smallest
		substring that contain the exceed part
	 */
	
	int limit = s.length() / 4;
	Map<Character, Integer> map = new HashMap<>();
	
	map.put('Q', 0);
	map.put('W', 0);
	map.put('E', 0);
	map.put('R', 0);
	
	for (int i = 0; i < s.length(); i++) {
	     map.merge(s.charAt(i), 1, Integer::sum);
	}
	
	// Update map
	map.put('Q', Math.max(0, map.get('Q') - limit));
	map.put('W', Math.max(0, map.get('W') - limit));
	map.put('E', Math.max(0, map.get('E') - limit));
	map.put('R', Math.max(0, map.get('R') - limit));
	
	if (isPerfect(map)) {
	     return 0;
	}
	
	int start = 0, end;
	int result = Integer.MAX_VALUE;
	for (end = 0; end < s.length(); end++) {
	     map.merge(s.charAt(end), -1, Integer::sum);
	     
	     while (isPerfect(map)) {
		map.merge(s.charAt(start), 1, Integer::sum);
		result = Math.min(result, end - start + 1);
		start++;
	     }
	}
	return result;
     }
     
     
     public static void main(String[] args) {
	System.out.println(balancedString("QQQQEERR"));
     }
     
     
}
