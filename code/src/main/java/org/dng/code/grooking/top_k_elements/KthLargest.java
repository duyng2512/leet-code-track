package org.dng.code.grooking.top_k_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
     
     PriorityQueue<Integer> queue = new PriorityQueue<>();
     int k;
     
     public KthLargest(int k, int[] nums) {
          this.k = k;
          for (int num : nums) {
               queue.add(num);
          }
          while (queue.size() > k) {
               queue.poll();
          }
     }
     
     public int add(int val) {
          queue.add(val);
          if (queue.size() > k) {
               queue.poll();
          }
          
          return queue.peek();
     }
     
     public static void main(String[] args) {
          KthLargest largest = new KthLargest(3, new int[] {4, 5, 8, 2});
          System.out.println(largest.add(3));
          System.out.println(largest.add(5));
          System.out.println(largest.add(10));
          System.out.println(largest.add(9));
          System.out.println(largest.add(4));
          // [null, 4, 5, 5, 8, 8]
          
     }
     
}
