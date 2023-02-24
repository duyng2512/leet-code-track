package org.dng.code.daily._2022;

import java.util.HashSet;
import java.util.Set;

/**
 * @author duyntc 12/2022
 */
public class D16_PossibleBipartition {

/**
 * @desc: https://leetcode.com/problems/possible-bipartition/
 */

static public boolean possibleBipartition(int n, int[][] dislikes) {
	
	Set<Integer> list0 = new HashSet<>();
	Set<Integer> list1 = new HashSet<>();
	
	
	for (int[] dislike : dislikes) {
		int i0 = dislike[0];
		int i1 = dislike[1];
		
		if (list0.contains(i1)) {
			list0.add(i1);
			list1.add(i0);
		} else if (list1.contains(i0)) {
			list1.add(i0);
			list0.add(i1);
		} else {
			list1.add(i1);
			list0.add(i0);
		}
	}
	
	for (Integer i : list0) {
		if (list1.contains(i)) {
			return false;
		}
	}
	
	return true;
}

public static void main(String[] args) {
	
	
	System.out.println(possibleBipartition(3, new int[][]
													  {{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}}
	));
}
}
