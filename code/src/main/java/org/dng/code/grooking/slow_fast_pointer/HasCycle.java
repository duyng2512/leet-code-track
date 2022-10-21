package org.dng.code.grooking.slow_fast_pointer;

import org.dng.code.grooking.slow_fast_pointer.common.ListNode;

public class HasCycle {
     
     public boolean hasCycle(ListNode head) {
	if (head == null || head.next == null) {
	     return false;
	}
	
	ListNode slow = head;
	ListNode fast = head.next;
	
	while (slow != fast) {
	     if (fast == null || fast.next == null) return false;
	     slow = slow.next;
	     fast = fast.next.next;
	}
	return true;
     }
}
