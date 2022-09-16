package org.dng.code.blind75.array;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class SearchInRotatedSortArr {

    public int search(int[] nums, int target) {
        int rotateIndex = findRotateIndex(nums, 0, nums.length-1);

        // if target is the smallest element
        if (nums[rotateIndex] == target)
            return rotateIndex;

        // if array is not rotated, search in the entire array
        if (rotateIndex == 0)
            return bsrSearch(nums, 0, nums.length-1, target);

        if (target < nums[nums.length-1]) {
            return bsrSearch(Arrays.copyOfRange(nums, 0, rotateIndex), 0, rotateIndex, target);
        } else {
            return bsrSearch(Arrays.copyOfRange(nums, rotateIndex, nums.length-1), rotateIndex, nums.length-1, target);
        }
    }

    public int bsrSearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) return mid;
            else {
                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public int findRotateIndex(int[] nums, int left, int right) {
        if (nums[left] < nums[right])
            return 0; // Return First Index
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1; // Pivot is abnormal
            else {
                if (nums[pivot] < nums[left]) // Abnormal Let the Right one become pivot
                    right = pivot - 1;
                else
                    left = pivot + 1; // Normal Case let inspect the right section
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        // System.out.println(SearchInRotatedSortArr.findRotateIndex(new int[]{10, 1, 2, 5, 6, 7, 9}, 0));
        System.out.println(SearchInRotatedSortArr.builder().build().search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 0));
    }
}
