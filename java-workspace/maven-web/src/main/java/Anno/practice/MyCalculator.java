package Anno.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyCalculator {
	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	public MyCalculator() {
//		calculator = new Calculator();
	}
	public MyCalculator(Calculator calculator) {
		this.calculator = calculator;
		System.out.println("생성자 의존 주입...");
	}
	public MyCalculator(int firstNum, int secondNum) {
		this();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	public MyCalculator(int firstNum, int secondNum, Calculator calculator) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}
	
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
	public void sub() {
		calculator.subtraction(firstNum, secondNum);		
	}
	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}
	public void div() {
		calculator.division(firstNum, secondNum);
	}
	
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	
	@Autowired
//	@Qualifier("calEN")
	@Qualifier("calKR")
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
		System.out.println("Setter 의존 주입...");
		System.out.println("주입 대상 : " + calculator);
	}
	
}
