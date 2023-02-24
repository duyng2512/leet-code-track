package org.dng.code.grooking.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindNLargestNumber {

public int findKthLargest(int[] nums, int k) {
	
	PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
	
	// Intuitive: push element to heap
	// However when there are more item
	// in heap push them out.
	for (int n : nums) {
		heap.add(n);
		if (heap.size() > k)
			heap.poll();
	}
	
	// output
	return heap.poll();
}
}
