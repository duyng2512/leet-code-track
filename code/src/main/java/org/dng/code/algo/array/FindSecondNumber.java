package org.dng.code.algo.array;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindSecondNumber {

public static void main(String[] args) {
	FindSecondNumber fNumber = new FindSecondNumber();
	fNumber.findKthLargest(new int[]{6, 2, 4, 1, 10, 5, 7}, 3);
}

public int findKthLargest(int[] nums, int k) {
	PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
	
	// keep k largest elements in the heap
	for (int n : nums) {
		heap.add(n);
		if (heap.size() > k)
			heap.poll();
	}
	
	// output
	return heap.poll();
}

public void appendToSubArr(int value, LinkedList<Integer> linkList, int k) {
	if (linkList.isEmpty()) {
		linkList.add(value);
		return;
	}
	
	int currentNode = linkList.get(0);
	int index = 0;
	
	while (currentNode > value && index < linkList.size()) {
		index++;
		if (index > linkList.size() - 1) break;
		currentNode = linkList.get(index);
	}
	linkList.add(index, value);
	if (linkList.size() > k) linkList.removeLast();
	System.out.println(linkList);
}
}
