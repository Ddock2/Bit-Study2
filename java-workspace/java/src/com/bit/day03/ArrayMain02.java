package com.bit.day03;

import java.util.Arrays;

public class ArrayMain02 {
	
	public static void arrInfo(int[] arr) {
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void copyArr(int[] arr1, int[] arr2) {
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
	}
	
	public static void main(String[] args) {
		int[] org = { 10, 20, 30, 40, 50 };
		int[] sub = new int[5];
		
		arrInfo(org);
		System.out.println();
		
//		System.arraycopy(org, 0, sub, 0, org.length);
		System.arraycopy(org, 3, sub, 1, 2);		
//		copyArr(org, sub);
		System.out.println(Arrays.toString(sub));
	}
	
}
