package com.bit.day08.generic;

public class WildCardMain {
	
	public static void main(String[] args) {
		House<Animal> h = new House<>();
		House<Cat> h2 = new House<>();
		House<Dog> h3 = new House<>();
		h.store(new Cat());
		h2.store(new Cat());
		h3.store(new Dog());
		open(h);
		open(h2);
//		open(h3);
	}
	
	// Animal을 상속받는 모든 자식을 스티커로 붙이겠다
//	public static void open(House<? extends Animal> param) {
//		Animal animal = param.pullOut();
//		animal.cry();
//	}
	// Cat에 상속을 하는 모든 클래스
	public static void open(House<? super Cat> param) {
		Animal animal = (Animal) param.pullOut();
		animal.cry();
	}
}

class Animal {
	public void cry() {
		System.out.println("동물.운다.");
	}
}

class Cat extends Animal{
	@Override
	public void cry() {
		System.out.println("야.옹.");
	}
}

class Dog extends Animal{
	@Override
	public void cry() {
		System.out.println("멍.멍.");
	}
}

class House<T> {
	T animal;
	
	public void store(T animal) {
		this.animal = animal;
	}
	public T pullOut() {
		return animal;
	}
}