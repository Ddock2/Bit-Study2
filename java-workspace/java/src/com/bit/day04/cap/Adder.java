package com.bit.day04.cap;

class Adder {
	private int addCnt;
	
	Adder() {
		addCnt = 0;
	}
	
	// 접근자 메소드 (Access Method)
	int getAddCnt() {
		return addCnt;
	}
	
	int addTwoNumber(int num1, int num2) {
		addCnt++;
		return num1 + num2;
	}
}
