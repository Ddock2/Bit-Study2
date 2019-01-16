package com.bit.day08.generic;

public class GenericMain {
	
	public static void main(String[] args) {
		Box<Banana> bBox = new Box<Banana>();
		bBox.store(new Banana("노랑"));
		Banana banana = bBox.pullOut();
		banana.info();
//		bBox.store(new Apple(5));	// 컴파일 에러
		
		Box<Apple> aBox = new Box<>();
		aBox.store(new Apple(5));
		Apple apple = aBox.pullOut();
		apple.info();
	}
	
}

/*
 * 일반적으로 사용하는 타입 약자
 * 	T - Data Type (U, ...)
 *	K - Key
 *	V - Value
 *	E - Element
 *	N - Number
 */

// datatype : 임의로 지은 이름
class Box<datatype> {
	// 자료형에 안전하지 않다
//	Object obj;		// 원하지 않는 객체가 담길 수 있다
	datatype item;	// 박스에 담을 객체를 붙여라
	
	public void store(datatype item) {
		this.item = item;
	}
	
	public datatype pullOut() {
		return item;
	}
}

class Apple {
	int sugar;
	public Apple(int sugar) {
		this.sugar = sugar;
	}
	public void info() {
		System.out.println("당도 : " + sugar);
	}
}

class Banana{
	String color;
	public Banana(String color) {
		this.color = color;
	}
	public void info() {
		System.out.println("색상 : " + color);
	}
}

// 자료형에 안전하다
// 종류별로 모든 클래스 정의해야 함
class AppleBox {
	Apple apple;
}

class BananaBox {
	Banana banana;
}