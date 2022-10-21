package org.dng.code.grooking.slow_fast_pointer;

import lombok.Builder;
import lombok.ToString;

@Builder
public class PalindromeLinkedList {
     @ToString
     public static class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
	     this.val = val;
	}
	ListNode(int val, ListNode next) {
	     this.val = val;
	     this.next = next;
	}
     }
     
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
	ListNode reverse = reverseList(slow);
          ListNode start = head;
          while (start != null && reverse != null) {
	     if (reverse.val != start.val) return false;
	     reverse = reverse.next;
	     start = start.next;
	}
          return true;
     }
     
     public ListNode reverseList(ListNode head) {
	ListNode prev = null;
	ListNode run = head;
	
	while (run != null) {
	     ListNode temp = run.next;
	     run.next = prev;
	     prev = run;
	     run = temp;
	}
	return prev;
     }
     
     public ListNode buildList(int[] arr) {
	
	ListNode head = new ListNode(arr[0]);
	ListNode run = head;
 
	for (int i = 1; i < arr.length; i++) {
	     ListNode temp = new ListNode(arr[i]);
	     run.next = temp;
	     run = temp;
	}
	return head;
     }
     
     public static void print(ListNode head) {
	while (head != null){
	     System.out.println(head.val);
	     head = head.next;
	}
     }
     
     
     
     public static void main(String[] args) {
	PalindromeLinkedList list = PalindromeLinkedList.builder().build();
	ListNode head = list.buildList(new int[] {1,3,4,4,3,1});
	boolean result = list.isPalindrome(head);
	System.out.println(result);
     }
}
