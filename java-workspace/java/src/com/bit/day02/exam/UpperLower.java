package com.bit.day02.exam;

import java.util.Scanner;

public class UpperLower {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("입력 : ");
		
		char c = s.nextLine().charAt(0);
		if(c >= 'a' && c <='z') {
			System.out.printf("아스키코드 활용 : %c\n", c-32);
		}else {
			System.out.printf("아스키코드 활용 : %c\n", c+32);	
		}
		
		// XOR 연산자 활용
		System.out.printf("비트 이동 연산자 활용 : %c\n", c ^ (1<<5));
		System.out.printf("16진수 활용 : %c\n", c ^ 0x20);
		
		s.close();
	}
	
}
