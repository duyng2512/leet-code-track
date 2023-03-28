package org.dng.code.interview.nab_algo;

public class Ex2 {
	
	static public int solve(int[] D, int X) {
		int countDay = 0;
		int idx = 0;
		while (idx <= D.length - 1) {
			System.out.print(" Start " + idx);
			boolean skip = false;
			if (idx + 1 < D.length && Math.abs(D[idx] - D[idx + 1]) <= X) {
				skip = true;
				int min = D[idx];
				while (Math.abs(min - D[idx + 1]) <= X) {
					idx += 1;
					if (D[idx] < min) min = D[idx];
					if (idx == D.length - 1) break;
				}
			}
			if (!skip) idx++;
			countDay++;
			
		}
		return countDay;
	}
	
	public static void main(String[] args) {
		//System.out.println(solve(new int[]{5, 8, 2, 7}, 3)); // 3
		//System.out.println(solve(new int[]{2, 5, 9, 2, 1, 4}, 4)); // 3
		System.out.println(solve(new int[]{1, 12, 10, 4, 5, 2}, 2)); // 4
		
		// 1
		// 12 10
		// 4 5
		// 2
		// return 4
	}
	
}
