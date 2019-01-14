package com.bit.day06.override;

// handler class
public class Menu {
	
	public void process(int num) {
		switch(num) {
		case 1:
			Cat cat = new Cat();
			cat.cry();
			break;
		case 2:
			Dog dog = new Dog();
			dog.cry();
			break;
		default:
			System.out.println("제대로 눌러");
			
		}
	}
	
}
