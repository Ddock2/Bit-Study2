package com.bit.day04.Prob;

// Prob4 문자열 배열 입력받아 하나의 문자열로 연결

public class StringUtil {
	// 문자열을 결합하여 리턴하는 메소드
	public static String concatenate(String[] str) {
		String result = "";
		for(String s : str) {
			result += s;
		}
		
		return result;
	}
}