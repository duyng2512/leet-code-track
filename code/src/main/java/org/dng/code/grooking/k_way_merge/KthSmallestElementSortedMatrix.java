package org.dng.code.grooking.k_way_merge;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
     
     /*
	Problem Statement
	Given an N * NN∗N matrix where each row and column
	is sorted in ascending order, find the Kth smallest
	element in the matrix.
     
	Example 1:
	
	Input: Matrix=[
	    [2, 6, 8],
	    [3, 7, 10],
	    [5, 8, 11]
	  ],
	  K=5
	Output: 7
	Explanation: The 5th smallest number in the matrix is 7.
      */
     
     public static int kthSmallest(int[][] matrix, int k) {
	PriorityQueue<Integer> queue = new PriorityQueue<>();
	for (int[] ints : matrix) {
	     for (int anInt : ints) {
		queue.add(anInt);
	     }
	}
	for (int i = 0; i < k-1; i++) {
	     queue.poll();
	}
	return queue.poll();
     }
     
     public static void main(String[] args) {
	int[][] arr1 = new int[][] {{1,5,9},
			     {10,11,13},
			     {12,13,15}};
     
	System.out.println(kthSmallest(arr1, 8));
 
	System.out.println(kthSmallest(new int[][] {{-5}} , 1));
     }
     
}
