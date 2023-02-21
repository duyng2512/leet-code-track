package org.dng.code.by_tag.tree;

import org.dng.code.utils.TreeNode;

public class MaxDepth {
     
     /**
      * 0
      * 1   2
      */
     
     public int maxDepth(TreeNode root) {
	if (root == null) {
	     return 0;
	}
	int left = maxDepth(root.left);
	int right = maxDepth(root.right);
	return Math.max(left, right) + 1;
     }
     
}
