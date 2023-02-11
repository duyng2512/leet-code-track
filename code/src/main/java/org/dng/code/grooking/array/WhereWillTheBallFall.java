package org.dng.code.grooking.array;

/**
 * @author duyntc 02/2023
 */
public class WhereWillTheBallFall {
     
     static public int dfs(int[][] grid, int row, int col) {
	
	// Base case
	if (row == grid.length)
	     return col;
	
	if (grid[row][col] == 1) {
	     int nextColumn = col + 1;
	     if (col != grid[0].length - 1 && grid[row][col] == grid[row][nextColumn])
		return dfs(grid, row + 1, nextColumn);
	     else
		return -1;
	} else {
	     int nextColumn = col - 1;
	     if (col != 0 && grid[row][col] == grid[row][nextColumn])
		return dfs(grid, row + 1, nextColumn);
	     else
		return -1;
	}
     }
     
     static public int[] findBall(int[][] grid) {
	int[] result = new int[grid[0].length];
	for (int i = 0; i < grid[0].length; i++) {
	     result[i] = dfs(grid, 0, i);
	}
	return result;
     }
}
