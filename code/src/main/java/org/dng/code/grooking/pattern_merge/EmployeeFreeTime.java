package org.dng.code.grooking.pattern_merge;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Builder
public class EmployeeFreeTime {
     
     
     /*
	Employee Free Time (hard)
 
	For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
	Our goal is to find out if there is a free interval that is common to all employees.
	You can assume that each list of employee working hours is sorted on the start time.
	
	Example 1:
	
	Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
	Output: [3,5]
	Explanation: Both the employess are free between [3,5].
	
	Example 2:
	
	Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
	Output: [4,6], [8,9]
	Explanation: All employess are free between [4,6] and [8,9].
	
	Example 3:
	
	Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
	Output: [5,7]
	Explanation: All employess are free between [5,7].
      */

public static void main(String[] args) {

}

;

public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
	PriorityQueue<Interval> priorityQueue = new PriorityQueue<>((a, b) -> a.start - b.start);
	List<Interval> result = new ArrayList<>();
	
	// Add all to priorityQueue
	schedule.forEach(priorityQueue::addAll);
	
	Interval temp = priorityQueue.poll();
	while (!priorityQueue.isEmpty()) {
		Interval next = priorityQueue.peek();
		// If there is intersection
		if (temp.end < next.start) {
			result.add(new Interval(temp.end, next.start));
			temp = priorityQueue.poll();
		} else {
			// We try to get the interval with later end
			temp = temp.end > next.end ? temp : next;
			priorityQueue.poll();
		}
	}
	return result;
}

static class Interval {
	public int start;
	public int end;
	
	public Interval() {
	}
	
	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
}
}
