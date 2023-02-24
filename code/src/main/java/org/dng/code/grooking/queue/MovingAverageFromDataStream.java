package org.dng.code.grooking.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverageFromDataStream {

public static void main(String[] args) {
	MovingAverage avg = new MovingAverage(3);
	System.out.println(avg.next(1));
	System.out.println(avg.next(10));
	System.out.println(avg.next(3));
	System.out.println(avg.next(5));
	
}

/**
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 * <p>
 * Implement the MovingAverage class:
 * <p>
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 */

static class MovingAverage {
	
	Queue<Integer> queue;
	long total;
	int size;
	
	public MovingAverage(int size) {
		this.size = size;
		queue = new ArrayDeque<>();
		total = 0L;
	}
	
	public double next(int val) {
		if (queue.size() < this.size) {
			queue.add(val);
			total += val;
		} else {
			int oldest = queue.poll();
			total -= oldest;
			total += val;
			queue.add(val);
		}
		return (double) total / queue.size();
	}
}

}
