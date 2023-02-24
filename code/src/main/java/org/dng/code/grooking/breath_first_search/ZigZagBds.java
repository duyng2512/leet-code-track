package org.dng.code.grooking.breath_first_search;

import org.dng.code.utils.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	List<List<Integer>> result = new LinkedList<List<Integer>>();
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	
	if (root == null) return result;
	q.offer(root);
	int curLevel = 0;
	
	while (!q.isEmpty()) {
		List<Integer> innerList = new LinkedList<>();
		int curSize = q.size();
		for (int i = 0; i < curSize; i++) {
			TreeNode curNode = q.poll();
			if (curNode.left != null) q.offer(curNode.left);
			if (curNode.right != null) q.offer(curNode.right);
			innerList.add(curNode.val);
		}
		
		curLevel++;
		if (curLevel % 2 == 0) {
			Collections.reverse(innerList);
		}
		result.add(innerList);
	}
	return result;
}
}
