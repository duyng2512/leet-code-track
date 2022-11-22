package org.dng.code.grooking.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
     
     public static List<List<Integer>> combine(int n, int k) {
	List<List<Integer>> result = new ArrayList<>();
	backtracking(result, new ArrayList<>(), n, k, 1);
	return result;
     }
     
     public static void backtracking(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
	if (temp.size() == k) {
	     result.add(new ArrayList<>(temp));
	} else {
	     for (int i = start; i <= n; i++) {
		if (temp.contains(i)) continue;
		temp.add(i);
		backtracking(result, temp, n, k, i+1);
		temp.remove(temp.size()-1);
	     }
	}
     }
     
     public static void main(String[] args) {
	System.out.println(combine(4, 2));
     }
     
}
