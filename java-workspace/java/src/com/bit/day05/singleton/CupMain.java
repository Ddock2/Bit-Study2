package com.bit.day05.singleton;

public class CupMain {
	
	public static void main(String[] args) {
//		Cup cup;				// 생성자 호출만 private이기에 이름 접근은 가능
//		Cup cup1 = new Cup();	// 생성자 private라서 error
//		Cup cup2 = new Cup();
		
		Cup cup1 = Cup.getInstance();
		Cup cup2 = Cup.getInstance();
		
		System.out.println("cup1 주소 : " + cup1);
		System.out.println("cup2 주소 : " + cup2);
	}
	
}
