package com.bit.day09.sort;

public class Program {
	
	public static void main(String[] args) {
//		int data[] = {3, 5, 2, 4, 1};
		int data[] = {3, 10, 5, 6, 2, 8, 4, 1, 7, 9};
		Sort.info(data);
		
//		Bubble b = new Bubble();
//		b.sort(data);
		
//		Select s = new Select();
//		s.sort(data);
		
//		Insert i = new Insert();
//		i.sort(data);
		
		Quick q = new Quick();
		q.sort(data, 0, data.length-1);
	}
	
}
