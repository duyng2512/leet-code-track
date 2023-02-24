package org.dng.code.grooking.array;

public class MinLengthOfSubArrTotalSumLargerN {

    /*
        Given an array of n positive integers and a positive integer s,
        find the minimal length of a contiguous subarray of which the
        sum ≥ s. If there isn't one, return 0 instead.

        Example:
        Input: s = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: the subarray [4,3] has the minimal length under
        the problem constraint.
     */

public static MinLengthOfSubArrTotalSumLargerN getInstance() {
	return new MinLengthOfSubArrTotalSumLargerN();
}

public static void main(String[] args) {
	System.out.println(MinLengthOfSubArrTotalSumLargerN.getInstance().minLength(new int[]{2, 3, 1, 2, 4, 3}, 7));
	System.out.println(MinLengthOfSubArrTotalSumLargerN.getInstance().minLength(new int[]{1, 4, 4}, 7));
	System.out.println(MinLengthOfSubArrTotalSumLargerN.getInstance().minLength(new int[]{1, 4, 4}, 11));
}

public int minLengthBruteForce(int[] nums, int target) {
	int minLength = Integer.MAX_VALUE;
	int[] sumArr = new int[nums.length];
	sumArr[0] = nums[0];
	for (int i = 1; i < nums.length; i++) {
		sumArr[i] = sumArr[i - 1] + nums[i];
	}
	for (int i = 0; i < nums.length; i++) {
		for (int j = i; j < nums.length; j++) {
			int sum = sumArr[j] - sumArr[i] + nums[i];
			if (sum >= target) {
				minLength = Math.min(minLength, (j - i + 1));
				break;
			}
		}
	}
	return minLength;
}

public int minLength(int[] nums, int target) {
	int minLength = Integer.MAX_VALUE;
	int sumArr = 0;
	int start = 0;
	
	for (int end = 0; end < nums.length; end++) {
		sumArr += nums[end];
		
		/**
		 * Intuitive when detect there are abnormal
		 * Start index increase
		 */
		while (sumArr >= target) {
			minLength = Math.min(minLength, end - start + 1);
			sumArr -= nums[start];
			start++;
		}
	}
	return minLength == Integer.MAX_VALUE ? 0 : minLength;
}

}
