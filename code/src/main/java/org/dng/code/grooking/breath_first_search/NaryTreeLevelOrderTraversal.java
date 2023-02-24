package org.dng.code.grooking.breath_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author duyntc 01/2023
 */
public class NaryTreeLevelOrderTraversal {

public static void main(String[] args) {
	
}

public List<List<Integer>> levelOrder(Node root) {
	if (root == null) return new ArrayList<>();
	
	// Prepare BFS
	List<List<Integer>> levels = new ArrayList<>();
	Queue<Node> queue = new ArrayDeque<>();
	queue.add(root);
	int level = 0;
	
	while (!queue.isEmpty()) {
		levels.add(new ArrayList<>());
		int levelLen = queue.size();
		
		for (int i = 0; i < levelLen; i++) {
			Node poll = queue.poll();
			levels.get(level).add(poll.val);
			queue.addAll(poll.children);
		}
		level++;
	}
	
	return levels;
}

static class Node {
	public int val;
	public List<Node> children;
	
	public Node() {
	}
	
	public Node(int _val) {
		val = _val;
	}
	
	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

}
