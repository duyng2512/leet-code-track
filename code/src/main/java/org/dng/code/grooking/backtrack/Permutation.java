package org.dng.code.grooking.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
     
     /*
          Problem Statement
          Given a set of distinct numbers, find all of its permutations.
          
          Permutation is defined as the re-arranging of the elements of the set.
          For example, {1, 2, 3} has the following six permutations:
          
          {1, 2, 3}
          {1, 3, 2}
          {2, 1, 3}
          {2, 3, 1}
          {3, 1, 2}
          {3, 2, 1}
          If a set has ‘n’ distinct elements it will have n!n! permutations.
          
          Example 1:
          
          Input: [1,3,5]
          Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
      */
     
     
     public static List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> list = new ArrayList<>();
	backtrack(list, new ArrayList<>(), nums);
          return list;
     }
     
     private static void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
          if (tempList.size() == nums.length) {
               ans.add(new ArrayList<>(tempList));
          } else {
               for (int num: nums) {
                    if (tempList.contains(num)) continue;
                    tempList.add(num);
                    backtrack(ans, tempList, nums);
                    tempList.remove(tempList.size()-1);
               }
          }
     }
     
     public static void main(String[] args){
     	int[] arr = new int[] {1, 2, 3};
	System.out.println(permute(arr));
     }
     
}
