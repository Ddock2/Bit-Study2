package com.bit.day01;

public class CastMain {
	
	public static void main(String[] args) {
	/*
		double a = 3.14;
		int b;
		b = (int) a;
		System.out.println(b);
		
		int c = 10;
		double d;
		d = c;
		System.out.println(d);
	*/
		byte b = 25;
		short s = b;
		int i = s;
		long l = i;
		float f = l;
		double d = f;

		byte b1 = (byte) 256;
		// 0000 0001 0000 0000 -> xxxx xxxx 0000 0000
		
		System.out.println("b : " + b);
		System.out.println("s : " + s);
		System.out.println("i : " + i);
		System.out.println("l : " + l);
		System.out.println("f : " + f);
		System.out.println("b : " + d);
		System.out.println("b1 : " + b1);
		
//		byte b2 = 128;	// -128 ~ 127 error
		
		int iNum = 100;
		long lNum = (long) iNum;
		System.out.println(lNum);
	}
	
}
