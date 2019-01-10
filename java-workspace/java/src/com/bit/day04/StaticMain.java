package com.bit.day04;

public class StaticMain {
	
	static String str = "static 멤버 변수 Called...";
	void print() {
		System.out.println("print() 메소드 Called...");
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		StaticSub ss1 = new StaticSub();
		StaticSub ss2 = new StaticSub("한채영");
		StaticSub ss3 = new StaticSub("박신혜");
		
		ss1.info();
		ss2.info();
		
		StaticSub.cntInfo();
		
		StaticMain sm = new StaticMain();
		sm.print();
		
//		str = "Hello Static";
		System.out.println(str);	// StaticMain 클래스 내부라서 str을 직접 쓸 수 있다
		
		StaticSub.sCnt = 10;		// static은 위치하는 해당 클래스로 접근
		System.out.println(StaticSub.sCnt);
	}
	
}

class StaticSub {
	String name;
	static int sCnt;
	int iCnt;
	
	StaticSub(String name){
		this();
		this.name = name;
	}
	
	StaticSub(){
		sCnt++;
		iCnt++;
	}
	
	void info() {
		System.out.println("static int sCnt : " + sCnt);
		System.out.println("int iCnt : " + iCnt);
	}
	
	static void cntInfo() {
		System.out.println("sCnt : " + sCnt);
//		System.out.println("iCnt : " + iCnt);	// static 메소드 프로그램 로딩 시점에 할당 -> 일반변수 못넣음
	}
}