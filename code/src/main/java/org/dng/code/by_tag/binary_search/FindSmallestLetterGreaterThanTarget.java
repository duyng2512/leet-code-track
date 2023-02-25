package org.dng.code.by_tag.binary_search;

/**
 * @author duyntc 12/2022
 */
public class FindSmallestLetterGreaterThanTarget {

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
