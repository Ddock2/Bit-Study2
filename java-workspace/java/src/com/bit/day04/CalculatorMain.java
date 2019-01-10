package com.bit.day04;

import com.bit.day04.cap.Calculator;

// com.bit.day04.cap 캡슐화 예제

public class CalculatorMain {
	
	public static void main(String[] args) {
		// 캡슐화 외부시점
		Calculator calc = new Calculator();
		
		System.out.println("addTwoNumber(3,8) : " + calc.addTwoNumber(3, 8));
		System.out.println("addTwoNumber(2,3) : " + calc.addTwoNumber(2, 3));
		System.out.println("subTwoNumber(9,2) : " + calc.subTwoNumber(9, 2));
		calc.viewCnt();
	}
	
}
