package com.bit.day08;

import java.util.LinkedList;
import java.util.Queue;

/*
	Queue
		FIFO(First In First Out)
		: 요청 시 가장 먼저 보관한 것을 꺼낸다
	
	public void offer(Element data)		: 데이터 보관
	public Element poll()				: 값을 반환(가장 마지막)
	public Element peek()				: 값을 참조(가장 마지막)
	public boolean isEmpty()			: 비어있는지 체크
 */

public class QueueMain {
	
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		q.offer("박신혜");
		q.offer("한채영");
		q.offer("박효신");
		
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		q.offer("손흥민");
		
		System.out.println("[몽땅 꺼내버리기]");
		while(q.isEmpty() == false) {
			System.out.println(q.poll());			
		}
		
		// 비어있는 상태
		System.out.println(q.peek());
		System.out.println(q.poll());			
	}
	
}
