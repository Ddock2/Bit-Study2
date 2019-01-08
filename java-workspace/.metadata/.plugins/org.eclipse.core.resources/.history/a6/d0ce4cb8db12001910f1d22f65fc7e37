package com.bit.day01.homework01;

public class Prob05 {
	
	public static void main(String[] args) {
		for(int i=1; i<100; i++) {
			if(i<10) {
				if(i%3==0) System.out.println(i + " 짝");
			}else {
				int clap = 0;
				if((i/10)%3 == 0) clap++;
				if((i%10 != 0) && ((i%10)%3 == 0)) clap++;
				
				if(clap>0) {
					System.out.print(i + " ");
					for(int j=clap; j>0; j--) System.out.print("짝");
					System.out.println();
				}
			}
		}
	}
	
}
