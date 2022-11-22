package org.dng.code.grooking.binary_search;

import java.util.Arrays;

public class FindFirstLastPosition {
     
     /*
     
          Given an array of integers nums sorted in non-decreasing order,
          find the starting and ending position of a given target value.
     
          If target is not found in the array, return [-1, -1].
          
          You must write an algorithm with O(log n) runtime complexity.
          
          Example 1:
          Input: nums = [5,7,7,8,8,10], target = 8
          Output: [3,4]
          
          Example 2:
          Input: nums = [5,7,7,8,8,10], target = 6
          Output: [-1,-1]
          
          Example 3:
          Input: nums = [], target = 0
          Output: [-1,-1]
      */
     
     public static int[] searchRange(int[] nums, int target) {
	int low = 0;
          int high = nums.length - 1;
          int[] result = new int[] {-1, -1};
          
          while (low <= high) {
               int mid = ( low + high ) / 2;
               if (nums[mid] == target) {
                    
                    // Found target here
                    int targetLeft = mid;
                    int targetRight = mid;
                    
                    while (targetLeft - 1 >= 0) {
                         if (nums[targetLeft-1] == target) targetLeft -= 1;
                         else break;
                    }
                    
                    while (targetRight + 1 < nums.length) {
                         if (nums[targetRight+1] == target) targetRight += 1;
                         else break;
                    }
                    System.out.println("Left " + targetLeft + " Right " + targetRight + " Mid " + mid);
                    result[0] = targetLeft;
                    result[1] = targetRight;
                    break;
               } else if (nums[mid] > target) {
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          
          return result;
     }
     
     public static void main(String[] args) {
          System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));

          System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));

          System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));

          System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 9, 10}, 8)));

          System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
     
          System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
     
          System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 2}, 1)));
     }
     
}
