package org.dng.code.grooking.binary_search;

public class FindSmallestLetterGreaterThanTarget {

public static char nextGreatestLetter(char[] letters, char target) {
	
	int left = 0;
	int right = letters.length - 1;
	int pivot = 0;
	
	while (left <= right) {
		pivot = (left + right) / 2;
		
		if (letters[pivot] == target) {
			if (pivot + 1 < letters.length) return letters[pivot + 1];
			else return letters[0];
		} else if (letters[pivot] > target) {
			right = pivot - 1;
		} else {
			left = pivot + 1;
		}
	}
	if ((target < letters[pivot]) && (pivot + 1 < letters.length)) {
		return letters[pivot];
	}
	return letters[0];
}

public static void main(String[] args) {
	System.out.println('c' - 'd');
	System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
}
}
