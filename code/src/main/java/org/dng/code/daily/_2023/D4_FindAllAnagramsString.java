package org.dng.code.daily._2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author duyntc 02/2023
 */
public class D4_FindAllAnagramsString {

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

static public List<Integer> findAnagrams(String s, String p) {
	List<List<Character>> result = new ArrayList<>();
	List<Character> temp = new ArrayList<>();
	
	for (int i = 0; i < p.length(); i++) {
		temp.add(p.charAt(i));
	}
	backtracking(result, temp, temp.size(), 0);
	
	List<String> pList = new ArrayList<>();
	
	for (List<Character> perm : result) {
		StringBuilder builder = new StringBuilder();
		for (Character ch : perm) {
			builder.append(ch);
		}
		pList.add(builder.toString());
		
	}
	
	List<Integer> indexArr = new ArrayList<>();
	for (String string : pList) {
		if (s.contains(string)) {
			List<Integer> allOccurs = findAllOccurrences(s, string);
			indexArr.addAll(allOccurs);
		}
	}
	return new ArrayList<>(new HashSet<>(indexArr));
}

static public List<Integer> findAllOccurrences(String string, String subStr) {
	
	List<Integer> result = new ArrayList<>();
	
	int lastIndex = 0;
	
	while (lastIndex != -1) {
		lastIndex = string.indexOf(subStr, lastIndex);
		if (lastIndex != -1) {
			result.add(lastIndex);
			lastIndex += subStr.length();
		}
	}
	return result;
}

static public void backtracking(List<List<Character>> result, List<Character> temp, int n, int first) {
	if (first == n) {
		result.add(new ArrayList<>(temp));
	}
	
	for (int i = first; i < n; i++) {
		Collections.swap(temp, first, i);
		backtracking(result, temp, n, first + 1);
		Collections.swap(temp, first, i);
	}
}

public static void main(String[] args) {
	
	System.out.println(findAllOccurrences("abab", "ab"));
}

}
