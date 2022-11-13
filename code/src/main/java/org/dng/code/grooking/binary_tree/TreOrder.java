package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

public class TreOrder {
     public static void preOrder(TreeNode root, StringBuilder string) {
	if (root == null) return;
          string.append(root.val).append("->");
          preOrder(root.left, string);
          preOrder(root.right, string);
     }
     
     public static void inOrder(TreeNode root, StringBuilder string) {
          if (root == null) return;
          inOrder(root.left, string);
          string.append(root.val).append("->");
          inOrder(root.right, string);
     }
     
     public static void postOrder(TreeNode root, StringBuilder string) {
          if (root == null) return;
          postOrder(root.left, string);
          postOrder(root.right, string);
          string.append(root.val).append("->");
     }
     
     /*
     	A bit to clarify
     
     		5
     	        4    7
     	         3  6  8
	Pre Order:   5 4 3 7 6 8
	In Order:    4 3 5 6 7 8
	Post Order:  3 4 6 8 7 5
      */
     
     public static void main(String[] args) {
          TreeNode root = new TreeNode(5);
          root.left = new TreeNode(4);
          root.left.right = new TreeNode(3);
          root.right = new TreeNode(7);
          root.right.left = new TreeNode(6);
          root.right.right = new TreeNode(8);
          
          StringBuilder string = new StringBuilder();
          preOrder(root, string);
          System.out.println(string);
     
          string = new StringBuilder();
          inOrder(root, string);
          System.out.println(string);
     
          string = new StringBuilder();
          postOrder(root, string);
          System.out.println(string);
     }
     
}
