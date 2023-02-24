package org.dng.code.grooking.depth_first_search;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNumbers {
     
     /*
     
          You are given the root of a binary tree containing digits from 0 to 9 only.

          Each root-to-leaf path in the tree represents a number.
          
          For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
          Return the total sum of all root-to-leaf numbers. Test cases are generated
          so that the answer will fit in a 32-bit integer.
          
          A leaf node is a node with no children.
          
          Input: root = [1,2,3]
          Output: 25
          Explanation:
          The root-to-leaf path 1->2 represents the number 12.
          The root-to-leaf path 1->3 represents the number 13.
          Therefore, sum = 12 + 13 = 25.
          
      */


Integer result = 0;

void preOrder(TreeNode root, List<Integer> pathNode) {
	if (root == null) return;
	
	pathNode.add(root.val);
	
	if (root.right == null && root.left == null) {
		StringBuilder s = new StringBuilder();
		for (Integer val : pathNode)
			s.append(val);
		result += Integer.parseInt(s.toString());
	} else {
		preOrder(root.right, pathNode);
		preOrder(root.left, pathNode);
	}
	pathNode.remove(pathNode.size() - 1);
}


public int sumNumbers(TreeNode root) {
	preOrder(root, new ArrayList<>());
	return result;
}

}
