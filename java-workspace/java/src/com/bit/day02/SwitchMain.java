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
		
		s.close();
	}
	
}
