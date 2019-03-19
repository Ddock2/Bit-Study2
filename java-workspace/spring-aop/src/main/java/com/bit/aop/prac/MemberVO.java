package com.bit.aop.prac;

public class MemberVO {
	private String name;

	public MemberVO() {
		super();
	}
	public MemberVO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " 일한다...";
	}
	
}
