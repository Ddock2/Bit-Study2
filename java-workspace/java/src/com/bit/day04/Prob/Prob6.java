package com.bit.day04.Prob;

import java.util.Scanner;

// Calculator 계산기

public class Prob6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("두 숫자 연산할 계산식을 입력하세요");
		String temp = s.nextLine();
		temp = temp.replaceAll(" ", "");
		int a, b;
		char operator = 'X';
		char[] cTemp = temp.toCharArray();
		
		for(int i=0; i<temp.length(); i++) {
			if(cTemp[i] == '+' || cTemp[i] == '-' || cTemp[i] == '*' || cTemp[i] == '/') operator = cTemp[i];
		}
		String[] temp2 = temp.split("\\" + operator);
		
		if(temp2.length == 2) {
			a = Integer.parseInt(temp2[0]);
			b = Integer.parseInt(temp2[1]);
			
			Calculator calc = new Calculator();
			calc.calculate(a, operator, b);
			
		} else{
			System.out.println("지원하지 않는 방식의 입력입니다.");
		}
		
		System.out.println("quit");
		
		s.close();
	}
	
}
