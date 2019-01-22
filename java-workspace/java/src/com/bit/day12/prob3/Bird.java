package com.bit.day12.prob3;

abstract public class Bird {
	private String name;
	
	abstract void fly();
	abstract void sing();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
