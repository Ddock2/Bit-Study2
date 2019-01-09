package com.bit.day03.prob;


// 문자 배열(char[])을 입력 받아,
// 공백을 ','로 변환하는 메소드와
// char[]을 입력 받아 출력하는 메소드를 만드세요

public class Prob3 {
	
	public static void main(String[] args) {
		char c[] = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.'};
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
	}
	
	public static void replaceSpace(char a[]) {
		for(int i=0; i<a.length; i++) {
			if(a[i] == ' ') {
				a[i] = ',';
			}
		}
	}
	
	public static void printCharArray(char a[]) {
		for(char c : a) {
			System.out.print(c);
		}
		System.out.println();
	}
}
