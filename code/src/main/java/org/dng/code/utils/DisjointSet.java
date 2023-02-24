package org.dng.code.utils;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author duyntc 01/2023
 */
public class DisjointSet {

/**
 * Disjoint set is a data structure that connect each vertex
 * There are two function for disjoint set:
 * union: can be optimized by ranking
 * find: can be optimized by compression
 */

@Getter
private final int[] root;
private final int[] rank;

public DisjointSet(int size) {
	root = new int[size];
	rank = new int[size];
	for (int i = 0; i < size; i++) {
		root[i] = i;
		rank[i] = 1;
	}
}

public static void main(String[] args) throws Exception {
	DisjointSet uf = new DisjointSet(10);
	// 1-2-5-6-7 3-8-9 4
	// 0 1 2 3 4 5 6 7 8
	uf.union(1, 2);
	uf.union(2, 5);
	uf.union(5, 6);
	uf.union(6, 7);
	uf.union(3, 8);
	uf.union(8, 9);
	System.out.println(uf.connected(1, 5)); // true
	System.out.println(uf.connected(5, 7)); // true
	System.out.println(uf.connected(4, 9)); // false
	// 1-2-5-6-7 3-8-9-4
	uf.union(9, 4);
	System.out.println(uf.connected(4, 9)); // true
	System.out.println(Arrays.toString(uf.getRoot()));
}

/**
 * Intuitive: keep looping until find a node that value = index
 *
 * @param v
 * @return
 */
public int findUnOptimize(int v) {
	while (v != root[v]) {
		v = root[v];
	}
	return v;
}

public int findUnOptimizeR(int x) {
	if (x == root[x]) {
		return x;
	}
	return findUnOptimizeR(root[x]);
}


/* OPTIMIZE CODE */

public void unionUnOptimize(int x, int y) {
	int rootX = findUnOptimize(x);
	int rootY = findUnOptimize(y);
	if (rootX != rootY) {
		root[rootY] = rootX;
	}
}

/**
 * Optimize solution
 */
public int find(int v) {
	if (v == root[v]) {
		return v;
	}
	return root[v] = find(root[v]);
	// Result of parent will propagate to root[x] simultaneously update them
}

public void union(int x, int y) {
	int rootX = find(x);
	int rootY = find(y);
	
	if (rootX != rootY) {
		
		// Choose which root is smaller
		if (rank[rootX] > rank[rootY]) {
			root[rootY] = rootX;
		} else if (rank[rootX] < rank[rootY]) {
			root[rootX] = rootY;
		} else {
			root[rootY] = rootX;
			rank[rootX] += 1;
		}
		
	}
}

public boolean connected(int x, int y) {
	return find(x) == find(y);
}

}

