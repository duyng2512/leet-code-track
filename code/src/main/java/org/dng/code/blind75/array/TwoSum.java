package org.dng.code.blind75.array;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class TwoSum {
    /**
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        tempMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
	  if (!tempMap.containsKey(nums[i])) tempMap.put(nums[i], i);
	  if (tempMap.containsKey(target - nums[i])){
	      return new int[]{tempMap.get(target - nums[i]), i};
	  }
        }
        return new int[]{};
    }

    public static int[] testTwoSum(int[] nums, int target) {
        return new TwoSum().twoSum(nums, target);
    }
}
