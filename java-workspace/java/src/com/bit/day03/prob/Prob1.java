package com.bit.day03.prob;

import java.util.Scanner;

// 돈 계산

public class Prob1 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("금액 : ");
		int money = s.nextInt();
		int[] moneyRange = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		int n = 0;
		
		for(int mr : moneyRange) {
			n = money/mr;
			money -= mr*n;
			System.out.printf("%d원 : %d개\n", mr, n);
		}
		
		s.close();
	}
	
}
