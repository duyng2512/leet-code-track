package org.dng.code.algo.array;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class ThreeSums {

    public List<List<Integer>> threeSum(int[] nums) {
        // Sorted the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            // Skip duplicate number
            if (i != 0 && nums[i] == nums[i-1])
                continue;

            // nums[i] > 0 skip
            if (nums[i] > 0)
                break;

            int current = nums[i];
            int low = i+1;
            int high = nums.length-1;
            
            while (low < high){
                if (nums[low] + nums[high] + current < 0) {
                    low ++;
                } else if (nums[low] + nums[high] + current > 0) {
                    high --;
                } else {
                    // num[low] + num[high] + current == 0
                    List<Integer> foundSet = Arrays.asList(nums[low], nums[high], nums[i]);
                    result.add(foundSet);
                    low++;
                    high--;

                    // Skip the duplicate
                    while (low < high && nums[low] == nums[low - 1])
                        low++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ThreeSums.builder().build().threeSum(new int[] {-1,0,1,2,-1,-4} ));
    }
}
