package org.dng.code.grooking.pattern_two_heap;

import java.util.*;

public class SlidingWindowMedian {
     PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
     PriorityQueue<Integer> large = new PriorityQueue<>();
     
     public void add(int data){
          if (small.isEmpty()){
               small.add(data);
          } else if (small.peek() < data) {
               small.add(data);
          } else {
               large.add(data);
          }

     }
     
     private void reBalance() {
          if (small.size() - large.size() > 1) {
               large.offer(small.poll());
          } else if (large.size() - small.size() > 1) {
               small.offer(large.poll());
          }
     }
     
     public double median() {
          if (small.size() == large.size())
               return (small.peek() + large.peek()) / 2.0;
          else
               return small.peek();
     }
     
     public void remove(int data){
          large.remove(data);
          small.remove(data);
          reBalance();
     }
    
     
     public double[] medianSlidingWindow(int[] nums, int k) {
          double[] result = new double[nums.length - k + 1];
          for (int i = 0; i < nums.length; i++) {
               if (i >= k){
                    result[i-k] = median();
                    remove(nums[i-k]);
               }
               add(nums[i]);
          }
          return result;
     }
     
   
     
     public static void main(String[] args) {
          SlidingWindowMedian median = new SlidingWindowMedian();
          double[] res = median.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3 );
          System.out.println(Arrays.toString(res));
     }
}
