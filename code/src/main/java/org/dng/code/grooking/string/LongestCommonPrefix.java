package org.dng.code.grooking.string;

import java.util.Arrays;

/**
 * @author duyntc 02/2023
 */
public class LongestCommonPrefix {

/**
 * Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan&id=level-2
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * @param strs
 * @return
 */

static public String longestCommonPrefix(String[] strs) {
	StringBuilder subStr = new StringBuilder();
	
	int n = Arrays.stream(strs).map(String::length).mapToInt(v -> v).min().getAsInt();
	int index = 0;
	boolean stop = false;
	
	for (int i = 0; i < n; i++) {
		char currentChar = strs[0].charAt(index);
		for (String str : strs) {
			if (currentChar != str.charAt(index)) {
				stop = true;
				break;
			}
		}
		
		if (stop) {
			break;
		}
		index++;
		subStr.append(currentChar);
	}
	
	return subStr.toString();
}

public static void main(String[] args) {
	System.out.println(longestCommonPrefix(new String[]{
			"flower", "flow", "flight"
	}));
	
	System.out.println(longestCommonPrefix(new String[]{
			"dog", "racecar", "car"
	}));
}

}
