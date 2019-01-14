package com.bit.day06.cast;

// 상속관계에서의 부모 자식간 형 변환
public class Program {
	
	public static void main(String[] args) {
//		Parent p = new Parent();
//		Child01 c01 = new Child01();
//		Child02 c02 = new Child02();
		
		Parent c01 = new Child01();
		c01.info();
		
		Parent p = new Parent();
		p.info();
		
//		Child01 p2 = new Parent() 				// 컴파일 에러
//		Child01 p2 = (Child01) new Parent();	// 런타임 에러
		
/*
 * instanceof 연산자
 * 	: 형변환(인스턴스)이 가능한지를 묻는 연산자
 *  : 가능하면 true, 불가능하면 false
 */
		
		Parent p2 = new Parent();
		info(p2);
		Child01 c1 = new Child01();
		info(c1);						// 매개변수가 부모타입이라 자식도 가능
		Child02 c2 = new Child02();
		info(c2);
	}
	
	static void info(Parent p) {	// 자식 전달, 묵시적 형변환, 자식의 객체 주소를 부모가 받아줌, up casting
		p.info();
		
		if(p instanceof Child01) {
			Child01 c = (Child01) p;
			c.study();
			c.play();
		}else if(p instanceof Child02){
			Child02 c = (Child02) p;
			c.sleep();
			c.sports();
		}
	}
}
