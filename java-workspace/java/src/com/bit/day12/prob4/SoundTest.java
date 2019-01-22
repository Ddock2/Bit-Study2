package com.bit.day12.prob4;

public class SoundTest {
	
	public static void main(String[] args) {
		printSound( new Cat() );
		printSound( new Dog() );
		printSound( new Sparrow() );
		printSound( new Duck() );
	}
	
	public static void printSound(Soundable animal) {
		System.out.println("\"" + animal.sound() + "\"");
	}
}
