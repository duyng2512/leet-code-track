package org.dng.code.grooking.bit_manipulate;

public class SingleNumber {

  // https://leetcode.com/problems/single-number/

  /**
   * Intuitive A ^ A = 0
   * The only thing remain is the number that appear only once
   * Time: O(n)
   * Space: O(1)
   */
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }

}
