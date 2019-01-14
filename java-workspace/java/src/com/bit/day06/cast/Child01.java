package com.bit.day06.cast;

public class Child01 extends Parent{
	public Child01() {
		name = "첫째";
	}
	
	void study() {
		System.out.println("자바자바자바자바");
	}
	
	void play() {
		System.out.println("뒹굴뒹굴뒹굴뒹굴");
	}
	
	@Override
	void info() {
		System.out.println(name + "에서 재정의된 메소드 호출...");
	}
	
	
}
