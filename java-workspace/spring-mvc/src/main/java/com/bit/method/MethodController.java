package com.bit.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signUp.do")
public class MethodController {
	// signUp.do 요청을 모두 받아 GET인지 POST인지 판단 후
	// 각각의 메소드를 수행
	// index.jsp에서 		signUp.do 요청 -> GET
	// signUpForm.jsp에서	signUp.do 요청 -> POST
	
	@RequestMapping(method = RequestMethod.GET)
	public String callGet() {
		return "method/signUpForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String callPOST() {
		return "method/signUpProcess";
	}
}
