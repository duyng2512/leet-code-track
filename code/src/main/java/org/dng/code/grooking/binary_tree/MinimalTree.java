package org.dng.code.grooking.binary_tree;

import org.dng.code.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MinimalTree {
     
     /*
     
     	Given an integer array nums where the elements are sorted in ascending order,
     	convert it to a height-balanced binary search tree.

	Input: nums = [-10,-3,0,5,9]
	Output: [0,-3,9,-10,null,5]
	Explanation: [0,-10,5,null,-3,null,9] is also accepted:

      */
     
     /*
     	Intuitive:
     	
     	Get the middle one, add to node
     	
     	Get the first half add to node left
     	Get the second half add to node right
     
      */
     
     public TreeNode merge(int[] nums) {
	if (nums.length == 0) return null;
	
	int middle = nums.length/2;
	TreeNode node = new TreeNode(nums[middle]);
	node.left = merge(Arrays.copyOfRange(nums, 0, middle));
	node.right = merge(Arrays.copyOfRange(nums, middle + 1, nums.length));
 
	return node;
     }
     
     public TreeNode sortedArrayToBST(int[] nums) {
	return merge(nums);
     }
     
     public static void main(String[] args) {
	List<Integer> myList = new ArrayList<>();
	myList.add(1);
	myList.add(2);
	myList.add(3);
	
	ListIterator<Integer> iter = myList.listIterator();
	
	while (iter.hasNext()) {
	     if (3 == iter.next()) {
		iter.remove();
	     }
	}
     }
}
