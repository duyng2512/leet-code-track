package org.dng.code.grooking.pattern_merge;

import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
     
     /*
     Given an array of intervals where intervals[i] = [starti, endi],
     merge all overlapping intervals, and return an array of the
     non-overlapping intervals that cover all the intervals in the input.

     Example 1:
     Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     Output: [[1,6],[8,10],[15,18]]
     Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     
     Example 2:
     Input: intervals = [[1,4],[4,5]]
     Output: [[1,5]]
     Explanation: Intervals [1,4] and [4,5] are considered overlapping.

      */
     
     public int[][] merge(int[][] intervals) {
	if (intervals.length == 1) return intervals;
	MergeUtils.sortByFirstKey(intervals);
	List<int[]> result = new LinkedList<>();
 
	for (int[] interval: intervals) {
	     int lastIndex = result.size() - 1;
	     if (result.isEmpty() || result.get(lastIndex)[1] < interval[0]) {
		result.add(interval);
	     } else {
		// Start to merge
		int[] mergeInterval = new int[] { Math.min(interval[0], result.get(lastIndex)[0]),
		     			Math.max(interval[1], result.get(lastIndex)[1])};
		result.set(lastIndex, mergeInterval);
	     }
	
	}
	return result.toArray(new int[result.size()][]);
     }
}
