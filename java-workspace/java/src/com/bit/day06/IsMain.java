package com.bit.day06;

public class IsMain {
	
	public static void main(String[] args) {
		BusinessMan bm = new BusinessMan("박신혜", "비트컴퓨터", "대리");
		Student s = new Student("박효신", "비트대학교", "실용음악");
		bm.info();
		s.info();
	}
	
}

// IS-A 관계 (상속관계)
class Person {
	private String name;
	
	public Person() { }
	
	public Person(String name) {
		this.name = name;
	}
	
	public void nameInfo() {
		System.out.println("제 이름은 " + name + "입니다.");
	}
}

class BusinessMan extends Person{
	private String company;
	private String position;
	
	public BusinessMan() { }
	
	public BusinessMan(String name, String company, String position) {
		super(name);
		this.company = company;
		this.position = position;
	}
	
	public void info() {
		nameInfo();
		System.out.println("회사는 " + company + "이고,");
		System.out.println("직책은 " + position + "입니다.");
	}
}

class Student extends Person {
	private String university;
	private String major;
	
	public Student() { }
	
	public Student(String name, String university, String major) {
		super(name);
		this.university = university;
		this.major = major;
	}
	
	public void info() {
		nameInfo();
		System.out.println("학교는 " + university + "이고,");
		System.out.println("전공은 " + major + "입니다.");
	}
}