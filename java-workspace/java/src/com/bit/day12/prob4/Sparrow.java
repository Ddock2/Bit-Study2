package com.bit.day12.prob4;

public class Sparrow implements Soundable{
	String cry;
	
	public Sparrow() {
		cry = "짹짹";
	}
	
	@Override
	public String sound() {
		return cry;
	}
	
}
