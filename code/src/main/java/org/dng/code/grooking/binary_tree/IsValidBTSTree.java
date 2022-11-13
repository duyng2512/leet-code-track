package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

import java.util.*;

public class IsValidBTSTree {
     
     /*
     	Given the root of a binary tree, determine if it is a valid binary search tree (BST).

	A valid BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
      */
     
     /*
     	Intuitive
     	
     	    5
     	  1   7
     	    6   8

	Max null   | min null  | val 5
	Max 5      | min null  | val 1
	Max null   | min 5     | val 7
	Max 7      | min 5     | val 6
	Max null   | min 7     | val 8
      */
     
     public boolean preOrder(TreeNode root, Integer min, Integer max) {
	if (root == null) return true;
	
	if ((max != null && root.val > max )
	||  (min != null && root.val < min))
	    return false;
	System.out.println("Max " + max + " min " + min + " val " + root.val);
	return preOrder(root.left, min, root.val)
	     && preOrder(root.right, root.val, max);
     }
     
     // Iterative approach
     public void update(Deque<TreeNode> queue,
		    Deque<Integer> min,
		    Deque<Integer> max,
		    TreeNode node,
		    Integer minVal,
		    Integer maxVal
     ) {
	
	queue.add(node);
	min.add(minVal);
	max.add(maxVal);
     }
     
     
     public boolean iterative(TreeNode root) {
	Deque<TreeNode> queue = new LinkedList<>();
	Deque<Integer> min = new LinkedList<>();
	Deque<Integer> max = new LinkedList<>();
	update(queue, min, max, root, null, null);
	
	while (!queue.isEmpty()) {
	     Integer minRange = min.poll();
	     Integer maxRange = max.poll();
	     TreeNode node = queue.poll();
	     if (node != null) {
		if (maxRange != null && node.val >= maxRange) return false;
		if (minRange != null && node.val <= minRange) return false;
		update(queue, min, max, node.left, minRange, node.val);
		update(queue, min, max, node.right, node.val, maxRange);
	     }
	     
	}
	return true;
     }
     
     
     public boolean isValidBST(TreeNode root) {
	return preOrder(root, null, null);
     }
     
}
