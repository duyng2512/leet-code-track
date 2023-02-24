package org.dng.code.grooking.depth_first_search;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumWithTarget {
     
     /*
     	Given the root of a binary tree and an integer targetSum,
     	return true if the tree has a root-to-leaf path such that
     	adding up all the values along the path equals targetSum.

	A leaf is a node with no children.
	
	Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
	Output: true
	Explanation: The root-to-leaf path with the target sum is shown.
	
      */

public static void main(String[] args) {

}

public void preOrderSum(TreeNode root, List<Integer> pathNode, List<List<Integer>> pathNodes) {
	if (root == null) return;
	pathNode.add(root.val);
	// We go to the end of the leaf
	if (root.left == null && root.right == null) {
		pathNodes.add(new ArrayList<>(pathNode));
	} else {
		preOrderSum(root.left, pathNode, pathNodes);
		preOrderSum(root.right, pathNode, pathNodes);
	}
	// Remove last path ? If we don't remove them, the pathNode keep raising the whole tree
	pathNode.remove(pathNode.size() - 1);
}

public boolean hasPathSum(TreeNode root, int targetSum) {
	List<Integer> pathNode = new ArrayList<>();
	List<List<Integer>> pathNodes = new ArrayList<>();
	preOrderSum(root, pathNode, pathNodes);
	return pathNodes.stream().anyMatch(l -> l.parallelStream().reduce(0, Integer::sum) == targetSum);
}

}
