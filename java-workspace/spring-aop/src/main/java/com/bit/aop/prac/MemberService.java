package com.bit.aop.prac;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	public MemberVO work(String name) {
		MemberVO member = new MemberVO(name);
		System.out.println(name + " 일해라!!");
		
		return member;
	}
	
}
