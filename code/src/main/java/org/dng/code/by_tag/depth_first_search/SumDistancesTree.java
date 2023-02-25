package org.dng.code.by_tag.depth_first_search;

/**
 * @author duyntc 12/2022
 */
public class SumDistancesTree {

/**
 * @desc: https://leetcode.com/problems/sum-of-distances-in-tree/
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
