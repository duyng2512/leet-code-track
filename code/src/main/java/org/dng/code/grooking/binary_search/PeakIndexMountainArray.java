package org.dng.code.grooking.binary_search;

public class PeakIndexMountainArray {
     
     public static int peakIndexInMountainArray(int[] arr) {
	int low = 0;
          int high = arr.length - 1;
          
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] < arr[mid+1]) {
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }
          return low;
     }
     
     public static void main(String[] args) {
	System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
 
	// 0 5 10 6 2
	// 0 5 10
	// 5 10
	// 10
     }
}
