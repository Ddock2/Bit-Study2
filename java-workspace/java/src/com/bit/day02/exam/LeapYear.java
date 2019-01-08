package com.bit.day02.exam;

import java.util.Scanner;

public class LeapYear {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("판단할 연수를 입력 : ");
		int year = s.nextInt();
		
		if(year % 4 != 0) {
			System.out.println("윤년이 아닙니다.");
		} else if(year % 100 != 0) {
			System.out.println("윤년입니다.");
		} else if(year % 400 != 0) {
			System.out.println("윤년이 아닙니다.");
		} else {
			System.out.println("윤년입니다.");
		}
		s.close();
	}
	
}
