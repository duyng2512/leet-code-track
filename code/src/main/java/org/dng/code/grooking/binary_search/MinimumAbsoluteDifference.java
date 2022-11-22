package org.dng.code.grooking.binary_search;

public class MinimumAbsoluteDifference {
     public static void main(String[] args) {
          System.out.println(find(new int[] {1, 2, 3}, 2));
          System.out.println(find(new int[] {1, 2, 3}, 3));
          System.out.println(find(new int[] {1, 2, 3}, 1));
     }
     
     public static int find(int[] arr, int target) {
          int diff = Integer.MAX_VALUE, index = 0;
          int left = 0;
          int right = arr.length-1;
          int pivot;
          
          
          while (left <= right) {
               pivot = (left + right) / 2;
               
               if (arr[pivot] == target) return pivot;
               else if (arr[pivot] > target) {
                    if (diff > Math.abs(arr[pivot] - target)) {
                         diff = Math.abs(arr[pivot] - target);
                         index = pivot;
                    }
                    
                    right = pivot - 1;
               } else {
                    if (diff > Math.abs(arr[pivot] - target)) {
                         diff = Math.abs(arr[pivot] - target);
                         index = pivot;
                    }
                    left = pivot + 1;
               }
          }
          return index;
     }
     
     
     
}
