package org.dng.code.daily._2023;

/**
 * @author duyntc 02/2023
 */
public class D2_ZigzagConversion {
     
     /**
      * P   A   H   N
      * A P L S I I G
      * Y   I   R
      *
      * P A Y P A L I S H I R I N G // num row = 3
      *
      *
      * P A H N A P L S I I G Y I R // num row = 3
      * @param s
      * @param numRows
      * @return
      */
     
     /**
      * 1       1
      * 1     1 1
      * 1   1   1
      * 1 1     1
      * 1       1
      * <p>
      * (3 1) 6
      * (2 2) 7
      *
      * @param s
      * @param numRows
      * @return
      */
     
     // 3 -> 1
     // 4 -> 2
     // 5 -> 3
     static public String convert(String s, int numRows) {
	if (numRows == 1) return s;
	
	int row = (s.length() / (2 * numRows - 2) + 1) * (numRows - 1);
	
	char[][] arr = new char[numRows][row];
	
	int divide = 2 * numRows - 2;
	int colIdx = 0;
	int stringIdx = 0;
	
	while (stringIdx < s.length()) {
	     fillIn(arr, s.substring(stringIdx, Math.min(stringIdx + divide, s.length())), colIdx, numRows);
	     colIdx += numRows - 1;
	     stringIdx += divide;
	}
	// visualize(arr);
	
	StringBuilder builder = new StringBuilder();
	
	for (char[] ints : arr) {
	     for (int j = 0; j < arr[0].length; j++) {
		if (ints[j] != '\u0000') {
		     builder.append(ints[j]);
		}
	     }
	}
	
	return builder.toString();
     }
     
     static public void fillIn(char[][] arr, String string, int col, int numRows) {
	
	// Fill the straight line
	for (int i = 0; i < Math.min(numRows, string.length()); i++) {
	     arr[i][col] = string.charAt(i);
	}
	
	// Fill the zig zag
	// 3 - 0 -2 = 1
	// 3 - 1 -2 = 1
	// 1 1
	for (int i = 0; i < numRows - 2; i++) {
	     try {
		arr[numRows - i - 2][col + i + 1] = string.charAt(numRows + i);
	     } catch (Exception e) {
		return;
	     }
	}
	// 4 -> 9
	// 3 -> 8
	// n + n - 2
	// 3 - 1
	// 15 / 2 = 6
	// ( 15 // (2*n - 2) ) * (n - 1) ==
	// 15 // 6 + 1 * (3) = 3 * 3 = 3
	//
     }
     
     static public void visualize(char[][] arr) {
	for (char[] ints : arr) {
	     StringBuilder builder = new StringBuilder();
	     for (int j = 0; j < arr[0].length; j++) {
		builder.append(ints[j]);
		builder.append(" ");
	     }
	     System.out.println(builder);
	}
     }
     
     public static void main(String[] args) {
	String s = convert("PAYPALISHIRING", 3); // PAHNAPLSIIGYIR
	System.out.println(s);
	s = convert("PAYPALISHIRING", 4); // PINALSIGYAHRPI
	System.out.println(s);
     }
     
}
