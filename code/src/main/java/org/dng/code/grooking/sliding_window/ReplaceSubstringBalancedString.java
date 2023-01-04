package org.dng.code.grooking.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class ReplaceSubstringBalancedString {
     
     static public int balancedString(String s) {
	// QQQWREWR -> Q to E
	// Count character first
	// Detect over limit
	// If there is no over limit restart start
	int limit = s.length() / 4;
	Map<Character, Integer> map = new HashMap<>();
	
	map.put('Q', 0);
	map.put('W', 0);
	map.put('E', 0);
	map.put('R', 0);
	
	for (int i = 0; i < s.length(); i++) {
	     map.merge(s.charAt(i), 1, Integer::sum);
	}
	
	Map<Character, Integer> curMap = new HashMap<>();
	int start = 0, end = 0;
	int len = Integer.MAX_VALUE;
	for (end = 0; end < s.length(); end++) {
	     curMap.merge(s.charAt(end), 1, Integer::sum);
	     
	     // Detect over limit
	     if (curMap.get(s.charAt(end)) > limit) {
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
		     
		     // If there is character that is missing than full-fill it
		     if (!entry.getKey().equals(s.charAt(end)) && (entry.getValue() < limit)) {
			map.merge(s.charAt(end), 1, Integer::sum);
			break;
		     }
		     
		}
		
		// len = Math.min(len, (end - start)); // Refactor
	     } else {
		start = end;
	     }
	}
	if (len == Integer.MAX_VALUE) return 0;
	return len;
     }
     
     public static void main(String[] args) {
//	System.out.println(balancedString("QWER"));
//	System.out.println(balancedString("QQER"));
	System.out.println(balancedString("QQQW"));
     }
     
}
