package org.dng.code.grooking.prefix_sum;

public class RangeSumQueryImmutable {

/**
 * Time: O(n + q)
 * Space: O(n)
 */
static class NumArray {
	
	int[] arr;
	
	public NumArray(int[] nums) {
		arr = new int[nums.length];
		arr[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			arr[i] += nums[i] + arr[i - 1];
		}
	}
	
	public int sumRange(int left, int right) {
		if (left == 0)
			return arr[right];
		return arr[right] - arr[left - 1];
	}
}

}
