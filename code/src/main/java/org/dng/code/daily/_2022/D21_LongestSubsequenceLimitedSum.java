package org.dng.code.daily._2022;

import java.util.Arrays;

/**
 * @author duyntc 12/2022
 */
public class D21_LongestSubsequenceLimitedSum {

/**
 * @desc: https://leetcode.com/problems/longest-subsequence-with-limited-sum/
 */

// Input: nums = [4,5,2,1], queries = [3,10,21]
// Output: [2,3,4]
static public int[] answerQueries(int[] nums, int[] queries) {
	
	int Q = queries.length;
	int[] answer = new int[queries.length];
	long[] total = new long[queries.length];
	
	for (int num : nums) {
		for (int j = 0; j < Q; j++) {
			if ((total[j] + num) <= queries[j]) {
				total[j] += num;
				answer[j] += 1;
			}
		}
	}
	return answer;
}

public static void main(String[] args) {
	System.out.println(Arrays.toString(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
}
}
