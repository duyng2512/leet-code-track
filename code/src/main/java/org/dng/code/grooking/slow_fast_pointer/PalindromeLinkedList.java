package org.dng.code.grooking.slow_fast_pointer;

import lombok.Builder;
import lombok.ToString;
import org.dng.code.grooking.slow_fast_pointer.common.ListNode;
import org.dng.code.grooking.slow_fast_pointer.common.ListUtils;

@Builder
public class PalindromeLinkedList {
     
     public boolean isPalindrome(ListNode head) {
	ListNode slow = head;
          ListNode fast = head;
          
          while (fast != null && fast.next != null) {
               slow = slow.next;
               fast = fast.next.next;
          }
          if (fast != null) {
               slow = slow.next;
          }
	ListNode reverse = ListUtils.reverseList(slow);
          ListNode start = head;
          while (start != null && reverse != null) {
	     if (reverse.val != start.val) return false;
	     reverse = reverse.next;
	     start = start.next;
	}
          return true;
     }
     
     public static void main(String[] args) {
	PalindromeLinkedList list = PalindromeLinkedList.builder().build();
	ListNode head = ListUtils.buildList(new int[] {1,3,4,4,3,1});
	boolean result = list.isPalindrome(head);
	System.out.println(result);
     }
}
