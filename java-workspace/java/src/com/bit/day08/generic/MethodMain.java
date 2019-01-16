package com.bit.day08.generic;

// 제네릭 메소드
public class MethodMain {
	
	public static void main(String[] args) {
		AAA a = new AAA();
		BBB b = new BBB();
		
		InstanceInfo iInfo = new InstanceInfo();
		iInfo.info(a);
		iInfo.info(b);
		
		// 제네릭 메소드를 활용해,
		// 전달되는 인자를 제한(설정)
		iInfo.<AAA>info(a);
		iInfo.<BBB>info(b);
//		iInfo.<AAA>info(b);	// 컴파일 에러
		
		iInfo.info(a, b);
		iInfo.<AAA, BBB>info(a, b);
//		iInfo.<BBB, AAA>info(a, b); // 컴파일 에러
	}
	
}

class AAA {
	@Override
	public String toString() {
		return "Class A";
	}
}

class BBB {
	@Override
	public String toString() {
		return "Class B";
	}
}
class InstanceInfo {
	public <T> void info(T inst) {
		System.out.println(inst);
	}
	
	// 2개 이상의 인자를 제네릭 타입으로
	public <T, U> void info(T inst1, U inst2) {
		System.out.println(inst1 + ", " + inst2);
	}
}