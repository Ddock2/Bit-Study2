package DI;

public class CalculatorEN implements Calculator{
	
	public CalculatorEN() {
		System.out.println("Caculator : " + this);
	}
	
	public void addition(int firstNum, int secondNum) {
		System.out.println("Addition : " + (firstNum + secondNum));
	}
	public void subtraction(int firstNum, int secondNum) {
		System.out.println("Subtraction : " + (firstNum - secondNum));
	}
	public void multiplication(int firstNum, int secondNum) {
		System.out.println("Multiplication : " + (firstNum * secondNum));
	}
	public void division(int firstNum, int secondNum) {
		System.out.println("Division : " + (firstNum / secondNum));
	}
	
}
