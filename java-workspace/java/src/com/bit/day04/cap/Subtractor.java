package com.bit.day04.cap;

class Subtractor {
	private int subCnt;
	
	Subtractor() {
		subCnt = 0;
	}

	public int getSubCnt() {
		return subCnt;
	}

	int subTwoNumber(int num1, int num2) {
		subCnt++;
		return num1 - num2;
	}
}
