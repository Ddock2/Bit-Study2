package com.bit.day02.exam;

import java.util.Scanner;

public class Gugudan {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("단수 입력 : ");
		int start = s.nextInt();
		int end = s.nextInt();
		System.out.println("입력한 단수 -> " +start + "~" + end);
		
		for(int i=start; i<=end; i++) {
			System.out.println(i + "단");
			for(int j=1; j<=9; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println();
		}
		
		s.close();
	}
	
}
