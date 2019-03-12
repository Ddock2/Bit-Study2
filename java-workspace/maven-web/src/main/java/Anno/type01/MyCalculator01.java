package Anno.type01;

import org.springframework.beans.factory.annotation.Autowired;

public class MyCalculator01 {
	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	public MyCalculator01() {
//		calculator = new Calculator();
	}
	public MyCalculator01(Calculator calculator) {
		this.calculator = calculator;
		System.out.println("생성자 의존 주입...");
	}
	public MyCalculator01(int firstNum, int secondNum) {
		this();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	public MyCalculator01(int firstNum, int secondNum, Calculator calculator) {
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
	// Bean의 사항에 맞도록 자동적으로 AppCtx의 의존을 자동으로 연결!
	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
		System.out.println("Setter 의존 주입...");
	}
	
}
