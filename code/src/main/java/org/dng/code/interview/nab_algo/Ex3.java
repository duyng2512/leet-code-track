package org.dng.code.interview.nab_algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex3 {
	
	// 12  1 2
	// 1
	static Set<Integer> getNums(int a) {
		Set<Integer> set = new HashSet<>();
		while (a != 0) {
			set.add(a % 10);
			a /= 10;
		}
		return set;
	}
	
	static List<Set<Integer>> convert(int[] arr) {
		List<Set<Integer>> result = new ArrayList<>();
		for (int j : arr) {
			result.add(getNums(j));
		}
		return result;
	}
	
	public static int solve(int[] arr) {
		int start = 0;
		int result = 0;
		
		Set<Integer> cur = new HashSet<>();
		List<Set<Integer>> array = convert(arr);
		
		for (int end = 0; end < array.size(); end++) {
			cur.addAll(array.get(end));
			while (cur.size() > 2) {
				int finalStart = start;
				cur.removeIf(x -> array.get(finalStart).contains(x));
				start++;
				if (start == array.size()) return 0;
				cur.addAll(array.get(start));
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[] {22, 333, 33, 30, 0, 505};
		int[] arr2 = new int[] {615, 88, 99, 9, 888};// 4
		int[] arr3 = new int[] {123, 456};
		int[] arr4 = new int[] {1, 1, 1, 1, 1};
		int[] arr5 = new int[] {};
		
		System.out.println(solve(arr1)); // 4
		System.out.println(solve(arr2)); // 4
		System.out.println(solve(arr3)); // 0
		System.out.println(solve(arr4)); // 5
		System.out.println(solve(arr5)); // 4
		
	}
	
}
