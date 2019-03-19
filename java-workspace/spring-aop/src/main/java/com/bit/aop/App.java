package com.bit.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 	AOP 주요 개념
 		Target
 			- 부가기능을 부여할 대상
 		
 		Join Point
 			- 어드바이스가 적용될 포인트(위치, 시점)
 			- 메소드 호출 전/후, 메소드 실행 중, 클래스 초기화 및 객체 생성 시점
 		
 		Point Cut
 			- 어떤 클래스의 어느 Join Point를 사용할 것인지 판별
 			- 어드바이스를 적용할 타겟을 선정
 			- 원하는 패키지 -> 클래스 네임 -> 메소드
 		
 		Advice
 			- 실제 부가 기능에 대한 구현체
 			- 적용될 타겟에 영향을 미치지 않고, 부가 기능만 수행
 			- 특정 Join Point에 실행되는 코드
 			- before, after, around
 		
 		Aspect
 			- 핵심 기능에 독립된 부가 기능을 적용하는 모듈
 			- 부가될 구현체인 Advice와 적용할 타겟인 Point Cut의 조합
 		
 		Proxy
 			- 타겟을 감싸는 형태
 			- 호출자가 타겟을 호출하면, 프록시가 호출되는 형태
 			- 타겟보다 먼저 호출되어 선/후 처리 작업 수행
 		
 		Weaving
 			- 타겟에 Aspect(PointCut, Advice)를 적용하여 감싸는 과정
 			- PointCut에 의해 결정된 JoinPoint에 실제 수행 구현체인 Advice를 적용
 */

public class App {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ctx.getBean(ProductService.class);
		ProductVO vo = ps.find("Computer");
		System.out.println(vo);
	}
	
}
