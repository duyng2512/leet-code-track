package org.dng.code.grooking.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author duyntc 02/2023
 */
public class TaskScheduler {
     
     
     /**
      * 1. Sorted Task by frequency
      * 2. Construct idle map with the largest count
      * 3. Fill up by the 2nd largest count
      * 4. So on ...
      *
      * @param tasks
      * @param n
      * @return
      */
     static public int leastInterval(char[] tasks, int n) {
	/**
	 * A B A A B C A A
	 * A: 5
	 * B: 2
	 * C: 1
	 *
	 * A  A  A  A  A  A
	 * AB AB A  A  A  A
	 * ABCAB A  A  A  A // f_max - 1 = 4
	 *
	 */
	Map<Character, Integer> map = new HashMap<>();
	for (char task : tasks) {
	     map.compute(task, (k, v) -> map.get(k) == null ? 1 : map.get(k) + 1);
	}
	PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
	queue.addAll(map.entrySet());
	
	assert queue.peek() != null;
	int highestFreq = queue.poll().getValue();
	int idleTime = (highestFreq - 1) * n; // A _ _ A with n = 2
	
	// Now minimize idle time
	while (!queue.isEmpty()) {
	     int currentFreq = queue.poll().getValue();
	     if (currentFreq == highestFreq) {
		// A _ _ A _ _ A
		// A B _ A B _ A B  --> This case
		idleTime -= highestFreq - 1;
	     } else {
		idleTime -= currentFreq;
	     }
	}
	idleTime = Math.max(0, idleTime);
	
	return idleTime + tasks.length;
     }
     
     
     public static void main(String[] args) {
	char[] task = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
	System.out.println(leastInterval(task, 2));
     }
}
