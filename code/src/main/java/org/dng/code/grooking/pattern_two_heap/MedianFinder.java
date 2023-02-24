package org.dng.code.grooking.pattern_two_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<Integer> large = new PriorityQueue<>();
private boolean even = true;

public MedianFinder() {
}

public void addNum(int num) {
	if (even) {
		large.offer(num);
		small.add(large.poll());
	} else {
		small.offer(num);
		large.add(small.poll());
	}
	even = !even;
}

public double findMedian() {
	if (even)
		return (small.peek() + large.peek()) / 2.0;
	else
		return small.peek();
}
}
