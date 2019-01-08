package com.bit.day02;

public class LoopMain {
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		/////////////////////////////////////////////////////////////////////////
		// 변수의 가시성 (Scope)
		// { } : Block Scope
		int num = 10;
		if(num > 5) {
			boolean bool = true;
			System.out.println(bool);
		}
//		System.out.println(bool); // bool이라는 변수를 찾을 수 없다
		
//		int i;
//		System.out.println(i); // 초기화하지 않은 변수의 사용
		
//		for( ; ; ) {}	// 무한루프
		
		//////////////////////////////////////////////////////////////////////////
		// 1~100까지의 합계
		int sum = 0;
		for(int j=1; j<=100; j++) {
			sum += j;
		}
		System.out.println("합계 : " + sum);
		
		//////////////////////////////////////////////////////////////////////////
		sum = 0;
		// 1~100 사이의 짝수의 합계
		for(int i=2; i<=100; i+=2) {
			sum += i;
		}
		System.out.println("짝수의 합계 : " + sum);
		
		///////////////////////////////////////////////////////////////////////////
		sum = 0;
		for(int x=0, y=100; x<=100; y--, x++) {
			sum += y;
		}										// x :	루프 카운트, y : 계산에 사용된 데이터
		System.out.println("결과 : " + sum);
		
		///////////////////////////////////////////////////////////////////////////
		int iNum = 0;
		while(iNum < 10) {
			System.out.print(iNum + " ");
			iNum++;
		}
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////
		int n = 0;
		do {
			System.out.print(n+" ");
			n++;
		}while(n<0);
		
		///////////////////////////////////////////////////////////////////////////
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
			}
			System.out.println();
		}
		
		///////////////////////////////////////////////////////////////////////////
		// break
		for(int i=0; i<10; i++) {
			if(i==5) {
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////
		// continue
		for(int i=0; i<10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////
		// label
		// 이름 원하는대로 사용 가능
		label: for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print("*");
				if(j==5) {
					break label;
				}
			}
			System.out.println();
		}
	}
	
}
