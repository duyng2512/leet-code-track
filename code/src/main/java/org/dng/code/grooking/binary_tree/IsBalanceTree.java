package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
     
}
