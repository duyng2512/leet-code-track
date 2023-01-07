package org.dng.code.utils;

import java.util.*;

/**
 * @author duyntc 01/2023
 */
public class Graph {
     
     /**
      * DFS
      */
     static public boolean validPath(int n, int[][] edges, int source, int destination) {
	Map<Integer, List<Integer>> graph = new HashMap<>();
	
	List<List<Integer>> allPaths = new LinkedList<>();
	
	List<Integer> currentPath = new ArrayList<>();
	currentPath.add(source);
	
	boolean[] seen = new boolean[n];
	
	for (int[] edge : edges) {
	     int a = edge[0], b = edge[1];
	     graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
	     graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
	}
	
	dfs(allPaths,
	     currentPath,
	     graph,
	     seen,
	     source,
	     destination);
	System.out.println(allPaths);
	return allPaths.size() > 0;
     }
     
     static private void dfs(List<List<Integer>> allPaths,
		         List<Integer> currentPath,
		         Map<Integer, List<Integer>> graph,
		         boolean[] seen,
		         int currNode,
		         int destination) {
	if (currNode == destination) {
	     allPaths.add(new ArrayList<>(currentPath));
	     return;
	}
	if (!seen[currNode]) {
	     seen[currNode] = true;
	     for (int nextNode : graph.get(currNode)) {
		currentPath.add(nextNode);
		dfs(allPaths, currentPath, graph, seen, nextNode, destination);
		currentPath.remove(currentPath.size() - 1);
	     }
	}
	
     }
     
     public static void main(String[] args) {
	// n = 6
	// {{0,1},{0,2},{3,5},{5,4},{4,3}}
	// source = 0
	// dest = 5
	
	// validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
	System.out.println(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
     }
     
     
}
