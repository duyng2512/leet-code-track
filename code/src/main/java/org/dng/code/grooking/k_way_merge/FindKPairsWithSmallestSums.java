package org.dng.code.grooking.k_way_merge;

import java.util.*;

public class FindKPairsWithSmallestSums {
     
     /*
	You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 
	Define a pair (u, v) which consists of one element from the first array and one element from the second array.
	
	Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
	
	
	
	Example 1:
	
	Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
	Output: [[1,2],[1,4],[1,6]]
	Explanation: The first 3 pairs are returned from the sequence:
	[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	Example 2:
	
	Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
	Output: [[1,1],[1,1]]
	Explanation: The first 2 pairs are returned from the sequence:
	[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	Example 3:
	
	Input: nums1 = [1,2], nums2 = [3], k = 3
	Output: [[1,3],[2,3]]
	Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
      */
     
     public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
          PriorityQueue<List<Integer>> que = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
          List<List<Integer>> res = new ArrayList<>();
          
          if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
          
          for (int i = 0; i < nums1.length && i < k; i++) que.offer(Arrays.asList(nums1[i], nums2[0], 0));
          
          while (k-- > 0 && !que.isEmpty()) {
               List<Integer> cur = que.poll();
               res.add(Arrays.asList(cur.get(0), cur.get(1)));
               if (cur.get(2) == nums2.length - 1) continue;
               que.offer(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1));
          }
          return res;
     }
     
     public static void main(String[] args) {
          System.out.println(kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6},3));
          // [[1, 6], [1, 4], [1, 2]]
          System.out.println(kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3},2));
          // [[1, 1], [1, 1]]
          
     }
     
}
