package org.dng.code.grooking.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duyntc 02/2023
 */
public class SpiralMatrix {
     
     /**
      * https://leetcode.com/problems/spiral-matrix/?envType=study-plan&id=level-2
      *
      * Given an m x n matrix, return all elements of the matrix in spiral order.
      *
      *
      *
      * Example 1:
      *
      * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
      * Output: [1,2,3,6,9,8,7,4,5]
      *
      *
      * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
      * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
      */
     
     
     /**
      * Intuitive using a visited matrix for this purpose
      * For each cell where check from TOP -> LEFT -> DOWN -> RIGHT before make a move.
      */
     
     static public int[] availableNextMove(boolean[][] visited,
				   int curRow,
				   int curCol,
				   boolean changeDirection) {
	
	int maxRow = visited.length;
	int maxCol = visited[0].length;
	
	if (!changeDirection) {
	     // Check Top
	     if (curRow - 1 != -1 && !visited[curRow - 1][curCol]) {
		return new int[]{curRow - 1, curCol};
	     }
	     
	     // Check right
	     if (curCol + 1 != maxCol && !visited[curRow][curCol + 1]) {
		return new int[]{curRow, curCol + 1};
	     }
	     
	     // Check Bottom
	     if (curRow + 1 != maxRow && !visited[curRow + 1][curCol]) {
		return new int[]{curRow + 1, curCol};
	     }
	     
	     // Check Left
	     if (curCol - 1 != -1 && !visited[curRow][curCol - 1]) {
		return new int[]{curRow, curCol - 1};
	     }
	     
	} else {
	     
	     // Check Left
	     if (curCol - 1 != -1 && !visited[curRow][curCol - 1]) {
		return new int[]{curRow, curCol - 1};
	     }
	     
	     // Check Top
	     if (curRow - 1 != -1 && !visited[curRow - 1][curCol]) {
		return new int[]{curRow - 1, curCol};
	     }
	     
	     // Check right
	     if (curCol + 1 != maxCol && !visited[curRow][curCol + 1]) {
		return new int[]{curRow, curCol + 1};
	     }
	     
	     // Check Bottom
	     if (curRow + 1 != maxRow && !visited[curRow + 1][curCol]) {
		return new int[]{curRow + 1, curCol};
	     }
	}
	System.out.println(curRow + " " + curCol + " dir " + changeDirection);
	return null;
     }
     
     
     static public List<Integer> spiralOrder(int[][] matrix) {
	int VISITED = 101;
	int rows = matrix.length;
	int columns = matrix[0].length;
	
	int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	int curDir = 0;
	
	// Intuitive when go spiral only four time we change direction
	int changeDirection = 0;
	
	int row = 0;
	int col = 0;
	
	List<Integer> result = new ArrayList<>();
	
	result.add(matrix[0][0]);
	matrix[0][0] = VISITED;
	
	while (changeDirection < 2) {
	     while (row + dir[curDir][0] >= 0 &&
		row + dir[curDir][0] < rows &&
		col + dir[curDir][1] >= 0 &&
		col + dir[curDir][1] < columns &&
		matrix[row + dir[curDir][0]][col + dir[curDir][1]] != VISITED) {
		
		changeDirection = 0;
		
		row = row + dir[curDir][0];
		col = col + dir[curDir][1];
		
		result.add(matrix[row][col]);
		matrix[row][col] = VISITED;
	     }
	     
	     curDir = (curDir + 1) % 4;
	     
	     changeDirection++;
	}
	return result;
     }
     
     
     public static void main(String[] args) {
	int[][] arr = new int[][]{
	     {1, 2, 3},
	     {4, 5, 6},
	     {7, 8, 9}
	};
	List<Integer> result = spiralOrder(arr);
	System.out.println(result); // [1,2,3,6,9,8,7,4,5]
     }
}
