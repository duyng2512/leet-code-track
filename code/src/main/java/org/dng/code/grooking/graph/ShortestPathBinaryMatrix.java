package org.dng.code.grooking.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author duyntc 01/2023
 */
public class ShortestPathBinaryMatrix {
     
     /**
      * Given an n x n binary matrix grid, return the length of
      * the shortest clear path in the matrix. If there is no clear path, return -1.
      * <p>
      * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
      * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
      * <p>
      * All the visited cells of the path are 0.
      * All the adjacent cells of the path are 8-directionally connected (i.e., they are
      * different and they share an edge or a corner).
      * The length of a clear path is the number of visited cells of this path.
      */
     
     static public int[][] directions = new int[][]{
	{-1, -1},
	{-1, 0},
	{-1, 1},
	{0, -1},
	{0, 1},
	{1, -1},
	{1, 0},
	{1, 1}};
     
     static public int shortestPathBinaryMatrix(int[][] grid) {
	int N = grid.length;
	
	if (grid[N - 1][N - 1] == 1 || grid[0][0] == 1) {
	     return -1;
	}
	
	// Set up BFS
	// Queue contain list of visited array
	Queue<int[]> queue = new ArrayDeque<>();
	
	// Visit 0,0
	grid[0][0] = 1;
	queue.add(new int[]{0, 0});
	
	while (!queue.isEmpty()) {
	     // Last visited cell
	     int[] cell = queue.poll();
	     int row = cell[0];
	     int col = cell[1];
	     int distance = grid[row][col];
	     if (row == N - 1 && col == N - 1) {
		return distance;
	     }
	     List<int[]> neighbours = getNeighbours(row, col, grid);
	     
	     for (int[] node : neighbours) {
		
		int neighbourRow = node[0];
		int neighbourCol = node[1];
		grid[neighbourRow][neighbourCol] = distance + 1;
		queue.add(new int[]{neighbourRow, neighbourCol});
	     }
	}
	
	return -1;
     }
     
     static public List<int[]> getNeighbours(int row, int col, int[][] grid) {
	int N = grid.length;
	List<int[]> neighbours = new ArrayList<>();
	for (int[] direction : directions) {
	     int newRol = row + direction[0];
	     int newCol = col + direction[1];
	     
	     // Checking for corners and cell with blocked
	     if (newCol == N ||
		newRol == N ||
		newRol < 0 ||
		newCol < 0 ||
		grid[newRol][newCol] != 0
	     ) {
		continue;
	     }
	     neighbours.add(new int[]{newRol, newCol});
	}
	return neighbours;
     }
     
     public static void main(String[] args) {
	int[][] grid = new int[][]{
	     {0, 0, 0},
	     {1, 1, 0},
	     {1, 1, 0}
	};
	
	System.out.println(shortestPathBinaryMatrix(grid));
	
	int[][] grid1 = new int[][]{
	     {0, 1},
	     {1, 0}
	};
	
	System.out.println(shortestPathBinaryMatrix(grid1));
	
     }
     
}
