package org.dng.code.daily._2022;

import org.dng.code.utils.TreeNode;

public class D5_BinaryTreeMaximumPathSum {

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
	
	D5_BinaryTreeMaximumPathSum m = new D5_BinaryTreeMaximumPathSum();
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
