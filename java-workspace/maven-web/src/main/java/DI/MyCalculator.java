package DI;

public class MyCalculator {
	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	public MyCalculator() {
		calculator = new CalculatorEN();
	}
	public MyCalculator(int firstNum, int secondNum) {
		this();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	// MyCalculator는 전달된 Calculator 객체에 의존하도록
	public MyCalculator(Calculator calculator) {
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
	
}
