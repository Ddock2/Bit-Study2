package com.bit.day02;

import java.util.Scanner;

public class SwitchMain {
	
	public static void main(String[] args) {
		int n = 5;
		switch(n) {
			case 1: System.out.println("숫자는 1"); break;
			case 2:	System.out.println("숫자는 2"); break;
			case 3:	System.out.println("숫자는 3"); break;
			default: System.out.println("default 수행"); break;
			case 5: System.out.println("숫자는 5"); break;
			case 4: System.out.println("숫자는 4");
		}
		System.out.println();
		
		Scanner s = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		switch(s.nextInt()/10) {
			case 10: System.out.println("만점입니다! ");
			case 9: System.out.println("A"); break;
			case 8: System.out.println("B"); break;
			case 7: System.out.println("C"); break;
			case 6: System.out.println("D"); break;
			default: System.out.println("F");
		}
		System.out.println();
		s.close();
		
		// 월별 일수 판단하기
		int month =1;
		int days = 0;
		/*
		if(month == 1 ||
			month == 3 ||
			month == 5 ||
			month ==7 ||
			month == 8 ||
			month==10 ||
			month == 12) {
			days = 31;
		} else if(month == 2) {
			days = 28;
		} else {
			days = 30;
		}
		System.out.println(month + "월은 " + days + "일까지 있습니다");
		*/
		switch(month) {
			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				days = 31; break;
			case 2 : days = 28; break;
			default  : days = 30;
		}
		System.out.println(month + "월은 " + days + "일까지 있습니다");
	}
	
}
