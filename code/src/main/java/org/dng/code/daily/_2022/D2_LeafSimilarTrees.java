package org.dng.code.daily._2022;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class D2_LeafSimilarTrees {
     
     /*
     	Consider all the leaves of a binary tree, from left to right order,
     	the values of those leaves form a leaf value sequence.
	For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
	
	Two binary trees are considered leaf-similar if their leaf value sequence is the same.
	
	Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
	
	Input: root1 = [3,5,1,6,2,9,8,null,null,7,4],
	root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
	Output: true
	
	Link: https://leetcode.com/problems/leaf-similar-trees/description/
      */
     
     public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	List<Integer> list1 = new ArrayList<>();
	getLeafs(root1, list1);
 
	List<Integer> list2 = new ArrayList<>();
	getLeafs(root2, list2);
	
	if (list1.size() != list2.size()) return false;
	
	for (int i = 0; i < list1.size(); i++) {
	     if (!list1.get(i).equals(list2.get(i))) return false;
	}
	return true;
     }
     
     public void getLeafs(TreeNode root, List<Integer> list) {
	if (root == null) return;
	if (root.left == null && root.right == null) list.add(root.val);
	getLeafs(root.left, list);
	getLeafs(root.right, list);
     }
     
     public static void main(String[] args) {
	TreeNode root_2 = new TreeNode(1);
	root_2.right = new TreeNode(2);
	root_2.right.left = new TreeNode(5);
	root_2.right.right = new TreeNode(4);
	root_2.left = new TreeNode(3);
	
	List<Integer> list = new ArrayList<>();
	D2_LeafSimilarTrees trees = new D2_LeafSimilarTrees();
	trees.getLeafs(root_2, list);
	System.out.println(list);
     }
     
}
