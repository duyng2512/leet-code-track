package org.dng.code.grooking.slow_fast_pointer;

import org.dng.code.utils.ListNode;

public class IntersectionOfTwoLinkedList {

public static void main(String[] args) {

}

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	ListNode run = headA;
	int lenA = 0;
	// Find length of A
	while (run != null) {
		lenA++;
		run = run.next;
	}
	
	run = headB;
	int lenB = 0;
	// Find length of A
	while (run != null) {
		lenB++;
		run = run.next;
	}
	
	int offset = Math.abs(lenA - lenB);
	ListNode runA = headA;
	ListNode runB = headB;
	
	while (offset > 0) {
		offset--;
		if (lenA > lenB) runA = runA.next;
		if (lenB > lenA) runB = runB.next;
	}
	;
	
	while (runA != null && runB != null) {
		if (runA.equals(runB)) return runA;
		runA = runA.next;
		runB = runB.next;
	}
	return null;
}

}
