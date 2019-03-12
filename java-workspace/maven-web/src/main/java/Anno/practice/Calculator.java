package Anno.practice;

// 추상화 - 하위 클래스의 공통점을 정의하고 분리
public interface Calculator {
	void addition(int firstNum, int secondNum);
	void subtraction(int firstNum, int secondNum);
	void multiplication(int firstNum, int secondNum);
	void division(int firstNum, int secondNum);
}
