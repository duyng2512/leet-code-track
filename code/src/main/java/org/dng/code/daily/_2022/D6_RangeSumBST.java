package org.dng.code.daily._2022;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class D6_RangeSumBST {

public static void main(String[] args) {
	
	TreeNode r = new TreeNode(-10);
	r.left = new TreeNode(9);
	r.right = new TreeNode(20);
	r.right.left = new TreeNode(15);
	r.right.right = new TreeNode(7);
	
	
}

/**
 * @desc: https://leetcode.com/problems/range-sum-of-bst/description/
 */

public void order(TreeNode root, int low, int high, List<Integer> list) {
	if (root == null) return;
	if (root.val <= high && root.val >= low) list.add(root.val);
	order(root.left, low, high, list);
	order(root.right, low, high, list);
}

public int rangeSumBST(TreeNode root, int low, int high) {
	List<Integer> list = new ArrayList<>();
	order(root, low, high, list);
	return list.stream().mapToInt(s -> s).sum();
}
}
