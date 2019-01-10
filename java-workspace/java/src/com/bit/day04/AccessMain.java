package com.bit.day04;

public class AccessMain {
	
	public static void main(String[] args) {
		
	}
	
}

class Access {
	private String name;
	private int age;
	
	public Access(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Access Method (접근자 메소드)
	// Getter, Setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}