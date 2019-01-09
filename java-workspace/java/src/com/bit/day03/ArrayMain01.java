package com.bit.day03;

import java.util.Arrays;

public class ArrayMain01 {
	
	public static void main(String[] args) {
		int[] iArr;
		iArr = new int[3];
		
		iArr[0] = 10;
		iArr[1] = 20;
		iArr[2] = 30;
		
		System.out.println("iArr배열 첫 데이터의 주소 : " + iArr);
		
		for(int i=0; i<iArr.length; i++) {
			System.out.println("iArr[" + i + "] : " + iArr[i]);
		}
		System.out.println();
		
		int[] iArr2 = { 1, 2, 3, 4 };
		for(int i=0; i<iArr2.length; i++) {
			System.out.println("iArr2[" + i + "] : " + iArr2[i]);
		}
		System.out.println();
		
		int[] iArr3 = new int [] {1, 2, 3};
		System.out.println("iArr3의 길이 : " + iArr3.length);
		for(int i=0; i<iArr3.length; i++) {
			System.out.println("iArr3[" + i + "] : " + iArr3[i]);
		}
		System.out.println();
		
		String[] strArr = new String[3];
		strArr[0] = "Hello";
		strArr[1] = "World";
		strArr[2] = "Bye~";
		
		int idx = 0;
		System.out.println(strArr[idx++]);
		System.out.println(strArr[idx++]);
		System.out.println(strArr[idx++]);
		System.out.println();
		
		// foreach 반복문
		for(String str : strArr) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println(Arrays.toString(strArr));
	}
	
}
