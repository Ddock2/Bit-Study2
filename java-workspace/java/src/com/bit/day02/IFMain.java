package com.bit.day02;

import java.util.Scanner;

public class IFMain {
	
	public static void main(String[] args) {
		int money = 2000;
		if(money >= 2300) {
			System.out.println("커피를 사먹을 수 있어!");
		}else {
			System.out.println("물이나 마셔야지...");
		}
		
		Scanner s = new Scanner(System.in);
		System.out.print("보유 금액 입력 : ");
		money = s.nextInt();
		if(money >= 10000) {
			System.out.println("너 돈 좀 있네?");
		}else {
			System.out.println("용돈 좀 줄까?");
		}
		System.out.println("입력한 금액 : " + money);
		
		int num = 10;
		System.out.println("입력된 수는 ");
		if(num < 0) {
			System.out.println("0미만");
		}else {
			System.out.println("0이상");
			if(num<100) {
				System.out.println("0이상 100미만");
			}else {
				System.out.println("100이상");		
			}
		}
		
		s.close();
	}
	
}
