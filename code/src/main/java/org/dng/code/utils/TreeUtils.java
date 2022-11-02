package org.dng.code.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TreeUtils {
     
     //       1
     //    2     3
     //  4   5
     
     
     public static void depthFirstSearch(TreeNode root) {
	if (root == null) return;
	
	Deque<TreeNode> nodeDeque = new ArrayDeque<>();
	Map<TreeNode, Integer> nodeHeight = new HashMap<>();
	
	nodeDeque.addFirst(root);
	nodeHeight.put(root, 0);
	
	
	while (!nodeDeque.isEmpty()) {
	     TreeNode temp = nodeDeque.pollFirst();
	     
	     System.out.printf("Value: %d height: %d \n", temp.val, nodeHeight.get(temp));
	     
	     if (temp.left != null) {
		nodeDeque.addFirst(temp.left);
		nodeHeight.put(temp.left, nodeHeight.get(temp) + 1);
	     }
	     if (temp.right != null) {
		nodeDeque.addFirst(temp.right);
		nodeHeight.put(temp.right, nodeHeight.get(temp) + 1);
	     }
	}
	
     }
     
     
     public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(6);
	root.right.left = new TreeNode(7);
	root.right.right = new TreeNode(8);
	depthFirstSearch(root);
     }
     
}
