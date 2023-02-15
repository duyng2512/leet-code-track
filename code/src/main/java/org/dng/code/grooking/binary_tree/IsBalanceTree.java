package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

public class IsBalanceTree {
     
     /*
     	A balance tree a tree that in every node,
     	left height and right height can not larger than 1
      */
     
     int height(TreeNode root) {
	if (root == null) return 0;
	
	int leftHeight = height(root.left);
	int rightHeight = height(root.right);
	
	return Math.max(leftHeight, rightHeight) + 1;
     }
     
     public boolean preOrder(TreeNode treeNode) {
	if (treeNode == null) return true;
 
	if (Math.abs(height(treeNode.right) - height(treeNode.left)) > 1) return false;
 
	return preOrder(treeNode.left) && preOrder(treeNode.right);
     }
     
     public boolean isBalanced(TreeNode root) {
	return preOrder(root);
     }
     
     // Alternative
     public boolean isBalanceBottomUp(TreeNode root) {
	return getHeights(root) != -1;
     }
     
     public int getHeights(TreeNode root) {
	
	if (root == null) {
	     return 0;
	}
	
	int leftHeight = getHeights(root.left);
	int rightHeight = getHeights(root.right);
	
	// Edge case
	if (leftHeight == -1 || rightHeight == -1 || Math.abs(rightHeight - leftHeight) > 1) return -1;
	
	// Normal case
	return Math.abs(rightHeight - leftHeight) + 1;
     }
     
}
