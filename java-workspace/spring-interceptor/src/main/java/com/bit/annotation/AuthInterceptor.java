package com.bit.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthInterceptor.preHandle Called...");
		
		/*
			로그인 시 인터셉터를 많이 사용하는 이유
			유저 세션 확인이 필요한 기능들
				게시판 - insert, delete, update
				회원정보수정 - modify
			에서 각 기능 마다 세션을 확인할 필요가 없다.
			결론 : 각 기능(메소드)에 대한 세션 확인 중복 코드를 최소화
			
			AuthInterceptor 역할
				Controller로 전달되는 모든 요청을 인터셉트로 받았다면,
				요청에 대한 각 예외 처리로 요청 URL에 따른 제어를 하겠다.
				
				인증 접근 제어
					-> "/modifyform" 요청 처리는 유저 세션이 존재할 경우에만!
					-> 무조건 유저 세션을 확인할 필요가 있는 요청과 아닌 것을 분류
					
				정상 수행 : 이터셉터 수행 후에 실행할 타겟
				
				1. HandlerMethod 존재 여부
					단순 페이지 이동, @RequestMapping이 된 메소드 없을 경우
					더 이상 인증 과정을 수행하지 말고 true로 종료 후 정상 수행		(false면 controller 메소드 접근 안함)
				2. @Auth 설정 여부
					제어할 메소드는 존재하지만 인증 접근 제어가 필요 없는 경우
					auth == null 이라면, 더 이상 인증 과정을 수행하지 않고 정상 수행
				3. 세션 확인을 통한 접근 제어
					[1단계] : 현재 세션 객체가 존재하는지 
					@Auth 인증 관련 어노테이션이 붙어있다면 (null이 아니라면),
					현재 세션 정보가 존재하는지 판단하여 세션 정보가 없다면,
					다른 페이지로 보내겠다.
					if(session == null){
						response.sendRedirect(
							request.getContextPath() + "이동할 페이지 요청 URL"
						);
						return false;
					}
					[2단계] : 현재 세션에 UserVO의 속성이 "authUser"인지를 판단
					
					예시)
						로그인하지 않은 상태에서 회원정보수정 요청이 들어온다면,
						로그인 폼 화면으로 강제 이동 시켜라
				4. 인증된 사용자
					위의 과정에서 중간에 반환되지 않은 경우
					HandlerMethod가 존재하고,
					@Auth 설정이 되어있고,
					session이 존재하며,
					해당 session의 정보가 authUser라면,
					정상 수행!
		 */
		
		/*
			handler
				요청 URL을 처리(handle) 할 수 있는 Method가 있는지
				다시 말해 RequestMapping이 된 Method가 있는지
				
				UserController에서,
				"/" 요청 시 받아 처리하는 메소드가 없다. -> false
				"/modifyform" 요청 시 @RequestMapping("/modifyform")이 설정된
				modify() 메소드가 처리 -> true
		*/
		// 1. handler 존재 하는지
		if(handler instanceof HandlerMethod == false) {
//			System.out.println("HandlerMethod does not exist...");
			return true;
		}
		
		/*
			요청을 받아 처리하는 HandlerMethod는 있지만,
			@Auth가 붙어 있는지 (메타 데이터가 설정되어 있는지)
		*/
		// 2. @Auth 설정 됐는지
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
		if(auth == null) {	// 접근 제어가 필요 없는 핸들러 일때
//			System.out.println("@Auth Annotation does not exist...");
			return true;
		}
		
		// 3. 세션 확인을 통한 접근 제어
		System.out.println("AuthUser!!! Session Exist!!!");
		
		// 4. 인증된 사용자
		return true;
	}
	
}
