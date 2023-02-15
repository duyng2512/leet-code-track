package org.dng.code.grooking.quick_select;

public class KthLargestElementInAnArray {

  static public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, k);
  }

  static private int quickSelect(int[] nums, int left, int right, int k) {
    if (left == right) {
      return nums[left];
    }

    int pivot = partition(nums, left, right);

    if (pivot == k - 1) {
      return nums[pivot];
    } else if (pivot < k - 1) {
      return quickSelect(nums, pivot + 1, right, k);
    } else {
      return quickSelect(nums, left, pivot - 1, k);
    }
  }

  static private int partition(int[] arr, int begin, int end) {
    int pivotVal = arr[end];
    int pivotIdx = begin;

    for (int i = begin; i <= end; i++) {
      if (arr[i] > pivotVal) {
        swap(arr, pivotIdx, i);
        pivotIdx++;
      }
    }

    swap(arr, end, pivotIdx);

    return pivotIdx;
  }

  static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

}
