package com.bit.day06.swap;

// Call By Reference : 주소에 의한 호출
// 		객체를 담는 참조변수는 주소
// 		자바는 기본적으로 Call By Value형이기 때문에...
// 		주소를 활용할 수 있는 객체를 사용
public class Swap02 {
	
	public static void main(String[] args) {
		Value i = new Value();
		i.setValue(7);
		
		Value j = new Value();
		j.setValue(3);
		
		System.out.println("i = " + i.getValue() + ", j = " + j.getValue());
		
		swap(i, j);
		System.out.println("i = " + i.getValue() + ", j = " + j.getValue());
	}
	
	public static void swap(Value a, Value b) {
		int temp = a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);
	}
}

class Value {
	private int value;
	public int getValue() {return value;}
	public void setValue(int value) {this.value = value;}
}