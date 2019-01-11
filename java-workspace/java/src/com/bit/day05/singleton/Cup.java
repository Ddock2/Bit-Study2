package com.bit.day05.singleton;

/*
	싱글톤 패턴
		: 객체를 단 하나만 생성하고 싶을 때
*/

public class Cup {
	String name;
	int size;
/*
	private static Cup obj;
	
	private Cup() { }
	
	public static Cup getInstance() {
		if(obj == null) {
			obj = new Cup();
		}
		return obj;
	}
*/
	// 확정된 인스턴스 같도록 상수화
	private final static Cup obj = new Cup();
	
	private Cup() { }
	
	public static Cup getInstance() {
		return obj;
	}
}
