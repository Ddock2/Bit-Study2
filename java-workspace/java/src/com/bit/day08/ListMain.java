package com.bit.day08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
	List 주요 메소드
	- add		: 데이터 입력
	- addAll	: 기존 저장된 집함 객체의 데이터 입력
	- get		: 데이터 추출
	- size		: 입력된 데이터의 개수 반환
	- remove	: 특정 데이터 삭제
	- clear		: 모든 데이터 삭제
	- contains	: 특정 데이터의 존재 여부
	- isEmpty	: 비어있는지 확인
	
	iterator
		인터페이스 객체 반환 목적 (반복자)
		컬렉션들마다 데이터 저장 방법이 다르기 때문에,
		전체 순회를 할 수 있는 반복자 제공
	- hasNext	: 요소(Element)의 존재 유무 판단
	- next		: 요소 추출
	- remove	: 요소 반환(삭제)
 */

public class ListMain {
	
	public static void main(String[] args) {
//		ArrayList<String> aList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		// index
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// for each
		for(String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		// iterator 순회
		Iterator<String> ite = list.iterator(); // list의 iterator()로 Iterator 형태로 사용하겠다
		while(ite.hasNext()) {
			System.out.print(ite.next() +" ");
		}
		System.out.println();
	}
	
}
