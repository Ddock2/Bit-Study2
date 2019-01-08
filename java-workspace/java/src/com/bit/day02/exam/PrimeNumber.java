package com.bit.day02.exam;

import java.util.Scanner;

// 입력한 수가 소수인지 판단하는 프로그램
public class PrimeNumber {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("수를 입력 : ");
		int num = s.nextInt();
		int check = 0;
		
		for(int i=num-1; i>1; i--) {
			if(num%i == 0) {
				check++;
				break;
			}
		}
		
		if(check == 0) {
			System.out.println(num + "은 소수입니다");
		}else {
			System.out.println(num + "은 소수가 아닙니다");
		}
		
		s.close();
	}
	
}
