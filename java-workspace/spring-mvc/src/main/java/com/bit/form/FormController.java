package com.bit.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "form/loginForm";
	}
	
	// Spring MVC Data Binding
	//	- @RequestParam, @ModelAttribute 생략
	// 	- 해당 요청이 들어오면 UserVO 객체의 default 생성자를 자동 호출
	//	- 객체 생성 후 요청 파라미터와 생성된 객체의 멤버 변수를 바인딩
	//	  *요청 파라미터와 멤버 변수 이름의 매칭, Setter를 활용한 1:1 맵핑
	@RequestMapping("/login.do")
	public String login(UserVO user, Model model) {
		System.out.println("전송된 유저 정보");
		System.out.println("ID : " + user.getId());
		System.out.println("PASSWORD : " + user.getPassword());
		System.out.println("USER NAME : " + user.getName());
		
		model.addAttribute("msg", "환영!");
		model.addAttribute("user", user);
		
		return "form/loginProcess";
	}
	
	/*
		 스프링 어노테이션
			@RequestParam
				- 요청 파라미터
				- 기본 required 속성이 true이기에, 모두 받아야한다
				- 필수 입력이 아니라면, required속성을 false로 지정!
				- Servlet에서의 다음 코드와 같다
					String id = request.getParameter("id")
			
			[주의 사항]
			전달되는 인자 중 name이 없다면,
			@RequestParam("name") String name
				-> 400 Error - Bad Request
			@RequestParam(value="name", required=false) String name
				-> null
				
			@ModelAttribute
				- 클라이언트가 전달하는 파라미터를 1:1 프로퍼티 설정
				- 클라이언트가 보낸 여러 데이터 중 객체의 멤버와 일치한다면 자동으로 할당
				- Servlet에서의 UserVO객체 생성 후 Setter와 setAttribute()의 동작
	*/
//	@RequestMapping("/login.do")
//	public String login(@RequestParam("id") String id,
//						@RequestParam("password") String password,
//						@RequestParam("name") String name,
//						@ModelAttribute("user") UserVO user) {
//		System.out.println("전송된 유저 정보");
//		System.out.println("ID : " + id);
//		System.out.println("PASSWORD : " + password);
//		System.out.println("USER NAME : " + name);
//		
//		
//		return "form/loginProcess";
//	}
	
	
	/*
	// Servlet 방법
	// 	- HttpServletReuqest
	//	- 파라미터를 받아와 직접 등록
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
//		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		UserVO user = new UserVO(id, password, name);
		
		System.out.println("전송된 유저 정보");
		System.out.println("ID : " + user.getId());
		System.out.println("PASSWORD : " + user.getPassword());
		System.out.println("USER NAME : " + user.getName());
		
		request.setAttribute("user", user);
		request.setAttribute("msg", "환영!");
		
		return "form/loginProcess";
	}
	*/
}
