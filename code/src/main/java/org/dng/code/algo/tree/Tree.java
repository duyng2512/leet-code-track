package org.dng.code.algo.tree;

import lombok.Builder;

@Builder
public class Tree {
public static void main(String[] args) {
	Tree tree = Tree.builder().build();
	Node root = tree.constructTreeFromArr(new int[]{1, 2, 3}, 0);
	root = tree.addNode(5, root);
	tree.inOrderLevel(root);
}

public Node constructTreeFromArr(int[] arr, int i) {
	Node root = null;
	// If base case for recursion
	if (i < arr.length) {
		root = new Node(arr[i]);
		root.left = constructTreeFromArr(arr, 2 * i + 1);
		root.right = constructTreeFromArr(arr, 2 * i + 2);
	}
	return root;
}

public void inOrderLevel(Node root) {
	if (root == null) return;
	inOrderLevel(root.left);
	System.out.println("Data : " + root.data);
	inOrderLevel(root.right);
}

public Node addNode(int data, Node root) {
	if (root == null) return new Node(data);
	Node currentNode = root;
	Node parentNode = root;
	
	while (currentNode != null) {
		parentNode = currentNode;
		if (data > currentNode.data) {
			currentNode = currentNode.right;
		} else {
			currentNode = currentNode.left;
		}
	}
	if (data > parentNode.data) parentNode.right = new Node(data);
	else parentNode.left = new Node(data);
	return root;
}
}
