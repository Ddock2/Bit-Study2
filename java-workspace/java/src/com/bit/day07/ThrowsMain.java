package com.bit.day07;

import java.io.FileReader;

// throws : 나를 호출한 곳으로 예외를 넘겨라

public class ThrowsMain /*throws Exception*/{
	// JVM에게 예외 처리를 던져라, JVM 자체 예외처리 구문을 가진다
	public static void main(String[] args) throws Exception{
//		foo();
		try {
			goo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void foo() throws Exception{
		@SuppressWarnings({ "unused", "resource" })
		FileReader fr = new FileReader("abc.txt");
	}
	
	static void goo() throws Exception{
		foo();
	}
}
