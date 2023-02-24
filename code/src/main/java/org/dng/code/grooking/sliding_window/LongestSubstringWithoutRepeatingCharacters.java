package org.dng.code.grooking.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class LongestSubstringWithoutRepeatingCharacters {

public int lengthOfLongestSubstring(String s) {
	int start = 0, end;
	int max = 0;
	Map<Character, Integer> map = new HashMap<>();
	
	for (end = 0; end < s.length(); end++) {
		
		// If already in a map cut this part from start to end
		if (map.containsKey(s.charAt(end))) {
			// This already in map
			start = Math.max(start, map.get(s.charAt(end)) + 1);
		}
		map.put(s.charAt(end), end);
		max = Math.max(max, end - start + 1);
	}
	return max;
}

}
