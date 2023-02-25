package org.dng.code.by_tag.tree;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSplittedBinaryTree {

	/*
	Given the root of a binary tree, split the binary tree into two subtrees
	by removing one edge such that the product of the sums of the subtrees is
	maximized.
	
		Return the maximum product of the sums of the two subtrees. Since the answer
		 may be too large, return it modulo 109 + 7.
	
		Note that you need to maximize the answer before taking the mod and not after
		taking it.
	
	*/

	private final List<Long> allSums = new ArrayList<>();
	
	/**
	 * 					1
	 * 						2
	 *					3		4
	 *						5		6
	 */
	public static void main(String[] args) {
		TreeNode root_2 = new TreeNode(1);
		root_2.right = new TreeNode(2);
		root_2.right.left = new TreeNode(3);
		root_2.right.right = new TreeNode(4);
		root_2.right.right.right = new TreeNode(6);
		root_2.right.right.left = new TreeNode(5);
	}
	
	public long total(TreeNode node) {
		if (node == null) return 0;
		long left = total(node.left);
		long right = total(node.right);
		long result = node.val + left + right;
		allSums.add(result);
		return result;
	}
	
	public int maxProduct(TreeNode root) {
		long total = total(root); // Find total of all root
		long best = 0;
		for (long sum : allSums) {
			best = Math.max(best, sum * (total - sum));
		}
		return (int) (best % 1000000007);
	}
}
