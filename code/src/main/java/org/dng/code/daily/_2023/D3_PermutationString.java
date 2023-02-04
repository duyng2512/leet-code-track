package org.dng.code.daily._2023;

import java.util.Arrays;

/**
 * @author duyntc 02/2023
 */
public class D3_PermutationString {
     
     /**
      * https://leetcode.com/problems/permutation-in-string/submissions/891165771/
      *
      * Intuition, just sorted the damn strings dummy !
      * Or we can count number of frequency.
      * @param s1
      * @param s2
      * @return
      */
     
     static public boolean checkInclusion(String s1, String s2) {
	s1 = sort(s1);
	for (int i = 0; i <= s2.length() - s1.length(); i++) {
	     if (s1.equals(sort(s2.substring(i, i + s1.length()))))
		return true;
	}
	return false;
     }
     
     static public String sort(String s) {
	char[] t = s.toCharArray();
	Arrays.sort(t);
	return new String(t);
     }
     
     
     public static void main(String[] args) {
	
	System.out.println(checkInclusion("ab", "eidboaoo")); // false
	// System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx"));
     }
}
