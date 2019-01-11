package com.bit.day05;

public class EllipsisMain {
	/*
		... : Ellipsis
		
		기존 매개변수 선언 방법
			(int n1, int n2, int n3... int n9, int n10)
			-> 매개변수를 1개부터 10개까지 전부 받는 메소드를 만들자니 10개를 오버로딩?
		
		가변배열 형식의 매개변수 선언 방법
			(int... n) -> int[] n : 넣은 인자 개수만큼 자동으로 배열로 생성
	 */
	
	public static void main(String[] args) {
		intPrint(1);
		intPrint(1, 2);
		intPrint(1, 2, 3);
		
		strPrint("one");
		strPrint("one", "two");
		strPrint("one", "two", "three");
	}
	
	public static void intPrint(int... n) {
		for(int i : n) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void strPrint(String... sArr) {
		for(String str : sArr) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
}
