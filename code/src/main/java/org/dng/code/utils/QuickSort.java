package org.dng.code.utils;

import java.util.Arrays;

public class QuickSort {

  public void quickSort(int[] arr, int begin, int end) {
    if (begin < end) {
      int index = partition(arr, begin, end);
      quickSort(arr, begin, index - 1);
      quickSort(arr, index + 1, end);
    }
  }

  // 8 7 1 2 5 3
  // 1 7 8 2 5 3
  // 1 2 8 7 5 3
  // 1 2 3 7 5 8 -> Swap 3 with 8

  private int partition(int[] arr, int begin, int end) {
    int pivot = arr[end];
    int i = begin - 1;

    for (int j = begin; j < end; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, end);
    return i + 1;
  }

  static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public static void main(String[] args) {
    QuickSort sort = new QuickSort();
    int[] arr = {9, 5, 2, 1, -1};
    sort.quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

}
