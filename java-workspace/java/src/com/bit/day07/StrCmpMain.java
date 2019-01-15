package com.bit.day07;

// 문자열 비교
public class StrCmpMain {
	
	public static void main(String[] args) {
		String str = new String("Hello");
		
//		if("Hello" == "Hello") {
//			
//		}else {
//			
//		}
		
		// 주소 비교
		if(str == "Hello") {
			System.out.println("str == Hello");
		}else {
			System.out.println("str != Hello");
		}
		
		// 값(value) 비교
		if(str.equals("Hello")) {
			System.out.println("같은 문자열");
		}else {
			System.out.println("다른 문자열");
		}
	}
	
}
