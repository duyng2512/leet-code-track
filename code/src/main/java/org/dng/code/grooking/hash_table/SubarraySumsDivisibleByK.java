package org.dng.code.grooking.hash_table;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
     
     static public int subarraysDivByK(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	map.put(0, 1);
	int count = 0, sum = 0;
	for (int i = 0; i < nums.length; i++) {
	     int a = nums[i];
	     sum = (sum + a) % k;
	     if (sum < 0) sum += k;  // Because -1 % 5 = -1, but we need the positive mod 4
	     
	     count += map.getOrDefault(sum, 0);
	     System.out.printf("I = %d sum = %d count = %d map = %d  %n", i, sum, count, map.getOrDefault(sum, 0));
	     map.put(sum, map.getOrDefault(sum, 0) + 1);
	}
	System.out.println(map);
	return count;
     }
     
     public static void main(String[] args) {
	System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
     }
     
}
