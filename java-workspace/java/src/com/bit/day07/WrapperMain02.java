package com.bit.day07;

public class WrapperMain02 {
	
	public static void main(String[] args) {
//		int i = Integer.parseInt("12345");
//		Integer i2 = new Integer(i); // Boxing
		
		// Auto-Boxing
		Integer i2 = Integer.parseInt("12345");
		String s = String.valueOf(i2);
		double d = Double.parseDouble("3.14");
		
		System.out.println(i2);
		System.out.println(s);
		System.out.println(d);
		
		// 16진수->10진수
		int num = Character.getNumericValue('A');
		System.out.println(num);
		
		int i3 = Integer.parseInt("f", 16);
		System.out.println(i3);
		
		// 2진수로
		String s2 = Integer.toBinaryString(15);
		System.out.println(s2);
		
		// 비트단위 1의 개수
		int bitCnt = Integer.bitCount(15);
		System.out.println(bitCnt);
		
		// 16진수로
		String hexStr = Integer.toHexString(255);
		System.out.println(hexStr);
	}
	
}
