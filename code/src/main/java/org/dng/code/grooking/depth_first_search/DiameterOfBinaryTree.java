package org.dng.code.grooking.depth_first_search;

import org.dng.code.utils.TreeNode;

public class DiameterOfBinaryTree {
     
     /*
    	Given the root of a binary tree, return the length of the diameter of the tree.

	The diameter of a binary tree is the length of the longest path between any two
	nodes in a tree. This path may or may not pass through the root.
	
	The length of a path between two nodes is represented by the number of edges between
	them.
      */
     
     /*
     	Intuition:
     	
     	At every node, we maintain left height and right height
     	Diameter will be the largest left_height + right_height
     	
     	   1
     	 2  3
     	4 5
     	 6
     	
      */

Integer di = 0;

public int preOrderSum(TreeNode root) {
	if (root == null) return 0;
	
	int leftHeight = preOrderSum(root.left);
	int rightHeight = preOrderSum(root.right);
	
	di = Math.max(leftHeight + rightHeight, di);
	
	return Math.max(leftHeight, rightHeight) + 1;
}

public int diameterOfBinaryTree(TreeNode root) {
	preOrderSum(root);
	return di;
	
}

}
