package com.bit.day02;

import java.util.Scanner;

public class ScannerMain {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int iNum = s.nextInt();
		System.out.println("정수 : " + iNum);
		System.out.println();
		
		System.out.print("실수 입력 : ");
		double dNum = s.nextDouble();
		s.nextLine(); // 입력 버퍼를 비우기 위해 사용
		System.out.println("실수 : " + dNum);
		System.out.println();
		
		System.out.print("문자 입력 : ");
		char c = s.nextLine().charAt(0);
		System.out.println("문자 : " + c);
		System.out.println();
		
		System.out.print("문자열 입력 : ");
		String str = s.next();
		s.nextLine();
		System.out.println("문자열 : " + str);
		System.out.println();
		
		System.out.print("문장 입력 : ");
		String str2 = s.nextLine();
		System.out.println("문자열 : " + str2);
		System.out.println();
		
		System.out.print("논리값 입력 : ");
		boolean bool = s.nextBoolean();
		System.out.println("논리값 : " + bool);
		
		s.close();
	}
	
}
