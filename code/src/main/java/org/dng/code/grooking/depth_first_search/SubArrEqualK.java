package org.dng.code.grooking.depth_first_search;

import java.util.HashMap;
import java.util.List;

public class SubArrEqualK {
// Target 9
// Val:     1, 2, 3, 4, 5
// Total:   1, 3, 6, 10, 15

// Dist:   -8, -6, -3, 1, 6

// Target 2
// VAL:     [1,1,1]
// TOTAL:   [1,2,3]

/**
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * @param arr
 * @param target
 * @return
 */

public static int windowSum(List<Integer> arr, int target) {
	
	int count = 0, sum = 0;
	
	// Key = sum,
	// Value = count
	HashMap<Integer, Integer> map = new HashMap<>();
	
	for (Integer integer : arr) {
		sum += integer;
		
		// When the first element equal target right away
		if (sum == target) {
			count = 1;
			map.put(sum, 1);
		}
		
		if (map.containsKey(sum - target)) {
			count += map.get(sum - target);
		}
		
		map.put(sum, map.getOrDefault(sum, 0) + 1);
	}
	
	System.out.println(map);
	return count;
}

/*
	Time: O(n)
	Space: O(n)
 */
public static int subarraySum(int[] nums, int k) {
	HashMap<Integer, Integer> map = new HashMap<>();
	int count = 0, sum = 0;
	
	// For element that equal themselves
	map.put(0, 1);
	
	for (int num : nums) {
		sum += num;
		
		// There is at least one element satisfied this
		if (map.containsKey(sum - k)) {
			count += map.get(sum - k);
		}
		map.put(sum, map.getOrDefault(sum, 0) + 1);
	}
	return count;
}

/*
	Time: O(n3)
	Space: O(1)
 */
public static int subarraySumBrute(int[] nums, int k) {
	int count = 0;
	for (int i = 0; i < nums.length; i++) {
		for (int j = i + 1; j <= nums.length; j++) {
			int sum = 0;
			for (int l = i; l < j; l++) {
				sum += nums[l];
			}
			if (sum == k) count++;
		}
	}
	return count;
}

/*
Time: O(n2)
Space: O(1)
*/
public static int subarraySumPointer(int[] nums, int k) {
	int count = 0;
	for (int i = 0; i < nums.length; i++) {
		int sum = 0;
		for (int j = i + 1; j <= nums.length; j++) {
			sum += nums[j];
			if (sum == k) count++;
		}
	}
	return count;
}
}
