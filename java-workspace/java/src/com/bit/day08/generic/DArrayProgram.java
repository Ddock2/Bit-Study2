package com.bit.day08.generic;

public class DArrayProgram {
	
	public static void main(String[] args) {
		// DArray -> Collection Framework의 ArraList 흉내
		DArray<Integer> darr = new DArray<>(3);
		
		darr.arrInfo();
		for(int i=3; i<12; i+=2) {
			darr.add(i);
			darr.arrInfo();
		}
		
		DArray<String> darr2 = new DArray<>(3);
		String[] sArray = {"one", "two", "three", "four", "five"};
		darr2.arrInfo();
		for(int i=0; i<sArray.length; i++) {
			darr2.add(sArray[i]);
			darr2.arrInfo();
		}
	}
}
