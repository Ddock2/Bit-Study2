package com.bit.day03;

public class MethodMain01 {
	
	public static int getNum() {
		return 10;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static void info(int age, double height) {
		System.out.println("저의 나이는 " + age + "살 입니다.");
		System.out.println("키는 " + height + "cm 입니다.");
		System.out.println();
	}
	
	public static void hello() {
		System.out.println("Hello Method");
		System.out.println();
	}
	
	public static void divide(int num1, int num2) {
		if(num2 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return;
		}
		
		System.out.println("나눗셈 결과 : " + (num1/num2));
	}
	
	public static int test(int num) {
		System.out.println("num : " + num);
		if(num > 10) {
			System.out.println("10보다 크네");
			return 1;
		}
		System.out.println("10보다 작네");
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("getNum() 호출 : " + getNum());
		int num = getNum();
		System.out.println("메소드의 결과를 변수에 대입 : " + num);
		System.out.println();
		
		System.out.println("add(3, 7) : " + add(3, 7));
		System.out.println();
		
		info(12, 150.6);
		
		hello();
		
		divide(8, 2);
		divide(2, 0);
		System.out.println();
		
		test(11);
		test(9);
		
	}
	
}
