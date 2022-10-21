package org.dng.code.grooking.slow_fast_pointer;

import org.dng.code.grooking.slow_fast_pointer.common.ListNode;
import org.dng.code.grooking.slow_fast_pointer.common.ListUtils;

public class RearrangeLinkedList {
     
     /*
          Problem Challenge 2
     
          Rearrange a LinkedList (medium)
          
          Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes
          from the second half of the LinkedList are inserted alternately to the nodes from the first half in
          reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should
          return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
          
          1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
          1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
          
          Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
          
          Example 1:
          
          Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
          Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
          
          Example 2:
          
          Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
          Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
      */
     
     public void reorderList(ListNode head) {
          if (head == null)
               return;
     
          if (head.next == null)
               return;
          
          
          ListNode slow = head;
          ListNode fast = head;
          
          while (fast != null && fast.next != null) {
               slow = slow.next;
               fast = fast.next.next;
          }
          
          if (fast != null) slow = slow.next;
          
          ListNode reverse = ListUtils.reverseList(slow);
          ListNode start = head;
     
          // Find the second last node
          ListNode second_last = head;
          while (second_last.next.next != null)
               second_last = second_last.next;
     
          // Change next of second last
          second_last.next = null;
          
          while (start != null && reverse != null) {
               ListNode nextStart = start.next;
               ListNode insertNode = new ListNode(reverse.val);
               insertNode.next = nextStart;
               start.next = insertNode;
               start = nextStart;
               reverse = reverse.next;
          }
          ListUtils.print(head);
     }
     
     public static void main(String[] args) {
          RearrangeLinkedList list = new RearrangeLinkedList();
	ListNode node = ListUtils.buildList(new int[] {1, 2, 4, 5});
          list.reorderList(node);
          System.out.println("------------------");
          node = ListUtils.buildList(new int[] {1, 2, 3, 4});
          list.reorderList(node);
          System.out.println("------------------");
          node = ListUtils.buildList(new int[] {1, 2, 3, 4, 5});
          list.reorderList(node);
     }
     
}
