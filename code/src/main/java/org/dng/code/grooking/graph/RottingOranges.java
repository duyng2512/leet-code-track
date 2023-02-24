package org.dng.code.grooking.graph;

import java.util.*;

/**
 * @author duyntc 01/2023
 */
public class RottingOranges {

int[][] directions = new int[][]{
		{0, 1},
		{1, 0},
		{0, -1},
		{-1, 0}
};

public static void main(String[] args) {
	
	RottingOranges rottingOranges = new RottingOranges();
	
	// [[2,1,1],[1,1,0],[0,1,1]]
	// int res = rottingOranges.orangesRotting()
	
}

public int orangesRotting(int[][] grid) {
	
	
	Queue<int[]> queue = new ArrayDeque<>();
	grid[0][0] = 2;
	queue.add(new int[]{0, 0});
	int time = 1;
	int N = grid.length;
	int M = grid[0].length;
	
	boolean flag = false;
	for (int[] row : grid) {
		for (int j = 0; j < M; j++) {
			// There are still un rotten orange
			if (row[j] == 1) {
				flag = true;
				break;
			}
		}
	}
	
	if (!flag) return 0;
	
	
	while (!queue.isEmpty()) {
		int[] node = queue.poll();
		int row = node[0];
		int col = node[1];
		
		// Check if this node is final node
		if (row == N - 1 && col == M - 1) {
			break;
		}
		
		List<int[]> neighbours = getNeighbours(row, col, grid);
		for (int[] neighbour : neighbours) {
			int neighbourRow = neighbour[0];
			int neighbourCol = neighbour[1];
			grid[neighbourRow][neighbourCol] = 2;
			queue.add(new int[]{neighbourRow, neighbourCol});
		}
		System.out.println(Arrays.deepToString(grid));
		time++;
	}
	
	for (int[] row : grid) {
		for (int j = 0; j < M; j++) {
			// There are still un rotten orange
			if (row[j] == 1) {
				return -1;
			}
		}
	}
	
	return time;
}

public List<int[]> getNeighbours(int row, int col, int[][] grid) {
	List<int[]> neighbours = new ArrayList<>();
	
	int N = grid.length;
	int M = grid[0].length;
	
	for (int[] direction : directions) {
		int newRow = row + direction[0];
		int newCol = col + direction[1];
		
		if (newRow >= N || newCol >= M || newRow < 0 || newCol < 0 || grid[newRow][newCol] != 1) {
			continue;
		}
		neighbours.add(new int[]{newRow, newCol});
	}
	return neighbours;
}

}
