package org.dng.code.algo.array;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class ProductOfAllExceptSelf {


// 1 2 3 6 = total_prod = 36
// 1 2 6

public static void main(String[] args) {
	System.out.println(Arrays.toString(ProductOfAllExceptSelf.builder().build().productExceptSelf(new int[]{2, 3, 5, 1})));
}

public int[] productExceptSelf(int[] nums) {
	int[] result = new int[nums.length];
	int[] leftProduct = new int[nums.length];
	int[] rightProduct = new int[nums.length];
	leftProduct[0] = 1;
	rightProduct[0] = 1;
	
	for (int i = 1; i < nums.length; i++) {
		leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
		rightProduct[i] = rightProduct[i - 1] * nums[nums.length - i];
	}
	
	for (int i = 0; i < nums.length; i++) {
		result[i] = leftProduct[i] * rightProduct[nums.length - i - 1];
	}
	return result;
}

}
