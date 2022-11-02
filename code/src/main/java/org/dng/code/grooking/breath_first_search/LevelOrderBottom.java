package org.dng.code.grooking.breath_first_search;

import org.dng.code.utils.TreeNode;

import java.util.*;

public class LevelOrderBottom {
     
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
	if (root == null) return new ArrayList<>();
	
	List<List<Integer>> levels = new ArrayList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();
	int level = 0;
	queue.add(root);
	
	while (!queue.isEmpty()) {
	     levels.add(new ArrayList<>());
	     int levelLength = queue.size();
	     
	     for (int i = 0; i < levelLength; i++) {
		TreeNode removeNode = queue.remove();
		levels.get(level).add(removeNode.val);
		if(removeNode.left != null) queue.add(removeNode.left);
		if(removeNode.right != null) queue.add(removeNode.right);
		
	     }
	     level++;
	}
	Collections.reverse(levels);
	return levels;
     }
     
     public void helper(List<List<Integer>> levels, int level, TreeNode root) {
	if (levels.size() == level)
	     levels.add(new ArrayList<>());
	levels.get(level).add(root.val);
	if (root.left != null) helper(levels, level + 1, root.left);
	if (root.right != null) helper(levels, level + 1, root.right);
	
     }
     
     public List<List<Integer>> levelOrderBottomV2(TreeNode root) {
	if (root == null) return new ArrayList<>();
	List<List<Integer>> levels = new ArrayList<>();
	helper(levels, 0, root);
	Collections.reverse(levels);
	return levels;
     }

}
