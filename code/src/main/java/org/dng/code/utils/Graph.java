package org.dng.code.utils;

import java.util.*;

/**
 * @author duyntc 01/2023
 */
public class Graph {
     
     /**
      * DFS
      */
     static public boolean dfsPath(int n, int[][] edges, int source, int destination) {
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
     
     /**
      * BFS
      *
      * @param args
      */
     static public List<List<Integer>> bfs(List<List<Integer>> graph) {
	List<List<Integer>> paths = new ArrayList<>();
	Queue<List<Integer>> queue = new LinkedList<>();
	List<Integer> path = new ArrayList<>();
	path.add(0);
	queue.add(path);
 
	while (!queue.isEmpty()) {
	     // Get current Path
	     List<Integer> currentPath = queue.poll();
	     // Get last element
	     int node = currentPath.get(currentPath.size() - 1);
	
	     for (Integer nextNode : graph.get(node)) {
		List<Integer> tempPath = new ArrayList<>(currentPath);
		tempPath.add(nextNode);
	 
		// graph length -1 here is the last node
		if (nextNode == graph.size() - 1) {
		     paths.add(new ArrayList<>(tempPath));
		} else {
		     queue.add(new ArrayList<>(tempPath));
		}
		
	     }
	}
	return paths;
     }
     
     public static void main(String[] args) {
	// n = 6
	// {{0,1},{0,2},{3,5},{5,4},{4,3}}
	// source = 0
	// dest = 5
 
	// dfsPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
	System.out.println(dfsPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
 
	// BFS
	// Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
	// Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
	List<List<Integer>> graph = new ArrayList<>();
	graph.add(new ArrayList<>(Arrays.asList(4,3,1)));
	graph.add(new ArrayList<>(Arrays.asList(3,2,4)));
	graph.add(new ArrayList<>(List.of(3)));
	graph.add(new ArrayList<>(List.of(4)));
	graph.add(new ArrayList<>());
 
	System.out.println(bfs(graph));
     }
     
     
}
