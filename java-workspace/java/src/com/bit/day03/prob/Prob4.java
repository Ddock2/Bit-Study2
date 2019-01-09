package com.bit.day03.prob;

import java.util.Scanner;

// 문자열(String)을 입력 받아,
// 해당 문자열을 문자 순서를 뒤집어서 char[]로 변환하는 메소드를 만들고,
// char[]을 입력 받아 출력하는 메소드를 만드시오

public class Prob4 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		printCharArray( reverse(str) );
		
		s.close();
	}
	
	public static char[] reverse(String str) {
		int length = str.length();
		char[] result = new char[length--];
		
		for(int i=length; i>=0; i--) {
			result[i] = str.charAt(length-i);
		}
		
		return result;
	}
	
	public static void printCharArray(char[] array) {
		for(char c : array) {
			System.out.print(c);
		}
	}
}
