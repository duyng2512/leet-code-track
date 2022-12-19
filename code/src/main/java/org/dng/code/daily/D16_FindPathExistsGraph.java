package org.dng.code.daily;

import java.util.*;

/**
 * @author duyntc 12/2022
 */
public class D16_FindPathExistsGraph {
     
     /**
      * @desc: https://leetcode.com/problems/find-if-path-exists-in-graph/
      */
     
     
     /**
      * BFS
      * Space Complexity: O(m+n)
      * Time Complexity: O(m+n)
      *
      * @param n
      * @param edges
      * @param source
      * @param destination
      * @return
      */
     static public boolean validPath(int n, int[][] edges, int source, int destination) {
	Map<Integer, List<Integer>> map = new HashMap<>();
	for (int[] edge : edges) {
	     int a = edge[0];
	     int b = edge[1];
	     map.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
	     map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
	}
	
	boolean[] seen = new boolean[n];
	seen[source] = true;
	Queue<Integer> queue = new ArrayDeque<>();
	queue.offer(source);
	
	while (!queue.isEmpty()) {
	     int poll = queue.poll();
	     if (poll == destination) {
		return true;
	     }
	     
	     for (Integer node : map.get(poll)) {
		if (!seen[node]) {
		     seen[node] = true;
		     queue.offer(node);
		}
	     }
	}
	return false;
     }
     
     /**
      * DS
      */
     static public boolean validPathDfs(int n, int[][] edges, int source, int destination) {
	Map<Integer, List<Integer>> graph = new HashMap<>();
	for (int[] edge : edges) {
	     int a = edge[0];
	     int b = edge[1];
	     graph.computeIfAbsent(a, v -> new ArrayList<>()).add(b);
	     graph.computeIfAbsent(b, v -> new ArrayList<>()).add(a);
	}
	boolean[] seen = new boolean[n];
	return dfs(graph, source, destination, seen);
     }
     
     static public boolean dfs(Map<Integer, List<Integer>> graph, int currNode, int dest, boolean[] seen) {
	if (currNode == dest) {
	     return true;
	}
	
	if (!seen[currNode]) {
	     seen[currNode] = true;
	     for (Integer node : graph.get(currNode)) {
		if (dfs(graph, node, dest, seen)) {
		     return true;
		}
	     }
	}
	return false;
     }
     
     public static void main(String[] args) {
	int[][] arr = new int[][]{
	     {0, 1}, {1, 2}, {2, 0}
	};
	
	System.out.println(validPathDfs(3, arr, 0, 2));
	
	arr = new int[][]{
	     {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}
	};
	
	System.out.println(validPathDfs(6, arr, 0, 5));
     }
}
