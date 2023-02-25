package org.dng.code.by_tag.count;

import java.util.Arrays;
import java.util.List;

public class D1_DetermineIfStringHalvesAreAlike {

public static boolean halvesAreAlike(String s) {
	List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
	
	int firstCount = 0;
	int secondCount = 0;
	
	for (int i = 0; i < (s.length() / 2); i++) {
		if (list.contains(s.charAt(i))) {
			firstCount++;
		}
	}
	
	for (int i = (s.length() / 2); i < s.length(); i++) {
		if (list.contains(s.charAt(i))) {
			secondCount++;
		}
	}
	return secondCount == firstCount;
}

public static void main(String[] args) {
	System.out.println(halvesAreAlike("book"));
	System.out.println(halvesAreAlike("textbook"));
}

}
