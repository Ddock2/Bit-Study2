package com.bit.day08;

import java.util.Stack;

/*
	Stack Class
  		LIFO(Last In First Out)
  		FILO(First In Last Out)
  			형태의 임시 버퍼
  		: 버퍼에 임시로 데이터를 저장하였다가 필요할 때 꺼내 쓴다
  		: 요청 시 가장 최근에 보관한 데이터부터 꺼낸다
  	
  	public void push(Element data)		: 순차 보관
  	public Element pop()				: 값을 반환 (최근 저장)
  	public Element peek()				: 값을 참조 (최근 저장)
  	public boolean empty(), isEmpty()	: 비어있는지 체크
  	public int search(Element data)		: 데이터 위치
 */

public class StackMain {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);	// 1
		stack.push(2);	// 1 2
		stack.push(3);	// 1 2 3
		System.out.println(stack.pop()); // 3
		System.out.println(stack.pop()); // 2
		
		stack.push(4);	// 1 4
		stack.push(5);	// 1 4 5
		System.out.println(stack.peek()); // 5
		System.out.println(stack.pop()); // 5
		
		System.out.println(stack.search(4)); // 1번째
		
		while(stack.empty() == false) {
			System.out.println(stack.pop());
		}
		
		// 비어있는 상태
//		System.out.println(stack.pop());	// EmptyStackException 발생
		
	}
	
}
