package org.dng.code.grooking.graph;

/**
 * @author duyntc 01/2023
 */
public class GraphValidTree {
     // Disjoint set
     
     /**
      * You have a graph of n nodes labeled from 0 to n - 1.
      * You are given an integer n and a list of edges where edges[i] = [ai, bi]
      * indicates that there is an undirected edge between nodes ai and bi in the graph.
      * <p>
      * Return true if the edges of the given graph make up a valid tree, and false otherwise.
      * <p>
      * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
      * Output: true
      */
     
     public static void main(String[] args) {
	
     }
     
     public boolean validTree(int n, int[][] edges) {
     
	if (edges.length != n - 1) return false;
	
	DisjointSet set = new DisjointSet(n);
	for (int[] edge : edges) {
	     if (!set.union(edge[0], edge[1])) {
		return false;
	     }
	}
	return true;
     }
     
     static class DisjointSet {
	
	int[] root;
	int[] rank;
	int count;
	
	public DisjointSet(int size) {
	     rank = new int[size];
	     root = new int[size];
	     for (int i = 0; i < size; i++) {
		root[i] = i;
		rank[i] = 1;
	     }
	}
	
	public int find(int n) {
	     if (root[n] == n) {
		return n;
	     }
	     return root[n] = find(root[n]);
	}
	
	public boolean union(int x, int y) {
	     int rootX = find(x);
	     int rootY = find(y);
	     
	     if (rootX == rootY) {
		return false;
	     }
	     
	     // Which node have a higher rank than stick to it
	     if (rank[rootX] > rank[rootY]) {
		root[rootY] = rootX;
	     } else if (rank[rootY] > rank[rootX]) {
		root[rootX] = rootY;
	     } else {
		root[rootY] = rootX;
		rank[rootX]++;
	     }
	     count++;
	     return true;
	     
	}
     }
     
}
