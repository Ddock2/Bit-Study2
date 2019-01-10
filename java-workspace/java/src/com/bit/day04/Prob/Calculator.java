package com.bit.day04.Prob;

// Prob6

public class Calculator {
	
	Add add;
	Sub sub;
	Mul mul;
	Div div;
	
	public Calculator() {
		add = new Add();
		sub = new Sub();
		mul = new Mul();
		div = new Div();
	}
	
	void calculate(int a, char operator, int b) {
		switch(operator) {
		case '+' : 
			add.setValue(a, b);
			System.out.println(add.calculate());
			break;
		case '-' :
			sub.setValue(a, b);
			System.out.println(sub.calculate());
			break;
		case '*' :
			mul.setValue(a, b);
			System.out.println(mul.calculate());
			break;
		case '/' :
			div.setValue(a, b);
			System.out.println(div.calculate());
			break;
		default : System.out.println("지원하지 않는 방식의 입력입니다.");
	}
	}
}

abstract class Operator {
	int a;
	int b;
	
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	abstract int calculate();
}


class Add extends Operator{
	@Override
	int calculate() {
		return this.a + this.b;
	}
}

class Sub extends Operator{
	@Override
	int calculate() {
		return this.a - this.b;
	}
}

class Mul extends Operator{
	@Override
	int calculate() {
		return this.a * this.b;
	}
}

class Div extends Operator{
	@Override
	int calculate() {
		return this.a / this.b;
	}
}