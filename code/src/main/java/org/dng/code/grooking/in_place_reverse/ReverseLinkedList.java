package org.dng.code.grooking.in_place_reverse;

import org.dng.code.utils.ListNode;

public class ReverseLinkedList {

public static void main(String[] args) {

}

public ListNode reverseList(ListNode head) {
	if (head.next == null) return head;
	ListNode prev = null;
	ListNode cur = head;
	while (cur != null) {
		ListNode temp = cur.next;
		cur.next = prev;
		prev = cur;
		cur = temp;
	}
	return prev;
	
	// After reverse a linked list
	// prev is the start of new list
	// cur is the null
	
}
}
