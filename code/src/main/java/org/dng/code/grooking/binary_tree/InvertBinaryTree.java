package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duyntc 02/2023
 */
public class InvertBinaryTree {
     
     public TreeNode invertTree(TreeNode root) {
	if (root == null) return null;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	
	while (!queue.isEmpty()) {
	     TreeNode currentNode = queue.poll();
	     TreeNode temp = currentNode.right;
	     currentNode.right = currentNode.left;
	     currentNode.left = temp;
	     if (currentNode.left != null) queue.add(currentNode.left);
	     if (currentNode.right != null) queue.add(currentNode.right);
	}
	return root;
     }
     
     /**
      *    1
      *  2  3
      * @param root
      * @return
      */
     
     public TreeNode invertTreeRecursive(TreeNode root) {
	if (root == null) {
	     return null;
	}
	
	TreeNode right = invertTreeRecursive(root.right);
	TreeNode left = invertTreeRecursive(root.left);
	
	root.right = left;
	root.left = right;
	
	return root;
     }
     
}
