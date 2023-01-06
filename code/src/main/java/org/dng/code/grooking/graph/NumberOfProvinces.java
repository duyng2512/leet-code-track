package org.dng.code.grooking.graph;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duyntc 01/2023
 */
public class NumberOfProvinces {
     
     /**
      * There are n cities. Some of them are connected, while some are not.
      * If city a is connected directly with city b, and city b is connected
      * directly with city c, then city a is connected indirectly with city c.
      * <p>
      * A province is a group of directly or indirectly connected cities and no
      * other cities outside of the group.
      * <p>
      * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
      * ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
      * <p>
      * Return the total number of provinces.
      * <p>
      * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
      * Output: 2
      * <p>
      * <p>
      * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
      * Output: 3
      */
     
     public static void main(String[] args) {
	int[][] arr1 = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	System.out.println(findCircleNum(arr1));
     }
     
     static public int findCircleNum(int[][] isConnected) {
	int N = isConnected.length;
	ProvinceSet provinceSet = new ProvinceSet(N);
	for (int i = 0; i < N; i++) {
	     for (int j = 0; j < N; j++) {
		if (isConnected[i][j] == 1) {
		     provinceSet.union(i, j);
		}
	     }
	}
	return provinceSet.count;
     }
     
     
     static class ProvinceSet {
	int[] root;
	int[] rank;
	int count;
	
	public ProvinceSet(int size) {
	     root = new int[size];
	     rank = new int[size];
	     count = size;
	     for (int i = 0; i < size; i++) {
		root[i] = i;
		rank[i] = 1;
	     }
	}
	
	public int find(int n) {
	     if (root[n] == n) {
		return root[n];
	     }
	     return root[n] = find(root[n]);
	}
	
	public void union(int x, int y) {
	     int rootX = find(x);
	     int rootY = find(y);
	     
	     if (rootX != rootY) {
		// Smaller rank is chosen
		if (rank[rootX] > rank[rootY]) {
		     root[rootY] = rootX;
		} else if (rank[rootX] < rank[rootY]) {
		     root[rootX] = rootY;
		} else {
		     root[rootY] = rootX;
		     rank[rootX] += 1;
		}
		count--;
	     }
	}
	
	public boolean connected(int x, int y) {
	     return find(x) == find(y);
	}
 
	public int[] getRoot() {
	     return root;
	}
 
	public int[] getRank() {
	     return rank;
	}
 
	public int getCount() {
	     return count;
	}
     }
     
}
