package org.dng.code.grooking.backtrack;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsChangingCase {
     
     /**
      * Given a string s, you can transform every letter individually
      * to be lowercase or uppercase to create another string.
      * <p>
      * Return a list of all possible strings we could create. Return the output in any order.
      *
      * @param s
      * @return
      */
     
     public static List<String> letterCasePermutation(String s) {
	List<String> result = new ArrayList<>();
	backtracking(s, result, 0);
	return result;
     }
     
     /**
      * Intuitive for every character, check if it is character
      * If Yes modify to Upper or Lower case, and shift the pointer 1
      * If pointer == len of string, add string to result array
      * @param s
      * @param result
      * @param i
      */
     
     public static void backtracking(String s, List<String> result, int i) {
	if (i == s.length()) {
	     result.add(s);
	} else {
	     if (Character.isLetter(s.charAt(i))) {
		
		StringBuilder builder = new StringBuilder(s);
		builder.setCharAt(i, Character.toUpperCase(s.charAt(i)));
		backtracking(builder.toString(), result, i + 1);
		
		builder = new StringBuilder(s);
		builder.setCharAt(i, Character.toLowerCase(s.charAt(i)));
		backtracking(builder.toString(), result, i + 1);
	     }
	     else
		backtracking(s, result, i+1);
	}
     }
     
     public static void main(String[] args) {
	System.out.println(letterCasePermutation("aR4t"));
     }
}
