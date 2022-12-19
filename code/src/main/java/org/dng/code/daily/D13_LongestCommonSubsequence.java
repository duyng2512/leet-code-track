package org.dng.code.daily;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author duyntc 12/2022
 */
public class D13_LongestCommonSubsequence {
     
     /**
      * @desc: https://leetcode.com/problems/longest-common-subsequence/description/
      *
      *
      * Intuitive:
      * There are two case:
      * Case 1: The first letter of string 1 is belonged to the optimal path
      * Case 2: The first letter of string 1 is not to the optimal path
      * We have to take in account both case
      */
     
     static String str1;
     static String str2;
     static int[][] memo;
     
     static public int memoSolve(int p1, int p2) {
	if (memo[p1][p2] != -1) {
	     return memo[p1][p2];
	}
 
	// Not include in optimal path
	int case1 = memoSolve(p1+1, p2);
 
	int case2 = 0;
	int indexFirstInText2 = str2.indexOf(str1.charAt(p1), p2);
	if (indexFirstInText2 != -1) {
	     case2 = 1 + memoSolve(p1+1, indexFirstInText2 + 1);
	}
	memo[p1][p2] = Math.max(case1, case2);
	return memo[p1][p2];
     }
     
     static public int longestCommonSubsequence(String text1, String text2) {
	str1 = text1;
	str2 = text2;
 
	memo = new int[text1.length() + 1][text2.length() + 1];
	
	for (int i = 0; i < text1.length(); i++) {
	     for (int j = 0; j < text2.length(); j++) {
		memo[i][j] = -1;
	     }
	}
	
	return memoSolve(0, 0);
     }
     
     public static void main(String[] args) {
	System.out.println(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy")); // 2  qr
     }
}
