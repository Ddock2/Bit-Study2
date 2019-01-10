package com.bit.day04.Prob;

import java.util.Scanner;

public class Prob2 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Goods[] goods = new Goods[3];
		
		for(int i=0; i<3; i++) {
			goods[i] = new Goods(s.next(), s.nextInt(), s.nextInt());
		}
		
		for(Goods good : goods) {
			good.info();
		}
		
		s.close();
	}
	
}

class Goods {
	private String name;
	private int price;
	private int num;
	
	public Goods() {
		this("null", 0, 0);
	}
	
	public Goods(String name, int price, int num){
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
	public void info() {
		System.out.printf("%s(가격: %d원)이 %d개 입고 되었습니다.%n", name, price, num);
	}
}