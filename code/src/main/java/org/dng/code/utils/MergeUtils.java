package org.dng.code.utils;

import java.util.Arrays;
import java.util.Comparator;

public class MergeUtils {

public static void sortByFirstKey(int[][] arr) {
	Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
}
}
