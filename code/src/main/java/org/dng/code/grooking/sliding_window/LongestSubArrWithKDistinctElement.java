package org.dng.code.grooking.sliding_window;


import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class LongestSubArrWithKDistinctElement {

    /*
	Problem Statement #
	Given a string, find the length of the longest substring in it with no more than K distinct characters.

	Example 1:
	Input: String="araaci", K=2
	Output: 4
	Explanation: The longest substring with no more than '2' distinct characters is "araa".

	Example 2:
	Input: String="araaci", K=1
	Output: 2
	Explanation: The longest substring with no more than '1' distinct characters is "aa".

	Example 3:
	Input: String="cbbebi", K=3
	Output: 5
	Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 
     	Desc: maintain a map of frequency character
      */
     
     public static void main(String[] args) {
	System.out.println(LongestSubArrWithKDistinctElement
	     .builder()
	     .build()
	     .lengthOfLongestSubstringKDistinct("cbbebi", 2));
     }
     
     public int lengthOfLongestSubstringKDistinct(String s, int k) {
	int windowStart = 0, windowEnd;
	int maxLen = 0, startIdx = 0, endIdx = 0;
	
	Map<Character, Integer> map = new HashMap<>();
	
	for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
	     map.merge(s.charAt(windowEnd), 1, Integer::sum);
	     
	     
	     while (map.size() > k) {
		map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);
		
		if (map.get(s.charAt(windowStart)) == 0) {
		     map.remove(s.charAt(windowStart));
		}
		
		windowStart++;
	     }
	     
	     if (windowEnd - windowStart + 1 > maxLen) {
		startIdx = windowStart;
		endIdx = windowEnd;
		maxLen = windowEnd - windowStart + 1;
	     }
	     
	}
	System.out.println("startIdx: " + startIdx);
	System.out.println("endIdx: " + endIdx);
	return maxLen;
     }
     
}
