package com.bit.day04;

public class ConstructorMain {

	public static void main(String[] args) {
		Person p = new Person("한채영", 39, 172);
		p.info();
		
		Person p2 = new Person("박철민", 25, 175);
		p2.info();
		
		System.out.println(p);
		System.out.println(p2);
		
		Person p3 = new Person();
		p3.info();
		
		Person p4 = null;
		p4 = new Person("음냐뤼", 20, 180);
		p4.info();
		
		String str = new String("Hello");
		System.out.println(str);
		
		System.out.println("==========================");
		
		Person p5 = new Person("옹냐뤼", 30, 170);
		p5.info();
		Person p6 = new Person("콩냐뤼", 20);
		p6.info();
		Person p7 = new Person("동냐뤼");
		p7.info();
		Person p8 = new Person();
		p8.info();
		
//		Member m = new Member();
//		m.Member(30); // 호출 가능
	}
	
}

/*
 * 생성자의 특징
 * 1. 클래스명과 동일
 * 2. 반환형이 존재하지 않음
 * 3. 클래스에 생성자 정의 없을 시, JVM이 디폴트 생성자 자동 생성
 * 4. 오버로딩 지원
 * 5. 객체의 초기화 담당
 * (생성자는 해당 객체를 생성할 때 단 한번만 호출되는 메소드)
 */

/*
 * 자바는 메소드 Overloading 지원
 * 	: 메소드의 이름이 같지만,
 * 		매개변수의 개수나 데이터 타입에 따라 차이를 두는 방법
 */

class Person {
	String name;
	int age;
	int height;
	
	final String WEIGHT;
	
	final double PI = 3.14;	// final 키워드로 변수를 상수화, 상수화된 변수의 이름은 전부 대문자로 선언, _로 단어구분(snake case)
	final int LENGTH_OF_CAR = 300;
	
	public Person() {
		this("null", -1, -1);
	}
	
	public Person(String name) {
		this(name, -1, -1);
	}

	public Person(String name, int age) {
		this(name, age, -1);
	}

	public Person(String name, int age, int height) {
		this.name = name;
		this.age = age;
		this.height = height;
		
		WEIGHT = "100kg";
	}
	
	public void info() {
		System.out.println("name : " + name + ", age : " + age + ", height :" + height);
	}
	
}

class Member{
	
	public Member() {
		System.out.println("디폴트 생성자 Member() Called...");
	}
	
	public Member(String name) {
		System.out.println("Member(String) 생성자 Called...");
	}
	
	public void info() {
		System.out.println("void info() 메소드 Called...");
	}
	
	public void info(int a) {
		System.out.println("void info(int) 메소드 Called...");
	}
/*
	// 이름은 해당 데이터를 찾기 위해 사용한다, 반환형이 달라도 이름이 같으면 불가
	public int info() {
		System.out.println("int info() 메소드 Called...");
		return 0;
	}
*/	
	
/*	
	// 생성자와 이름이 같아도, 반환형이 붙으면 메소드로 취급
	public void Member(int age) {
		System.out.println("Member(int age) 메소드 Called...");
	}
*/
	
}