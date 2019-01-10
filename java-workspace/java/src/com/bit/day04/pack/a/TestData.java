package com.bit.day04.pack.a;

public class TestData {
	
	Pen p = new Pen();
	
	public		String	name;
	protected	String	id;
				String	addr;
	private		int		money;
	
	public TestData() {
		name = "매머드";
		id = "123";
		addr = "seoul";
		money = 4000;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}

class Pen {
	int length;
	Pen() {	}
}