package com.bit.day04.pack.a;

public class A {
	
	TestData td = new TestData();
	
	A() {
		System.out.println(td.name);
		System.out.println(td.id);
		System.out.println(td.addr);
//		System.out.println(td.money);
		System.out.println(td.getMoney());
	}
	
}
