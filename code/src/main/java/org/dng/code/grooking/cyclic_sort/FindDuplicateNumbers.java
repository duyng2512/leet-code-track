package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class FindDuplicateNumbers {
     
     static void cyclicSort(int[] nums) {
          int i = 0;
          
          while (i < nums.length) {
               int correctPos = nums[i]-1;
               if (nums[i] != nums[correctPos]) swap(nums, i, correctPos);
               else i++;
          }
     }
     
     static void swap(int[] arr, int curIdx, int correctIdx) {
          int temp = arr[curIdx];
          arr[curIdx] = arr[correctIdx];
          arr[correctIdx] = temp;
     }
     
     public int findDuplicate(int[] nums) {
	cyclicSort(nums);
          for (int i = 0; i < nums.length; i++) {
               if (i + 1 != nums[i]) return nums[i];
          }
          return -1;
     }
     
     public static void main(String[] args) {
          int result = FindDuplicateNumbers.builder().build().findDuplicate(new int[] {1,3,4,2,2} );
          System.out.println(result);
     }
     
}
