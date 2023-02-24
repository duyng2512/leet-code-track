package org.dng.code.interview;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duyntc 01/2023
 */
public class Solution {

static public boolean isBalance(String string) {
	Set<Character> set = new HashSet<>();
	for (int i = 0; i < string.length(); i++) {
		set.add(string.charAt(i));
	}
	for (int i = 0; i < string.length(); i++) {
		char curr = string.charAt(i);
		if (!set.contains(Character.toUpperCase(curr)) || !set.contains(Character.toLowerCase(curr))) {
			return false;
		}
	}
	return true;
}

static public int solution(String s) {
	int result = -1;
	int N = s.length();
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j <= N; j++) {
			String substr = s.substring(i, j);
			if (isBalance(substr)) {
				result = Math.max(result, substr.length());
			}
		}
	}
	return result;
}

public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
	System.out.println(solution("azABaabZax"));
}

}
