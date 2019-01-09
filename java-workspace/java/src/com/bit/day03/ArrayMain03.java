package com.bit.day03;

public class ArrayMain03 {
	
	public static void main(String[] args) {
		int[][] iArr = new int[2][3];
		
		iArr[0][0] = 10;
		iArr[0][1] = 20;
		iArr[0][2] = 30;
		iArr[1][0] = 40;
		iArr[1][1] = 50;
		iArr[1][2] = 60;
		
		for(int i=0; i<iArr.length; i++) {
			for(int j=0; j<iArr[i].length; j++) {
				System.out.printf("iArr[%d][%d] : %d\n", i, j, iArr[i][j]);
			}
		}
		System.out.println();

		iArr[0] = new int[3];
		iArr[1] = new int[2];	// new로 생성 시 특징 : 초기화하지 않는다면, 자동으로 0으로 초기화
		
		for(int i=0; i<iArr.length; i++) {
			for(int n : iArr[i]) {
				System.out.print(n +" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int[] arr : iArr) {
			for(int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
}
