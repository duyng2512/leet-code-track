package org.dng.code.grooking.pattern_two_heap;

import java.util.*;

public class FindRightInterval {
     
     /*
     	
     	You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
	The right interval for an interval i is an interval j
	such that startj >= endi and startj is minimized. Note that i may equal j.

	Return an array of right interval indices for each interval i.
	If no right interval exists for interval i, then put -1 at index i.

 
	Input: intervals = [[3,4],[2,3],[1,2]]
	Output: [-1,0,1]
	Explanation: There is no right interval for [3,4].
	The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
	The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
	
      */
     
     public static int[] findRightInterval(int[][] intervals) {
	
	TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	for (int i = 0; i < intervals.length; i++) {
	     treeMap.put(intervals[i][0], i);
	}
	int[] result = new int[intervals.length];
	
	for (int i = 0; i < intervals.length; i++) {
	     Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
	     if (entry == null) result[i] = -1;
	     else result[i] = entry.getValue();
	}
	return result;
     }
     
     public static void main(String[] args) {
	int[] result = findRightInterval(new int[][] {{2,3},{3,4},{1,2}});
	System.out.println(Arrays.toString(result));
     }
}
