package com.bit.day05;

public class ExtendsMain {
	
	public static void main(String[] args) {
//		One one = new One();
//		Two two = new Two();	// 서브클래스가 생성되더라도 수퍼클래스가 먼저 생성된 후에 서브 생성
		@SuppressWarnings("unused")
		Three three = new Three("180.5cm");
	}
	
}

class One {
	protected String bloodType = "A";
	
	public One(){
		System.out.println("One() 생성자 Called...");
		System.out.println(bloodType);
	}
}

class Two extends One{
	String height = "183.8cm";
	
	public Two(){
		super();
		bloodType = "O";
		System.out.println("Two() 생성자 Called...");
		System.out.println(bloodType);
	}
	
	Two(String height){
		this.height = height;
	}
	
}

class Three extends Two{
	String height;
	public Three() {
		bloodType = "AB";
		System.out.println("Three() 생성자 Called...");
		System.out.println(bloodType);
	}
	
	public Three(String height) {
		this.height = height;
		System.out.println(this.height);
		System.out.println(super.height);
	}
}