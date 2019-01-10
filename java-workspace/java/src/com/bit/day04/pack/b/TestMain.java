package com.bit.day04.pack.b;

import com.bit.day04.pack.a.TestData;

public class TestMain {
	
	public static void main(String[] args) {
//		Pen pen = new Pen();
		TestData td = new TestData();

		System.out.println(td.name);
//		System.out.println(td.id);
//		System.out.println(td.addr);
//		System.out.println(td.money);
		System.out.println(td.getMoney());
	}
	
}
