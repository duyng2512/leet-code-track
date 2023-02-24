package org.dng.code.grooking.pattern_merge;

import lombok.Builder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Builder
public class FindCommonIntervals {

     /*
	Problem Statement
	Given two lists of intervals, find the intersection of these two lists.
	Each list consists of disjoint intervals sorted on their start time.
	
	Example 1:
	
	Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
	Output: [2, 3], [5, 6], [7, 7]
	Explanation: The output list contains the common intervals between the two lists.
	
	Example 2:
	
	Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
	Output: [5, 7], [9, 10]
	Explanation: The output list contains the common intervals between the two lists.
      */

public static void main(String[] args) {
	FindCommonIntervals intervals = FindCommonIntervals.builder().build();
	
	// Test case 1
	int[][] arr1 = new int[][]{{1, 3}, {5, 6}, {7, 9}};
	int[][] arr2 = new int[][]{{2, 3}, {5, 7}};
	int[][] result = intervals.intervalIntersection(arr1, arr2);
	
	System.out.println(Arrays.deepToString(result));
}

public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
	List<int[]> intersectionResult = new LinkedList<>();
	int first = 0;
	int second = 0;
	while (first < firstList.length && second < secondList.length) {
		int low = Math.max(firstList[first][0], secondList[second][0]);
		int high = Math.min(firstList[first][1], secondList[second][1]);
		
		if (low <= high) intersectionResult.add(new int[]{low, high});
		
		if (firstList[first][1] > secondList[second][1]) second++;
		else first++;
	}
	return intersectionResult.toArray(new int[intersectionResult.size()][]);
}

}

