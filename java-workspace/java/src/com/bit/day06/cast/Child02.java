package com.bit.day06.cast;

public class Child02 extends Parent {
	public Child02() {
		name = "둘째";
	}
	
	void sports() {
		System.out.println("운동운동운동운동운동");
	}
	
	void sleep() {
		System.out.println("드르렁..zzZ");
	}
	
	@Override
	void info() {
		System.out.println(name + "에서 재정의된 메소드 호출...");
	}
	
}
