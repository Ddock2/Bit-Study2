package com.bit.day06.bs;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
//		Animal cat = new Cat();
//		Animal dog = new Dog();
//		
//		cat.cry();
//		dog.cry();
		
		Scanner s = new Scanner(System.in);
		System.out.println("동물을 선택하세요");
		System.out.println("[1]:고양이 [2]강아지");
		
		int num = s.nextInt();
		
		/*
		// Program, User 입장에서 번호를 입력하면 해당 경우들이 눈에 보임
		switch(num) {
			case 1:
				Cat cat = new Cat();
				cat.cry();
				break;
			case 2:
				Dog dog = new Dog();
				dog.cry();
				break;
			default:
				System.out.println("제대로 눌러");
				
		}
		*/
		new Menu().process(num);
		
		s.close();
	}
	
}
