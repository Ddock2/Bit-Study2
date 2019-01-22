package com.bit.day12.prob3;

public class Prob3 {
	
	public static void main(String[] args) {
		Bird duck = new Duck("꽥꽥이");
		duck.fly();
		duck.sing();
		duck.toString();
		
		Bird sparrow = new Sparrow("짹짹");
		sparrow.fly();
		sparrow.sing();
		sparrow.toString();
	}
	
}
