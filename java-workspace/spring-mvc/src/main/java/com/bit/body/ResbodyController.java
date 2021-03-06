package com.bit.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller, @ResponseBody
//@Controller
public class ResbodyController {
	
	@RequestMapping("/resBody.do")
//	@ResponseBody
	public String resStringBody() {
		return "문자열 응답!";
		// @ResponseBody
		// 	- MVC의 View와 관련없이 반환
		//	- HTTP Response Body에 직접 표현
		//	- 쓰여지기전 MessageConverter의 영향
		
		// request.setCharacterEncoding("utf-8");
		// 응답 객체의 encoding -> filter로 대체!
		// web.xml의 <filter>...</filter>
	}
	
	@RequestMapping("/resBody.json")
	public Map<String, String> resJsonBody() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("ID", "mammoth");
		result.put("PASSWORD", "qwerty");
		result.put("NAME", "커피");
		
		return result;
	}
	
	@RequestMapping("/resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO result = new MemberVO("아이디", "password", "이름");
		
		return result;
	}
	
	@RequestMapping("/resStrListBody.json")
	public List<String> resJsonStrListBody() {
		List<String> result = new ArrayList<String>();
		result.add("hi");
		result.add("hello");
		result.add("bye");
		result.add("bye");
		
		return result;
	}
	
	@RequestMapping("/resVOListBody.json")
	public List<List<MemberVO>> resJsonVOListBody() {
		List<List<MemberVO>> list = new ArrayList<List<MemberVO>>();
		List<MemberVO> result = new ArrayList<MemberVO>();
		for(int j=1; j<4; j++) {
			for(int i=0; i<=5; i++) {
				MemberVO user = new MemberVO("id"+i, "pw"+i, "name"+i);
				result.add(user);
			}
			list.add(result);
		}
		
		return list;
	}

}
