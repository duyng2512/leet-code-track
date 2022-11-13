package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

import java.util.*;

public class CommonAncestor {
     
     /*
     
     	Intuitive:
     	
     	Build a map between node and its parent
     	
     	From p build a path of ancestor
     	From q check the node that is belonged to set of ancestor
     	
      */
     
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Deque<TreeNode> queue = new ArrayDeque<>();
	
	// Map of node and its ancestor
	Map<TreeNode, TreeNode> map = new HashMap<>();
	queue.push(root);
	map.put(root, null);
	
	while (!map.containsKey(p) || !map.containsKey(q)) {
	     
	     TreeNode temp = queue.poll();
	     
	     if (temp.left != null) {
		map.put(temp.left, temp);
		queue.add(temp.left);
	     }
	     
	     if (temp.right != null) {
		map.put(temp.right, temp);
		queue.add(temp.right);
	     }
	}
	
	Set<TreeNode> ancestor = new HashSet<>();
	
	ancestor.add(p);
	while (p != null) {
	     ancestor.add(p);
	     p = map.get(p);
	}
	
	while (!ancestor.contains(q)) {
	     q = map.get(q);
	}
	return q;
     }
     
}
