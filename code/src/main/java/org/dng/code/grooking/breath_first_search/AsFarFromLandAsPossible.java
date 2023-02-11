package org.dng.code.grooking.breath_first_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duyntc 02/2023
 */
public class AsFarFromLandAsPossible {
     
     /**
      * https://leetcode.com/problems/as-far-from-land-as-possible/
      * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
      * find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
      * If no land or water exists in the grid, return -1.
      * <p>
      * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0)
      * and (x1, y1) is |x0 - x1| + |y0 - y1|.
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * <p>
      * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
      * Output: 2
      * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
      * Example 2:
      * <p>
      * <p>
      * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
      * Output: 4
      * Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
      */
     
     
     static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
     
     static public int maxDistanceDFS(int[][] grid) {
	
	int numRow = grid.length;
	int numCol = grid[0].length;
	
	int[][] visited = new int[numRow][numCol];
	Queue<int[]> queue = new LinkedList<>();
	
	// Fill up visited matrix
	for (int i = 0; i < numRow; i++) {
	     for (int j = 0; j < numCol; j++) {
		visited[i][j] = grid[i][j];
		if (visited[i][j] == 1) {
		     queue.add(new int[]{i, j});
		}
	     }
	}
	
	int distance = -1;
	
	while (!queue.isEmpty()) {
	     
	     int curQueueSize = queue.size();
	     while (curQueueSize-- > 0) {
		int[] land = queue.poll();
		
		// Update all water to land
		for (int[] direction : directions) {
		     
		     assert land != null;
		     int x = land[0] + direction[0];
		     int y = land[1] + direction[1];
		     
		     if (x >= 0 &&
			y >= 0 &&
			x < numRow &&
			y < numCol &&
			visited[x][y] == 0
		     ) {
			visited[x][y] = 1;
			queue.add(new int[]{x, y});
		     }
		     
		}
	     }
	     
	     distance++;
	}
	
	return distance == 0 ? -1 : distance;
     }
     
     /**
      * Intuition:
      * <p>
      * 1. Create dist matrix
      * 2. Fill up with MAX_DISTANCE
      * 3. We travel from TOP LEFT -> BOTTOM RIGHT the distance is min of ( cell left and cell above)
      * 4. We travel from BOTTOM RIGHT -> TOP LEFT the distance is min of ( cell right and cell bottom)
      * 5. Check max distance
      *
      * @param grid
      * @return
      */
     
     static public int maxDistance(int[][] grid) {
	
	int numRow = grid.length;
	int numCol = grid[0].length;
	
	
	int[][] dist = new int[numRow][numCol];
	int MAX_DIST = numCol + numRow + 1;
	
	boolean haveLand = false;
	for (int i = 0; i < numRow; i++) {
	     for (int j = 0; j < numCol; j++) {
		if (grid[i][j] == 1) {
		     dist[i][j] = 0;
		     haveLand = true;
		} else {
		     dist[i][j] = MAX_DIST;
		}
	     }
	}
	
	if (!haveLand) return -1;
	
	System.out.println(Arrays.deepToString(dist));
	
	int result = Integer.MIN_VALUE;
	
	// First transversal
	for (int i = 0; i < numRow; i++) {
	     for (int j = 0; j < numCol; j++) {
		// Water cell
		
		int leftDist = MAX_DIST;
		int topDist = MAX_DIST;
		if (i - 1 >= 0) {
		     leftDist = dist[i - 1][j] + 1;
		}
		if (j - 1 >= 0) {
		     topDist = dist[i][j - 1] + 1;
		}
		dist[i][j] = Math.min(dist[i][j], Math.min(leftDist, topDist));
		
	     }
	}
	System.out.println(Arrays.deepToString(dist));
	
	for (int i = numRow - 1; i >= 0; i--) {
	     for (int j = numCol - 1; j > 0; j--) {
		// Water cell
		
		int rightDist = MAX_DIST;
		int bottomDist = MAX_DIST;
		if (i + 1 < numRow) {
		     bottomDist = dist[i + 1][j] + 1;
		}
		if (j + 1 < numCol) {
		     rightDist = dist[i][j + 1] + 1;
		}
		dist[i][j] = Math.min(dist[i][j], Math.min(bottomDist, rightDist));
		result = Math.max(result, grid[i][j]);
		
	     }
	}
	
	return result == 0 || result == MAX_DIST ? -1 : result;
     }
     
     public static void main(String[] args) {
	int[][] grid = new int[][]{
	     {1, 0, 0}, {0, 0, 0}, {0, 0, 0}
	};
	
	System.out.println(maxDistance(grid));
     }
     
}
