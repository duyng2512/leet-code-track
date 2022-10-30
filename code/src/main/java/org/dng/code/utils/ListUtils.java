package org.dng.code.utils;

public class ListUtils {
     
     public static ListNode reverseList(ListNode head) {
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
     
     public static ListNode buildList(int[] arr) {
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
}
