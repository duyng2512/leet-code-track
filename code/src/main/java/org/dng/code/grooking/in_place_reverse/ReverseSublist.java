package org.dng.code.grooking.in_place_reverse;

import lombok.Builder;
import org.dng.code.utils.ListNode;
import org.dng.code.utils.ListUtils;

@Builder
public class ReverseSublist {
     
     /*
     	Given the head of a LinkedList and two positions ‘p’ and ‘q’,
     	reverse the LinkedList from position ‘p’ to ‘q’.
     	
     	Input: head = [1,2,3,4,5], left = 2, right = 4
     	-> 2 -> 3 -> 4
     	2 <- 3 <- 4
	Output: [1,4,3,2,5]
	Example 2:
	
	Input: head = [5], left = 1, right = 1
	Output: [5]
      */

public static void main(String[] args) {
	System.out.println("-------");
	ListNode head = ListUtils.buildList(new int[]{1, 2, 3, 4, 5});
	ListNode result = ReverseSublist.builder().build().reverseBetween(head, 2, 3);
	ListUtils.print(result);
}

public ListNode reverseBetween(ListNode head, int left, int right) {
	if (head == null || head.next == null) return head;
	
	ListNode prev = null;
	ListNode cur = head;
	while (left > 1) {
		prev = cur;
		cur = cur.next;
		left--;
		right--;
	}
	// Anchor the end and the start
	ListNode con = prev;
	ListNode tail = cur;
	
	while (right > 0) {
		ListNode temp = cur.next;
		cur.next = prev;
		prev = cur;
		cur = temp;
		right--;
	}
	
	if (con != null) con.next = prev;
	else head = prev;
	tail.next = cur;
	return head;
}

}
