package com.bit.day07.except;

import java.util.Random;

public class Program {
	
	public static void main(String[] args) {
		Random r = new Random();
		int rNum = r.nextInt(100) + 1;
		
		if(rNum % 2 != 0) {
			System.out.println("생성된 난수 " + rNum + "은 홀수입니다");
		}else {
			try {
				String msg = "생성된 난수 " + rNum + "은 짝수입니다";
				throw new EvenException(msg);
				// 예외를 던져라, catch가 잡도록 throw로 예외를 발생시켜라
			}catch(EvenException ee) {
				ee.printStackTrace();
			}
		}
	}
	
}
