package com.bit.day06;

public class ObjectMain {
	
	public static void main(String[] args) {
		AAA a = new AAA();
		System.out.println(a.toString());
		
		// BBB 클래스는 Object 클래스를 상속받는 형태
		// 부모 클래스 Object의 멤버 메소드인 toString 호출 가능
		// System.out.println(b) : toString() 자동 호출
		BBB b = new BBB();
		System.out.println(b.toString());
		System.out.println(b);
	}

}

class AAA {
	// 모든 클래스는 최상위 클래스 Object를 상속한다.
	@Override
	public String toString() {
		return "졸려..";
	}
}

class BBB {
	
}