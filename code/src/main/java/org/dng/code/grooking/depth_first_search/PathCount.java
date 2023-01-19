package org.dng.code.grooking.depth_first_search;

import org.dng.code.utils.TreeNode;

import java.util.HashMap;

public class PathCount {
     
     /*
     	Problem Statement:
     	
	Given a binary tree and a number ‘S’,
	find all paths in the tree such that the sum of all the
	node values of each path equals ‘S’.
	
	Please note that the paths can start or end at any node but
	all paths must follow direction from parent to child (top to bottom).
	
	Link: https://leetcode.com/problems/path-sum-iii/solution/

     	Intuitive:
     	
     	There are two scenarios for this:
     	
     	- First is sum is equal from node to leaf
     	- Second is sum equal around the middle of the leaf
     	 
     	 We should construct a hash map to
     	 remember current sum and its frequency
     	
      */
     
     Long count = 0L;
     HashMap<Long, Long> map = new HashMap<>();
     
     public void preOrderTree(TreeNode root, long curSum, long targetSum) {
          if (root == null) return;
          
          curSum += root.val;
          
          // This is the first scenario we're talking about
          if (curSum == targetSum) count++;
     
          // This is the second scenario we're talking about
          count += map.getOrDefault(curSum - targetSum, 0L);
	
          // Put the pre fix to map
          map.put(curSum, map.getOrDefault(curSum, 0L) + 1);
          
          preOrderTree(root.left, curSum, targetSum);
          preOrderTree(root.right, curSum, targetSum);
          
          // We need to remove last element from map for its execute concurrently
          
          map.put(curSum, map.get(curSum) - 1);
          
     }
     
     public int pathSum(TreeNode root, long targetSum) {
          int curSum = 0;
	preOrderTree(root, curSum, targetSum);
          return count.intValue();
     }
     
     
     public static void main(String[] args) {
	
     }
     
}
