package com.bit.day02.exam;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int key = 0;
		
		System.out.println("[1]:추가, [2]:삭제, [3]:검색, [4]:수정, [0]:종료");
		do {
			System.out.print("원하는 동작을 선택입력 : ");
			key = s.nextInt(); 
			switch(key) {
				case 1:
					System.out.printf("[추가]를 선택하셨습니다.\n\n");
					break;
				case 2:
					System.out.printf("[삭제]를 선택하셨습니다.\n\n");
					break;
				case 3:
					System.out.printf("[검색]을 선택하셨습니다.\n\n");
					break;
				case 4:
					System.out.printf("[수정]을 선택하셨습니다.\n\n");
					break;
				case 0:
					System.out.println("프로그램 종료");
					break;
				default:
					System.out.printf("[System] : 잘못 입력하셨습니다.\n\n");
			}
		}while(key != 0);
			
		s.close();
	}
}
