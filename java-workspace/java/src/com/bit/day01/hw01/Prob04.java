package com.bit.day01.hw01;

import java.util.Scanner;

public class Prob04 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		for(int i=0; i<=str.length(); i++) {
			System.out.println(str.subSequence(0, i));
		}
		
		sc.close();
	}
	
}
