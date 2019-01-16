package com.bit.day08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
	Set 주요 메소드
	- add		: 데이터 입력
	- remove	: 특정 데이터 삭제
	- clear		: 모든 데이터 삭제
	- size		: 집합 객체의 크기 반환
	- contains	: 특정 객체의 존재 여부 반환
	- isEmpty	: 비어있는지
	- toArray	: 배열로 반환
	- iterator	: 반복자
	
	Set에서 요소를 전부 출력하는 3가지
	- for each
	- iterator
	- toArray()
 */

public class SetMain {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		// 1. 중복을 허용하지 않음
		System.out.println("입력 여부 : " + set.add("two"));
		System.out.println("입력 여부 : " + set.add("six"));
		
		// 2. 저장 순서가 없다
		for(String str : set) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		System.out.println("--------------------------------");
		
		set = new TreeSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		// 사전식 정렬
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		System.out.println();
		
		// toArray 순회
		Object[] arr = set.toArray();
		System.out.println(Arrays.toString(arr));
		
//		String[] strArr = (String[])set.toArray();	// Object가 가리키는 것을 String으로 강제 변환해도 예외 발생
//		System.out.println(Arrays.toString(strArr));
		
		System.out.println(set.size());
		System.out.println(set.contains("two"));
		set.remove("two");
		System.out.println(set.contains("two"));
	}
	
}
