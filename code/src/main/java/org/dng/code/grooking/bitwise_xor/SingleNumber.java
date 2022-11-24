package org.dng.code.grooking.bitwise_xor;

public class SingleNumber {
     public static int singleNumber(int[] nums) {
	int a = 0;
	for (int num: nums) {
	     a ^= num;
	}
	return a;
     }
     
     public static void main(String[] args) {
	System.out.println(singleNumber(new int[] {1, 1, 2} ));
     }
}
