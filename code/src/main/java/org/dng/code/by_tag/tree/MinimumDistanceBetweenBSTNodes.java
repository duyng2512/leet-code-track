package org.dng.code.by_tag.tree;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
     
     /**
      * 1
      * 2 3
      */
     List<Integer> array = new ArrayList<>();
     
     public void traversal(TreeNode treeNode) {
	if (treeNode == null) {
	     return;
	}
	
	traversal(treeNode.left);
	
	array.add(treeNode.val);
	
	traversal(treeNode.right);
     }
     
     public int minDiffInBST(TreeNode root) {
	traversal(root);
	int min = Integer.MAX_VALUE;
	
	
	for (int i = 1; i < array.size(); i++) {
	     min = Math.min(min, array.get(i) - array.get(i - 1));
	}
	
	return min;
     }
     
}
