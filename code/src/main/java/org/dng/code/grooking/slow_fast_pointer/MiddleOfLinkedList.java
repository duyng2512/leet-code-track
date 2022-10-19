package org.dng.code.grooking.slow_fast_pointer;

public class MiddleOfLinkedList {
     
     /**
      * Problem Statement
      * Given the head of a Singly LinkedList, write a
      * method to return the middle node of the LinkedList.
      * <p>
      * If the total number of nodes in the LinkedList
      * is even, return the second middle node.
      * <p>
      * Example 1:
      * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
      * Output: 3
      * <p>
      * Example 2:
      * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
      * Output: 4
      * <p>
      * Example 3:
      * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
      * Output: 4
      */
     
     public static class ListNode {
	int val;
	ListNode next;
	
	ListNode() {
	}
	
	ListNode(int val) {
	     this.val = val;
	}
	
	ListNode(int val, ListNode next) {
	     this.val = val;
	     this.next = next;
	}
     }
     
     public ListNode middleNode(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;
 
	while (fast != null && fast.next != null) {
	     fast = fast.next.next;
	     slow = slow.next;
	}
	return slow;
     }
     
}
