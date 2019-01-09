package com.bit.day03;

public class MethodMain02 {
	
	public static int factorial(int n) {
		if(n!=1) {
			return n * factorial(--n);
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
}
