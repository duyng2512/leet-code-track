package org.dng.code.grooking.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 02/2023
 */
public class LongestPalindromeConcatenatingTwoLetterWords {

/**
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 * <p>
 * Create the longest possible palindrome by selecting some elements from words and concatenating
 * them in any order. Each element can be selected at most once.
 * <p>
 * Return the length of the longest palindrome that you can create. If it is impossible to create any
 * palindrome, return 0.
 * <p>
 * A palindrome is a string that reads the same forward and backward.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
 * Note that "clgglc" is another longest palindrome that can be created.
 * Example 2:
 * <p>
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 * Example 3:
 * <p>
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: One longest palindrome is "cc", of length 2.
 * Note that "ll" is another longest palindrome that can be created, and so is "xx".
 */

static public int longestPalindrome(String[] words) {
	
	/**
	 * Intuition count the number of word
	 * aa bb cc
	 * {
	 * aa aa bb cc
	 *      aa = 2
	 *      bb = 1
	 *      cc = 2
	 * }
	 *
	 * result = count is even add to result ( add two aa )
	 * result = count is odd add count -1 ( 3 add 2, 1 add 0 , mark with central)
	 *
	 */
	
	Map<String, Integer> map = new HashMap<>();
	for (String word : words) {
		map.compute(word, (k, v) -> v = map.get(k) == null ? 1 : map.get(k) + 1);
	}
	
	boolean central = false;
	int result = 0;
	
	for (Map.Entry<String, Integer> entry : map.entrySet()) {
		String word = entry.getKey();
		int countWord = entry.getValue();
		
		// Palindrome
		if (word.charAt(0) == word.charAt(1)) {
			
			if (countWord % 2 == 0) {
				result += countWord;
			} else {
				result += countWord - 1;
				central = true;
			}
			
		} else if (word.charAt(0) < word.charAt(1)) {
			// ab ba ab -> 2 4
			// Not a palindrome but still
			String reverseWord = new StringBuilder(word).reverse().toString();
			
			if (map.containsKey(reverseWord)) {
				result += 2 * Math.min(countWord, map.get(reverseWord));
			}
		}
	}
	
	if (central) {
		result += 1;
	}
	
	return result * 2;
}


public static void main(String[] args) {
	// tylcclyt
	System.out.println(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"})); // 8
	System.out.println(longestPalindrome(new String[]{"cc", "ll", "xx"})); // 2
	System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"})); // 2
}

}
