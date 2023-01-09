package org.dng.code.grooking.array;

import java.util.PriorityQueue;

public class FindNLargestNumber {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        
        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
              heap.poll();
          }
  
          // output
          return heap.poll();  
    }
}
