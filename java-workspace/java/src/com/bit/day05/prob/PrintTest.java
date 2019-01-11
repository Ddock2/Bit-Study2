package com.bit.day05.prob;

// Prob1

public class PrintTest {
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
	
}

class Printer {
	public void println(int n) {
		System.out.println(n);
	}
	
	public void println(boolean b) {
		System.out.println(b);
	}
	
	public void println(double d) {
		System.out.println(d);
	}
	
	public void println(String str) {
		System.out.println(str);
	}
}