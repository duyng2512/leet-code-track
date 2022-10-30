package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class FirstMissingPositive {

     /*
          Problem Challenge 2
          Find the Smallest Missing Positive Number (medium)
          
          Given an unsorted array containing numbers, find the smallest missing positive number in it.
          
          Example 1:
          Input: nums = [1,2,0]
          1, 2, 3
          Output: 3
          Explanation: The numbers in the range [1,2] are all in the array.
          
          Example 2:
          Input: nums = [3,4,-1,1]
          1, 3, 4
          Output: 2
          Explanation: 1 is in the array but 2 is missing.
          
          Example 3:
          Input: nums = [7,8,9,11,12]
          Output: 1
          Explanation: The smallest positive integer 1 is missing.
      */
     
     static public void swap(int[] arr, int curIdx, int correctIdx) {
          int temp = arr[curIdx];
          arr[curIdx] = arr[correctIdx];
          arr[correctIdx] = temp;
     }
     
     private static void cyclicSort(int[] arr){
          int i = 0;
          while (i < arr.length){
               int correctIdx = (arr[i] - 1);
               if (correctIdx >=0 && correctIdx < arr.length && arr[i] != arr[correctIdx]) swap(arr, i, correctIdx);
               else i++;
          }
     }
     
     public int firstMissingPositive(int[] nums) {
          // int[] filterNum = Arrays.stream(nums).filter(num -> num > 0).toArray();
          cyclicSort(nums);
          System.out.println(Arrays.toString(nums));
          int i = 0;
          for (i = 0; i < nums.length; i++) {
               if (nums[i] - 1 != i) return i+1;
           }
          return i + 1;
     }
     
     public static void main(String[] args) {
          System.out.println(FirstMissingPositive.builder().build().firstMissingPositive(new int[] {1, 2, 0}));
          // [7,8,9,11,12]
          System.out.println(FirstMissingPositive.builder().build().firstMissingPositive(new int[] {7, 8, 9}));
          // [3,4,-1,1]
          System.out.println(FirstMissingPositive.builder().build().firstMissingPositive(new int[] {3, 4, -1, 1}));
          
          System.out.println(FirstMissingPositive.builder().build().firstMissingPositive(new int[] {1}));
     }
     
}
