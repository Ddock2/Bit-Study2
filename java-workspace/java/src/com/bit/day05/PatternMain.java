package com.bit.day05;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	  정규 표현식
	  	: 문자열을 원하는 패턴으로 처리하는 방법
	    : 문자열 입력에서 원하는 데이터 방식으로 제한
	   
	   ^	 : 패턴 시작
	   $	 : 패턴 끝
	   []	 : 문자의 종류 및 범위 제한
	   [a-z] : 소문자 a부터 z까지
	   [A-Z] : 대문자 A부터 Z까지
	   [0-9] : 숫자    0부터 9까지
	   ()	 : 내부의 문자를 하나의 문자로
	   {}	 : 개수 및 범위를 표현
	   *	 : 적용되는 문자의 길이가 0~무한으로 받게끔
 */

public class PatternMain {
	
	public static void main(String[] args) {
		String pattern = "^[a-zA-Z]*$";
		String str = "abcdEFGhiJk";
//		String str ="abCD1234efg";
		
		if(Pattern.matches(pattern, str)) {
			System.out.println("일치하는 패턴입니다.");
		}else {
			System.out.println("일치하지 않는 패턴입니다.");
		}
		
		Pattern p = Pattern.compile("(^[0-9]*$)");
		
		Scanner s = new Scanner(System.in);
		System.out.print("입력 : ");
		String sVal = s.nextLine();
		
		Matcher m = p.matcher(sVal);
		if(m.find()) {
			int num = Integer.parseInt(sVal);
			System.out.println("입력하신 " + num + "은 숫자 데이터 입니다.");
		}else {
			System.out.println("입력하신 " + sVal + "은 숫자 데이터가 아닙니다.");
		}
		
		/*
		 * 정규 표현식의 필수 요소
		 * 1. 시작과 끝
		 * 2. 표현 종류
		 * 3. 표현 범위
		 */
		// 전화번호를 입력받는 패턴
		p = Pattern.compile("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");
		String pNum;
		System.out.print("입력 : ");
		pNum = s.nextLine();
		Matcher mc = p.matcher(pNum);
		if(mc.find()) {
			System.out.println("전화번호 양식과 일치합니다.");
		}else {
			System.out.println("전화번호 양식과 불일치합니다.");
		}
		
		/*
		 	\d : 숫자
		 	\D : 숫자 제외한 문자
		 	\w : 영문, 숫자
		 	\W : 영문, 숫자 제외한 문자
		 	\s : 공백 문자
		 	\S : 공백 문자를 제외한 문자
		 */
		// 이메일
		pattern = "^\\w*@\\w*\\.\\w*$";	//. : 모든 문자와 일치
		String input = "bmkwak22@gmail.com";
		
		if(Pattern.matches(pattern,  input)) {
			System.out.println(input + " 이메일 양식 일치합니다.");
		}else {
			System.out.println(input + " 이메일 양식 불일치합니다.");			
		}
		
		// 핸드폰 번호, 주민 번호, IP주소, 파일 확장자
		
		// 핸드폰 번호
		pattern = "^01(?:0|1|[6-8])-\\d{4}-\\d{4}$";
		input = "010-2034-5774";
		
		if(Pattern.matches(pattern,  input)) {
			System.out.println(input + " 핸드폰 번호 양식 일치합니다.");
		}else {
			System.out.println(input + " 핸드폰 번호 양식 불일치합니다.");			
		}
		
		// 주민 번호
		pattern = "^\\d{6}-[1-4]\\d{6}$";
		input = "123456-1234567";
		
		if(Pattern.matches(pattern,  input)) {
			System.out.println(input + " 주민 번호 양식 일치합니다.");
		}else {
			System.out.println(input + " 주민 번호 양식 불일치합니다.");			
		}
		
		// IP 주소
		pattern = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
		input = "192.168.1.35";
		
		if(Pattern.matches(pattern,  input)) {
			System.out.println(input + " IP 양식 일치합니다.");
		}else {
			System.out.println(input + " IP 양식 불일치합니다.");			
		}
		
		// 파일 확장자
		// +	: 구분자로 활용, \S는 . 문자까지 인식,
		//		    앞의 문자가 1개 이상 있는것들을 구분, 찾을 때 사용
		// (?i)	: 대소문자 무시
		pattern = "^\\S+\\.(?i)(doc|hwp|ppt|pdf|java)$";
		input = "hello.java";
		
		if(Pattern.matches(pattern,  input)) {
			System.out.println(input + " 사용 가능한 확장자 입니다.");
		}else {
			System.out.println(input + " 사용 불가능한 확장자 입니다.");			
		}
		
		
		s.close();
	}
	
}
