package com.bit.day04.Prob;

// CurrencyConverter 환율 계산기

public class Prob3 {
	
	public static void main(String[] args) {
		CurrencyConverter.setRate(1119.73);
		
		System.out.println("백만원은 " + CurrencyConverter.toDollar(1000000) + "달러입니다.");
		System.out.println("백달러은 " + CurrencyConverter.toKRW(100) + "원입니다.");
	}
	
}
