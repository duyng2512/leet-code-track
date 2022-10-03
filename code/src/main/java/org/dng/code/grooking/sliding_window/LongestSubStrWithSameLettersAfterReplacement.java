package org.dng.code.grooking.sliding_window;


import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class LongestSubStrWithSameLettersAfterReplacement {

    /*
        Problem Statement
        Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
        letters with any letter, find the length of the longest substring having the same letters
        after replacement.

        Example 1:

        Input: String="aabm n", k=2
        Output: 5
        Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

        Example 2:

        Input: String="bbcb", k=1
        Output: 4
        Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".

        Example 3:

        Input: String="aabbbcccdef", k=1
        Output: 3
     */
     
     /*
     	Intuition: Let sample we get rid of K contraints, the problems become
     	
     	-> Get the longest substring with the same element, this become very simple
     	
     	Condition for longest substrings with the same element will be:
     	windowEnd - windowStart - maxCount = 0
     	
     	Given this we can maintain a string such that
     	
     	(length of substring - number of times of the maximum occurring character in the substring) <= k
      */

    public int characterReplacement(String s, int k) {
        	int maxLen = 0, windowStart = 0, windowEnd;
	int maxCount = 0;

	Map<Character, Integer> map = new HashMap<>();
        	for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
		map.merge(s.charAt(windowEnd), 1, Integer::sum);
		maxCount = Math.max(maxCount, map.get(s.charAt(windowEnd)));

		while (windowEnd - windowStart - maxCount + 1 > k) {
		    map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);
		    windowStart ++;
		}
	    maxLen = Math.max(windowEnd - windowStart + 1, maxLen);
        	}
	return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(LongestSubStrWithSameLettersAfterReplacement.builder().build().characterReplacement("abccde", 2));
    }

}
