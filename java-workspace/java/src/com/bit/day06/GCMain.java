package com.bit.day06;

/*
	System 클래스의 쓰레기 수집 정적 메소드
	1. public static void gc()
		: 쓰레기 수집기 가동
	2. public static void runFinalization()
		: 쓰레기 수거
	3. public static void runFinalizersOnExit(boolean value)
		: 프로세스가 끝날 때 모든 객체를 수거
 */

public class GCMain {
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Plate p1 = new Plate(1);
		System.out.println("접시 생성 : " + p1.getNum());
		Plate p2 = new Plate(2);
		System.out.println("접시 생성 : " + p2.getNum());
		
//		Plate p3; // 단순한 참조변수만 선언
//		System.runFinalizersOnExit(true);
		
		p1 = null;
		System.gc();	// 호출 시점에 쓰레기에 해당되는 것들을 확인, 쓰레기 수거에 해당하는 finalize() 호출
		p2 = null;
		
		try{			
			System.out.println("그릇 번호 : " + p1.getNum());
			System.out.println("그릇 번호 : " + p2.getNum());
		}catch(Exception e) {
			System.out.println("없다");
		}
	}
	
}

class Plate {
	private int num;
	
	public Plate() { }
	
	public Plate(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}
	
	protected void finalize() {	// 객체 소멸 시 호출되는 메소드
		System.out.println(num +"번 객체 정리!");
	}
}