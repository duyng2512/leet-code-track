package org.dng.code.grooking.k_way_merge;

import org.dng.code.utils.ListNode;

import java.util.*;

public class MergeKSortedLists {
     
     public ListNode mergeKListsAns(ListNode[] lists) {
          Comparator<ListNode> cmp = Comparator.comparingInt(o -> o.val);
          
          Queue<ListNode> queue = new PriorityQueue<>(cmp);
          for(ListNode l : lists){
               if(l!=null){
                    queue.add(l);
               }
          }
          ListNode head = new ListNode(0);
          ListNode point = head;
          while(!queue.isEmpty()){
               point.next = queue.poll();
               point = point.next;
               ListNode next = point.next;
               if(next!=null){
                    queue.add(next);
               }
          }
          return head.next;
     }
     
     public static ListNode mergeKLists(ListNode[] lists) {
          if (lists.length == 0) return null;
          if (lists[0] == null && lists.length == 1) return null;
          
          Comparator<ListNode> comparator = Comparator.comparingInt(o -> o.val);
          
          PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
     
          for(ListNode l : lists){
               if(l!=null){
                    queue.add(l);
               }
          }
     
     
          ListNode head = new ListNode(0);
          ListNode point = head;
          while(!queue.isEmpty()){
               point.next = queue.poll();
               point = point.next;
               ListNode next = point.next;
               if(next!=null){
                    queue.add(next);
               }
          }
          return head.next;
     }
     
     public static void main(String[] args) {
     
     
     
     }
     
}
