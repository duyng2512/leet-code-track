package org.dng.code.by_tag.depth_first_search;

import java.util.*;

/**
 * @author duyntc 12/2022
 */
public class PossibleBipartition {
	
	/**
	 * @desc: https://leetcode.com/problems/possible-bipartition/
	 */
	
	
	static public boolean dfs(int node, int nodeColor, Map<Integer, List<Integer>> adj, int[] color) {
		color[node] = nodeColor;
		if (!adj.containsKey(node))
			return true;
		for (int neighbor : adj.get(node)) {
			if (color[neighbor] == color[node])
				return false;
			if (color[neighbor] == -1) {
				if (!dfs(neighbor, 1 - nodeColor, adj, color))
					return false;
			}
		}
		return true;
	}
	
	static public boolean possibleBipartition(int n, int[][] dislikes) {
		
		// Build adjacency list
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] edge : dislikes) {
			int a = edge[0], b = edge[1];
			adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
			adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
		}
		int[] color = new int[n + 1];
		Arrays.fill(color, -1);
		
		for (int i = 1; i <= n; i++) {
			if (color[i] == -1) {
				// For each pending component, run DFS.
				if (!dfs(i, 0, adj, color))
					// Return false, if there is conflict in the component.
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(possibleBipartition(3, new int[][]
				{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}}
		));
	}
}
