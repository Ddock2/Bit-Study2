package com.bit.day04;

public class CarMain {
	
	public static void main(String[] args) {
		Car car = new Car();	// 인스턴스 생성		인스턴스와 객체는 엄연히 다른 개념이지만, 편리를 위해 객체생성
		car.name = "펠리세이드";
		car.speed = 160;
		car.move();
		
		Car car2 = new Car();
		car2.name = "에스컬레이드";
		car2.speed = 200;
		car2.move();
		
		System.out.println("name : " + car.name + ", speed : " + car.speed);
		System.out.println("name : " + car2.name + ", speed : " + car2.speed);
		
	}
	
}

class Car {
	// 멤버변수 (데이터)
	String name;
	int speed;
	
	// 기능, 행위 (멤버 메소드)
	public void move() {
		System.out.println("이동!");
	}
	
}