package com.bit.day03.dynamic;

public class Program {
	
	public static void main(String[] args) {
		IntDArray idarr = new IntDArray(3);
		
		idarr.arrInfo();
		for(int i=3; i<12; i+=2) {
			idarr.add(i);
			idarr.arrInfo();
		}
	}
}
