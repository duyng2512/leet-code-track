package org.dng.code.grooking.depth_first_search;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
     
     /*
     	Problem Statement
	Given a binary tree and a number ‘S’,
	find all paths from root-to-leaf such that
	the sum of all the node values of each path equals ‘S’.
	
	Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
	Output: [[5,4,11,2],[5,8,4,5]]
	Explanation: There are two paths whose sum equals targetSum:
	5 + 4 + 11 + 2 = 22
	5 + 8 + 4 + 5 = 22
	
      */

public static void main(String[] args) {
	/*
	 	  1
		 2 3
		4 5
		   6
	 */
	
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.left.right.right = new TreeNode(6);
	
	PathSum sum = new PathSum();
	sum.preOrder(root);
	
	List<List<Integer>> res = sum.pathSum(root, 7);
	System.out.println(res);
}

public void preOrder(TreeNode root) {
	if (root == null) return;
	System.out.println(root.val);
	preOrder(root.left);
	preOrder(root.right);
}

public void preOrderSum(TreeNode root, List<Integer> pathNode, List<List<Integer>> pathNodes, int remainSum) {
	if (root == null) return;
	pathNode.add(root.val);
	if (remainSum == root.val && root.left == null && root.right == null) {
		pathNodes.add(new ArrayList<>(pathNode));
	} else {
		preOrderSum(root.left, pathNode, pathNodes, remainSum - root.val);
		preOrderSum(root.right, pathNode, pathNodes, remainSum - root.val);
	}
	
	// Remove last path ? If we don't remove them, the pathNode keep raising the whole tree
	pathNode.remove(pathNode.size() - 1);
}

public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	List<List<Integer>> pathsList = new ArrayList<>();
	List<Integer> pathNodes = new ArrayList<>();
	preOrderSum(root, pathNodes, pathsList, targetSum);
	return pathsList;
}

}
