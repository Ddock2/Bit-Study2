package com.bit.day07;


public class LocalMain {
	
	public static void main(String[] args) {
		/*
		OuterClass oc = new OuterClass("첫째");
		Readable r = oc.createLocalClassInst();
		r.read();
		
		OuterClass oc2 = new OuterClass("둘째");
		Readable r2 = oc2.createLocalClassInst2();
		r2.read();
		*/
		

		OuterClass oc = new OuterClass("첫째");
		Readable r = oc.createLocalClassInst(10);
		r.read();
		
		OuterClass oc2 = new OuterClass("둘째");
		Readable r2 = oc2.createLocalClassInst2(20);
		r2.read();
		
	}
	
}

interface Readable {
	void read();
}

class OuterClass {
	private String name;
	
	public OuterClass(String name){
		this.name = name;
	}
	
	// LocalClass : 메소드 내부에 존재하는 클래스
	public Readable createLocalClassInst(/*final*/ int id) {
		class LocalClass implements Readable {
			public void read() {
				System.out.println("name : " + name);
				System.out.println("매개변수 id : " + id);
			}
		}
		
		return new LocalClass();
	}
	
	// 익명의 LocalClass인 AnonymousClass
	public Readable createLocalClassInst2(/*final*/ int id) {	// 매개변수가 내부 클래스에 쓰일 경우 상수 취급
		// read() 멤버 메소드를 가진 익명 클래스가 존재
		// 익명 클래스는 Readable을 상속받는 형태
		return new Readable() {
			public void read() {
				System.out.println("name : " + name);
				System.out.println("매개변수 id : " + id);		// return 수행 시 메소드의 메모리는 해제, id가 살아있는 이유는 constant pool
			}
		};
	}
}