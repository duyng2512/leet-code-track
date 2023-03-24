package org.dng.code.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarTest {
	
	/**
	 * 1 4 1
	 * 1 5 1
	 * <p>
	 * 4 1 1
	 * 5 1 1
	 * <p>
	 * 5 1 0
	 * 5 1 1
	 * <p>
	 * // We try to fill as much car as possible
	 * <p>
	 * <p>
	 * 4 4 2 4
	 * 5 5 2 5
	 * <p>
	 * 4 4 4 2
	 * 5 5 5 2
	 * <p>
	 * 5 3 4 2
	 * 5 5 5 2
	 * <p>
	 * 5 5 2 2
	 * 5 5 5 2
	 * <p>
	 * 5 5 4 0
	 * 5 5 5 2
	 */
	
	static class Entry implements Comparable<Entry> {
		int people;
		int seat;
		
		public Entry(int people, int seat) {
			this.people = people;
			this.seat = seat;
		}
		
		@Override
		public int compareTo(Entry entry) {
			return seat - entry.seat;
		}
		
		@Override
		public String toString() {
			return "Entry{" +
					"people=" + people +
					", seat=" + seat +
					'}';
		}
	}
	
	public int solution(int[] P, int[] S) {
		int N = P.length;
		List<Entry> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) arr.add(new Entry(P[i], S[i]));
		
		Collections.sort(arr);
		Collections.reverse(arr);
		
		// System.out.println("Before" + arr);
		
		int remain = 0;
		for (int i = 0; i < arr.size(); i++) {
			Entry cur = arr.get(i);
			remain = cur.seat - cur.people;
			
			// While there is still empty seat
			int index = i + 1;
			while (remain > 0 && index != arr.size()) {
				Entry next = arr.get(index);
				int available = Math.min(next.people, remain);
				next.people -= available;
				cur.people += available;
				remain -= available;
				index++;
			}
		}
		
		// System.out.println("After" + arr);
		
		int emptyCar = 0;
		for (Entry entry : arr) {
			if (entry.people == 0) emptyCar++;
		}
		return P.length - emptyCar;
	}
	
	
	public static void main(String[] args) {
		int[] P = new int[]{1, 4, 1};
		int[] S = new int[]{1, 5, 1};
		
		CarTest carTest = new CarTest();
		int x = carTest.solution(P, S); // 2
		System.out.println(x);
		
		P = new int[]{4, 4, 2, 4};
		S = new int[]{5, 5, 2, 5};
		x = carTest.solution(P, S); // 3
		System.out.println(x);
		
		P = new int[]{2, 3, 4, 2};
		S = new int[]{2, 5, 7, 2};
		x = carTest.solution(P, S); // 2
		System.out.println(x);
		
	}
}
