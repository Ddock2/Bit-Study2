package com.bit.day01.homework01;

import java.util.Scanner;

public class Prob03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		System.out.print("숫자를 입력하세요 : ");
		for(int i=sc.nextInt(); i>0; i-=2) {
			result += i;
		}
		System.out.println("결과값 : " + result);
		
		sc.close();
	}
	
}
