package org.dng.code.grooking.top_k_elements;

import java.util.*;

public class FindKClosest {
     
     public static List<Integer> findClosestElements(int[] arr, int k, int x) {
	// Diff - Value
	Comparator<int[]> comparator = new Comparator<>() {
	     @Override
	     public int compare(int[] o1, int[] o2) {
		return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
	     }
	};
	PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
	for (int j : arr) {
	     int diff = Math.abs(j - x);
	     queue.add(new int[] {diff, j} );
	}
	
	List<Integer> result = new ArrayList<>();
	for (int i = 0; i < k; i++) {
	     result.add(queue.poll()[1]);
	}
	Collections.sort(result);
	return result;
     };
     
     public static void main(String[] args) {
	System.out.println(findClosestElements(new int[]{ 0,0,1,2,3,3,4,7,7,8 }, 3, 5));
     }
     
}
