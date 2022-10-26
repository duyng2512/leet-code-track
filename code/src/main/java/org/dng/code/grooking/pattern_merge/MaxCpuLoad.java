package org.dng.code.grooking.pattern_merge;

import lombok.Builder;

import java.util.Arrays;
import java.util.Comparator;

@Builder
public class MaxCpuLoad {
     
     /*
	Maximum CPU Load (hard)
	
	We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
	Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
	
	Example 1:
	Jobs: [[1,4,3], [2,5,4], [7,9,6]]
	Output: 7
	Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
	jobs are running at the same time i.e., during the time interval (2,4).
	
	Example 2:
	Jobs: [[6,7,10], [2,4,11], [8,12,15]]
	Output: 15
	Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
	
	Example 3:
	Jobs: [[1,4,2], [2,4,1], [3,6,5]]
	Output: 8
	Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4]. `
      */
     
     public int getOrder(int[][] tasks) {
	if (tasks.length == 1) return tasks[0][2];
	
	Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]));
	int[] prev = tasks[0];
     	int currentLoad = tasks[0][2];
	int maxLoad = tasks[0][2];
	
	for (int i = 1; i < tasks.length; i++) {
	     // Check if previous task is done
	     if (tasks[i][0] < prev[1]) {
		currentLoad += tasks[i][2]; // Add more load;
	     } else {
		// If done
		currentLoad -= prev[2]; // Release load
	     }
	     maxLoad = Math.max(currentLoad, maxLoad);
	     prev = tasks[i];
	}
	return maxLoad;
     }
     
     public static void main(String[] args) {
	// [[1,4,3], [2,5,4], [7,9,6]]
	System.out.println(MaxCpuLoad.builder().build().getOrder( new int[][] {{1,4,3}, {2,5,4}, {7,9,6}} ));
     }
     
}
