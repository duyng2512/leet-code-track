package org.dng.code.daily._2023;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 02/2023
 */
public class D1_VerifyingAlienDictionary {
     
     static public boolean isAlienSorted(String[] words, String order) {
	Map<Character, Integer> map = buildMap(order);
	for (int i = 1; i < words.length; i++) {
	     if (compareString(words[i], words[i - 1], map) < 0) {
		return false;
	     }
	}
	return true;
     }
     
     static public int compareString(String str1, String str2, Map<Character, Integer> map) {
	
	for (int i = 0; i < str1.length() && i < str2.length(); i++) {
	     char char1 = str1.charAt(i);
	     char char2 = str2.charAt(i);
	     int val1 = map.get(char1);
	     int val2 = map.get(char2);
	     
	     if (val1 != val2) {
		return val1 - val2;
	     }
	}
	
	// Case two string similar first part "ABC" or "ABCD";
	if (str1.length() < str2.length()) {
	     return str1.length() - str2.length();
	} else if (str1.length() > str2.length()) {
	     return str1.length() - str2.length();
	} else {
	     return 0; // Two String is similar
	}
     }
     
     static public Map<Character, Integer> buildMap(String string) {
	Map<Character, Integer> map = new HashMap<>();
	for (int i = 0; i < string.length(); i++) {
	     map.put(string.charAt(i), i);
	}
	return map;
     }
     
     public static void main(String[] args) {
	String[] words1 = new String[2];
	words1[0] = "hello";
	words1[1] = "leetcode";
 
	System.out.println(isAlienSorted(words1, "hlabcdefgijkmnopqrstuvwxyz")); // true
 
 
	String[] words2 = new String[3];
	words2[0] = "word";
	words2[1] = "world";
	words2[2] = "row";
 
	System.out.println(isAlienSorted(words2, "worldabcefghijkmnpqstuvxyz")); // false
 
 
	String[] words3 = new String[2];
	words3[0] = "apple";
	words3[1] = "app";
 
	System.out.println(isAlienSorted(words3, "abcdefghijklmnopqrstuvwxyz")); // false
     }
     
}
