package org.dng.code.grooking.breath_first_search;

import org.dng.code.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class MinimumDepth {
     
     /*
	Given a binary tree, find its minimum depth.
	
	The minimum depth is the number of nodes along the shortest
	path from the root node down to the nearest leaf node.
	
	Note: A leaf is a node with no children.
	
	Example 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: 2
	
	Example 2:
	Input: root = [2,null,3,null,4,null,5,null,6]
	Output: 5

      */
     
     public int minDepth(TreeNode root) {
	if (root == null) return 0;
 
	Queue<TreeNode> queue = new ArrayDeque<>();
	queue.add(root);
	int level = 1;
	while (!queue.isEmpty()) {
	     int levelLength = queue.size();
	     for (int i = 0; i < levelLength; i++) {
		TreeNode remove = queue.remove();
		
		if (remove.left == null && remove.right == null)
		     return level;
		
		if (remove.left != null) queue.add(remove.left);
		if (remove.right != null) queue.add(remove.right);
	     }
	     level++;
	}
	return level;
     }
     
}
