package com.bit.day06;

import java.util.Random;

// final class : 상속하는 것을 허용하지 않는 클래스

public class FinalMain{
	
	public static void main(String[] args) {
		Random r = new Random();
		int rNum = r.nextInt(2);
		System.out.println(rNum);
		
		MyRandom mr = new MyRandom();
		rNum = mr.nextInt(2);
		System.out.println(rNum);
	}
	
}

/*final*/ class FinalSuper {		// 상속 불가
	/*final*/ void foo() {			// 상속 시 오버라이드 불가
		System.out.println("foo() Method Called...");
	}
}

class FinalSub extends FinalSuper {
	void foo() {
		
	}
}


@SuppressWarnings("serial")
class MyRandom extends Random {
	@Override
	public int nextInt(int bound) {
		return super.nextInt(bound) + 1;
	}
	
}