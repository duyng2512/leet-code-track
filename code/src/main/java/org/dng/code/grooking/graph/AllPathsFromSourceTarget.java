package org.dng.code.grooking.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author duyntc 01/2023
 */
public class AllPathsFromSourceTarget {
     
     static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	List<List<Integer>> allPaths = new ArrayList<>();
	List<Integer> currentPath = new LinkedList<>();
	currentPath.add(0);
	boolean[] beingVisited = new boolean[graph.length];
	
	Map<Integer, List<Integer>> mapGraph = new HashMap<>();
	
	for (int i = 0; i < graph.length; i++) {
	     mapGraph.computeIfAbsent(i, val -> new ArrayList<>()).addAll(Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
	}
	
	dfs(allPaths, currentPath, mapGraph, beingVisited, 0, graph.length - 1);
	return allPaths;
     }
     
     static public void dfs(List<List<Integer>> allPaths,
		        List<Integer> currentPath,
		        Map<Integer, List<Integer>> graph,
		        boolean[] beingVisited,
		        int source,
		        int dest) {
	
	if (source == dest) {
	     allPaths.add(new ArrayList<>(currentPath));
	     return;
	}
	
	// If node not being visited
	if (!beingVisited[source]) {
	     beingVisited[source] = true;
	     for (Integer node : graph.get(source)) {
		currentPath.add(node);
		dfs(allPaths, currentPath, graph, beingVisited, node, dest);
		currentPath.remove(currentPath.size() - 1);
	     }
	     beingVisited[source] = false;
	}
     }
     
     public static void main(String[] args) {
	System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
     }
     
}
