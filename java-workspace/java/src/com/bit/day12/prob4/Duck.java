package com.bit.day12.prob4;

public class Duck implements Soundable{
	String cry;
	
	public Duck() {
		cry = "꽥꽥";
	}
	
	@Override
	public String sound() {
		return cry;
	}
	
}
