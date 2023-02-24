package org.dng.code.grooking.pattern_merge;

import lombok.Builder;
import org.dng.code.utils.MergeUtils;

@Builder
public class ConflictAppointment {
     
     /*
	Problem Statement
	Given an array of intervals representing ‘N’ appointments,
	find out if a person can attend all the appointments.
	
	Example 1:
	
	Appointments: [[1,4], [2,5], [7,9]]
	Output: false
	Explanation: Since [1,4] and [2,5] overlap, a person cannot
	attend both of these appointments.
	
	Example 2:
	
	Appointments: [[6,7], [2,4], [8,12]]
	Output: true
	Explanation: None of the appointments overlap, therefore a person
	can attend all of them.
	
	Example 3:
	
	Appointments: [[4,5], [2,3], [3,6]]
	Output: false
	Explanation: Since [4,5] and [3,6] overlap, a person cannot attend
	both of these appointments.
	
      */

public static void main(String[] args) {

}

public int eraseOverlapIntervals(int[][] intervals) {
	if (intervals.length == 1) return 0;
	
	MergeUtils.sortByFirstKey(intervals);
	int removeCount = 0;
	int[] prev = intervals[0];
	
	for (int i = 1; i < intervals.length; i++) {
		// If there is no overlap
		if (prev[1] <= intervals[i][0]) {
			prev = intervals[i];
			continue;
		}
		
		// If there is overlap and the current is smaller than prev both end
		if (prev[1] >= intervals[i][1]) {
			prev = intervals[i];
			removeCount++;
			continue;
		}
		
		// If there is overlap and the tail of curr is behind prev
		if (prev[1] <= intervals[i][1]) {
			removeCount++;
		}
	}
	return removeCount;
}

}
