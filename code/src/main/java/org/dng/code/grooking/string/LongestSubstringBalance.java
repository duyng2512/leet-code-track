package org.dng.code.grooking.string;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class LongestSubstringBalance {
     
     public static void main(String[] args) throws IOException {
	String str = "11010111";
	// 1 1 2 2 2
	// 0 1 0 2 3
	// 1 0 2 0 -1
	
	int zeroCounter = 0, oneCounter = 0;
	Map<Integer, Integer> map = new HashMap<>();
	map.put(0, -1);
	int result = 0;
	
	for (int i = 0; i < str.length(); i++) {
	     if (str.charAt(i) == '0') {
		++zeroCounter;
	     } else {
		++oneCounter;
	     }
	     
	     // When diff is zero it marks the start of balance string
	     int diff = zeroCounter - oneCounter;
	     
	     if (map.containsKey(diff)) {
		result = Math.max(result, i - map.get(diff));
	     } else {
		map.put(diff, i);
	     }
	}
 
	System.out.println("Result " + result);
	
     }
     
}
