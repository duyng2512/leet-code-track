package org.dng.code.grooking.array;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class ThreeSums {
     
     /**
      * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
      * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
      * <p>
      * Notice that the solution set must not contain duplicate triplets.
      * Example 1:
      * <p>
      * Input: nums = [-1,0,1,2,-1,-4]
      * Output: [[-1,-1,2],[-1,0,1]]
      * Explanation:
      * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
      * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
      * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
      * The distinct triplets are [-1,0,1] and [-1,-1,2].
      * Notice that the order of the output and the order of the triplets does not matter.
      * Example 2:
      * <p>
      * Input: nums = [0,1,1]
      * Output: []
      * Explanation: The only possible triplet does not sum up to 0.
      *
      * @param nums
      * @return
      */
     
     public List<List<Integer>> threeSum(int[] nums) {
	// Sorted the array
	Arrays.sort(nums);
	List<List<Integer>> result = new ArrayList<>();
	for (int i = 0; i < nums.length; i++) {
	     
	     // Skip duplicate number
	     if (i != 0 && nums[i] == nums[i - 1])
		continue;
	     
	     // nums[i] > 0 skip
	     // Because since we count from here to the end of the sorted array,
	     // from here there is only increasing value
	     if (nums[i] > 0)
		break;
	     
	     int current = nums[i];
	     int low = i + 1;
	     int high = nums.length - 1;
	     
	     while (low < high) {
		if (nums[low] + nums[high] + current < 0) {
		     low++;
		} else if (nums[low] + nums[high] + current > 0) {
		     high--;
		} else {
		     // num[low] + num[high] + current == 0
		     List<Integer> foundSet = Arrays.asList(nums[low], nums[high], nums[i]);
		     result.add(foundSet);
		     low++;
		     high--;
		}
	     }
	}
	return result;
     }
     
     public static void main(String[] args) {
	System.out.println(ThreeSums.builder().build().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
     }
}
