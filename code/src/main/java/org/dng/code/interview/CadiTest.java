package org.dng.code.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class CadiTest {
     
     public static boolean isAnagram(String str1, String str2) {
	
	if (str1.length() != str2.length()) return false;
	
	int N = str2.length();
	Map<Character, Integer> map = new HashMap<>();
	
	for (int i = 0; i < N; i++) {
	     Character character = str1.charAt(i);
	     if (map.containsKey(character)) {
		map.put(character, map.get(character) + 1);
	     } else {
		map.put(character, 1);
	     }
	}
	
	for (int i = 0; i < N; i++) {
	     Character character = str2.charAt(i);
	     if (map.containsKey(character)) {
		map.put(character, map.get(character) - 1);
	     } else {
		return false;
	     }
	     
	     if (map.get(character) == 0) {
		map.remove(character);
	     }
	}
	return map.size() == 0;
     }
     
     
     public static void main(String[] args) {
	System.out.println(isAnagram("duel", "eldi")); // false
	System.out.println(isAnagram("duel", "eldu")); // true
	System.out.println(isAnagram("duel", "eldasdasdu")); // false
	System.out.println(isAnagram("duel", "duel")); // true
	System.out.println(isAnagram("lued", "duel")); // true
     }
}
