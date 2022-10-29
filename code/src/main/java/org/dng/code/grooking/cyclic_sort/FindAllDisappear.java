package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class FindAllDisappear {
     
     /*
    	Given an array nums of n integers where nums[i] is in the range [1, n], return an
    	array of all the integers in the range [1, n] that do not appear in nums.

    	Input: nums = [4,3,2,7,8,2,3,1]
	Output: [5,6]
	
	Input: nums = [1,2,4]
	[-1,-2,4]
	Output: [3]
    
    */
     
     // Cyclic sort
     public void cyclicSort(int[] arr) {
          int i = 0;
          while (i < arr.length) {
               int correctPos = arr[i] - 1;
               if (arr[i] != arr[correctPos]) swap(arr, i, correctPos);
               else i++;
          }
     }
     
     static void swap (int[] arr, int index, int correctIdx) {
          int temp  = arr[index];
          arr[index] = arr[correctIdx];
          arr[correctIdx] = temp;
     }
     
     public List<Integer> findDisappearedNumbers(int[] nums) {
          List<Integer> result = new ArrayList<>();
          cyclicSort(nums);
          System.out.println(Arrays.toString(nums));
          for (int i = 0; i < nums.length; i++)
               if (i != nums[i] -1) result.add(i+1);
          return result;
     }
     
     public static void main(String[] args) {
          List<Integer> result = FindAllDisappear.builder().build().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1} );
          System.out.println(result);
     }
}
