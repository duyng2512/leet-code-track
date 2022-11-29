package org.dng.code.grooking.top_k_elements;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
     
     /*
     	Given an integer array nums and an integer k,
     	return the k most frequent elements. You may
     	return the answer in any order.
      */
     
     
     public static int[] topKFrequent(int[] nums, int k) {
          Map<Integer, Integer> map = new HashMap<>();
     
          for (int num : nums)
               map.put(num, map.getOrDefault(num, 0) + 1);
          
          List<Map.Entry<Integer, Integer>> sort;
          
          Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
     
          sort = map.entrySet()
               .stream()
               .sorted(comparator)
               .collect(Collectors.toList());
          List<Integer> result = new ArrayList<>();
     
          for (int i = 0; i < k; i++) {
               result.add(sort.get(i).getKey());
          }
          
          return result.stream().mapToInt(i -> i).toArray();
     }
     
     public static void main(String[] args) {
          System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
          System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
     }
     
}
