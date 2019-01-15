package com.bit.day07;

/*
 * Inner Class의 형태
 * 	: 클래스 내부에 클래스가 존재하는 형태 (내부클래스)
 * 
	class OuterClass {
		class InnerClass{
			
		}
		static class NestedClass{
			
		}
}
 */

public class InnerMain {
	
	public static void main(String[] args) {
		// 일반 내부 클래스 접근하는 방법
		Outer out = new Outer();
		Outer.Inner oi = out.new Inner();
		oi.goo();
		
		Outer.Inner oi2 = new Outer().new Inner();
		oi2.goo();
		
		System.out.println("-----------------------------------------");
		// 객체 생성과 동시에 메소드 호출
		// 일회용, 객체를 재사용할 수 없다
		new Battle().startGame();
		
		// Game interface를 상속받는 익명 클래스
		Game g = new Game() {
			public void startGame() {
				System.out.println("게임 시작");
			}
		};
		g.startGame();
		
		new Battle() {
			public void startGame() {
				System.out.println("겜시작");
			}
		}.startGame();
	}
	
}

class Outer {
	public Outer() {
		// 클래스 내부에서는 직접 생성 가능
		Nested nst = new Nested();
		nst.foo();
		
//		Nested.foo();
	}
	static class Nested{
		public /*static*/ void foo() {
			System.out.println("Nested Class foo() Method Called...");
		}
	}
	class Inner {
		public void goo(){
			System.out.println("Inner Class goo() Method Called...");
		}
	}
}

interface Game {
	void startGame();
}

class Battle implements Game{
	@Override
	public void startGame() {
		System.out.println("게임을 시작합니다.");
	}
}