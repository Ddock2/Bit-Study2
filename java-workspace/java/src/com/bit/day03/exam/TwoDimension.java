package com.bit.day03.exam;

import java.util.Scanner;

/*
 *  Q. 다음 요구에 따라 프로그램을 작성하시오
 *  	배열의 크기 m(세로)과 n(가로)를 입력받아,
 *  	숫자를 짝수 행은 왼쪽부터 오른쪽으로 증가,
 *  		 홀수 행은 오른쪽부터 왼쪽으로 증가
 *  	하는 2차원 배열을 만들어 출력하시오
 *  	
 *  	[실행 결과]
 *  	세로와 가로를 입력 : 3 4
 *  	1  2  3  4
 *  	8  7  6  5
 *  	9  10 11 12
 */

public class TwoDimension {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("세로와 가로를 입력 : ");
		int row = s.nextInt();
		int col = s.nextInt();
		int val = 1;
		
		int[][] tdArr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			if(i%2 == 0) {				
				for(int j=0; j<col; j++) {
					tdArr[i][j] = val++;
				}
			}else {
				for(int j=col-1; j>=0; j--) {
					tdArr[i][j] = val++;
				}
			}
		}
		
		for(int[] arr : tdArr) {
			for(int n : arr) {
				System.out.print(n + "	");
			}
			System.out.println();
		}
		
		s.close();
	}
	
}
