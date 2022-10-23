package org.dng.code.grooking.pattern_merge;

import lombok.Builder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Builder
public class InsertInterval {
     /*
	You are given an array of non-overlapping intervals where intervals[i] = [start_i, end_i]
	represent the start and the end of the ith interval and intervals is sorted in ascending order by start_i.
	You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 
	Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i and intervals
	still does not have any overlapping intervals (merge overlapping intervals if necessary).
	
	Return intervals after the insertion.
	
	Example 1:
	Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
	Output: [[1,5],[6,9]]
	
	Example 2:
	Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
	Output: [[1,2],[3,10],[12,16]]
	Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
      */
     
     public int[][] insert(int[][] intervals, int[] newInterval) {
	if (intervals.length == 0) return new int[][]{newInterval};
	
	List<int[]> merge = new LinkedList<>();
	
	// Add interval to the right spot first
	if (newInterval[0] <= intervals[0][0])
	     merge.add(newInterval);
	merge.add(intervals[0]);
	
	for (int i = 1; i < intervals.length; i++) {
	     if(intervals[i][0] >= newInterval[0] && intervals[i-1][0] < newInterval[0])
		merge.add(newInterval);
	     merge.add(intervals[i]);
	}
	
	// Interval have not been added
	if (merge.size() == intervals.length) merge.add(newInterval);
	
	// Start merging if necessary
	List<int[]> result = new LinkedList<>();
	for (int[] interval: merge) {
	     int lastIndex = result.size() - 1;
	     
	     // First element or not overlap
	     if (result.isEmpty() || result.get(lastIndex)[1] < interval[0]  ) {
		result.add(interval);
	     } else {
		// Start to merge
		int[] mergeInterval = new int[] {Math.min(interval[0], result.get(lastIndex)[0]),
		     			Math.max(interval[1], result.get(lastIndex)[1])};
		result.set(lastIndex, mergeInterval);
	     }
	}
	return result.toArray(new int[result.size()][]);
     }
     
     public static void main(String[] args) {
	int[][] result ;
	// result = InsertInterval.builder().build().insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8} );
	result = InsertInterval.builder()
	     		.build()
	     		.insert(new int[][] {{1,5}}, new int[] {0,0} );
	
	System.out.println(Arrays.deepToString(result));
     }

}
