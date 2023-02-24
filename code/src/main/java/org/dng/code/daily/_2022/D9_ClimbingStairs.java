package org.dng.code.daily._2022;

import java.util.HashMap;
import java.util.Map;

public class D9_ClimbingStairs {

/**
 * @desc: https://leetcode.com/problems/climbing-stairs/
 */

// DP
static public int stepNo(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (n == 2) return 2; // 1 + 1 and 2
	else return stepNo(n - 1) + stepNo(n - 2);
}

static public int step(int n, Map<Integer, Integer> memo) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (n == 2) return 2; // 1 + 1 and 2
	if (memo.containsKey(n)) return memo.get(n);
	else {
		int res = step(n - 1, memo) + step(n - 2, memo);
		memo.put(n, res);
		return res;
	}
}

static public int climbStairs(int n) {
	Map<Integer, Integer> map = new HashMap<>();
	return step(n, map);
}

public static void main(String[] args) {
	long start = System.currentTimeMillis();
	System.out.println(climbStairs(45));
	System.out.println("Took " + (System.currentTimeMillis() - start));
	
	start = System.currentTimeMillis();
	System.out.println(stepNo(45));
	System.out.println("Took " + (System.currentTimeMillis() - start));
}
}
