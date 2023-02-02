package org.dng.code.daily._2022;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 12/2022
 */
public class D19_DominoTrominoTiling {
     
     /**
      * @desc: https://leetcode.com/problems/domino-and-tromino-tiling/
      */
     
     static int MOD = 1_000_000_007;
     static Map<Integer, Long> mapP = new HashMap<>();
     static Map<Integer, Long> mapF = new HashMap<>();
     
     static public long p(int n) {
	if (n == 2) {
	     return 1;
	}
	if (!mapP.containsKey(n)) {
	     long val = f(n - 2) + p(n - 1);
	     val = val % MOD;
	     mapP.put(n, val);
	}
	
	return mapP.get(n);
     }
     
     static public long f(int n) {
	if (n == 1) {
	     return 1;
	}
	
	if (n == 2) {
	     return 2;
	}
	
	if (!mapF.containsKey(n)) {
	     long val = f(n - 1) + f(n - 2) + 2 * p(n - 1);
	     val = val % MOD;
	     mapF.put(n, val);
	}
	;
	
	return mapF.get(n);
     }
     
     public static void main(String[] args) {
	
     }
     
     // 4 = 3 + 1 = k-1 + 1 = 5 + 1  = 5
     // 4 = k - 2 = k-2 + 2 = 2 + 1  = 2
     // 4 = 1 + 2  = 3
     // f(k) = f(k−1)+f(k−2)+2∗p(k−1)
     // p(k) = p(k-2) + p(k-1)
     
     public int numTilings(int n) {
	return (int) f(n);
     }
}
