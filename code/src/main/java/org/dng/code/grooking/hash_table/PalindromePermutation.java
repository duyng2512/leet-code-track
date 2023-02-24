package org.dng.code.grooking.hash_table;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

static public boolean canPermutePalindrome(String s) {
	
	Map<Character, Integer> map = new HashMap<>();
	
	for (int i = 0; i < s.length(); i++) {
		char k = s.charAt(i);
		map.put(s.charAt(i), !map.containsKey(k) ? 1 : map.get(k) + 1);
	}
	
	boolean isOdd = false;
	
	for (Map.Entry<Character, Integer> entry : map.entrySet()) {
		
		if (entry.getValue() % 2 == 0) {
			continue;
		} else {
			if (isOdd) return false;
			isOdd = true;
		}
	}
	
	return true;
}

static public boolean isPalindrome(String string) {
	int left = 0;
	int right = string.length() - 1;
	
	while (left <= right) {
		if (string.charAt(left) == string.charAt(right)) {
			left++;
			right--;
		} else {
			return false;
		}
	}
	return true;
}

public static void main(String[] args) {
	// Palindrome Permutation
	System.out.println(canPermutePalindrome("code"));
	System.out.println(canPermutePalindrome("aab"));
	System.out.println(canPermutePalindrome("carerac"));
	
}

}
