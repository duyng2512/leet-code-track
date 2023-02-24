package org.dng.code.grooking.sliding_window;

/**
 * @author duyntc 01/2023
 */
public class SplitStringBalancedStrings {
     
     /*
	Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 
	Given a balanced string s, split it into some number of substrings such that:
	
	Each substring is balanced.
	Return the maximum number of balanced strings you can obtain.
	
      */

static public int balancedStringSplit(String s) {
	
	int countR = 0;
	int countL = 0;
	int total = 0;
	
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == 'R') countR++;
		else countL++;
		
		if (countL == countR) {
			total++;
			countL++;
			countR++;
		}
	}
	return total;
}

public static void main(String[] args) {
	System.out.println(balancedStringSplit("RLRRLLRLRL"));
	System.out.println(balancedStringSplit("RLRRRLLRLL"));
}
}
