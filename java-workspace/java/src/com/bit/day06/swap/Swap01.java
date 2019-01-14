package com.bit.day06.swap;

public class Swap01 {
	
	public static void main(String[] args) {
		int i = 7;
		int j = 3;
		System.out.println("i = " + i + ", j = " + j);
		
//		int temp = i;
//		i = j;
//		j = temp;
		swap(i, j);
		System.out.println("i = " + i + ", j = " + j);
		
	}
	
	// Call By Value : 값에 의한 호출
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
}
