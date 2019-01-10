package com.bit.day04.pack.b;

import com.bit.day04.pack.a.TestData;

class B extends TestData{
	// protected로 접근 가능한 멤버는
	// 상속을 주는 TestData가 아닌 받는 B가 활용
	TestData td = new TestData();
	B b = new B();	// 클래스 내부에서 자기 자신을 생성
	
	B() {
		System.out.println(td.name);
//		System.out.println(td.id);		// protected
		System.out.println(b.id);
//		System.out.println(td.addr);	// default
//		System.out.println(td.money);	// private
	}
	
}
