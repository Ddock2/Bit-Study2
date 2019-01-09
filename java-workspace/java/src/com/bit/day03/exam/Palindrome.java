package com.bit.day03.exam;

// 2개의 세 자리 정수의 곱으로 만들어지는 대칭수를 구하시오
// (대칭수인지 판별하는 메소드를 정의하시오)

public class Palindrome {
	
	// 넘어온 수가 12345라면 뒤집어서 54321 원본과 같은지를 비교
	public static boolean isPalindrome(int n) {
		
		int rvs = 0;
		int temp = n;
		
		while(temp>0) {
			rvs = 10 * rvs + (temp % 10);
			temp /= 10;
		}
		
		if(n==rvs) { return true; }
		
		return false;
	}
	
	public static void main(String[] args) {
		int max=0, cnt=0;
		
		for(int i=100; i<1000; i++) {
			for(int j=100; j<1000; j++) {
				int n= i*j;
				if(isPalindrome(n) && n > max) { 
					cnt++;
					max = n;
				}
			}
		}
		System.out.println("최대값 : " +max + ", 수 : " + cnt);
	}
	
}
