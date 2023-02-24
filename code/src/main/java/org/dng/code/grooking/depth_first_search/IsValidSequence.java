package org.dng.code.grooking.depth_first_search;

import org.dng.code.utils.TreeNode;

public class IsValidSequence {
public boolean preOrder(TreeNode treeNode, int index, int[] arr) {
	if (treeNode == null) return false;
	
	if (index == arr.length || arr[index] != treeNode.val) return false;
	
	if (treeNode.left == null && treeNode.right == null && index == arr.length - 1) return true;
	
	return preOrder(treeNode.right, index + 1, arr) || preOrder(treeNode.left, index + 1, arr);
}


public boolean isValidSequence(TreeNode root, int[] arr) {
	return preOrder(root, 0, arr);
}

}
