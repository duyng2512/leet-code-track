package org.dng.code.grooking.hash_table;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author duyntc 02/2023
 */
public class IntegerToRoman {

static public String intToRoman(int num) {
	
	List<Integer> arr = getEachPart(num);
	
	return handle(arr.get(0) * 1000, 5000, 1000, 10000, "", "M", "") +
				   handle(arr.get(1) * 100, 500, 100, 1000, "D", "C", "M") +
				   handle(arr.get(2) * 10, 50, 10, 100, "L", "X", "C") +
				   handle(arr.get(3), 5, 1, 10, "V", "I", "X");
}

// I II III IV V VI VII VIII IX
static public String handle(int input,
							int numBase,
							int numStart,
							int numEnd,
							String charBase,
							String charStart,
							String charEnd) {
	
	if (input == 0) {
		return "";
	}
	
	if (input == numBase) {
		return charBase;
	}
	if (input > numBase) {
		if (input == numEnd - numStart) {
			return charStart + charEnd;
		} else {
			int time = (input - numBase) / numStart;
			return charBase + String.valueOf(charStart).repeat(Math.max(0, time));
		}
	} else {
		if (input == numBase - numStart) {
			return charStart + charBase;
		} else {
			int time = input / numStart;
			return String.valueOf(charStart).repeat(Math.max(0, time));
		}
	}
}

static public List<Integer> getEachPart(int num) {
	int remain = num;
	List<Integer> result = new LinkedList<>();
	while (remain != 0) {
		result.add(remain % 10);
		remain = remain / 10;
	}
	Collections.reverse(result);
	
	while (result.size() < 4) {
		result.add(0, 0);
	}
	return result;
}

public static void main(String[] args) {
	System.out.println(intToRoman(3921));
}

}