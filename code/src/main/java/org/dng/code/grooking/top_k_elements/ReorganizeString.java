package org.dng.code.grooking.top_k_elements;

import java.util.*;

public class ReorganizeString {

public static String reorganizeString(String s) {
	StringBuilder builder = new StringBuilder();
	Map<Character, Integer> map = new HashMap<>();
	
	
	for (Character character : s.toCharArray()) {
		map.put(character, map.getOrDefault(character, 0) + 1);
	}
	
	Comparator<Map.Entry<Character, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
	PriorityQueue<Map.Entry<Character, Integer>> maxQueue = new PriorityQueue<>(comparator);
	Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
	
	maxQueue.addAll(map.entrySet());
	
	while (!maxQueue.isEmpty()) {
		Map.Entry<Character, Integer> current = maxQueue.poll();
		builder.append(current.getKey());
		current.setValue(current.getValue() - 1);
		
		waitQueue.add(current);
		
		if (waitQueue.peek().getKey() != current.getKey()) {
			Map.Entry<Character, Integer> front = waitQueue.poll();
			if (front.getValue() > 0) {
				maxQueue.add(front);
			}
		}
		
	}
	return builder.toString().length() == s.length() ? builder.toString() : "";
}

public static void main(String[] args) {
	System.out.println(reorganizeString("vvvlo"));
}

}
