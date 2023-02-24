package org.dng.code.grooking.slow_fast_pointer;

import org.dng.code.utils.ListNode;
import org.dng.code.utils.ListUtils;

public class RemoveNthNode {

public static void main(String[] args) {
	RemoveNthNode node = new RemoveNthNode();
	ListNode list = ListUtils.buildList(new int[]{1, 2});
	ListNode head = node.removeNthFromEnd(list, 2);
	ListUtils.print(head);
}

public ListNode removeNthFromEnd(ListNode head, int n) {
	if (head == null) return null;
	
	ListNode offSet = head;
	int i = 0;
	while (i < n - 1) {
		i++;
		offSet = offSet.next;
	}
	
	ListNode del = head;
	while (offSet.next != null) {
		del = del.next;
		offSet = offSet.next;
	}
	
	ListNode run = head;
	ListNode prev = null;
	
	if (run.equals(del)) {
		return run.next;
	}
	
	while (run.next != null) {
		if (run.next.equals(del)) {
			run.next = run.next.next;
		} else {
			run = run.next;
		}
	}
	return head;
}

}
