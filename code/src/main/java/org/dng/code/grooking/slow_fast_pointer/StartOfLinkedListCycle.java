package org.dng.code.grooking.slow_fast_pointer;

import lombok.Builder;
import org.dng.code.utils.ListNode;

@Builder
public class StartOfLinkedListCycle {
     /*
     	Given the head of a linked list, return the node where the cycle begins.
     	If there is no cycle, return null.

	Input: head = [3,2,0,-4], pos = 1
	Output: tail connects to node index 1
	Explanation: There is a cycle in the linked list, where tail connects
	to the second node.
	
      */
     public ListNode detectCycle(ListNode head) {
	if (head == null || head.next == null) return null;
	
	ListNode slow = head;
	ListNode fast = head;
	
	while (fast != null && fast.next != null) {
	     fast = fast.next.next;
	     slow = slow.next;
	     if (slow.equals(fast)) break;
	     // Find the insertion
	}
	if (fast == null || fast.next == null) return null;

	ListNode start = head;
	while (true) {
	     if (start.equals(fast)) return start;
	     start = start.next;
	     fast = fast.next;
	}
     }
     
     public static void main(String[] args) {
	
     }

}
