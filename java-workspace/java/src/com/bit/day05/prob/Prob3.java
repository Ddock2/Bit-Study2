package com.bit.day05.prob;

public class Prob3 {
	
}

class Unit {
	int healthPoint;
	int size;
	int def;
	
	void move() { }
}

class Marine extends Unit {
	int atk;
	void attack() {	}
	
	public Marine(){
		size = 1;
	}
}

class Tank extends Unit {
	int atk;
	int mode;
	void attack() {	}
	
	public Tank(){
		size = 2;
	}
}

class Dropship extends Unit {
	int usable;
	void embark() { }
	void landing() { }
	
	public Dropship() {
		size = 4;
	}
}
