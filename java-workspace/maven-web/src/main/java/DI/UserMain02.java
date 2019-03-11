package DI;

public class UserMain02 {
	public static void main(String[] args) {
		// Strategy Pattern (전략 패턴)
		// 	- 인터페이스(추상화)로 기능을 분리하여,
		//	     하위클래스가 어떠한 것이 사용되더라도,
		//	     해당 기능을 보장받는 디자인 패턴!
		
		// 외부
		Calculator calculator = new CalculatorEN();
		
		// Dependency Injection (의존성 주입)
		// 	: 외부에서 생성된 객체를 Constructor, Setter를 통해 설정
		
		// 자바 생성자 DI
		MyCalculator my = new MyCalculator(calculator);
		my.setFirstNum(7);
		my.setSecondNum(3);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
		System.out.println();
		
		calculator = new CalculatorKR();
		my = new MyCalculator(calculator);
		my.setFirstNum(7);
		my.setSecondNum(3);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
	}
}
