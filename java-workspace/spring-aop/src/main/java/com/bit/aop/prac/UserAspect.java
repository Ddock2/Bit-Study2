package com.bit.aop.prac;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
	@Before("execution( * *..*.MemberService.*(..) )")
	public void beforeMethod() {
		System.out.println("[before advice]");
	}
	
	@After("execution( * *..*.MemberService.*(..) )")
	public void afterMethod() {
		System.out.println("[after advice]");
	}
}
