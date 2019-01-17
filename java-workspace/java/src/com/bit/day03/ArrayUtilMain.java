package com.bit.day03;

import com.bit.util.ArrayUtil;

public class ArrayUtilMain {
	
	public static void main(String[] args) {
		int[] iArr = {10, 20, 30, 40, 50};
		double[] dArr = ArrayUtil.intToDouble(iArr);
		
		for(int i=0; i<dArr.length; i++) {
			System.out.print(dArr[i]+ " ");
		}
		System.out.println();
		
		double[] dArr2 = {10.1, 20.2, 30.3, 40.4, 50.5};
		int[] iArr2 = ArrayUtil.doubleToInt(dArr2);
		
		for(int i=0; i<dArr.length; i++) {
			System.out.print(iArr2[i]+ " ");
		}
		System.out.println();
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {6, 7, 8, 9, 10};
		
		int[] result = ArrayUtil.concat(a, b);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
