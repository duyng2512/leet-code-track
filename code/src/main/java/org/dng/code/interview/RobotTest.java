package org.dng.code.interview;

import java.util.Arrays;

public class RobotTest {
	
	static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public int solution(String[] R) {
		
		int ROW = R.length;
		int COL = R[0].length();
		
		// Edge case
		if (ROW == 1) {
			int result = 0;
			for (int i = 0; i < R[0].length(); i++) {
				if (R[0].charAt(i) == '.') {
					result++;
				} else {
					break;
				}
			}
			return result;
		}
		
		
		int[][] arr = new int[ROW][COL];
		
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				char cell = R[i].charAt(j);
				if (cell == 'X') {
					arr[i][j] = -1;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		
		// if there is a cell = 3 mean that we already cross this 3 time
		int cell = 0;
		int counter = 0; // use for rotate the matrix;
		int result = 0;
		
		int row = 0;
		int col = 0;
		
		while (cell != 3) {
			
			if (canGoNextStep(arr, row, col, directions[counter])) {
				arr[row][col] += 1;
				row += directions[counter][0];
				col += directions[counter][1];
			} else {
				counter = (counter + 1) % 4;
			}
			cell = arr[row][col];
		}
		System.out.println(Arrays.deepToString(arr));
		for (int[] ints : arr) {
			for (int anInt : ints) {
				if (anInt != -1 && anInt != 0) result++;
			}
			// System.out.println(Arrays.toString(ints));
		}
		
		return result;
	}
	
	public boolean canGoNextStep(int[][] arr, int row, int col, int[] dir) {
		
		int nextRow = row + dir[0];
		int nextCol = col + dir[1];
		
		if (nextRow < 0 || nextRow > arr.length - 1) return false;
		if (nextCol < 0 || nextCol > arr[0].length - 1) return false;
		return arr[nextRow][nextCol] != -1;
	}
	
	
	public static void main(String[] args) {
		RobotTest nabTest = new RobotTest();
		
		String[] arr = new String[3];
		arr[0] = "...X..";
		arr[1] = "....XX";
		arr[2] = "..X...";
		System.out.println(nabTest.solution(arr)); // 6
		
		arr = new String[4];
		arr[0] = "....X..";
		arr[1] = "X......";
		arr[2] = ".....X.";
		arr[3] = ".......";
		System.out.println(nabTest.solution(arr)); // 15
		
		arr = new String[4];
		arr[0] = "...X.";
		arr[1] = ".X..X";
		arr[2] = "X...X";
		arr[3] = "..X..";
		System.out.println(nabTest.solution(arr)); // 9
		
		
		arr = new String[1];
		arr[0] = ".....";
		System.out.println(nabTest.solution(arr)); // 5
		
		arr = new String[1];
		arr[0] = "..";
		System.out.println(nabTest.solution(arr)); // 2
		
		arr = new String[1];
		arr[0] = "..X";
		System.out.println(nabTest.solution(arr)); // 2
		
		arr = new String[1];
		arr[0] = ".X";
		System.out.println(nabTest.solution(arr)); // 1
		
		arr = new String[1];
		arr[0] = "...X";
		System.out.println(nabTest.solution(arr)); // 3
		
		arr = new String[1];
		arr[0] = ".X";
		System.out.println(nabTest.solution(arr)); // 1
	}
}
