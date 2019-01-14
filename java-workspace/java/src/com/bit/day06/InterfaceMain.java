package com.bit.day06;

public class InterfaceMain {
	
	public static void main(String[] args) {
		
	}
	
}

// 1. 자바는 다중상속을 지원하지 않는다
//class AA extends BB, CC { }
//class BB { }
//class CC { }

// interface를 활용하여 다중상속의 형태를 지원
interface AA { }
interface BB { }
//class MyClass implements AA, BB { }

// 하나의 class와 여러 interface 상속 가능
class CC { }
class MyClass extends CC implements AA, BB { }

// 2. interface를 활용한 상수 데이터 관리
class Cweek {
	public static final int MON = 1;
	// ...
	public static final int SUN = 7;
}

interface Iweek {
	/*public static final*/ int MON=1, /*...*/ SUN=7;
}

// 3. 무엇이 가능한가를 표시하는 용도 (클래스의 특성 표시)
//	~able로 끝나는 interface 표현, ~가능하다
interface UpperCasePrintable {
	// 인터페이스 내부의 메소드는 모두 아래의 형태
	/*public abstract*/ void toUpperCasePrint();
}

class Printer implements UpperCasePrintable {
	// interface 메소드의 접근지정자 public에 맞게,
	// Override된 메소드의 접근지정자 또한 public으로
	// *부모 클래스의 메소드 접근지정자보다, 확장될 수 있으나 축소 불가
	/*
	 * OCP (Open-Closed Principle)
	 *  : 개방 폐쇄의 원칙
	 *  : 확장에는 열려있지만, 수정에는 닫혀 있어야한다.
	 */
	@Override
	public void toUpperCasePrint() {
		
	}
}