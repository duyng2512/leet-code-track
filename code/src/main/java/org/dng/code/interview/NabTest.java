package org.dng.code.interview;

public class NabTest {
	
	// hot
	// hoo
	
	public String solution(String S) {
		int result = -1;
		
		for (int i = 0; i < S.length(); i++) {
			if (i < S.length() - 1 && S.charAt(i + 1) < S.charAt(i)) {
				result = i;
				break;
			}
		}
		
		if (result != -1 ){
			return S.substring(0, result) + S.substring(result + 1);
		} else {
			return S.substring(0, S.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		NabTest nabTest = new NabTest();
		System.out.println(nabTest.solution("acb"));
		System.out.println(nabTest.solution("hot"));
		System.out.println(nabTest.solution("codility"));
		System.out.println(nabTest.solution("aaa"));
		System.out.println(nabTest.solution("cd"));
		System.out.println(nabTest.solution("abcdef"));
	}
}
