package com.bit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	// @Before
	//	- 타겟 메소드가 호출 될 때 수행!
	@Before("execution(ProductVO com.bit.aop.ProductService.find(..))")
	public void beforeAdvice() {
		System.out.println("[before advice] Called...");
	}
	
	// @After
	//	- 타겟 메소드가 호출된 후 수행!
	//	- 수행 성공 여부와 관계없이 완료되면 수행
	@After("execution( * *..*.ProductService.*(..) )")
	public void afterAdvice() {
		System.out.println("[after advice] Called...");
	}
	
	// @AfterReturning
	//	- 타겟 메소드가 정상적으로 반환 됐을 경우 수행!
	@AfterReturning("execution( * *..*.ProductService.*(..) )")
	public void afterReturningAdvice() {
		System.out.println("[afterReturning advice] Called...");
	}
	
	// @AfterThrowing
	//	- 타겟 메소드가 수행 중 예외를 던지게 되면 수행!
	@AfterThrowing("execution( * *..*.ProductService.*(..) )")
	public void afterThrowingAdvice() {
		System.out.println("[afterThrowing advice] Called...");
	}
	
	// @Around
	//	- 어드바이스가 타겟인 메소드를 앞 뒤로 감싸서 호출 전과 호출 후를 구분
	//	- proceed() 메소드 호출하여, 타겟 메소드를 수행!
	@Around("execution( * *..*.ProductService.*(..) )")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// before
		System.out.println("[around advice : before] Called...");
		
		// point cut 대상 호출
		// 전부 받기로 했으니 오브젝트 배열로 받아 처리
		Object[] parameters = { "Phone" };
		Object result = pjp.proceed(parameters);
		
		// after
		System.out.println("[around advice : after] Called...");
		
		// 반환
		return result;
	}
	
}
