package org.dng.code.grooking.breath_first_search;

import org.dng.code.utils.TreeNode;

import java.util.*;

public class ZigZagBds {
     
     /*
     if (root == null) return new ArrayList<>();
	List<List<Integer>> results = new ArrayList<>();
	LinkedList<TreeNode> queue = new LinkedList<>();
	queue.addLast(root);
	queue.addLast(null);
	
	LinkedList<Integer> levelList = new LinkedList<>();
	boolean isOrderLeft = true;
	
	while (queue.size() > 0) {
	     TreeNode currNode = queue.pollFirst();
	     if (currNode != null) {
		if (isOrderLeft)
		     levelList.addLast(currNode.val);
		else
		     levelList.addFirst(currNode.val);
		
		if (currNode.left != null)
		     queue.addLast(currNode.left);
		if (currNode.right != null)
		     queue.addLast(currNode.right);
	     } else {
		results.add(new LinkedList<>());
		if (queue.size() > 0) queue.addLast(null);
		isOrderLeft = !isOrderLeft;
	     }
	}
	return results;
      */
     
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	if (root == null) return new ArrayList<>();
 
	List<List<Integer>> levels = new ArrayList<>();
	LinkedList<TreeNode> deque = new LinkedList<>();
	int level = 0;
	boolean reverse = false;
	
	deque.add(root);
	
	while (!deque.isEmpty()) {
	     levels.add(new ArrayList<>());
	     int levelLen = deque.size();
	     for (int i = 0; i < levelLen; i++) {
	     
		TreeNode remove = deque.removeLast();
		levels.get(level).add(remove.val);
	 
		if (remove.left != null) deque.add(remove.left);
		if (remove.right != null) deque.add(remove.right);
	     }
	     
	     if (reverse) {
		levelLen = deque.size();
		for (int i = 0; i < levelLen; i++) {
		     TreeNode remove = deque.removeLast();
		     deque.addFirst(remove);
		}
	     }
	     
	     reverse = !reverse;
	     level++;
	}
	return levels;
     }
}
