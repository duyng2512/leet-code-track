package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

public class InOrderSuccessor {
     
     /*
     
     	A bit to clarify
     
     		5
     	        4    7
     	         3  6  8
	Pre Order:   5 4 3 7 6 8
	In Order:    4 3 5 6 7 8
	Post Order:  3 4 5 6 8 5
     
      */


private TreeNode previous;
private TreeNode inorderSuccessorNode;

public TreeNode inorderSuccessor(TreeNode root, TreeNode target) {
	
	// First case when target have a right node
	// We simply cursive to get the left most mode
	if (target.right != null) {
		TreeNode node = target.right;
		while (node.left != null) {
			node = node.left;
		}
		inorderSuccessorNode = node;
	} else {
		// Second case when target does not have a right node
		// This is trickier to handle than the first case. In this case, one of the ancestors acts as the inorder successor.
		// That ancestor can be the immediate parent, or, it can be one of the ancestors further up the tree.
		inorderCase2(root, target);
	}
	return inorderSuccessorNode;
}

private void inorderCase2(TreeNode node, TreeNode target) {
	if (node == null) return;
	inorderCase2(node.left, target);
	if (previous == target && inorderSuccessorNode == null) {
		inorderSuccessorNode = node;
		return;
	}
	previous = node;
	inorderCase2(node.right, target);
}
}
