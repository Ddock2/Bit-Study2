package com.bit.day12.prob4;

public class Dog implements Soundable{
	String cry;
	
	public Dog() {
		cry = "멍멍";
	}
	
	@Override
	public String sound() {
		return cry;
	}
	
}
