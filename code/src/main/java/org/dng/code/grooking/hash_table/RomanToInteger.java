package org.dng.code.grooking.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class RomanToInteger {


/**
 * https://leetcode.com/problems/roman-to-integer/
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * @param s
 * @return
 */

public int romanToInt(String s) {
	Map<Character, Integer> map = new HashMap<>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	
	int total = 0;
	Character prev = null;
	for (int i = 0; i < s.length(); i++) {
		Character curr = s.charAt(i);
		total += map.get(curr);
		
		if (prev != null) {
			if (map.get(prev) < map.get(curr)) {
				total -= 2 * map.get(prev);
			}
		}
		
		prev = curr;
	}
	return total;
}

}
