package com.bit.day02.exam;

import java.util.ArrayList;

// 세자리수의 각 자리수의 세제곱의 합이 원래 수와 같은 수 찾기
// 370 = 3^3 + 7^3 + 0^3
public class ArmstrongNumber {
	
	public static void main(String[] args) {
		ArrayList<Integer> armstrong = new ArrayList<>();
		
		for(int i=100; i<1000; i++) {
			if(i == (int) (Math.pow(i/100, 3) + Math.pow((i/10)%10, 3) + Math.pow(i%10, 3))) {
				armstrong.add(i);
			}
		}
		
		System.out.println(armstrong.toString());
	}
	
}
