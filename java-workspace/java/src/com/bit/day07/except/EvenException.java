package com.bit.day07.except;

// 사용자 정의 예외 클래스
@SuppressWarnings("serial")
public class EvenException extends Exception{
	public EvenException() {
		super();
	}
	
	public EvenException(String msg) {
		super(msg);		// 예외 메시지를 출력하도록 만듬
	}
}
