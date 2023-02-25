package org.dng.code.by_tag.tree;

import org.dng.code.utils.TreeNode;

public class MaximumDiffBetweenNodeAncestor {

/**
 * @desc: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 */

static public int transverse(TreeNode root, int min, int max) {
	if (root == null) return 0;
	
	if (root.val < min) min = root.val;
	if (root.val > max) max = root.val;
	
	int left = transverse(root.left, min, max);
	int right = transverse(root.right, min, max);
	
	return Math.max(left, Math.max(right, max - min));
}

static public int maxAncestorDiff(TreeNode root) {
	if (root == null) return 0;
	return transverse(root, root.val, root.val);
}

public static void main(String[] args) {
	TreeNode r = new TreeNode(8);
	r.left = new TreeNode(3);
	r.left.left = new TreeNode(1);
	r.left.right = new TreeNode(6);
	r.left.right.left = new TreeNode(4);
	r.left.right.right = new TreeNode(7);
	
	r.right = new TreeNode(10);
	r.right.right = new TreeNode(14);
	r.right.right.left = new TreeNode(13);
	
	System.out.println(maxAncestorDiff(r));
}
}
