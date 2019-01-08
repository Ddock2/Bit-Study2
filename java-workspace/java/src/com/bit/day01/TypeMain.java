package com.bit.day01;

public class TypeMain {
	
	public static void main(String[] args) {
		boolean bool = true;
		System.out.println(bool);
		
		char c = 'A';
		System.out.println(c);
		
		byte b = 20;
		System.out.println(b);
		System.out.println("byte의 크기 : " + Byte.SIZE);
		
		short s = 20;
		System.out.println(s);
		System.out.println("short의 크기 : " + Short.SIZE);
		
		int i = 10;
		System.out.println(i);
		System.out.println("int의 크기 : " + Integer.SIZE);
		
		long l = 10;
		System.out.println(l);
		System.out.println("long의 크기 : " + Long.SIZE);
		
		float f = 3.5f;
		System.out.println(f);
		System.out.println("float의 크기 : " + Float.SIZE);
		
		double d = 3.14;
		System.out.println(d);
		System.out.println("double의 크기 : " + Double.SIZE);
	}
	
}
