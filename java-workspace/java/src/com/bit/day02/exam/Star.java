package com.bit.day02.exam;

public class Star {
	
	public static void main(String[] args) {
		/*
			  *
			  **
			  ***
			  ****
			  *****
		*/
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
			 *****
			 ****
			 ***
			 **
			 *
		 */
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
			     *
			    **
			   ***
			  ****
			 *****
		 */
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i-1; j++) {
				System.out.print(" ");
			}
			
			for(int j=i; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 	 *****
		 	  ****
		 	   ***
			    **
			     *
		 */
		for(int i=5; i>=1; i--) {
			for(int j=i; j<5; j++) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
			    *   
			   ***
			  *****
			 *******
			  *****
			   ***
			    *
		 */
		for(int i=1; i<=7; i++) {
			int jmax = 4-i;
			if(jmax < 0) jmax *= -1;
			
			for(int j=1; j<=jmax; j++) {
				System.out.print(" ");
			}
			
			for(int j=1; j <= 7 - 2*jmax; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
			      *   
			     ***
			    *****
			   *******
			     ***
			    *****
			   *******
			  *********
			    *****
			   *******
			  *********
			 ***********
		 */
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				for(int k=1; k<=5-i-j; k++) {
					System.out.print(" ");
				}
				
				for(int k = 11 - 2*(j + i); k<=11; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	
}
