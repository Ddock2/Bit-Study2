package com.bit.day03.exam;

public class Hanoi {
	
	static int cnt = 0;
	
	/**
	 * @param a 기둥1
	 * @param b 기둥2
	 * @param c 기둥3
	 * @param n 원반 개수
	 */
	public static void move(char a, char b, char c, int n) {
		if(n < 1) {
			return;
		}
		cnt++;
		move(a, c, b, n-1);
		System.out.printf("move : %s -> %s \n", a, c);
		move(b, a, c, n-1);
	}
	
	
	public static void main(String[] args) {
		move('a', 'b', 'c', 3);
		System.out.println("count : " + cnt);
	}
	
}
