package org.dng.code.grooking.backtrack;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsChangingCase {
     
     public static List<String> letterCasePermutation(String s) {
	List<String> result = new ArrayList<>();
	backtracking(s, result, 0);
	return result;
     }
     
     public static void backtracking(String s, List<String> result, int i) {
	if (i == s.length()){
	     result.add(s);
	} else {
	     if (Character.isLetter(s.charAt(i))) {
		StringBuilder builder = new StringBuilder(s);
		builder.setCharAt(i, Character.toUpperCase(s.charAt(i)));
	     	backtracking(builder.toString(), result, i+1);
		builder = new StringBuilder(s);
		builder.setCharAt(i, Character.toLowerCase(s.charAt(i)));
		backtracking(builder.toString(), result, i+1);
	     }
	     else
		backtracking(s, result, i+1);
	}
     }
     
     public static void main(String[] args) {
	System.out.println(letterCasePermutation("aR4t"));
     }
}
