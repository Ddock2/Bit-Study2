package com.bit.day04.cap;

public class Calculator {
	// 각 기능의 참조변수를 private
	private Adder add;
	private Subtractor sub;
	
	public Calculator() {
		add = new Adder();
		sub = new Subtractor();
	}
	
	public int addTwoNumber(int num1, int num2) {
		return add.addTwoNumber(num1, num2);
	}
	
	public int subTwoNumber(int num1, int num2) {
		return sub.subTwoNumber(num1, num2);
	}
	
	public void viewCnt() {
		System.out.println("덧셈 수 : " + add.getAddCnt());
		System.out.println("뺄셈 수 : " + sub.getSubCnt());
	}
}
