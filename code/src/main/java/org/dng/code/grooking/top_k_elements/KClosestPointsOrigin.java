package org.dng.code.grooking.top_k_elements;

import java.util.*;

public class KClosestPointsOrigin {

public static int[][] kClosest(int[][] points, int k) {
	Comparator<int[]> comparator = (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
	PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
	
	queue.addAll(Arrays.asList(points));
	List<int[]> result = new ArrayList<>();
	for (int i = 0; i < k; i++) {
		result.add(queue.poll());
	}
	
	return result.toArray(new int[][]{});
}

public static void main(String[] args) {
	// [[1,3],[-2,2]], k = 1
	int[][] arr = new int[][]{{1, 3}, {-2, 2}};
	System.out.println(Arrays.deepToString(kClosest(arr, 1)));
	
	int[][] arr1 = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
	System.out.println(Arrays.deepToString(kClosest(arr1, 2)));
	
	int[][] arr2 = new int[][]{{2, 10}, {-9, -9}, {0, 8}, {-2, -2}, {8, 9}, {-10, -7}, {-5, 2}, {-4, -9}};
	System.out.println(Arrays.deepToString(kClosest(arr2, 7)));
}

}
