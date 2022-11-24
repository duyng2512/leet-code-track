package org.dng.code.grooking.top_k_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
     
     /*
     
     	Given a string s, sort it in decreasing order based on the frequency of the characters.
     	The frequency of a character is the number of times it appears in the string.

	Return the sorted string. If there are multiple answers, return any of them.

	Example 1:
	Input: s = "tree"
	Output: "eert"
	Explanation: 'e' appears twice while 'r' and 't' both appear once.
	So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
	
	
	Example 2:
	Input: s = "cccaaa"
	Output: "aaaccc"
	Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
	Note that "cacaca" is incorrect, as the same characters must be together.
     
      */
     
     public static String frequencySort(String s) {
	HashMap<Character, Integer> map = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	}
	System.out.println(map);
	StringBuilder builder = new StringBuilder();
	Comparator<Map.Entry<Character, Integer>> comparator = (o1, o2) -> o2.getValue().compareTo(o1.getValue());
	
	map.entrySet()
	     .stream()
	     .sorted(comparator)
	     .forEach(entry -> {
		Character character = entry.getKey();
		builder.append(String.valueOf(character).repeat(Math.max(0, entry.getValue())));
	     });
	return builder.toString();
     }
     
     public static void main(String[] args) {
	System.out.println(frequencySort("tree"));
	System.out.println(frequencySort("cccaaa"));
	System.out.println(frequencySort("Aabb"));
     }
     
}
