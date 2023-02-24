package org.dng.code.interview;


/**
 * @author duyntc 01/2023
 */
public class SolutionFrog {

public static void main(String[] args) {
	SolutionFrog solutionFrog = new SolutionFrog();
	int[] arr;
	arr = new int[]{2, 6, 8, 5};
	System.out.println(solutionFrog.solution(arr)); // 3
	
	arr = new int[]{1, 5, 5, 2, 6};
	System.out.println(solutionFrog.solution(arr)); // 4
	
	arr = new int[]{0, 0};
	System.out.println(solutionFrog.solution(arr)); // 2
}

public int solution(int[] blocks) {
	int result = -1;
	
	for (int i = 0; i < blocks.length; i++) {
		int currentDist = twoPointer(blocks, i);
		result = Math.max(result, currentDist);
	}
	
	return result;
}

public int twoPointer(int[] blocks, int init) {
	int frog1 = init;
	int frog2 = init;
	int N = blocks.length;
	int maxDist = -1;
	
	// Frog 1 can move forward
	// Frog 2 can move backward
	
	boolean frog1CanMove = true;
	boolean frog2CanMove = true;
	
	while (frog1CanMove || frog2CanMove) {
		
		if (frog1 == N - 1 || blocks[frog1] > blocks[frog1 + 1]) {
			frog1CanMove = false;
		} else {
			frog1++;
		}
		
		if (frog2 == 0 || blocks[frog2 - 1] < blocks[frog2]) {
			frog2CanMove = false;
		} else {
			frog2--;
		}
		
		maxDist = Math.max(maxDist, Math.abs(frog1 - frog2 + 1));
	}
	return maxDist;
}

}
