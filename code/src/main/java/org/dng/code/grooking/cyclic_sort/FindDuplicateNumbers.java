package org.dng.code.grooking.cyclic_sort;

import lombok.Builder;
import org.dng.code.utils.MiscUtils;

@Builder
public class FindDuplicateNumbers {

static void cyclicSort(int[] nums) {
	int i = 0;
	
	while (i < nums.length) {
		int correctPos = nums[i] - 1;
		if (nums[i] != nums[correctPos]) MiscUtils.swap(nums, i, correctPos);
		else i++;
	}
}

public static void main(String[] args) {
	int result = FindDuplicateNumbers.builder().build().findDuplicate(new int[]{1, 3, 4, 2, 2});
	System.out.println(result);
}

public int findDuplicate(int[] nums) {
	cyclicSort(nums);
	for (int i = 0; i < nums.length; i++) {
		if (i + 1 != nums[i]) return nums[i];
	}
	return -1;
}

}
