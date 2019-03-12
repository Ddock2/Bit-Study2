package Anno.practice;

public class CalculatorKR implements Calculator{
	
	public CalculatorKR() {
		System.out.println("계산기 : " + this);
	}
	
	public void addition(int firstNum, int secondNum) {
		System.out.println("덧셈 : " + (firstNum + secondNum));
	}
	public void subtraction(int firstNum, int secondNum) {
		System.out.println("뺄셈 : " + (firstNum - secondNum));
	}
	public void multiplication(int firstNum, int secondNum) {
		System.out.println("곱셈 : " + (firstNum * secondNum));
	}
	public void division(int firstNum, int secondNum) {
		System.out.println("나눗셈 : " + (firstNum / secondNum));
	}
}
