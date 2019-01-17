package com.bit.day09.sort;

public class Sort {
	public static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	public static void info(int[] data) {
		for(int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
