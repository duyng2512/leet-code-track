package org.dng.code.grooking.top_k_elements;

import java.util.*;
import java.util.stream.Collectors;

public class LeastNumberUniqueIntegersAfterKRemovals {
     
     /*
          Given an array of integers arr and an integer k.
          Find the least number of unique integers after removing exactly k elements.

          Example 1:
          
          Input: arr = [5,5,4], k = 1
          Output: 1
          Explanation: Remove the single 4, only 5 is left.
          
          
          Example 2:
          Input: arr = [4,3,1,1,3,3,2], k = 3
          Output: 2
          Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
     
          Intuitive:
          
          We want to replace k number with the least frequency
     
      */
     
     public static int findLeastNumOfUniqueInts(int[] arr, int k) {
	Map<Integer, Integer> freq = new HashMap<>();
          for (int num : arr) {
               freq.put(num, freq.getOrDefault(num, 0) + 1);
          };
          
          
          List<Map.Entry<Integer, Integer>> sort =  freq.entrySet()
               .stream()
               .sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toList());
          int remain = k;
          for (Map.Entry<Integer, Integer> entry: sort) {
               if (remain > entry.getValue()) {
                    remain -= entry.getValue();
                    entry.setValue(0);
               } else {
                    entry.setValue(entry.getValue() - remain);
                    break;
               }
          }
          int result = 0;
          for (Map.Entry<Integer, Integer> entry: sort) {
               if (entry.getValue() > 0) {
                    result++;
               }
          }
          return result;
     }
     
     public static void main(String[] args) {
          System.out.println(findLeastNumOfUniqueInts(new int[] {5,5,4}, 1));
          System.out.println(findLeastNumOfUniqueInts(new int[] {4,3,1,1,3,3,2}, 3));
     }
}
