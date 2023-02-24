package org.dng.code.grooking.breath_first_search;

import org.dng.code.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RightSideView {
     
     /*
	Given the root of a binary tree, imagine yourself standing on the right side of it,
	return the values of the nodes you can see ordered from top to bottom.
      */

public List<Integer> rightSideView(TreeNode root) {
	if (root == null) return new ArrayList<>();
	List<List<TreeNode>> levels = new ArrayList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();
	int level = 0;
	queue.add(root);
	
	while (!queue.isEmpty()) {
		if (level == levels.size()) levels.add(new ArrayList<>());
		
		int levelLen = queue.size();
		for (int i = 0; i < levelLen; i++) {
			TreeNode temp = queue.remove();
			levels.get(level).add(temp);
			if (temp.left != null) queue.add(temp.left);
			if (temp.right != null) queue.add(temp.right);
		}
		level++;
	}
	return levels.stream()
				   .map(levelList -> levelList.get(levelList.size() - 1).val)
				   .collect(Collectors.toList());
}
}
