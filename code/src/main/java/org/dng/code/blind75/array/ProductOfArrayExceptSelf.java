package org.dng.code.blind75.array;

import lombok.Builder;

@Builder
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] result = new int[nums.length];
        boolean containZero = false;
        for (int num : nums) {
	  if (num != 0) {
	      product = product * num;
	  } else {
	      containZero = true;
	  }
        }
        if (containZero) {
	  for (int i = 0; i < nums.length; i++) {
	      if (nums[i]==0) result[i] = product;
	      else result[i] = 0;
	  }
        } else {
	  for (int i = 0; i < nums.length; i++) {
	      result[i] = product/nums[i];
	  }
        }
        return result;
    }
}
