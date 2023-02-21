package org.dng.code.by_tag.math;

public class CountOddNumbersIntervalRange {
     
     /**
      *
      */
     
     // 3 7 -> 3 4 5 6 7 8 9-> 7/2 -> 4
     // 8 9 10 -> 3 -> 1 _ 3/2 = 1
     // 8 9 10 11 12-> 5 -> 5/2 = 2
     // 8 9 10 11 -> 4/2
     //
     static public int countOdds(int low, int high) {
	long total = high - low + 1;
	if (low % 2 == 1 && high % 2 == 1) {
	     return (int) Math.round((double) total / 2);
	} else {
	     return (int) Math.floor((double) total / 2);
	}
     }
     
     public static void main(String[] args) {
	System.out.println(countOdds(798273637, 970699661));
     }
}
