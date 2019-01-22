package com.bit.day12.prob3;

public class Duck extends Bird{
	
	public Duck(String name) {
		setName(name);
	}
	
	@Override
	void fly() {
		System.out.println("오리(" + getName() + ")는 날지 않습니다.");
	}

	@Override
	void sing() {
		System.out.println("오리(" + getName() + ")가 소리내어 웁니다.");		
	}

	@Override
	public String toString() {
		System.out.println("오리의 이름은 " + getName() + " 입니다.");
		return "오리의 이름은 " + getName() + " 입니다.";
	}
	
}
