package com.bit.day05;

import java.util.StringTokenizer;

public class StringMain {
	
	public static void main(String[] args) {
//		String str = "Hello";
		// 차이점은 자바 메모리 이후에...
		
		String str = new String("Hello");
		System.out.println(str);
		
		// startsWith()
		str = "Sing.mp3";
		String sub = "Si";
		boolean bool = str.startsWith(sub);
		if(bool) {
			System.out.println(sub + "로 시작합니다.");
		}else {
			System.out.println(sub + "로 시작하지 않습니다.");
		}
		
		// endsWith()
		sub = ".pdf";
		bool = str.endsWith(sub);
		if(bool) {
			System.out.println("PDF 파일입니다.");
		}else {
			System.out.println("PDF 파일이 아닙니다.");
		}
		
		// equals()
		String[] strArr = {"이선균", "박신혜", "박보영", "임시완"};
		for(String s : strArr) {
			if(s.equals("박신혜"))
				System.out.println("풀 네임이 박신혜인 사람 : " + s);
		}
		for(String s : strArr) {
			if(s.startsWith("박"))
				System.out.println("성이 박씨인 사람 : " + s);
		}
		for(String s : strArr) {
			if(s.endsWith("시완"))
				System.out.println("이름이 시완인 사람 : " + s);
		}
		
		// indexOf()
		str = "Hello World";
		int idx = str.indexOf('l');
		System.out.println("l 문자의 위치 : " + idx);
		
		idx = str.indexOf("World");
		System.out.println("World 문자열의 위치 : " + idx);
		
		char c = 'l';
		idx = str.indexOf('l');
		while(idx != -1) {
			System.out.println(c + "의 위치 : " + idx);
			idx = str.indexOf(c, idx + 1);
			// 찾고자 하는 위치를 강제로 하나 증가
			// 인자1 : 찾고자 하는 문자(문자열)
			// 인자2 : 찾을 위치
		}
		
		idx = -1;
		while((idx = str.indexOf(c, idx + 1)) != -1)
			System.out.println(c +"의 위치 : " + idx);
		
		// substring()
		str = "Hello Java Program";
		String result = str.substring(3, str.length());
		// 인자1 : 시작 위치(index)
		// 인자2 : 끝 위치(index-1)
		
		System.out.println(str + "의 길이 : " + str.length());
		System.out.println(result + "의 길이 : " + result.length());

		result = str.substring(3, 10);
		System.out.println(str + "의 길이 : " + str.length());
		System.out.println(result + "의 길이 : " + result.length());
		
		// replace()
		result = str.replace('a', 'o');
		System.out.println("str : " + str);
		System.out.println("result : " + result);
		
		// trim()
		str = "                         hi   ";
		result = str.trim();
		System.out.println("str : " + str);
		System.out.println("result : " + result);
		
		// split()
		str = "박신혜:이선균:임시완:한채영";
		String[] sArr = str.split(":");
		for(String s : sArr) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		// StringTokenizer
		StringTokenizer st = new StringTokenizer(str, ":");
		while(st.hasMoreTokens()) {
			System.out.print(st.nextToken() +" ");
		}
		System.out.println();
		
		// String.valueOf()
		char[] chars = {'A', 'B', 'C', 'D', 'E'};
		String str1 = String.valueOf(chars);
		System.out.println("str1 : " + str1);
		
		String str2 = "";
		for(int i=0; i<chars.length; i++) {
			str2 += chars[i];
		}
		System.out.println("str2 : " + str2);
		
		String str3 = new String(chars);
		System.out.println("str3 : " + str3);
		
		// String, StringBuffer 차이
		String s = new String("Hello");
		StringBuffer sb = new StringBuffer("Hello");
		
		System.out.println(s);
		System.out.println(sb);
		
		System.out.println("String 연산시작");
		long sTime = System.currentTimeMillis();
		
		@SuppressWarnings("unused")
		String str4 = "";
		for(int i=0; i<10000; i++) {
			str4 += i;
		}
		System.out.println("String 연산끝");
		System.out.println("소요시간 : " + (System.currentTimeMillis()-sTime)/1000.0 + "s");
		
		System.out.println("StringBuffer 연산시작");
		sTime = System.currentTimeMillis();
		StringBuffer sb2 = new StringBuffer();
		for(int i=0; i<10000; i++) {
			sb2.append(i);
		}
		System.out.println("StringBuffer 연산끝");
		System.out.println("소요시간 : " + (System.currentTimeMillis()- sTime)/1000.0 + "s");
	}
	
}
