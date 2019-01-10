package com.bit.day04;

/*
 * 접근 지정자 (접근 제한자)
 * public		: 어디서나 접근 가능
 * private		: 클래스 내부에서만 접근 가능
 * (default)	: 동일 패키지 내부에서 접근 가능
 * protected	: 상속관계에서 접근 가능
 */

public class AnimalMain {
	// main도 메소드 -> JVM이 호출해서 실행
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "누렁이";
//		dog.age = 3;
		dog.weight = 12.7;
	}
	
}

class Cat {
	String name;
	int age;
	double weight;
	
	Dog dog;
	
	Cat() {
		dog = new Dog();
		dog.name = "예삐";
//		dog.age = 5;
		dog.weight = 5.2;
	}
}

class Dog{
	public String name;
	private int age;
	double weight;
	
	Dog() {
		this.age = 2;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}