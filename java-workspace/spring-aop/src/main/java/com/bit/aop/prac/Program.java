package com.bit.aop.prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	
	public static void main(String[] args) {
		// 1. MemberService에 비지니스 로직을 구성
		// 2. UserAspect에서 before, after를 구현
		// 3. before, after JoinPoint에 Advice 구현
		// 4. MemberService에 PointCut으로 적용
		// 5. Advice 적용됐는지 콘솔에 출력
		
		@SuppressWarnings("resource")
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		MemberService ms = ctx.getBean(MemberService.class);
		MemberVO vo = ms.work("사람");
		System.out.println(vo);		
	}
	
}
