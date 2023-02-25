package org.dng.code.by_tag.tree;

import org.dng.code.utils.TreeNode;

public class BinaryTreeMaximumPathSum {

/**
 * @desc: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

int maxSum;

public static void main(String[] args) {
	
	TreeNode r = new TreeNode(-10);
	r.left = new TreeNode(9);
	r.right = new TreeNode(20);
	r.right.left = new TreeNode(15);
	r.right.right = new TreeNode(7);
	
	BinaryTreeMaximumPathSum m = new BinaryTreeMaximumPathSum();
	System.out.println(m.maxPathSum(r));
}

public int order(TreeNode root) {
	if (root == null) return 0;
	int right = Math.max(order(root.right), 0);
	int left = Math.max(order(root.left), 0);
	maxSum = Math.max(maxSum, left + right + root.val);
	return Math.max(root.val + left, root.val + right);
}

public int maxPathSum(TreeNode root) {
	maxSum = Integer.MIN_VALUE;
	order(root);
	return maxSum;
}
}
