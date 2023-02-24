package org.dng.code.grooking.slow_fast_pointer;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class HappyNumber {
     /*
	Problem Statement
	Any number will be called a happy number if,
	after repeatedly replacing it with a number
	equal to the sum of the square of all of its digits,
	leads us to number ‘1’.
	
	All other (not-happy) numbers will never reach ‘1’.
	Instead, they will be stuck in a cycle of numbers
	which does not include ‘1’.
	
	
      */

public static void main(String[] args) {
	System.out.println(HappyNumber.builder().build().isHappy(19));
	System.out.println(HappyNumber.builder().build().isHappy(2));
	System.out.println(HappyNumber.builder().build().isHappy(1));
	System.out.println(HappyNumber.builder().build().isHappy(10));
	System.out.println(HappyNumber.builder().build().isHappy(1));
	
	HappyNumber happyNumber = new HappyNumber();
	int result = happyNumber.takeSquare(happyNumber.takeSquare(10));
	System.out.println(result);
}

public int takeSquare(int n) {
	List<Integer> segment = new ArrayList<>();
	while (n != 0) {
		segment.add(n % 10);
		n /= 10;
	}
	int total = 0;
	for (Integer val : segment) {
		total += Math.pow(val, 2);
	}
	return total;
}

public boolean isHappy(int n) {
	int slow = takeSquare(n);
	int fast = takeSquare(takeSquare(n));
	
	while (true) {
		if (slow == fast && slow != 1) return false;
		if (fast == 1) return true;
		
		slow = takeSquare(slow);
		fast = takeSquare(takeSquare(fast));
	}
}
}
