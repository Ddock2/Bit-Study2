package com.bit.day12.prob4;

public class Cat implements Soundable{
	String cry;
	
	public Cat() {
		cry = "야옹";
	}
	
	@Override
	public String sound() {
		return cry;
	}
	
}
