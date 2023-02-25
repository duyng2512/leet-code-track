package org.dng.code.by_tag.linked_list;

import org.dng.code.utils.ListNode;

public class OddEvenLinkedList {

/**
 * @desc: https://leetcode.com/problems/odd-even-linked-list/description/
 */

static public ListNode oddEvenList(ListNode head) {
	if (head == null) return null;
	if (head.next == null || head.next.next == null) return head;
	
	ListNode even = head;
	ListNode odd = head.next;
	ListNode anchor = head.next;
	
	while (odd != null && odd.next != null) {
		ListNode tempEven = even.next.next;
		ListNode tempOdd = odd.next.next;
		even.next = tempEven;
		odd.next = tempOdd;
		even = tempEven;
		odd = tempOdd;
	}
	
	even.next = anchor;
	return head;
}

public static void main(String[] args) {
     
	/*
	 	1 2 3 4 5 6
	 ->	1 3 5 _ 2 4 6
	 */
	
	ListNode node = new ListNode(1);
	node.next = new ListNode(2);
	node.next.next = new ListNode(3);
	node.next.next.next = new ListNode(4);
	node.next.next.next.next = new ListNode(5);
	node.next.next.next.next.next = new ListNode(6);
	
	ListNode transform = oddEvenList(node);
	
	while (transform != null) {
		System.out.println(transform.val);
		transform = transform.next;
	}
	
}
}
