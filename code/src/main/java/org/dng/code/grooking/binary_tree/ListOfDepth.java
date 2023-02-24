package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ListOfDepth {

public List<List<Integer>> levelOrder(TreeNode root) {
	if (root == null) return new ArrayList<>();
	
	Queue<TreeNode> queue = new ArrayDeque<>();
	List<List<Integer>> result = new ArrayList<>();
	int level = 0;
	queue.add(root);
	
	while (!queue.isEmpty()) {
		// New Level
		if (level == result.size()) result.add(new ArrayList<>());
		
		int heightLen = queue.size();
		
		for (int i = 0; i < heightLen; i++) {
			TreeNode temp = queue.remove();
			if (temp.left != null) queue.add(temp.left);
			if (temp.right != null) queue.add(temp.right);
			result.get(level).add(temp.val);
		}
		level++;
	}
	return result;
}

}
