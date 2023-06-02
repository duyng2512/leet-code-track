package org.dng.code.template;

import java.util.List;

public class BinarySearch {

    static public int binarySearchLowOrEqual(int value, List<Integer> list) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == value) {
                return mid + 1;  // value element found at index mid
            } else if (list.get(mid) < value) {
                low = mid + 1;  // value element may be in the right half
            } else {
                high = mid - 1;  // value element may be in the low half
            }
        }
        return low;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // found the target
            } else if (arr[mid] < target) {
                left = mid + 1; // target is in the right half
            } else {
                right = mid - 1; // target is in the left half
            }
        }

        return -1; // target is not present in the array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

}
