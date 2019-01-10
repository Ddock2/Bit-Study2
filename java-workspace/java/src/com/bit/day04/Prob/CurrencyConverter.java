package com.bit.day04.Prob;

// Prob3 환율 계산기

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {		
		return won/rate;
	}
	
	public static double toKRW(double dollar) {		
		return dollar*rate;
	}
	
	public static void setRate(double r) {
		rate = r;
	}
}
