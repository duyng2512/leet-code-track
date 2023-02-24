package org.dng.code.grooking.linked_list;

import org.dng.code.utils.ListNode;

/**
 * @author duyntc 02/2023
 */
public class SortList {

public ListNode sortList(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}
	ListNode mid = getMid(head);
	ListNode left = sortList(head);
	ListNode right = sortList(mid);
	return merge(left, right);
}

public ListNode merge(ListNode list1, ListNode list2) {
	ListNode head = new ListNode();
	ListNode tail = head;
	
	while (list1 != null && list2 != null) {
		
		if (list1.val < list2.val) {
			tail.next = list1;
			list1 = list1.next;
		} else {
			tail.next = list2;
			list2 = list2.next;
		}
		tail = tail.next;
	}
	
	tail.next = (list1 != null) ? list1 : list2;
	return head.next;
}

public ListNode getMid(ListNode head) {
	ListNode slow = null;
	ListNode fast = head;
	
	while (fast != null && fast.next != null) {
		slow = (slow == null) ? head : slow.next;
		fast = fast.next.next;
	}
	
	assert slow != null;
	ListNode mid = slow.next;
	slow.next = null;
	return mid;
}

}
