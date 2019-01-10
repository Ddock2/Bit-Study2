package com.bit.day04.Prob;

// StringUtil 문자열 배열 입력받아 하나의 문자열로 연결

public class Prob4 {
	
	public static void main(String[] args) {
		String[] strArr = {"SuperMan", "BatMan", "SpiderMan"};
		String resultStr = StringUtil.concatenate(strArr);
		
		System.out.println("결과 문자열 : " + resultStr);
	}
	
}
