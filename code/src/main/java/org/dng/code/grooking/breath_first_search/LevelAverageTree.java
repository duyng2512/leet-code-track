package org.dng.code.grooking.breath_first_search;


import lombok.Builder;
import org.dng.code.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Builder
public class LevelAverageTree {
     
     public List<Double> averageOfLevels(TreeNode root) {
	if (root == null) return new ArrayList<>();
 
	Queue<TreeNode> queue = new ArrayDeque<>();
	List<Double> average = new ArrayList<>();
	queue.add(root);
	
	while (!queue.isEmpty()) {
	     double total = 0;
	     int levelLength = queue.size();
	     for (int i = 0; i < levelLength; i++) {
		TreeNode remove = queue.remove();
		total += remove.val;
		if (remove.left != null) queue.add(remove.left);
		if (remove.right != null) queue.add(remove.right);
	     }
	     average.add(total / levelLength);
	}
	return average;
     }
     
     public static void main(String[] args) {
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9);
	root.right = new TreeNode(20);
	root.right.left = new TreeNode(15);
	root.right.right = new TreeNode(7);
 
	System.out.println(LevelAverageTree.builder().build().averageOfLevels(root));
     }
     
}
