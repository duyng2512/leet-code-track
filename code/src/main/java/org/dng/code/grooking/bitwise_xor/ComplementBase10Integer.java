package org.dng.code.grooking.bitwise_xor;

public class ComplementBase10Integer {
     
     public static int bitwiseComplement(int n) {
	String result = Integer.toBinaryString(n);
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < result.length(); i++) {
	     if (result.charAt(i) == '1') {
		builder.append('0');
	     } else {
		builder.append('1');
	     }
	}
     	return Integer.parseInt(builder.toString(), 2);
     }
     
     public static void main(String[] args) {
	System.out.println(bitwiseComplement(5));
     }
     
}
