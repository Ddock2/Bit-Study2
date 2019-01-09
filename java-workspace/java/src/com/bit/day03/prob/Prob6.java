package com.bit.day03.prob;

public class Prob6 {
	
	public static void main(String[] args) {
		char[][] tdArr = new char[6][6];
		int num = tdArr.length;
		int sub = 1;
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				tdArr[i][j] = 97;
			}
		}
		
		while(sub < num/2) {
			for(int i=sub ; i < num-sub; i++) {
				for(int j=sub; j<num-sub; j++) {
					tdArr[i][j] += 1;
				}
			}
			sub++;
		}
		
		for(char[] cArr : tdArr) {
			for(char c : cArr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
}
