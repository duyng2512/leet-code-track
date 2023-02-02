package org.dng.code.daily._2022;

/**
 * @author duyntc 12/2022
 */
public class D17_FindSmallestLetterGreaterThanTarget {
     
     /**
      * @desc: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
      */
     
     static public char nextGreatestLetter(char[] letters, char target) {
	int lo = 0;
	int hi = letters.length;
	
	while (lo < hi) {
	     int mid = (lo + hi) / 2;
	     if (letters[mid] > target) {
		hi = mid;
	     } else {
		lo = mid + 1;
	     }
	}
	return letters[lo % letters.length];
     }
     
     public static void main(String[] args) {
	
     }
}
