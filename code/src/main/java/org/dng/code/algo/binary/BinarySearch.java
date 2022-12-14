package org.dng.code.algo.binary;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class BinarySearch {

    public int search(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int mid = Math.floorDiv(arr.length, 2);
        if (arr[mid] < target) {
            return search(Arrays.copyOfRange(arr, mid + 1, arr.length), target);
        } else if (arr[mid] > target) {
            return search(Arrays.copyOfRange(arr, 0, mid), target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.builder().build().search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 2 ));
    }

}
