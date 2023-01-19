package org.dng.code.grooking.breath_first_search;

import lombok.Builder;
import org.dng.code.utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


public class BinaryTreeLeveOrderTraversal {
     
     /*
          Given the root of a binary tree, return the level order traversal
          of its nodes' values. (i.e., from left to right, level by level).
          
          Input: root = [3,9,20,null,null,15,7]
          Output: [[3],[9,20],[15,7]]
          Example 2:
          
          Input: root = [1]
          Output: [[1]]
          Example 3:
          
          Input: root = []
          Output: []
      */
     
     List<List<Integer>> levels;
     
     public BinaryTreeLeveOrderTraversal() {
	this.levels = new ArrayList<List<Integer>>();
     }
     
     public void helper(TreeNode node, int level) {
	// start the current level
	if (levels.size() == level) levels.add(new ArrayList<>());
	
	// fulfil the current level
	levels.get(level).add(node.val);
	
	// process child nodes for the next level
	if (node.left != null) helper(node.left, level + 1);
	if (node.right != null) helper(node.right, level + 1);
     }
     
     public List<List<Integer>> levelOrder(TreeNode root) {
	if (root == null) return levels;
	helper(root, 0);
	return levels;
     }
     
     public List<List<Integer>> levelOrderV2(TreeNode root) {
	if (root == null) return new ArrayList<>();
	
	List<List<Integer>> levels = new ArrayList<>();
	Queue<TreeNode> deque = new ArrayDeque<>();
	int level = 0;
	deque.add(root);
	
	while (!deque.isEmpty()) {
	     levels.add(new ArrayList<>());
	     int levelLen = deque.size();
	     for (int i = 0; i < levelLen; i++) {
		
		TreeNode remove = deque.remove();
		levels.get(level).add(remove.val);
		
		if (remove.left != null) deque.add(remove.left);
		if (remove.right != null) deque.add(remove.right);
	     }
	     level++;
	}
	return levels;
     }
     
     public static void main(String[] args) {
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9);
	root.right = new TreeNode(20);
	root.right.left = new TreeNode(15);
	root.right.right = new TreeNode(7);
	BinaryTreeLeveOrderTraversal traversal = new BinaryTreeLeveOrderTraversal();
	System.out.println(traversal.levelOrder(root));
     }
     
}
