package org.dng.code.utils;

import java.util.Arrays;
import java.util.Comparator;

public class MergeUtils {
     
     public static void sortByFirstKey(int[][] arr) {
          Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
     }
     
     public static void main(String[] args) {
          sortByFirstKey(new int[][] {{1, 3}, {10, 12}, {8, 10}, {15, 18}});
     }
}
