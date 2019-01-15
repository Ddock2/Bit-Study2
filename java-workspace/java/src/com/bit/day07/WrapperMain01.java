package com.bit.day07;

import java.math.BigDecimal;

public class WrapperMain01 {
	
	public static void main(String[] args) {
		/*
		 * Wrapper Class
		 * Integer
		 * Double
		 * ...
		 * 	-> 기본 데이터 타입을 객체로 사용하고 싶을 때
		 * 
		 * Boxing	: 기본 데이터 타입을 객체로
		 * UnBoxing	: 객체를 기본 데이터 타입으로
		 */
		Integer iVal = new Integer(10);		// int형 상수 10을 Integer로 Boxing
		System.out.println(iVal);
		
		double dNum = 3.14;
		Double dVal = new Double(dNum);		// double형 변수 dNum을 Double로 Boxing
		System.out.println(dVal);
		
		double subNum = dVal.doubleValue();	// UnBoxing
		System.out.println(subNum);
		
		System.out.println(iVal);
		iVal += 10;
		System.out.println(iVal);
		
		Integer num1 = 10;					// Auto-Boxing
		Integer num2 = 20;
		num1++;								// UnBoxing -> Boxing :	num1 = new Integer(num1.intValue() + 1);
		num2++;
		System.out.println(num1);
		System.out.println(num2);
		
		// 실수는 오차가 존재
		double d1 = 1.6;
		double d2 = 0.1;
		System.out.println(d1+d2);
		
		BigDecimal e1 = new BigDecimal(1.6);
		BigDecimal e2 = new BigDecimal(0.1);
		System.out.println(e1.add(e2));
		
		BigDecimal e3 = new BigDecimal("1.6");
		BigDecimal e4 = new BigDecimal("0.1");
		System.out.println(e3.add(e4));
	}
	
}
