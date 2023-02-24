package org.dng.code.grooking.two_pointer;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class TripletWithSmallerSum {

public static void main(String[] args) {
	System.out.println(TripletWithSmallerSum.builder().build().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
	System.out.println(TripletWithSmallerSum.builder().build().threeSumSmaller(new int[]{-2, 0, 1, 3}, 4));
	System.out.println(TripletWithSmallerSum.builder().build().threeSumSmaller(new int[]{0, 0, 0}, 0));
}

public int threeSumSmaller(int[] nums, int target) {
	if (nums.length == 0 || nums.length == 1) return 0;
	int result = 0;
	Arrays.sort(nums);
	
	for (int i = 0; i < nums.length; i++) {
		int endIdx = nums.length - 1;
		int currentTotal;
		
		while (endIdx > i) {
			int startIdx = i + 1;
			
			
			while (startIdx < endIdx) {
				currentTotal = nums[i] + nums[startIdx] + nums[endIdx];
				if (currentTotal >= target) break;
				
				// System.out.printf("%d %d %d Total = %d\n", i, startIdx, endIdx, currentTotal);
				result++;
				startIdx++;
			}
			endIdx--;
		}
	}
	return result;
}
}
